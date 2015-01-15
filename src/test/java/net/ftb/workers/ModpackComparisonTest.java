package net.ftb.workers;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import net.ftb.data.ModPack;
import net.ftb.data.Settings;
import net.ftb.util.OSUtils;
import org.junit.Rule;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import java.io.File;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.support.membermodification.MemberModifier.*;

@PrepareForTest( {Settings.class, OSUtils.class})
public class ModpackComparisonTest {

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @Test
    public void foo() {
        String baseDir = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "modpackcomparison";
        // mock ModPack
        ModPack pack = mock(ModPack.class);
        when(pack.getDir()).thenReturn("testmodpack");
        when(pack.getUrl()).thenReturn("testmodpack.zip");

        // mock Settings
        Settings settings = mock(Settings.class);
        when(settings.getInstallPath()).thenReturn(baseDir);
        mockStatic(Settings.class);
        when(Settings.getSettings()).thenReturn(settings);

        // mock OSUtils
        stub(method(OSUtils.class, "getCacheStorageLocation")).toReturn(baseDir + File.separator);

        // create worker
        ModpackComparison comp = new ModpackComparison(pack);

        // verify mocked calls
        verify(pack).getDir();
        verify(settings).getInstallPath();
        //verify(pack).getUrl();

        // run run()
        comp.doInBackground();

        // finally test results
        assertEquals(comp.enabledMods.size(), 2);
        assertEquals(comp.disabledMods.size(), 1);

        assertEquals(comp.added.size(), 1);
        assertEquals(comp.removed.size(),  1);
        assertEquals(comp.disabled.size(), 1);
    }

}
