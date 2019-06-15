@echo off

:start
echo Clear......
start "" "C:\Program Files (x86)\LuDaShi\LuDaShi\sweeper\MemoryOptimizer.exe" /optimize"

choice /t 300 /d y /n >nul

goto start