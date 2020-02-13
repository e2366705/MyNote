::fk::举个例子: AutoHotkey 真是好用到爆!!!!! 强烈安利..... 嘤嘤嘤 ~ ~ ~
::boo::border: red solid 1px;
::bbb::background-color: pink;
::conso::console.log();
::posiab::position:absolute;
::posire::position:relative;
::equal::=====================================================================================================
::whbg::width: 150px; height: 150px; background-color: skyblue;
::maxmin::max-width:640px;min-width:320px;border:green solid 1px;margin:0 auto;
::pause::print("===============================  程序暂停(pause)了  =========================");time.sleep(9999);



::=========   脚本分割线  =========::  





::111::```````  `n`n`n```````






::=========   脚本分割线  =========::  




::6666::
clipboard=
(
<details>
<summary><b>my_name_is_jack</b></summary>


</details>
)
Send ^v{enter}
Sleep, 1000
Return






::=========   脚本分割线  =========::  








^3::send %A_YYYY%-%A_MM%-%A_DD% %A_Hour%:%A_Min%:%A_Sec%









::=========   脚本分割线  =========::  






; win键 + 右Ctrl : 打开文件夹, 并且点击右键 , 选中 Get Bash Here , 输入 ./update.sh , 就差回车确认了
*<#RCtrl:: 

sleep, 123
Run C:\D\Nut_cloud___\我的坚果云\笔记\Github_Notes\MyNote

sleep, 666
WinMaximize, A  ; 最大化活动窗口

sleep, 666
Click 1776,931 right      ; 在坐标1776, 931位置上, 点击右键

sleep, 123
MouseMove, 100, -180, 12, R

sleep, 123
Click left

sleep, 999
SendEvent {Blind}{Up down}
KeyWait RCtrl  ; 防止键盘自动重复导致的重复鼠标点击.
SendEvent {Blind}{Up up}

sleep, 333
Send, 00

return




























