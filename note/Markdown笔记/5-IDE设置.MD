# 各种开发IDE 或 编辑器的设置选项 :

## No.1 - JetBrains 家族:

### idea中注释:  /** */ 支持自动格式化  ,  /* */不支持自动格式化...


### idea maven太慢, 一招解决!!
### https://blog.csdn.net/zhaoyy0513/article/details/80682934
	


# 注意: SpringBoot是不用自己去配置Tomcat的!!!
## 妈的, 我在2020-01-23这一天折腾了好几个小时, 死活配置不好Tomacat, 突然想起来SpringBoot是不用配置Tomcat的....




<details>
<summary>111111111111111</summary>

111111111111111
</details>



<details>
<summary><b>222222222222</b></summary>

2222222222222
</details>





#### 各种版本的Java官方下载:
```
https://www.oracle.com/technetwork/java/archive-139210.html

```


#### 随后: 设置行号颜色
```  
settings
Editor
color scheme
General
code -> line number
```


#### Found duplicated code(发现了重复的代码)
```  
Settings —> Editor —> Inspections —> General —> Duplicated Code

```


#### idea 找不到Tomcat服务器?
```  
打开 settings -> 搜索:plugins
把 tomcat 打上勾

```


#### IntelliJ IDEA报Found duplicated code in this file
```  
IntelliJ IDEA编程工具报Found duplicated code in this file错误提示是因为你的代码重复了
IntelliJ IDEA设置步骤如下
File → Settings → Editor → Inspections → General → Duplicated Code.
```



#### Pycharm出现太多空格 : Pycharm pep 8 indentation contains tabs
```  
As a temporary workaround:

Alt+Enter

choose "Ignore errors like this"

```



#### idea 开发 springBoot如何实时刷新?
```  
如果因为旧项目十分臃肿，导致热重启很慢而影响开发效率，
建议直接在POM移除spring-boot-devtools 依赖，然后使用 Ctrl+Shift+F9 进行免启动快速更新！！

2020-01-25 经过测试发现 
Ctrl+Shift+F9 只针对前端内容(html / css / JavaScript)的改动生效
对后端(Java springBoot)的改动并不生效
可以直接在idea里面用 Ctrl+F5 重启 debug  只不过速度比较慢...

教程链接 https://www.jianshu.com/p/f658fed35786	
```

	

#### Intellij IDEA ，按Ctrl+左键，不能进入类或方法，
#### 提示Cannot find declaration to go to
```  
解决办法:
		是因为没有设置资源文件夹(Sources Root) , 
		java'文件夹右键设置资源文件即可
```



#### idea 配置 less:
```  
	首先安装 file watchers 插件: settings -> Plugins -> 搜索:file watchers 插件安装
	重启idea编辑器
	settings -> 搜索 file watchers
	配置less解析器
```


#### idea打包javaweb项目,有两种方式 : 一种是war，一种是 war explored
```  
	war不支持热更新(就是你修改html源代码, 不自动更新源码)
	war explored 支持热更新, 修改html内容, 网页也随之改变
	推荐使用 war explored 
```



#### idea 自动编译:
```  
	1 打开settings, 搜索compiler -> build project automatically
	2 ide右上角 , Run –>EditConfigguration
	  找到Tomcat Server
	  有两个选项卡, on update action + on feame deactivation
	  两个都选择: update classes and resources
```


<details>
<summary><b>idea 自定义注释模板:</b></summary>

```  
settings
live templates
点击右边那个加号 弹出 live template
填写 // 
下面 template text 填写:  // $date$ $time$
点击 edit variables 
date选择 data()
time选择 time()
选择应用范围(一般是 Java 和 JavaScript)

最后, 在编辑过程中, 打出 // 然后按一下 Tap 键,
就会一键生成 // 2020/1/26 15:38
```
</details>





<details>
<summary>必须设置的:</summary>

```  
	快捷键 => settings -> keymap:
	关闭当前标签:
 	搜索: ctrl + F4 
	再然后搜索 close 设置快捷键

	在系统文件夹打开:
	show in explorer : Alt + E

	格式化代码:
	搜索: format
	设置为: shift + F


 	字体设置(font):
		包括字体大小
			哪种字体
			行间距为 1.4 比较合适,不要太挤



	忽略大小写自动提示:
	打开 setting -> 输入 Completion
	有一个 code Completion项目 点击去
	有个match case,  把那个钩去掉



	代码颜色:
	CTRL + alt + S 进入 settings 界面 -> 输入 color 
	常用的需要配置颜色的有:
	java
	JavaScript
	html
	css
	xml

	常用的有:
	//
	/* */
	/** */
	""

```
</details>





<details>
<summary><b>idea 配置自动编译</b></summary>

```  
首先:
	打开 setting 
	搜索: "Java compile" :
		找到: 'build project automatically' 打上勾 ;
		找到 "compile independent modules in parallel (may require larger heap size)" 打上勾;

在 idea 的右上角 , 有个 'edit configurations' 点击进去 (就是每次点击 Run/debug 的地方) , 
有个 'on update action'  ,
选择 : hot swap classes and update trigger file if failed
下面就选择: update classess and resouses

* 如果上述还是不行的话, 最后一招:
	按住 shift + alt + ctrl + /   会弹出一个对话框 , 选择: Registry 
	找到:
		comiler.perform.outputs.refresh.on.start
		compiler.automake.allow.when.app.running
	这两行打上勾

```
</details>




<details>
<summary><b>idea 自带快捷键: </b></summary>

```  
	1-- itar  
	生成for循环的快捷键:
		for (var i = 0; i < ii.length; i++) {
				const iiElement = ii[i];
		}

	2-- itin 
		for (var iiKey in ii) {
				
		}

	3-- fori
		for (var i = 0; i < ; i++) {
				
		}
	4-- cl -> console.log()  JavaScript
		需要自己去设置!!!  
		settings -> live Template
```
</details>

# 这是示范 1
## 这是示范 2
### 这是示范 3
#### 这是示范 4  => 这个字体大小刚刚合适
##### 这是示范 5
###### 这是示范 6




# other:

#### AutoHotkey
```  
::fk::举个例子: AutoHotkey 真是好用到爆!!!!! 强烈安利..... 嘤嘤嘤 ~ ~ ~

::boo::border: red solid 1px;
::bbb::background-color: pink;
::cl::console.log();
::al::alert();
::111::```````  `n`n`n```````
::whbg::width: 150px; height: 150px; background-color: skyblue;
::htmllll::<html lang="zh"><head><style>*{margin:0;padding:0;text-decoration:none;list-style-type:none}body{max-width:640px;min-width:320px;border:red solid 1px}</style><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"><meta http-equiv="X-UA-Compatible" content="ie=edge"><title>YXB</title><link rel="styleSheet" href="" type="text/css"><script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script></head><body><h1>YXB</h1></body><script type="text/javascript" src=""></script></html>

换行(适用于一大段文字的情况下):
::hhh::
clipboard=
(
aaaaaaaaaaaaaaaaaa
bbbbbbbbbbb
cccccccccc
)
Send ^v{enter}
Sleep, 1000
Return

```

