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
