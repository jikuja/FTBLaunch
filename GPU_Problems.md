# Table of Content
 - [Generic Problems: Pixel Format Not Accelerated](#notaccel)
 - [Generic Problems: GPU driver crash](#gpudrivercrash)
 - [Intel GMA](#ancient)
 - [Westmere and Sandy Bridge HD Graphics iGPUs](#1st2nd)
 - [Haswell, Broadwell & Skylake: Performance problems](4th5th6th)

<!-------------------------------------------------------------------------------------------- -->
<div id="notaccel" class="customanchor"></div>

# Error: Pixel Format Not Accelerated
Do you use HD Graphics 2000 or 3000? Do you use HD Graphics inside Westmere or Sandy Bridge CPUs?
If yes skip to [Westmere and Sandy Bridge HD Graphics iGPUs](#1st2nd) otherwise continue reading....

Please check Mojang's documentation and try to fix the problem
* http://hopper.minecraft.net/help/pixel-format-not-accelerated/
* http://hopper.minecraft.net/help/references/windows-10/minecraft-compatibility

<!-------------------------------------------------------------------------------------------- -->
<div id="GPU driver crash" class="customanchor"></div>

# Generic Problems: GPU driver crash
* Update/downgrade/reinstall your GPU drivers. Check Mojang's links from previous section.

<!-------------------------------------------------------------------------------------------- -->
<div id="ancient" class="customanchor"></div>

# Pre Intel GMA
* Intel GMA: https://en.wikipedia.org/wiki/Intel_GMA
* Fourth generation and earlier in this list: https://en.wikipedia.org/wiki/List_of_Intel_graphics_processing_units
* Try updating GPU drivers. Warning: some mods are not compatible with these chipsets.

<!-------------------------------------------------------------------------------------------- -->
<div id="1st2nd" class="customanchor"></div>

# Westmere and Sandy Bridge driver problem with Windows 10/minecraft-compatibility
Drivers for these chipsets are broken. With Windows 10 usage of Java 8u51 or older is required. Intel will not fix drivers!
* https://github.com/LWJGL/lwjgl/issues/119
* https://bugs.mojang.com/browse/MC-297
* https://software.intel.com/en-us/forums/graphics-driver-bug-reporting/topic/607695

## Workarounds
* Do not use Windows 10
* Use correct Java version. Link to java archives: http://www.oracle.com/technetwork/java/archive-139210.html
* Buy better GPU
* #blameintel


<!-------------------------------------------------------------------------------------------- -->
<div id="4th5th6th" class="customanchor"></div>

# Haswell, Broadwell & Skylake: Performance problems
* Some driver version has worse performance. Load time of modded MC is increased to 30-60 minutes.
* https://github.com/LWJGL/lwjgl/issues/127

## Known workarounds
* Update/Downgrade your GPU drivers. Please report if this fixes performance
* Use real GPU
* Just wait patiently


