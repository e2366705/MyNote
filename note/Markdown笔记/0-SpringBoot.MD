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
<summary><b>pom.xml添加文件依赖 / 并配置 aliyun 镜像</b></summary>

```  	

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.4.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>



    <groupId>YXB__YXB__YXB</groupId>
    <artifactId>translate</artifactId>
    <version>2.2.4.RELEASE</version>







    <dependencies>

        <!--               Spring 家族                      -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.1</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>        

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
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

    </dependencies>





    <repositories>

        <repository>
            <id>aliyun</id>
            <name>aliyun</name>
            <url>http://maven.aliyun.com/nexus/content/groups/public</url>
        </repository>

    </repositories>





    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

```
</details>






















<details>
<summary><b>访问路径</b></summary>

```  
静态资源一定要放在 src\main\resources\static 下面, 不要没办法访问

而且一定要 重启 springBoot 服务器 , 不然静态资源没办法更新 ( 在idea下快捷键是: Ctrl + F5 )

配置文件:
application.properties:
spring.mvc.static-path-pattern=/**

html引用:
<script src="/Remember_words/Last_Next_Words.js"></script>

src\main\resources\static\Remember_words\Last_Next_Words.js



@Controller
@RequestMapping(value="/Collected_word")
public class Collected_word {
    
    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String index(){                                --> 单纯的网页跳转, 就不要有任何的参数
        return "/Collected_word/Collected_word.html";
    }
}



```
</details>



















<details>
<summary><b>要注意的:</b></summary>

```  

注意:   在 Controller 里面注入 POJO 的时候
        有几个 POJO , 就在上面写几个 @Autowired
        不然会注入失败

@Controller
@RequestMapping(value="/Remember_word_Controller")
public class Remember_words_Controller {

    @Autowired
    private Dao dao;

    @Autowired
    private PhraseDao phraseDao;

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








<details>
<summary><b>SQL</b></summary>

```  

    像这种, 返回的是一个集合(list 接收返回的数据)
    @Select("SELECT * FROM words_warehouse")
    List<Words_Warehouse> getAll();


    像这种, 返回的只是一个 Java 对象
    @Select("SELECT * FROM words_warehouse WHERE word = #{word}")
    Words_Warehouse getOne(String word);

    改 返回一个 int 数据, 意思是, 修改成功了 X 条
    @Update(" UPDATE `words_warehouse` SET `status`='very_familiar_with' WHERE word= #{english_word};")
    int really_remember(String english_word);

    增
    @Insert("INSERT INTO words_warehouse(words_warehousename) VALUES(#{words_warehouseName})")
    void insert(Words_Warehouse words_warehouse);

    删
    @Delete("DELETE FROM words_warehouse WHERE word =#{word}")
    void delete(Integer word);

```
</details>























































































---
# Java + SpringBoot 前后端
> 注意:  html文件记得加上:   
> html xmlns:th="http://www.thymeleaf.org"

<details>
<summary><b> Ajax + SpringBoot + jQuery </b></summary>

```  

jQuery 中 Ajax 中 dataType 有哪些类型

”xml”: 返回 XML 文档，可用 jQuery 处理
”html”: 返回纯文本 HTML 信息；包含的 script 标签会在插入 dom 时执行
”script”:  返回纯文本 JavaScript 代码。不会自动缓存结果。除非设置了 “cache” 参数。
            注意：在远程请求时(不在同一个域下)，所有 POST 请求都将转为 GET 请求。（因为将使用 DOM 的 script标签来加载）
”json”: 返回 JSON 数据 
”jsonp”: JSONP 格式。使用 JSONP 形式调用函数时，如 “myurl?callback=?” jQuery 将自动替换 ? 为正确的函数名，以执行回调函数
”text”: 返回纯文本字符串



               前端 Ajax
//params.XX必须与 Spring Mvc controller中的参数名称一致 , 否则在controller中使用@RequestParam绑定
var params = {};
params.Familiar = "YXB----YXB---YXB...";

$.ajax({
    async:false,
    type: "POST",
    url: "/Make_word_Familiar/index",         // 路径
    data:params,
    dataType:"json",
    success:function(data){
            alert(data.result);
            params = data;
    },
    error:function(data){
        // alert(data.result);
    }
});
return params;    
需要把 data 赋值给 params, 再去返回值, 不然直接 return data 是没有作用的



                后端 Java
@Controller
@RequestMapping(value="/Make_word_Familiar")
public class Make_word_Familiar {
    
    // 注入 Dao 层
    @Autowired
    private PhraseDao phraseDao;

    @RequestMapping(value="/index", method= RequestMethod.POST)
    @ResponseBody           //此注解不能省略 否则ajax无法接受返回值
    public void update(String Familiar){            --> 必须和上面的 params.Familiar 保持一致, 不然没办法取值
        System.out.println(Familiar);
    }
}


=====================================================================================================   

    @RequestMapping(value="/Get_Random_phrase", method= RequestMethod.GET)
    @ResponseBody           //此注解不能省略 否则ajax无法接受返回值
    public List<Phrase> Get_Random_phrase(Model model) {
        List<Phrase> result =  phraseDao.get_Phrase_Random();
        model.addAttribute("result" , result);
        return result;
    }


```
</details>













<details>
<summary><b> 前端取后端传来的数据 </b></summary>

```  

后端
@Controller
@RequestMapping(value="/Collected_word")
public class Collected_word {

    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String index(Model model){
        List<Tb_word> tb_words = otherDao.Get_Collected_word();
        model.addAttribute("result" , tb_words);
        return "/Collected_word/Collected_word.html";
    }
}

在 thymeleaf 中使用 JavaScript 获取后台传到前台的值
    <script th:inline="javascript">
        var results = [[${result}]];
        console.log(results);
    </script>



html循环遍历的方式:
    <li th:each="result : ${result}">
        <h3><a target="_blank"  th:href="@{/English_Article_Controller/Read_Article/(file_name=${result})}"  th:text="${result}" style="color: #5FB878; "></a></h3>
        <!--<button class="btn" th:onlick="'getName(\''+${person.name}+'\');'">获得名字</button>-->
    </li>




简单取值:
后端:
    @GetMapping("/message")
    public String getMessage(Model model){
        model.addAttribute("message","This is your message");
        return "index";
    }

前端:    
    <p th:text="#{message}">default message</p>









jQuery方式 ( thymeleaf ???   )
    <table>
        <tr th:each="user, interStat : ${result}">
            <td th:text="${interStat.index}"></td>
            <td th:text="${user.id}"></td>
            <td th:text="${user.name}"></td>
            <td th:text="${user.phone}"></td>
        </tr>
    </table>    
    ps:
        interStat  系统自带


```
</details>












<details>
<summary><b> 前端 转递form表单数据 到后端 </b></summary>

```  

前端
    <form action="/file/test3" method="GET">
        <input type="text" class="form-control" placeholder="Text input" name="username">
        <input class="btn btn-danger" type="submit" value="提交"/>
        <input type="reset" value="重置"/>
    </form>


后端
    @Controller
    @RequestMapping(value="/file")
    public class Article_list_Controller {

        @ResponseBody
        @RequestMapping(value="/test3",method=RequestMethod.GET)
        public String add(HttpServletRequest request, HttpServletResponse response){

            System.err.println("asdasdasdasdasdasdasdasdasdasdasdasdasdasda");

            System.err.println(request.getParameter("username"));

            return null;
        }    

```
</details>
















































---


<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>








































