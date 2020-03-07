# Windows 10 一些需要设置 / 优化的


### 1. Windows 10 需要关闭的(服务)
```  

https://www.zhihu.com/question/36192602


把以下五个默认是自动但是对于你来说毫无乱用的服务禁用掉Diagnostic System Host
Diagnostic Service Host
Diagnostic Policy Service
HomeGroup Provider
HomeGroup Listener
前三个用于诊断你的系统错误，反馈给微软，帮你自动解决。
但事实是只有大约1%的可能性会成功。
大多数时候，我们的电脑出故障了，是交给第三方软件解决的（或者百度）。
微软的那些东西卵用没有（难道你不这么觉得？）
后两个用于家庭组功能。
我敢说，在中国，用家庭组功能的人数“凤毛麟角”

1803版本更新后，windows直接取消了家庭组功能，
也就是
HomeGroup Provider
HomeGroup Listener
从服务列表里消失了这是不是侧面证明家庭组功能的无用？


```









### 2. 浏览器插件移植 (仅限于chromium内核浏览器)
```  

将 Chrome 的插件安装到 Edge (chromium):
参考资料:   https://zhuanlan.zhihu.com/p/61945053

C:\Users\[你的windows用户名]\AppData\Local\Google\Chrome\User Data\Default\Extensions
C:\Users\[你的windows用户名]\AppData\Local\Google\Chrome\User Data\Default\Extensions\aimiinbnnkboelefkjlenlgimcabobli\0.8.17_0


C:\Users\SpringBoot\AppData\Local\Google\Chrome\User Data\Default\Extensions\jlgkpaicikihijadgifklkbpdajbkhjo


在电脑的文件管理器是这样的:
C盘 / 用户 / 你的windows用户名(SpringBoot)  / AppData / Local / 
相对应的: 
    Google               谷歌 / 谷歌浏览器
    MicrosoftEdge        微软 Edge 浏览器 
    Opera Software       欧朋浏览器

插件放在 MicrosoftEdge \ User \ Default \ Extensions 下面






常用的浏览器插件有:
-----------------------------------------------------------------------------------------------
(仅限于chromium内核浏览器)
    谷歌访问助手                           做什么的, 不用我多说了叭
    二维码生成器 (Quick QR)                把网页生成二维码, 方便手机用户扫码访问
    扩展管理器（Extension Manager）        这是一款插件管理器, 强烈推荐, 可以快速方便的管理多个插件
    crxMouse Chrome 手势                  鼠标手势
    CSDN页面优化                           CSDN 广告真的恶心, 一个劲的给我推送植发, 
    GitZip for github                     可以下载单个 GitHub 的文件
    Google 翻译                           略...
    Linkclump                             一次性打开多个链接, 不过不要打开过多的网页, 小心卡死


```





