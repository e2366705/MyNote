# Node.js







<details>
<summary><b> 入门 </b></summary>

```
npm init
npm install express -save

nodemon将监视启动目录中的文件，如果有任何文件更改，nodemon将自动重新启动node应用程序
npm install -g nodemon

var express = require('express');   导入项目包, 相当于 Java 中的 import xxx.xxx.xx;






-----------------------------------   简单入门:    -------------------------------------

新建一个 index.html 页面, 用来访问:
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>菜鸟教程(runoob.com)</title>
</head>
<body>
    <h1>我的第一个标题</h1>
    <p>我的第一个段落。</p>
</body>
</html>



新建一个 one.js , 里面写:
var http = require('http');
var fs = require('fs');
var url = require('url');


// 创建服务器
http.createServer( function (request, response) {  
   // 解析请求，包括文件名
   var pathname = url.parse(request.url).pathname;

   // 输出请求的文件名
   console.log("Request for " + pathname + " received.");

   // 从文件系统中读取请求的文件内容
   fs.readFile(pathname.substr(1), function (err, data) {
      if (err) {
         console.log(err);
         // HTTP 状态码: 404 : NOT FOUND
         // Content Type: text/html
         response.writeHead(404, {'Content-Type': 'text/html'});
      }else{             
         // HTTP 状态码: 200 : OK
         // Content Type: text/html
         response.writeHead(200, {'Content-Type': 'text/html'});    

         // 响应文件内容
         response.write(data.toString());        
      }
      //  发送响应数据
      response.end();
   });   
}).listen(3300);

// 控制台会输出以下信息
console.log(' 新建一个 index.html 放在根目录, 然后浏览器访问: http://127.0.0.1:3300/index.html ');


然后启动服务器:    nodemon one.js

然后浏览器访问 : http://127.0.0.1:3300/index.html



在手机端访问, 打开 cmd 命令行输入: ipconfig 回车:
得到一个 IPv4 地址:  192.168.1.100  ,  这就是本机地址,
用手机访问  http://192.168.1.100:3300/index.html  
即可~










-----------------------------------      ------------------------------------
var express = require('express');
var app = express();

app.get('/', function(req, res){
    var req_date = {
        name: "YXB",
        age: 23
    }
    res.send(req_date);   // 返回的数据可以是 json , 可以是 字符串
});

app.listen(3000);
console.log("lintening to port 3000...");
-----------------------------------      ------------------------------------


nodemon将监视启动目录中的文件，如果有任何文件更改，nodemon将自动重新启动node应用程序


npm install -g nodemon

到这一步可能会报错:
nodemon : 无法加载文件 C:\Users\YXB\AppData\Roaming\npm\nodemon.ps1，因为在此系统上禁止运行脚本。有关详细信息，请参阅 https:/go.microsoft.
com/fwlink/?LinkID=135170 中的 about_Execution_Policies


以管理员身份打开 PowerShell 输入 set-executionpolicy remotesigned
选择Y 然后电脑上就可以执行自己编写的脚本文件, 然后再去安装 npm install -g nodemon

启动应用 nodemon [your node app]:
nodemon server.js

然后打开浏览器, 输入 http://localhost:3000/     (3000是端口号)




-----------------------------------      ------------------------------------


var express = require('express');
var app = express();

// 有: 冒号的, 就是动态的
app.get('/get/:id', function(req, res){
    console.log(req.params);    // 后台输出 : { id: '23333' }
    res.send("you request params is : " + req.params.id);
});

app.listen(3000);
console.log("lintening to port 3000...");

浏览器访问: http://localhost:3000/get/23333
浏览器输出: you request params is : 23333




-----------------------------------      -------------------------------------
var express = require('express');
var app = express();

app.get('/', function(req, res){
    console.log(req.query);   // 后台输出: { age: '23' }
    res.send("you request params is : " + req.query.age);
});

app.listen(3000);
console.log("lintening to port 3000...");



浏览器输入: http://localhost:3000/?age=23
浏览器输出: you request params is : 23



-----------------------------------      -------------------------------------
用 postman 模拟 post 请求:
Chrome插件直接下载:

var express = require('express');
var bodyParser = require('body-parser');

var app = express();

app.use(bodyParser.urlencoded({extended: false}))

app.get('/', function(req, res){
    console.log(req.query);   // 后台输出: { age: '23' }
    res.send("you request params is : " + req.query.age);
});

app.post('/', function(req, res){
    console.dir(req.body); // 后台输出 : [Object: null prototype] { age: '5656888' }
    res.send(req.body.age);
})

app.listen(3000);
console.log("lintening to port 3000...");

```
</details>




























<details>
<summary><b> loading - 正在加载效果实现 </b></summary>

```

新建 one.js:
/*引用模块*/
var express = require('express');
var app = express();

var url = require('url');//url模块,对url格式的字符串进行解析，返回一个对象。根据不同的url进行处理，返回不同的数据。

app.all('*', function (req, res, next) {
   res.header('Access-Control-Allow-Origin', '*');//*表示可以跨域任何域名都行（包括直接存在本地的html文件）出于安全考虑最好只设置 你信任的来源也可以填域名表示只接受某个域名
   res.header('Access-Control-Allow-Headers', 'X-Requested-With,Content-Type');//可以支持的消息首部列表
   res.header('Access-Control-Allow-Methods', 'PUT,POST,GET,DELETE,OPTIONS');//可以支持的提交方式
   res.header('Content-Type', 'application/json;charset=utf-8');//响应头中定义的类型
   next();
});
/*随便定义一个要返回的信息*/
var mans = [
   {
      name: '土狗',
      age: 16,
      gender: 'boy'
   },
   {
      name: '猫咪',
      age: 15,
      gender: 'girl'
   }
];


app.get('/get', function (req, res) {

   setTimeout(() => {
      console.log(" 模拟暂停线程...");

      console.log(req.url);//这里可以打印出请求的url看一下
      var parseObj = url.parse(req.url, true);//对url进行解析 将第二个参数设置为true会将query属性生成为一个对象
      //console.log(parseObj);//这里包含了很多信息有兴趣可以看一下 了解一下
      var queryObj = parseObj.query;//只获取参数的对象
      res.status(200);
      console.log('发送过来的信息:');
      console.log(queryObj);//get的信息中的值全为字符串
      queryObj.age = parseInt(queryObj.age);//将有必要转化的值进行转化

      mans[1] = queryObj;

      // res.json(mans);//  返回给前端一个对象数组

      res.json(queryObj.age);//  返回给前端

      //res.send(mans);//一样的效果这个较为通用一些 不仅仅可以发送json

   }, 3333);

});

var server = app.listen(3000, function () {//监听3000端口
   var port = server.address().port;
   console.log('Example app listening on port:%s', port, '浏览器访问: http://localhost:3000');
});









新建 index.html :
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>ajaxtest</title>
    <script src="https://s1.pstatp.com/cdn/expire-1-M/jquery/2.1.4/jquery.min.js"
        type="application/javascript"></script>
    <script src="https://s1.pstatp.com/cdn/expire-1-M/layer/2.3/layer.js" type="application/javascript"></script>

    <style>
        #spinner {
            display: none;
            margin: 100px auto;
            width: 50px;
            height: 60px;
            text-align: center;
            font-size: 10px;
        }
        #spinner_background {
            position: absolute;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            background-color: rgba(0, 0, 0, .5);
            display: block;
        }

        #spinner>div {
            background-color: #67CF22;
            height: 100%;
            width: 6px;
            display: inline-block;

            -webkit-animation: stretchdelay 1.2s infinite ease-in-out;
            animation: stretchdelay 1.2s infinite ease-in-out;
        }

        #spinner .rect2 {
            -webkit-animation-delay: -1.1s;
            animation-delay: -1.1s;
        }

        #spinner .rect3 {
            -webkit-animation-delay: -1.0s;
            animation-delay: -1.0s;
        }

        #spinner .rect4 {
            -webkit-animation-delay: -0.9s;
            animation-delay: -0.9s;
        }

        #spinner .rect5 {
            -webkit-animation-delay: -0.8s;
            animation-delay: -0.8s;
        }

        @-webkit-keyframes stretchdelay {

            0%,
            40%,
            100% {
                -webkit-transform: scaleY(0.4)
            }

            20% {
                -webkit-transform: scaleY(1.0)
            }
        }

        @keyframes stretchdelay {

            0%,
            40%,
            100% {
                transform: scaleY(0.4);
                -webkit-transform: scaleY(0.4);
            }

            20% {
                transform: scaleY(1.0);
                -webkit-transform: scaleY(1.0);
            }
        }
    </style>

</head>

<body>
    <div id="data"></div>
    <button id="send">发送 Ajax 请求 </button>


    <div id="spinner">
        <span id="spinner_background"></span>
        <div class="rect1"></div>
        <div class="rect2"></div>
        <div class="rect3"></div>
        <div class="rect4"></div>
        <div class="rect5"></div>
        加载中...
    </div>

    <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>            <h1> Lorem ipsum doue sed! </h1>        


</body>
<script>

    var sendBtn = $('#send');
    if (sendBtn) {
        sendBtn.click(function () {
            $.ajax({
                type: 'get',
                url: 'http://127.0.0.1:3000/get?name=one&age=11&gender=boy',//这个url直接粘贴进浏览器地址栏也能够看到返回的信息
                beforeSend: function () {
                    console.log("处理中...");
                    document.getElementById("spinner").style.display = "block";
                    $('body').css('overflow','hidden');//禁止滚动
                }, success: function (data) {
                    console.log(data);
                    $('body').css('overflow','auto');//允许滚动
                    document.getElementById("spinner").style.display = "none";
                    document.getElementById("data").innerText = data;
                },
                error: function () {
                    console.log('error');
                }
            });
        });
    }
</script>
</html>


把这个 index.html 在本地用浏览器打开
启动服务器:    nodemon one.js

```
</details>
