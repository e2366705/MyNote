# Bootstrap
* 一个好用方便的 UI 框架




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


  




<h1>      搜索框                </h1>



<div class="input-group">
  <input type="text" class="form-control"/>
  <span class="input-group-addon">搜索</span>
</div>


  




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
