# 安装 Maven
---

```

下载好 maven

解压在 C:\Program Files\Maven\ 这个文件夹, 没有建一个

 win -> 搜素 '高级系统设置 '  -> 环境变量

 新建系统变量  
    MAVEN_HOME  变量值：C:\Program Files\Maven\apache-maven-3.5.0\

 编辑系统变量  Path    
    添加变量值： %MAVEN_HOME%\bin


查看 maven 安装路径 :
  打开 cmd , 输入 mvn -v
  Maven home: C:\Program Files\Maven\apache-maven-3.5.0\bin\..
  这就是 maven 的安装路径


国内的maven仓库太慢,  配置镜像:

打开maven 文件夹里面有个 conf 文件夹, 
找到配置文件: setting.xml，
里面有个<mirrors>配置项目，所有的镜像都配置在这里面，如下面配置了两个镜像库:



修改 idea 自带的 maven 地址:  
一般的安装路径在: 
C:\Program Files\JetBrains\IntelliJ IDEA 2019.3.3\plugins\maven\lib\maven3\conf\settings.xml




镜像地址:
<mirrors>
    <mirror>
      <id>aliyun</id>
      <mirrorOf>central</mirrorOf>
      <name>aliyun</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public</url>
    </mirror>
    <mirror>
      <id>UK</id>
      <name>UK Central</name>
      <url>http://uk.maven.org/maven2</url>
      <mirrorOf>central</mirrorOf>
    </mirror>
  </mirrors>







方式二，针对单个项目
在项目的maven配置文件pom.xml里，添加repositories配置即可，如下：

  <repositories>
    <repository>
      <id>aliyun</id>
      <name>aliyun</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public</url>
    </repository>
  </repositories>






```
