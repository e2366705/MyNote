# About Springboot
# 注意: SpringBoot是不用自己去配置Tomcat的!!!
## 妈的, 我在2020-01-23这一天折腾了好几个小时, 死活配置不好Tomacat, 突然想起来SpringBoot是不用配置Tomcat的....

```  


```


## Springboot 常见目录结构树 ( win10 打开 cmd -> tree D:code  /f ):
<details>
<summary><b> Springboot 文件夹树形结构 </b></summary>

```  

├─demo-2
│  │  pom.xml
│  │
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─example
│      │  │          └─demo
│      │  │              │  DemoApplication.java
│      │  │              │
│      │  │              ├─bean
│      │  │              │      Major.java
│      │  │              │      Student.java
│      │  │              │      User.java
│      │  │              │
│      │  │              ├─controller
│      │  │              │      MajorController.java
│      │  │              │      StudentController.java
│      │  │              │      UserLoginController.java
│      │  │              │
│      │  │              ├─dao
│      │  │              │      MajorDao.java
│      │  │              │      StudentDao.java
│      │  │              │      UserLoginDao.java
│      │  │              │
│      │  │              └─service
│      │  │                  │  MajorService.java
│      │  │                  │  StudentService.java
│      │  │                  │  UserLoginService.java
│      │  │                  │
│      │  │                  └─impl
│      │  │                          MajorImpl.java
│      │  │                          StudentImpl.java
│      │  │                          UserLoginImpl.java
│      │  │
│      │  └─resources
│      │          application.properties
│      │
│      └─test
│          └─java
│              └─com
│                  └─example
│                      └─demo
│                              DemoApplicationTests.java





├─spring-boot-web-thymeleaf
│  │  pom.xml
│  │
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─demo
│      │  │      └─springboot
│      │  │          │  WebApplication.java
│      │  │          │
│      │  │          ├─domain
│      │  │          │      Book.java
│      │  │          │
│      │  │          ├─service
│      │  │          │  │  BookService.java
│      │  │          │  │
│      │  │          │  └─impl
│      │  │          │          BookServiceImpl.java
│      │  │          │
│      │  │          └─web
│      │  │                  BookController.java
│      │  │
│      │  └─resources
│      │      │  application.properties
│      │      │
│      │      ├─static
│      │      │  ├─css
│      │      │  │      default.css
│      │      │  │
│      │      │  └─images
│      │      │          favicon.ico
│      │      │
│      │      └─templates
│      │              bookForm.html
│      │              bookList.html
│      │
│      └─test
│          └─java
│              └─demo
│                  └─springboot
│                          WebApplicationTests.java


```
</details>







<details>
<summary><b>树形目录结构详解: </b></summary>

```  


├─demo-2
│  │  pom.xml
│  │
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─example
│      │  │          └─demo
│      │  │              │  DemoApplication.java   [启动类 run ]
                                        public static void main(String[] args) {
                                                SpringApplication.run(DemoApplication.class, args);
                                        }
│      │  │              │
│      │  │              ├─bean   [bean类(也叫Entity)]
│      │  │              │      User.java
                                            private int user_id;
                                            private String user_name;
                                            private String password;

                                            public User(){}

                                            public User(String user_name, String password) {
                                                this.user_name = user_name;
                                                this.password = password;
                                            }      
│      │  │              │
│      │  │              ├─controller   [ controller 控制类]
│      │  │              │      StudentController.java
                                          @GetMapping("/getAll")
                                          public List<Student> getAll(){
                                              return studentService.findAll();
                                          }

                                          @GetMapping("/get/{name}")
                                          public Student getByName(@PathVariable String name){
                                              return studentService.searchByName(name);
                                          }
│      │  │              │
│      │  │              ├─dao   [dao类 与数据库互动]
│      │  │              │      StudentDao.java
                                    @Query("select s from Student s where s.stu_name=?1")
                                    Student searchByName(String name);
│      │  │              │
│      │  │              └─service   [service类]
│      │  │                  │  StudentService.java
                                    public interface StudentService {
                                            //根据姓名查找
                                            Student searchByName(String name);  
                                    }
│      │  │                  │
│      │  │                  └─impl   [实现类]
│      │  │                         StudentImpl.java
                                        @Autowired
                                        StudentDao studentDao;

                                        @Override
                                        public Student searchByName(String name) {
                                            return studentDao.searchByName(name);
                                        }    
│      │  │
│      │  └─resources   [资源文件夹]
│      │       application.properties   [配置文件]
                            spring.datasource.url=jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false
                            spring.datasource.username=root
                            spring.datasource.password=root

                            spring.datasource.driver-class-name=com.mysql.jdbc.Driver
                            spring.jpa.properties.hibernate.hbm2ddl.auto=none
│      │      ├─static   [静态文件 css js pic等]
│      │      │  ├─css
│      │      │  │      default.css
│      │      │  │
│      │      │  └─images
│      │      │          favicon.ico
│      │      │
│      │      └─templates   [html]
│      │              bookForm.html
│      │              bookList.html                            
│      │
│      └─test
│          └─java
│              └─com
│                  └─example
│                      └─demo
│                              DemoApplicationTests.java



```
</details>








<details>
<summary><b>springBoot访问静态资源(js, CSS等)</b></summary>

```  
静态资源一定要放在 src\main\resources\static 下面, 不要没办法访问

而且一定要 重启 springBoot 服务器 , 不然静态资源没办法更新 ( 在idea下快捷键是: Ctrl + F5 )

配置文件:
application.properties:
spring.mvc.static-path-pattern=/**

html引用:
<script src="/Remember_words/Last_Next_Words.js"></script>

src\main\resources\static\Remember_words\Last_Next_Words.js

```
</details>


<details>
<summary><b>pom.xml添加文件依赖 / 并配置 aliyun 镜像</b></summary>

```  	

    首先要加上这个:
        <parent>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.0.0.M4</version>
        </parent>  



<dependencies> 里面添加:   


        <!--               Spring 家族                      -->

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>

        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.2</version>
        </dependency>






        <!--                      other                           -->
     <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
            <version>4.5.5</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/javazoom/jlayer -->
        <dependency>
            <groupId>javazoom</groupId>
            <artifactId>jlayer</artifactId>
            <version>1.0.1</version>
        </dependency>

        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.9.5</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.4.5</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.12</version>
        </dependency>

        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.8.2</version>
        </dependency>

        <dependency>
            <groupId>org.jsoup</groupId>
            <artifactId>jsoup</artifactId>
            <version>1.10.2</version>
        </dependency>

        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.1</version>
        </dependency>


    <repositories>里面添加:
            <repository>
                <id>aliyun</id>
                <name>aliyun</name>
                <url>http://maven.aliyun.com/nexus/content/groups/public</url>
            </repository>


```
</details>





<details>
<summary><b>配置 application.properties</b></summary>

```  
server.port=8082

server.tomcat.uri-encoding=UTF-8

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/english_word?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root

spring.mvc.static-path-pattern=/static/**

# 开发时关闭缓存,不然没法看到实时页面
spring.thymeleaf.cache=false
```
</details>




<details>
<summary><b>添加 controller</b></summary>

```  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *  index
 */
@Controller
public class index_controller {
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(Model model){

        System.out.println("index");

//        String path = "src/main/java/com/hehe/Article/";
//
//        model.addAttribute("result" , path);

        return "index";
    }
}
```
</details>



### 一个 html 文件里面包含另一个 html 文件
```  
    <div th:replace="head_title.html"></div>
```


#### 然后 - 添加 html 文件: resources\templates 文件夹下面
```  
index.html
```

# idea 配置自动编译
```  
首先:
	打开 setting 
	搜索: 'Java compile' 
	找到: 'build project automatically' 打上勾

在 idea 的右上角 , 有个 'edit configurations' 点击进去 (就是每次点击 Run/debug 的地方)
有个 'on update action'  选择 : hot swap classes and update trigger file if failed
下面就选择: update classess and resouses

* 如果上述还是不行的话, 最后一招:
	按住 shift + alt + ctrl + /   会弹出一个对话框 , 选择: Registry 
	找到:
		comiler.perform.outputs.refresh.on.start
		compiler.automake.allow.when.app.running
	这两行打上勾

```


### 在浏览器打开
```  
http://localhost:8082/
```





--------------------------------------------------------------------------------------------------------------------

# SpringBoot 配置
### application.yml
```  
```






### application.properties
```  
spring.application.name=compute-service
server.port=8081
server.tomcat.uri-encoding=UTF-8

#mybatis.type-aliases-package=com.neo.model
#spring.datasource.url=jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true
#spring.datasource.username=root
#spring.datasource.password=root
#spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

```

### 或者:
```  

spring.mvc.static-path-pattern=/static/**

```

### 又或者:
```  
server.port=8080
server.context-path=/demo
druid.driver=com.mysql.jdbc.Driver
druid.url=jdbc:mysql://localhost:3306/mysql
druid.username=root
druid.password=123456
druid.init-size=1
druid.min-idel=1
druid.max-active=5
druid.login.timeout.seconds=30
druid.query.timeout.seconds=30

```


### 又或者:
```  
server.port=8083
spring.datasource.url=jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false
spring.datasource.username=root
spring.datasource.password=root

spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.properties.hibernate.hbm2ddl.auto=none

```





# springBoot 中 css 文件引入失败?
```  
spring.mvc.static-path-pattern=/static/**

```


































