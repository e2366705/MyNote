# 各种开发IDE 或 编辑器的设置选项 :
* idea中注释:  /** */ 支持自动格式化  ,  /* */不支持自动格式化...


### idea maven太慢, 一招解决!!
* https://blog.csdn.net/zhaoyy0513/article/details/80682934
	


### 注意: SpringBoot是不用自己去配置Tomcat的!!!
### 妈的, 我在2020-01-23这一天折腾了好几个小时, 死活配置不好Tomacat, 突然想起来SpringBoot是不用配置Tomcat的....
* SpringBoot 自己内置了一个小型的服务器
* 方便快捷, 适用于快速开发


### IntelliJ IDEA 自带的数据库管理工具是真的香
* 支持智能提醒, 语法报错, 真是太适合我这种小菜鸟了
* IntelliJ IDEA 大法好!!!





### 另外, 还有一款 命令行 管理MySQL的工具, 叫做: MyCli , 支持自动补全关键字、表名、列和函数 
<details>
<summary><b> MyCli </b></summary>

```

MyCli 是 MySQL 的专用命令行客户端，可以自动补全和语法高亮显示
安装方法:  pip install mycli   (首先先要安装 python )

mycli -uroot

直接可以进入 MySQL 

支持语法字段/表名自动补全, 提醒, 完美

另外好用的 MySQL 管理客户端有:  
	IntelliJ IDEA 自带的数据库管理工具 (五星级好用, 收费, 可试用)
	SQLyog(收费, 可试用)   
	MySQL-Front(免费)   
	HeidiSQL(免费)

经过使用, 发现 SQLyog 不如 HeidiSQL好用 , 数据有时候已经更新了, 但是在 SQLyog 里面就是刷新不出来


```
</details>













<details>
<summary><b> Test </b></summary>

```  

<summary><b> Test </b></summary> 下面必须空一行, 不然在 Markdown 里识别失败

<b> 是加粗字体的效果

这里是内容...

```
</details>

























# 一些基本的
* idea 卸载之前一定要把 `删除设置` , `删除缓存` 按钮给勾选上, 不然重装之后会直接报只有 30 分钟试用
<details>
<summary><b>首先...</b></summary>

```  


可以直接在 Settings 里面搜索: 比如搜索: font(字体设置)


第一步肯定是字体的设置(大小 颜色):
	字体分为软件界面设置 和 编辑区代码字体设置:
		软件界面字体大小:
			File | Settings | Appearance & Behavior | Appearance
				字体大小 16 比较合适
		
		编辑区代码字体设置:
			File | Settings | Editor | Font
			字体大小 18 比较合适
			字体推荐 Fira code
			行间距为 1.3 比较合适,不要太挤


第二就是快捷键的设置:
	File | Settings | Keymap

		关闭当前标签:
		搜索: ctrl + F4 
		再然后搜索 close 设置快捷键

		在系统文件夹打开:
		show in explorer : Alt + E

		格式化代码:
		搜索: format
		设置为: shift + F


第三:
	忽略大小写自动提示:
	打开 setting -> 输入 Completion
	有一个 code Completion项目 点击去
	有个match case,  把那个钩去掉


其他:
代码颜色的设置:
	File | Settings | Editor | Color Scheme

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




	idea 自动补全代码 
		Alt + 回车键(enter)
	比如:
		new User();  直接一键生成  User user = new User();
	(一键导包也是这个快捷键)

	
	
	
	系统自带快捷键:

	Alt + Insert :
		一键生成 getter / setter / toString / 构造方法

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

	5-- 
		Ctrl + F2 停止程序		

	6--
		Alt + Enter  一键补全代码( new User;  =>  User user = new User();  )




各种版本的Java官方下载:
https://www.oracle.com/technetwork/java/archive-139210.html

设置行号颜色:
settings
Editor
color scheme
General
code -> line number


Found duplicated code(发现了重复的代码)
Settings —> Editor —> Inspections —> General —> Duplicated Code


idea 找不到Tomcat服务器?
打开 settings -> 搜索:plugins
把 tomcat 打上勾


IntelliJ IDEA报Found duplicated code in this file
IntelliJ IDEA编程工具报Found duplicated code in this file错误提示是因为你的代码重复了
IntelliJ IDEA设置步骤如下
File → Settings → Editor → Inspections → General → Duplicated Code.



Pycharm出现太多空格 : Pycharm pep 8 indentation contains tabs
As a temporary workaround:
Alt+Enter
choose "Ignore errors like this"



idea 配置 less:
	首先安装 file watchers 插件: settings -> Plugins -> 搜索:file watchers 插件安装
	重启idea编辑器
	settings -> 搜索 file watchers
	配置less解析器



idea打包javaweb项目,有两种方式 : 一种是war，一种是 war explored
	war不支持热更新(就是你修改html源代码, 不自动更新源码)
	war explored 支持热更新, 修改html内容, 网页也随之改变
	推荐使用 war explored 


```
</details>


















<details>
<summary><b> PyCharm 取消没必要的波浪线</b></summary>

```  

python是门语言代码非常严格的编程语言, 有时候你写的代码并没有错, 只是代码不符合规范, PyCharm也会提出警告(黄色波浪线)

但是这些代码仅仅是不规范, 并没有语法上的错误

如何修改 PyCharm 不让他碍手碍脚呢?

教程如下:

https://blog.csdn.net/xiemanR/article/details/72583718


```
</details>




















<details>
<summary><b> idea 开发 springBoot如何实时刷新?</b></summary>

```  

如果因为旧项目十分臃肿，导致热重启很慢而影响开发效率，
建议直接在POM移除spring-boot-devtools 依赖，然后使用 Ctrl+Shift+F9 进行免启动快速更新！！

2020-01-25 经过测试发现 
Ctrl+Shift+F9 只针对前端内容(html / css / JavaScript)的改动生效
对后端(Java springBoot)的改动并不生效
可以直接在idea里面用 Ctrl+F5 重启 debug  只不过速度比较慢...

教程链接 https://www.jianshu.com/p/f658fed35786	


```
</details>


















<details>
<summary><b>Maven</b></summary>

```  

针对单个项目
在项目的maven配置文件pom.xml里，添加repositories配置即可，如下：

  <repositories>
    <repository>
      <id>aliyun</id>
      <name>aliyun</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public</url>
    </repository>
  </repositories>

```
</details>



















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
<summary><b> 导入 / 导出设置 </b></summary>

```  

IntelliJ IDEA导出设置

导出：【File】->【Export Settings】

导入：【File】->【Import Settings】


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





# 这是示范 1
## 这是示范 2
### 这是示范 3
#### 这是示范 4  => 这个字体大小刚刚合适
##### 这是示范 5
###### 这是示范 6




# other:


