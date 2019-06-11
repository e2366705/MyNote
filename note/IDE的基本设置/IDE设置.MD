


# java(PHP)开发IDE设置选项 :
```  
	idea必须重新设置的快捷键 (因为实在是太常用了): 
		* 字体设置.
		* 设置配色方案 打开setting -> color scheme 找到JavaScript/java/html/css, 修改对应的配色方案 (注释: // /**/ /** 修改为白色)
		* 设置行号颜色 settings搜索 line number
		* 关闭窗口: (settings -> key)  搜索: ctrl + F4 
		* 自定义常用快捷键 (live Template 里面设置) :	
```



# IntelliJ IDEA报Found duplicated code in this file
```  
IntelliJ IDEA编程工具报Found duplicated code in this file错误提示是因为你的代码重复了
IntelliJ IDEA设置步骤如下
File → Settings → Editor → Inspections → General → Duplicated Code.
```



# 设置行号:
```
	打开setting -> 搜索 line number 
```



# 设置格式化的快捷键
```  
打开 settings 
输入 keymap
搜索 Reformat (格式化的意思)
```


# 配置编辑时候的文字颜色:
```  
CTRL + alt + S 进入 settings 界面 -> 输入 color 
下面一些就是配置颜色的了:\
常用的需要配置颜色的有:
	java
	JavaScript
	html
	css
	xml
```




# AutoHotkey
```  
::fk::举个例子: AutoHotkey 真是好用到爆!!!!! 强烈安利..... 嘤嘤嘤 ~ ~ ~

::boo::border: red solid 1px;
::bbb::background-color: pink;
::cl::console.log();
::al::alert();
::whbg::width: 150px; height: 150px; background-color: skyblue;
::htmllll::<html lang="zh"><head><style>*{margin:0;padding:0;text-decoration:none;list-style-type:none}body{max-width:640px;min-width:320px;border:red solid 1px}</style><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"><meta http-equiv="X-UA-Compatible" content="ie=edge"><title>YXB</title><link rel="styleSheet" href="" type="text/css"><script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script></head><body><h1>YXB</h1></body><script type="text/javascript" src=""></script></html>
```



# idea 自动编译:
```  
	1 打开settings, 搜索compiler -> build project automatically
	2 ide右上角 , Run –>EditConfigguration
	  找到Tomcat Server
	  有两个选项卡, on update action + on feame deactivation
	  两个都选择: update classes and resources
```



# idea 自带快捷键:	    
```  
	1-- itar   JavaScript 
			for (var i = 0; i < ii.length; i++) {
					const iiElement = ii[i];
			}

	2-- itin 	 JavaScript 
			for (var iiKey in ii) {
					
			}

	3-- fori 	  JavaScript 
			for (var i = 0; i < ; i++) {
					
			}
	4-- cl -> console.log()  JavaScript
		需要自己去设置!!!  
		settings -> live Template
```




# idea 开发 springBoot如何实时刷新?
```  
如果因为旧项目十分臃肿，导致热重启很慢而影响开发效率，
笔者建议直接在POM移除spring-boot-devtools依赖，然后使用Control+Shift+F9进行免启动快速更新！！

教程链接 https://www.jianshu.com/p/f658fed35786	
```

	


# Intellij IDEA ，按Ctrl+左键，不能进入类或方法，
# 提示Cannot find declaration to go to
```  
解决办法:
		是因为没有设置资源文件夹(Sources Root) , 
		java'文件夹右键设置资源文件即可
```




# idea 配置 less:
```  
	首先安装 file watchers 插件: settings -> Plugins -> 搜索:file watchers 插件安装
	重启idea编辑器
	settings -> 搜索 file watchers
	配置less解析器
```



# idea打包javaweb项目,有两种方式 : 一种是war，一种是 war explored
```  
	war不支持热更新(就是你修改html源代码, 不自动更新源码)
	war explored 支持热更新, 修改html内容, 网页也随之改变
	推荐使用 war explored 
```

