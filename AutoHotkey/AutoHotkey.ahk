::fk::举个例子: AutoHotkey 真是好用到爆!!!!! 强烈安利..... 嘤嘤嘤 ~ ~ ~
::boo::border: red solid 1px;
::bbb::background-color: pink;
::conso::console.log();
::posiab::position:absolute;
::posire::position:relative;
::whbg::width: 150px; height: 150px; background-color: skyblue;
::maxmin::max-width:640px;min-width:320px;border:green solid 1px;margin:0 auto;
::----::-----------------------------------      -----------------------------------


;C语言中的:
::cpri::printf("            \n");

;================   我是注释  ==================


::111::```````  `n`n`n```````


::=========   脚本分割线  =========::  


::HTMLTEMPLATE::
clipboard=
(
<!DOCTYPE html><html lang="zh"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1.0"><title>YXB</title><script src="https://s1.pstatp.com/cdn/expire-1-M/jquery/2.1.4/jquery.min.js"        type="application/javascript"></script><script src="http://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script><script src="https://s0.pstatp.com/cdn/expire-1-M/vue/2.6.10/vue.min.js" type="application/javascript"></script><link href="https://s2.pstatp.com/cdn/expire-1-M/twitter-bootstrap/3.4.0/css/bootstrap.min.css" type="text/css"        rel="stylesheet" /><script src="https://s1.pstatp.com/cdn/expire-1-M/twitter-bootstrap/3.4.0/js/bootstrap.min.js"        type="application/javascript"></script><script src="https://s1.pstatp.com/cdn/expire-1-M/layer/2.3/layer.js" type="application/javascript"></script><style>        * {            margin: 0;            padding: 0;            text-decoration: none;            list-style-type: none;        }</style></head><body><h1>Hello World~</h1></body><script></script></html>
)
Send ^v{enter}
Sleep, 1000
Return


::=========   脚本分割线  =========::  

::6666::
clipboard=
(
<details>
<summary><b>my_name_is_jack</b></summary>

``````


``````
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
Run C:\Users\YXB\Documents\我的坚果云\笔记\Github_Notes\MyNote

sleep, 666
WinMaximize, A  ; 最大化活动窗口

sleep, 666
Click 1776,931 right      ; 在坐标1776, 931位置上, 点击右键

 ;  方向键 [上] (第 1  次)
sleep, 66
SendEvent {Blind}{Up down}
KeyWait RCtrl                       ; 防止键盘自动重复导致的重复鼠标点击.
SendEvent {Blind}{Up up}

 ;  方向键 [上] (第 2  次)
sleep, 66
SendEvent {Blind}{Up down}
KeyWait RCtrl                       ; 防止键盘自动重复导致的重复鼠标点击.
SendEvent {Blind}{Up up}

 ;  方向键 [上] (第 3  次)
sleep, 66
SendEvent {Blind}{Up down}
KeyWait RCtrl                       ; 防止键盘自动重复导致的重复鼠标点击.
SendEvent {Blind}{Up up}

 ;  方向键 [上] (第 4  次)
sleep, 66
SendEvent {Blind}{Up down}
KeyWait RCtrl                       ; 防止键盘自动重复导致的重复鼠标点击.
SendEvent {Blind}{Up up}

 ;  方向键 [上] (第 5  次)
sleep, 66
SendEvent {Blind}{Up down}
KeyWait RCtrl                       ; 防止键盘自动重复导致的重复鼠标点击.
SendEvent {Blind}{Up up}

 ;  方向键 [上] (第 6  次)
sleep, 66
SendEvent {Blind}{Up down}
KeyWait RCtrl                       ; 防止键盘自动重复导致的重复鼠标点击.
SendEvent {Blind}{Up up}

 ;  方向键 [上] (第 7  次)
sleep, 66
SendEvent {Blind}{Up down}
KeyWait RCtrl                       ; 防止键盘自动重复导致的重复鼠标点击.
SendEvent {Blind}{Up up}

 ;  方向键 [上] (第 8  次)
sleep, 66
SendEvent {Blind}{Up down}
KeyWait RCtrl                       ; 防止键盘自动重复导致的重复鼠标点击.
SendEvent {Blind}{Up up}

 ;  方向键 [上] (第  9  次)
sleep, 66
SendEvent {Blind}{Up down}
KeyWait RCtrl                       ; 防止键盘自动重复导致的重复鼠标点击.
SendEvent {Blind}{Up up}

sleep, 200

; 按下 回车键
Send {Enter}

sleep, 999          ; 暂停 xxx 毫秒

; 防止键盘自动重复导致的重复鼠标点击


sleep, 333
Send, ./update.sh00

return




























