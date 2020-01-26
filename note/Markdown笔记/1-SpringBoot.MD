# About Springboot
# 注意: SpringBoot是不用自己去配置Tomcat的!!!
## 妈的, 我在2020-01-23这一天折腾了好几个小时, 死活配置不好Tomacat, 突然想起来SpringBoot是不用配置Tomcat的....


### 包含另一个 html 文件
```  
    <div th:replace="head_title.html"></div>
```


<details>
<summary><b>springBoot访问静态资源(js, CSS等)</b></summary>

```  
静态资源一定要放在 src\main\resources\static 下面, 不要没办法访问

配置文件:
application.properties:
spring.mvc.static-path-pattern=/**

html引用:
<script src="/Remember_words/Last_Next_Words.js"></script>

src\main\resources\static\Remember_words\Last_Next_Words.js

```
</details>


<details>
<summary><b>添加xml文件依赖:</b></summary>

```  	
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.12</version>
        </dependency>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.3.1</version>
        </dependency>
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


































