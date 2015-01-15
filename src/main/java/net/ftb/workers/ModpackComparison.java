/*
 * This file is part of FTB Launcher.
 *
 * Copyright © 2012-2014, FTB Launcher Contributors <https://github.com/Slowpoke101/FTBLaunch/>
 * FTB Launcher is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ftb.workers;

import com.google.common.collect.Lists;
import lombok.Setter;
import net.ftb.data.ModPack;
import net.ftb.data.Settings;
import net.ftb.log.Logger;
import net.ftb.util.ModPackUtil;

import javax.swing.SwingWorker;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class ModpackComparison extends SwingWorker<Void, Void> {
    private ModPack pack;
    @Setter
    private File folder;
    @Setter
    private String dir;
    Set<String> defaultMods;

    List<String> enabledMods = Lists.newArrayList();
    List<String> disabledMods = Lists.newArrayList();

    // makes testing easier
    List<String> enabled = Lists.newArrayList();
    List<String> added = Lists.newArrayList();
    List<String> disabled = Lists.newArrayList();
    List<String> removed = Lists.newArrayList();

    public ModpackComparison(ModPack pack) {
        this.pack = pack;

        // setup
        dir = "minecraft" + File.separator + "mods";
        folder = new File(Settings.getSettings().getInstallPath(), pack.getDir() + File.separator + dir);
    }

    @Override
    protected Void doInBackground () {
        // one-time setup per thread
        defaultMods = ModPackUtil.getDefaultModFiles(pack);

        // collect data
        analyzeMods();

        // print results
        printAddedMods();
        printDisabledMods();
        printRemovedMods();

        //repeat for other directories. Add coremods, mods/x.y.z, etc

        return null;
    }

    @Override
    protected void done() {
        try {
            get();
        } catch (InterruptedException e) {
            Logger.logDebug("Swingworker Exception", e);
        } catch (ExecutionException e) {
            Logger.logDebug("Swingworker Exception", e.getCause());
        }
    }

    private void analyzeMods() {
        for (String name : folder.list()) {
            String s = dir.replace("\\", "/") + "/" + name;
            s = s.toLowerCase();

            if (s.endsWith(".zip") || s.endsWith(".jar") || s.endsWith(".litemod")) {
                enabledMods.add(s);
            } else if (s.endsWith(".zip.disabled")) {
                disabledMods.add(s);
            } else if (s.endsWith(".jar.disabled")) {
                disabledMods.add(s);
            } else if (s.endsWith(".litemod.disabled")) {
                disabledMods.add(s);
            }
        }
    }

    private void printAddedMods() {
        for (String s: enabledMods) {
            if (!defaultMods.contains(s)) {
                if (defaultMods.contains(s + ".disabled")) {
                    enabled.add(s);
                    Logger.logDebug("User has enabled mod: " + s);
                } else {
                    added.add(s);
                    Logger.logDebug("User has added mod: " + s);
                }
            }
        }
    }

    private void printDisabledMods() {
        for (String s: disabledMods) {
            if (defaultMods.contains(s.replace(".disabled", ""))) {
                disabled.add(s);
                Logger.logDebug("User has disabled mod: " + s.replace(".disabled", ""));
            }
        }
    }

    private void printRemovedMods() {
        String dir = this.dir.replace("\\", "/");
        for (String s: defaultMods) {
            if ( s.startsWith(dir) ) {
                if (s.endsWith(".disabled")) {
                    if ( ! enabledMods.contains(s.replace(".disabled","")) && ! disabledMods.contains(s))
                        removed.add(s);
                        Logger.logDebug("User has removed mod: " + s);
                } else {
                    if ( ! enabledMods.contains(s) && ! disabledMods.contains(s + ".disabled"))
                        removed.add(s);
                        Logger.logDebug("User has removed mod: " + s);
                }
            }
        }
    }
}