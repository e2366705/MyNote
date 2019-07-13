# PHP调试 - Xdebug
### 视频教程
### https://www.bilibili.com/video/av58197159?from=search&seid=11993396181794044005

## 下载 phpstudy , 并且把 php版本切换至 7.2.1 版本 , 原因是: xdebug不支持php5

```  

打开这个网站
https://xdebug.org/wizard.php

输入 echo phpinfo(); 的信息

按照要求下载dll文件

```

# 在 C:\phpStudy\PHPTutorial\php\php-7.2.1-nts\php.ini 加入:
```  
[Xdebug]
zend_extension = "C:\phpStudy\PHPTutorial\php\php-7.2.1-nts\ext\php_xdebug-2.7.2-7.2-vc15-nts.dll"

xdebug.remote_enable=1
xdebug.remote_host=127.0.0.1
xdebug.remote_port=9000

```

## 然后 , 打开chrome浏览器的插件市场 , 搜索:  `Xdebug helper` , 点击安装

## 打开phpstorm , 你会看到右上角有个像 `电话` 一样的图标 , 点击它