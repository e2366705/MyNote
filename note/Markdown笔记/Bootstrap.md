# Bootstrap
* 一个好用方便的 UI 框架
* 参考资料:    http://blog.bbadtimes.com/2017/08/21/159




.


<details>
<summary><b> 基础 :</b></summary>

```  


文本 :
.text-justify           设定文本对齐,段落中超出屏幕部分文字自动换行
.text-nowrap            段落中超出屏幕部分不换行
.col-sm-10              控制大小
.form-inline            控制是否在一行
.text-right             向右对齐
.text-center            居中对齐
.center-block           居中显示 , 但是会被设置元素为 display:block
.pull-left              元素浮动到左边
.pull-right             元素浮动到右边
.clearfix               清除浮动
.show                   强制元素显示
.hidden                 强制元素隐藏


固定到顶部、底部
        .navbar-fixed-top 
        .navbar-fixed-bottom  
  <button class="btn btn-danger navbar-fixed-bottom">navbar-fixed-bottom</button>

倒置的导航栏 带有黑色背景白色文本的倒置的导航栏 .navbar-inverse
  <button class="btn btn-danger navbar-inverse">navbar-inverse</button>


row -> 表示 在一行:
    <div class="row">
    <div class="col-lg-2">
        <input type="text" class="form-control" placeholder="col-lg-2">
    </div>
    <div class="col-lg-3">
        <input type="text" class="form-control" placeholder="col-lg-3">
    </div>
    <div class="col-lg-4">
        <input type="text" class="form-control" placeholder="col-lg-4">
    </div>
    </div>




clearfix : 清除浮动:
  <div class="clearfix"  style="background: #D8D8D8;border: 1px solid #000;padding: 10px;">
    <div class="pull-left" style="background:#58D3F7;">向左快速浮动</div>
    <div class="pull-right" style="background: #DA81F5;">向右快速浮动</div>
  </div>
  
pull-* 快速浮动:
    <div class="pull-left">向左快速浮动</div>
    <div class="pull-right">向右快速浮动</div>



btn-group-justified: 三个按钮平分整个屏幕:
    <div class="btn-group btn-group-justified">
    <div class="btn-group">
        <button class="btn btn-default">left</button>
    </div>
    <div class="btn-group">
        <button class="btn btn-default">middle</button>
    </div>
    <div class="btn-group">
        <button class="btn btn-default">right</button>
    </div>
    </div>





--------------------  按钮  --------------------
一 样式
.btn               为按钮添加基本样式
.btn-default       默认/标准按钮
.btn-primary       原始按钮样式（未被操作）
.btn-success       表示成功的动作
.btn-info          该样式可用于要弹出信息的按钮
.btn-warning       表示需要谨慎操作的按钮
.btn-danger        表示一个危险动作的按钮操作
.btn-link          让按钮看起来像个链接 (仍然保留按钮行为)
.btn-lg            制作一个大按钮
.btn-sm            制作一个小按钮
.btn-xs            制作一个超小按钮
.btn-block         块级按钮(拉伸至父元素100%的宽度)
.active            按钮被点击
.disabled          禁用按钮
.dl-horizontal     可以让 <dl> 内的短语及其描述排在一行





--------------------  图片  --------------------
.img-rounded：         添加 border-radius:6px 来获得图片圆角。
.img-circle：          添加 border-radius:50% 来让整个图片变成圆形。
.img-thumbnail：       添加一些内边距（padding）和一个灰色的边框。
.img-responsive        图片响应式 (将很好地扩展到父元素)



--------------------  input  --------------------
分别使用 class .input-lg 和 .col-lg-* 来设置表单的高度和宽度
<div class="form-group">
  <input class="form-control input-lg" type="text" placeholder="input-lg">
</div>



--------------------    --------------------



```
</details>





















<details>
<summary><b> 字体图标 垂直居中 </b></summary>

```

/*  bootstrap 字体图标 垂直居中  */
.nav a::before {
  vertical-align: middle;
  padding-right: 5px;
}


<div class="nav">
  <ul>
    <li><a href="#" class="glyphicon glyphicon-signal">电商整机</a></li>
  </ul>
</div>


```
</details>




























# 响应式开发, 技术点
<details>
<summary><b> 响应式 动态 </b></summary>

```
    /*     当进入小屏幕 或者 超小屏幕的时候, 让 nav 里面的 li 浮动起来, 并且宽度为 20%    */
    @media screen and (max-width: 991px) {
      .nav li {
        float: left;
        width: 20%;
      }

      article {
        margin-top: 10px;
      }
    }

    /*     当进入超小屏幕的时候, 让 nav 文字会变成 14px    */
    @media screen and (max-width: 767px) {
      .nav li a {
        font-size: 12px;
        padding-left: 0;
      }

      /* 当我们处于超小屏幕, news 第一个 li 宽度为 100% , 剩下的 小 li 各 50% */
      .news li:nth-child(1) {
        width: 100% !important;
      }

      .news li {
        width: 50% !important;
      }

    }

```
</details>




















<details>
<summary><b> 超小屏幕的时候 隐藏起来 </b></summary>

```
<!--    hidden-xs 表示处于超小屏幕的时候 隐藏起来    (具体细节参考 Bootstrap 手册)    -->
<img src="https://www.w3school.com.cn/i/eg_tulip.jpg" class="hidden-xs">

```
</details>





















# html 文件示例
<details>
<summary><b>  示例  </b></summary>

```  


<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <script src="https://s1.pstatp.com/cdn/expire-1-M/jquery/2.1.4/jquery.min.js" type="application/javascript"></script>
  <script src="http://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script>
  <script src="https://s0.pstatp.com/cdn/expire-1-M/vue/2.6.10/vue.min.js" type="application/javascript"></script>
  <link href="https://s2.pstatp.com/cdn/expire-1-M/twitter-bootstrap/3.4.0/css/bootstrap.min.css" type="text/css"
    rel="stylesheet" />
  <script src="https://s1.pstatp.com/cdn/expire-1-M/twitter-bootstrap/3.4.0/js/bootstrap.min.js"
    type="application/javascript"></script>
</head>
<body>


  






  <h1>      搜索框 (居中显示)               </h1>

  <div>
    <form  class="input-group col-lg-8 "  style="margin:0 auto;">
      <input type="text" name="id" class="form-control input-lg" placeholder="按回车搜索"   autofocus="autofocus" />
      <span class="input-group-addon">搜索</span>
    </form>
  </div>

按下回车访问路径为 :  http://localhost:8088/index?id=236670

autofocus="autofocus"  是页面加载 input 自动获取焦点






  

  




<h1>      居中                </h1>

  
<div class="input-group" style="width:800px;margin:0 auto;">
  <input type="text" class="form-control" placeholder="手机..." maxlength="11">
  <div class="input-group-btn">
    <button type="submit" class="btn btn-primary">
      <span class="glyphicon glyphicon-search"></span>
    </button>
  </div>
</div>


  





<h1>      添加 图标               </h1>

  

<div class="btn-group buttons">
  <a class="btn btn-primary" href="add.html"><span class="glyphicon glyphicon-plus"></span>添加</a>
  <a class="btn btn-default" href="list.html"><span class="glyphicon glyphicon-align-justify"></span>列表</a>
</div>

  





<h1>      各种按钮                </h1>

  

<a href="" class="btn btn-primary">primary</a>
<a href="" class="btn btn-default">default</a>
<a href="" class="btn btn-success">success</a>
<a href="" class="btn btn-info">info</a>
<a href="" class="btn btn-warning">warning</a>
<a href="" class="btn btn-danger">danger</a>
<hr>
<a href="" class="btn btn-lg btn-primary">大按钮</a>
<a href="" class="btn btn-lg btn-default">大按钮</a>
<a href="" class="btn btn-primary">普通按钮</a>
<a href="" class="btn btn-default">普通按钮</a>
<a href="" class="btn btn-sm btn-primary">小按钮</a>
<a href="" class="btn btn-sm btn-default">小按钮</a>
<a href="" class="btn btn-xs btn-primary">超小型按钮</a>
<a href="" class="btn btn-xs btn-default">超小型按钮</a>


  





<h1>      下拉按钮                </h1>

  

<div class="btn-group">
  <button class="btn btn-default btn-lg dropdown-toggle" data-toggle="dropdown">Default <span class="caret"></span></button>
  <ul class="dropdown-menu">
      <li><a href="">html</a></li>
      <li><a href="">javascript</a></li>
      <li><a href="">jQuery</a></li>
  </ul>
</div>

  




<!--    三个按钮横向排列     -->
<div class="btn-group btn-group-lg">
    <button type="button" class="btn btn-default">左</button>
    <button type="button" class="btn btn-default">中</button>
    <button type="button" class="btn btn-default">右</button>
</div>

<!--     三个按钮竖向排列      -->
<div class="btn-group-vertical btn-group-lg">
    <button type="button" class="btn btn-default">上</button>
    <button type="button" class="btn btn-default">中</button>
    <button type="button" class="btn btn-default">下</button>
</div>







<h1>      向上 按钮                </h1>

  
<div class="btn-group dropup">
  <button class="btn btn-default btn-lg dropdown-toggle" data-toggle="dropdown">Default <span class="caret"></span></button>
  <ul class="dropdown-menu">
      <li><a href="">html</a></li>
      <li><a href="">javascript</a></li>
      <li><a href="">jQuery</a></li>
  </ul>
</div>


  





<h1>      下拉搜索                </h1>

  

<form action="">
  <div class="row">
      <div class="col-md-6">
          <div class="input-group">
              <div class="input-group-btn">
                  <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">dropdown<span class="caret"></span></button>
                  <ul class="dropdown-menu">
                      <li><a href="">资讯</a></li>
                      <li><a href="">新闻</a></li>
                      <li><a href="">关于</a></li>
                  </ul>
              </div>
              <input class="form-control" type="text"/>
          </div>
      </div>
  </div>
</form>


  





<h1>      数字标签                </h1>

  
<a href="">Messages <span class="badge">20</span></a>
<button class="btn btn-default">Messages <span class="badge">20</span></button>





</body>
<script>
</script>
</html>


```
</details>






















# 完整 Demo
<details>
<summary><b> 响应式web : 阿里百秀 </b></summary>

```

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>

  <script src="https://s1.pstatp.com/cdn/expire-1-M/jquery/2.1.4/jquery.min.js" type="application/javascript"></script>
  <link href="https://s2.pstatp.com/cdn/expire-1-M/twitter-bootstrap/3.4.0/css/bootstrap.min.css" type="text/css"
    rel="stylesheet" />
  <script src="https://s1.pstatp.com/cdn/expire-1-M/twitter-bootstrap/3.4.0/js/bootstrap.min.js"
    type="application/javascript"></script>
  <script src="https://s0.pstatp.com/cdn/expire-1-M/vue/2.6.10/vue.min.js" type="application/javascript"></script>
  <script src="https://s1.pstatp.com/cdn/expire-1-M/layer/2.3/layer.js" type="application/javascript"></script>

  <style>
    ul {
      list-style-type: none;
      margin: 0;
      padding: 0;
    }

    a {
      color: #666;
      text-decoration: none;
    }

    @media screen and (min-width: 1280px) {
      .container {
        width: 1280px;
      }
    }


    /*      header    */
    header {
      padding-left: 0 !important;
    }

    .logo img {
      display: block;
      margin: 0 auto;
      max-width: 100%;
    }

    /*  1. 如果进入了超小屏幕下, logo 里面的图片就隐藏起来  */
    /* 2. 事先准备好一个盒子, 在 logo 里面 , 它平时是隐藏起来的, 只有在超小屏幕下显示 */
    .logo span {
      display: block;
      height: 50px;
      line-height: 50px;
      font-size: 18px;
      background-color: black;
      color: greenyellow;
      text-align: center;
    }

    .nav {
      background-color: #eee;
      border-bottom: 1px solid #ccc;
    }

    .nav a {
      display: block;
      height: 50px;
      line-height: 50px;
      padding-left: 30px;
      font-size: 16px;
    }

    .nav a:hover {
      background-color: #fff;
    }

    /*  bootstrap 字体图标 垂直居中  */
    .nav a::before {
      vertical-align: middle;
      padding-right: 5px;
    }





    /*       article          */
    .news li {
      float: left;
      width: 25%;
      height: 128px;
      padding-right: 10px;
      margin-bottom: 10px;
    }

    /*     当进入小屏幕 或者 超小屏幕的时候, 让 nav 里面的 li 浮动起来, 并且宽度为 20%    */
    @media screen and (max-width: 991px) {
      .nav li {
        float: left;
        width: 20%;
      }

      article {
        margin-top: 10px;
      }
    }

    /*     当进入超小屏幕的时候, 让 nav 文字会变成 14px    */
    @media screen and (max-width: 767px) {
      .nav li a {
        font-size: 12px;
        padding-left: 0;
      }

      /* 当我们处于超小屏幕, news 第一个 li 宽度为 100% , 剩下的 小 li 各 50% */
      .news li:nth-child(1) {
        width: 100% !important;
      }

      .news li {
        width: 50% !important;
      }

    }

    .news li a {
      position: relative;
      display: block;
      width: 100%;
      height: 100%;
      background-color: purple;
    }

    .news li a img {
      width: 100%;
      height: 100%;
    }

    .news li a p {
      position: absolute;
      bottom: 0;
      left: 0;
      width: 100%;
      height: 41px;
      background-color: rgba(0, 0, 0, 0.5);
      font-size: 12px;
      color: #fff;
      margin-bottom: 0;
      padding: 0 10px;
    }

    .news li:nth-child(1) {
      width: 50%;
      height: 266px;
    }


    .news li:nth-child(1) p {
      font-size: 21px;
      line-height: 41px;
    }






    /*          publish          */
    .publish {
      border-top: 1px solid #ccc;
    }

    .publish .row {
      border-bottom: 1px solid #ccc;
    }

    .pic {
      margin-top: 10px;
    }

    .pic img {
      width: 100%;
    }





    /*           aside             */
    .banner img {
      width: 100%;
    }

    .hot {
      display: block;
      margin-top: 20px;
      padding: 0 20px 20px;
      border: 1px solid #ccc;
    }
  </style>
</head>

<body>



  <div class="container">
    <div class="row">

      <h2>响应式开发: 尝试把浏览器缩放至不同的大小, 手机端也是</h2>
      <h2> 教程来源 : https://www.bilibili.com/video/av86016423?p=29 </h2>
      <!--            header           -->
      <header class="col-md-2">
        <div class="logo">
          <a href="#">
            <!--    hidden-xs 表示处于超小屏幕的时候 隐藏起来    (具体细节参考 Bootstrap 手册)    -->
            <img src="https://www.w3school.com.cn/i/eg_tulip.jpg" class="hidden-xs">

            <!--  2. 事先准备好一个盒子, 在 logo 里面 , 它平时是隐藏起来的, 只有在超小屏幕下显示  -->
            <!--  visible-xs 表示只有屏幕尺寸在 xs 下才可以表现出来 (具体细节参考 Bootstrap 手册) -->
            <span class="visible-xs">哈哈百科</span>

          </a>
        </div>
        <div class="nav">
          <ul>
            <li><a href="#" class="glyphicon glyphicon-signal">电商整机</a></li>
            <li><a href="#" class="glyphicon glyphicon-repeat">婴儿用品</a></li>
            <li><a href="#" class="glyphicon glyphicon-lock">零食食品</a></li>
            <li><a href="#" class="glyphicon glyphicon-camera">电子产品</a></li>
            <li><a href="#" class="glyphicon glyphicon-share">电器数码</a></li>
          </ul>
        </div>
      </header>


      <!--           article             -->
      <article class="col-md-7">

        <!-- 新闻 -->
        <div class="news clearfix">
          <ul>
            <li>
              <a href="#">
                <img src="https://www.w3school.com.cn/i/eg_tulip.jpg" alt="">
                <p>哈哈哈哈哈</p>
              </a>
            </li>
            <li>
              <a href="#">
                <img src="https://www.w3school.com.cn/i/eg_tulip.jpg" alt="">
                <p>2 为什么会 出现这种 问提 啊实打实的 啊实打打 </p>
              </a>
            </li>
            <li>
              <a href="#">
                <img src="https://www.w3school.com.cn/i/eg_tulip.jpg" alt="">
                <p>3 为什么会 出现这种 问提 啊实打实的 啊实打打 </p>
              </a>
            </li>
            <li>
              <a href="#">
                <img src="https://www.w3school.com.cn/i/eg_tulip.jpg" alt="">
                <p>4 为什么会 出现这种 问提 啊实打实的 啊实打打 </p>
              </a>
            </li>
            <li>
              <a href="#">
                <img src="https://www.w3school.com.cn/i/eg_tulip.jpg" alt="">
                <p>5 为什么会 出现这种 问提 啊实打实的 啊实打打 </p>
              </a>
            </li>
          </ul>
        </div>




        <!-- 发表 -->
        <div class="publish">
          <div class="row">
            <div class="col-sm-9">
              <h3>电子: 关于电源的参数, 你知道几个?</h3>
              <p class="text-muted">YXB 发布于 2020-03-10</p>
              <p> 阿斯顿阿斯顿阿萨大 阿斯顿啊 啊实打实 阿斯顿阿萨 阿斯顿啊 阿萨大是的 阿斯顿</p>
              <p class="text-muted">阅读(20228) 评论(56) 赞(189) 标签: 健康/电子/电器/装机/数码</p>
            </div>
            <div class="col-sm-3 pic hidden-xs">
              <img src="https://www.w3school.com.cn/i/eg_tulip.jpg" alt="">
            </div>
          </div>
          <div class="row">
            <div class="col-sm-9">
              <h3>电子: 关于电源的参数, 你知道几个?</h3>
              <p class="text-muted">YXB 发布于 2020-03-10</p>
              <p> 阿斯顿阿斯顿阿萨大 阿斯顿啊 啊实打实 阿斯顿阿萨 阿斯顿啊 阿萨大是的 阿斯顿</p>
              <p class="text-muted">阅读(20228) 评论(56) 赞(189) 标签: 健康/电子/电器/装机/数码</p>
            </div>
            <div class="col-sm-3 pic hidden-xs">
              <img src="https://www.w3school.com.cn/i/eg_tulip.jpg" alt="">
            </div>
          </div>
        </div>
      </article>





      <!--          aside                 -->
      <aside class="col-md-3">
        <a href="#" class="banner">
          <img src="https://www.w3school.com.cn/i/eg_tulip.jpg" alt="">
        </a>
        <a href="#" class="hot">
          <span class="btn btn-primary">热搜</span>
          <h4 class="text-primary">怎么才能最好???</h4>
          <p>这里是全球最大!@#$#$^% ^&%$ ^& 大苏打$ 阿斯顿发生 </p>
        </a>
      </aside>
    </div>
  </div>



</body>
<script>
</script>
</html>

```
</details>
