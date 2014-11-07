**Never paste your logs directly onto the question or onto IRC.**

At the very least put them in  codeblocks if you do not use pastebin. Usage of pastebin is preferred. These pages have extra hooks and properly linked pastebin posts are automatically opened with question.

A note on logs: please always provide the most recent, COMPLETE log. Partial logs or just the error portion of the log, are completely useless in determining a problem. If you were asked to reinstall or move your installation post a new log instead of saying "same error".

# Table of contents
 - [How to submit your logs](#common)
 - [In cases Upload Log does not work](#nopastebin)
   - [Manually copy logs from console window to pastebin](#copylogs)
   - [Manually submit your log files](#submitlogs)
 - [For Server Problems](#server)
 - [My Launcher does not work at all](#notstarting)
 - [How to submit hardware information](#hardware)
 - [Thread dump](#threaddump)
 - [Force crash MC to generate crash log](#forcemccrash)

<div id="common" class="customanchor"></div>

# How to submit your Logs

Simply press the `Upload Log` Button on the console.

If you don't see the console or launcher closes itself after quitting/crashing MC go to the launcher's options tab, check the boxes `Show Console` and `Reopen launcher when Minecraft exits`. Then launch your pack again and when the crash/error/other problem occurs, click the `Upload Log` button.

Now just copy the **URL** from the page that just opened and paste it along with your issue description in the support website or IRC.

<div id="nopastebin" class="customanchor"></div>

# In cases `Upload Log` does not work

If you have network problems then `Upload Log` does not work. In this situation you have following choices:

<div id="copylogs" class="customanchor"></div>

## Manually copy logs from console window to pastebin

 - Push `Copy to clipboard` button in console window. Do NOT copy text from the console's text area, use that button!
 - Open http://paste.feed-the-beast.com/ and paste contents of clipboard into the large text area.
 - Complete the captcha and press Create
 - Copy the URL into your question/comment or into IRC

<div id="submitlogs" class="customanchor"></div>

## Manually submit your log files

 - Log files are located in your FTB installation directory. FTBLauncherLog.txt is launcher's log and MinecraftLog.txt is minecraft's log. FTBLauncherLog.txt is always needed and MinecraftLog.txt if problem is in your modpack e.g. modpack crashes.
 - Open http://wikisend.com/, press `Browse` button, select log file and then press `Upload file` button. Add given link to your question/comment or paste link to IRC

<div id="server" class="customanchor"></div>

# For Server Problems

You will be asked to provide a Server log. This should be in the server folder. Your file path should resemble this: C:\Users\Me\Desktop\DW20Server\ForgeModLoader-server-0.log.

<div id="notstarting" class="customanchor"></div>

# My launcher does not work at all

If your launcher do not open at all, console window's buttons are disabled or console windows does not respond then 1. Check if there are files FTBLauncherLog.txt and/or MinecraftLog.txt in your FTB launcher installation location. 2. If files are updated when you run launcher manually submit log files

If those files are empty or do not update you need to run launcher from command line:
## Windows

 1. Move launcher.jar in your Desktop. If you do not have FTB_Launcher.jar then download it into your desktop from http://feed-the-beast.com/
 2. Open command prompt (Click the Windows icon and search for CMD then hit enter.)
 3. Move in in your Desktop by typing cd Desktop and pressing enter key
 4. Type "java -jar " e.g. `java -jar FTB_Launcher.jar` and press enter
 5. Right click command prompt's title bar => `Edit` => `Select all` => then press `enter` to copy contents of window to clipboard
 6. Paste output from clipboard into pastebin and attach new paste URL into your question/comment

## Linux / OS X

 - Open terminal
 - follow windows guide. Use OS specific methods to copy contents of terminal.

<div id="hardware" class="customanchor"></div>

# How to submit hardware information
## Windows

 - hold the Windows logo key and tap R
 - the Run box will appear
 - type: `dxdiag` and press `enter`
 - on the dxdiag screen, click `save all information`
 - save it to a file on your desktop
 - go to http://wikisend.com16 and upload that file and give us the URL

## Linux

 - install lshw
 - run `sudo lshw > lshw.log` in terminal
 - go to http://wikisend.com16 and upload that file and give us the URL

<div id="threaddump" class="customanchor"></div>

# Thread dump

## If you have installed only JRE and you are running Windows:

 1. Download required external tool: https://github.com/walware/statet/raw/master/de.walware.statet.r.console.core/win32/x86_64/sendsignal.exe Save program in your Desktop
 2. Open command prompt and run launcher in it like described earlier
 3. Fetch PID of the Launcher: To determine PID of the Java:
    - Right-click an empty area on the task bar and select Task Manager.
    - Select the Processes tab.
    - Select View > Select columns... from the menu bar.
    - Check PID (Process Identifier).
    - Click the OK button.
    - Click on the Image Name column to resort the processes by name.
    - Locate the process named "java". If there are multiple Java processes, locate the relevant one.
    - Note of the number in the PID column.
 4. Open new command prompt and run "SendSignal" e.g. `SendSignal 4242`
 5. copy/paste and post new thread dump from other command prompt

## If you have installed JDK(not JRE): Use visualVM:

 - download https://java.net/projects/visualvm/downloads/download/release137/visualvm_137.zip
 - Unzip the downloaded archive. The archive already contains the top-level visualvm directory.
 - Start VisualVM by invoking the binary appropriate for your OS: visualvm\bin\visualvm.exe or visualvm/bin/visualvm
 - Start launcher if not already running
 - Locate Applications tab, (expand local if needed), right click FTB_Launcher-x.x.x.jar (pid xxxxx), left click "Thread dump" from popup menu
 - Thread dump will be opened at right side. Use mouse to select all and copy. Finally paste thread dump into pastebin and give use pastebin link.

## If you have installed JDK(not JRE): Use tools shipped with JDK:

 - start launcher
 - open command line terminal
 - Use "jps" to fetch PID of launcher
 - Use jstack -l to generate thread dump
 - copy/paste and post thread dump generated by jstack

<div id="forcemccrash" class="customanchor"></div>

# Force crash MC to generate crash log

You can force Minecraft to crash and generate a crash log by holding the "F3" + "C" at the same time for 10 seconds. This will crash Minecraft and generate a crash report.

# Documentation of doc

 - Document follows CommonMark specs
   - All HTML blocks must be in  separated blocks. Otherwise following lines will be also interpreted as HTML instead of CommonMark
 - I wanted to use permanent fragment ID's. Current implementations does not allow setting id of the the headers => fixed by adding extra div
   - other solution is use anchor inside header, but that solution is too buggy
   - Later `<div class="customanchor">`s should be converted to use CommonMark attribute syntax as soon as spec is done and there is implementation to use

