# CSS
看起来简单, 实际复杂的没边...















<details>
<summary><b> lorem 随机生成单词 </b></summary>

```

lorem6    按回车(Tap键)  表示随机生成 6个 单词
lorem*6   按回车(Tap键)  表示随机生成 6行 单词

```
</details>
























<details>
<summary><b> 在线图片引入 </b></summary>

```

<img src="https://dummyimage.com/1266x666/FF7F00/1C86EE" alt="">

<img src="https://dummyimage.com/1266x666/FF7F00/1C86EE&text=2333333" alt="">

```
</details>

























<details>
<summary><b> 哪些是块级元素，哪些是行内元素 </b></summary>

```  

 HTML哪些是块级元素，哪些是行内元素

常用块级元素：div , p , form, ul, li , ol, dl, form, address, fieldset, hr, menu, table

块级元素：块级大多为结构性标记
  <address>...</adderss>   
  <center>...</center>  地址文字
  <h1>...</h1>  标题一级
  <h2>...</h2>  标题二级
  <h3>...</h3>  标题三级
  <h4>...</h4>  标题四级
  <h5>...</h5>  标题五级
  <h6>...</h6>  标题六级
  <hr>  水平分割线
  <p>...</p>  段落
  <pre>...</pre>  预格式化
  <blockquote>...</blockquote>  段落缩进   前后5个字符
  <marquee>...</marquee>  滚动文本
  <ul>...</ul>  无序列表
  <ol>...</ol>  有序列表
  <dl>...</dl>  定义列表
  <table>...</table>  表格
  <form>...</form>  表单
  <div>...</div>


行内元素：行内大多为描述性标记
  <span>...</span>
  <a>...</a>  链接
  <br>  换行
  <b>...</b>  加粗
  <strong>...</strong>  加粗
  <img >  图片
  <sup>...</sup>  上标
  <sub>...</sub>  下标
  <i>...</i>  斜体
  <em>...</em>  斜体
  <del>...</del>  删除线
  <u>...</u>  下划线
  <input>...</input>  文本框
  <textarea>...</textarea>  多行文本
  <select>...</select>  下拉列表


·块级元素
  1.总是从新的一行开始
  2.高度、宽度都是可控的
  3.宽度没有设置时，默认为100%
  4.块级元素中可以包含块级元素和行内元素

·行内元素
  1.和其他元素都在一行
  2.高度、宽度以及内边距都是不可控的
  3.宽高就是内容的高度，不可以改变
  4.行内元素只能行内元素，不能包含块级元素


可变元素
	可变元素为根据上下文语境决定该元素为块元素或者内联元素
	applet - java applet
	button - 按钮
	del - 删除文本
	iframe - inline frame
	ins - 插入的文本
	map - 图片区块 (map)
	object - object 对象
	script - 客户端脚本


```
</details>

















<details>
<summary><b> 基础 </b></summary>

```  

移动端页面开发的两种方式
https://www.cnblogs.com/jasmine-95/p/7235186.html

web网页中必备的的一句代码 : <meta charset="UTF-8">

去掉所有浏览器的兼容性影响
* {
	margin: 0;
	padding: 0;
	text-decoration: none;
	list-style-type: none;
}


web中常用颜色 : 
#F5F5F5 浅灰色
skyblue 天蓝色
pink    粉红色
#FFF	白色
#e0e0e0 边框的颜色

红色 #D24D57  危险
绿色 #26A65B  安全
橙色 #EB7347  警告
黑色 #2C3E50  默认
橙红色 #FC9D99 温馨


在CSS中,如果css属性设置冲突的话,就在css样式后面加入 !important 即可,
这样该设置就会拥有最高优先级
比如 : color: black !important;

阻止缓存,链接后面加一个时间戳,这样每次请求的都是新链接,可以有效的阻止缓存
如下: +new Date().getTime()

CSS去掉小圆点 : list-style-type:none;
CSS去掉下划线 : text-decoration:none;
CSS下划线 : text-decoration:underline;  
CSS圆角 : border-radius:50px ;
CSS左上圆角:border-top-left-radius: 15px;


padding : 内边距
margin : 外边距

margin : 上 右 下 左
margin : 上下 左右

注意!!! : 
font-size:50px;  这个设置方法,在*{}中不适用

P标签和span标签的区别:
P 		块级元素	换行
span    行内元素	不换行

outline: none;		input 输入框 清除文本框获取焦点时,默认的边框阴影
border: none;  		清除样式,方便自己定义


如果是实现四周阴影,主要是第三个参数设置大一点,我这里设置成了60px
box-shadow: black 0px 0px 60px;

文字的阴影:
text-shadow: 1px 1px 8px


问:
---给li设置样式display:inline-block 后，ul 下的 li 元素之间有间距，怎么清除间距？ 
答案是:
在ul标签中设置font-size=0,在li中设置标签文字的大小；
因为空格也属于字符，把字符大小设为0，就没有空格了
给父级元素设置 font-size:0  在给li单独设置字体大小

把行内元素不可以设置宽高,加上 inline-block 即可;


鼠标放上去有一个小手:
cursor: pointer;


浏览器兼容(Chrome,Firefox,oprea):
background: -webkit-linear-gradient(top,red,green);
background: -moz-linear-gradient(top,skyblue,pink);
background: -o-linear-gradient(top,black,white);

在CSS中, .fixxx.active 和 .fixxx .active是不同的(注意!后者中间有个空格)

CSS中:
border: solid #000;  ==> border可以不加1px
.show_pages > a{}  ==> 代表.show_pages盒子下面(下一级)的a标签,不包括下面其他盒子的
.show_pages a{}    ==> 代表.show_pages盒子下面所有的a标签,包括其他盒子的

css缩写 : w100  == width: 100px;
		  h100  == height: 100px;	

一般 按钮的 基本样式设置 (div型 点击按钮)  常用 样式 三连
background-color: #D24D57;
color: #FFF;
width: 200px;
height: 50px;
font-size: 30px;
line-height: 50px;
text-align: center;
cursor: pointer;  /* 鼠标放上去有个小手 */


```
</details>






















<details>
<summary><b> 小技巧 </b></summary>

```
width: calc(100% - 12px);

```
</details>



















  <details>
<summary><b> flex 布局 </b></summary>

```

  <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">

  <div id="box2" style="display: flex;">
    <i class="fa fa-google-plus fa-5x" aria-hidden="true" style=""></i>
    <input type="text" />
    <button>submit</button>
  </div>

```
</details>















  <details>
<summary><b> 在线引入图标  </b></summary>

```


-----------------------------------   阿里矢量图   ------------------------------------
注意: 对彩色图标支持不是很好
第一步:
    <link rel="stylesheet" href="https://at.alicdn.com/t/font_1092800_n971mpjzzdn.css">
第二步:
    <i class="icon-mayi-shoucang-moren iconfont"></i>
    iconfont 必须要的



-----------------------------------   引入 font-awesome 图标   ------------------------------------

  <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">

  <div id="box2" style="display: flex;">
    <i class="fa fa-google-plus fa-5x" aria-hidden="true" style=""></i>
    <input type="text" />
    <button>submit</button>
  </div>

```
</details>






















<details>
<summary><b> HTML </b></summary>

```  

<a href="链接的页面" target="_blank">新窗口打开</a><br />
<a href="链接的页面" target="_parent">原窗口打开</a>
<a href="JavaScript:void(0)">点击注册</a>
<form>
	<input type="email" placeholder="你的电子邮箱" />
	<button type="submit">TEST</button>
</form>

SEO搜索引擎优化三要素: title description  Keywords
<title>京东(JD.COM)-正品低价、品质保障、配送及时、轻松购物！</title>
<meta name="description" content="京东JD.COM-专业的综合网上购物商城，为您提供正品低价的购物选择、优质便捷的服务体验。商品来自全球数十万品牌商家，囊括家电、手机、电脑、服装、居家、母婴、美妆、个护、食品、生鲜等丰富品类，满足各种购物需求。" />
<meta name="Keywords" content="网上购物,网上商城,家电,手机,电脑,服装,居家,母婴,美妆,个护,食品,生鲜,京东" />


```
</details>

























<details>
<summary><b> 移动端web开发必须 </b></summary>

```  

head里面记得加上这个:
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
        表示支持移动端


我们在移动端开发时，在<head>标签中加入:
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
这句话帮我们解决了很多问题，我们只要按照设备物理像素的大小来进行开发就行了。


```
</details>




















<details>
<summary><b> 隐藏一个元素? </b></summary>

```  

怎么隐藏一个元素?? 



第一种:  display: none
经典的display隐藏元素,这个是彻底的隐藏了元素，不占据空间，也就不影响布局，当然也无法响应事件
但是这个元素会从页面消失, 也没法去点击
    <h1 style="display: none; ">1111111111111</h1>
    <h1>2222222222222</h1>


    <hr>
    <hr>
    <hr>
    <hr>
    <hr>

第二种:  opacity:0;
    opacity是用来设置元素透明度的，但当设置成0的时候也就相当于隐藏元素了
    因此，元素依然存在原来的位置，占据空间也可响应事件
    占据空间，可以点击
    <h1 style="  opacity:0; ">1111111111111</h1>
    <h1>2222222222222</h1>


    <hr>
    <hr>
    <hr>
    <hr>
    <hr>

第三种: visibility:hidden;
    opacity 属性，被隐藏的元素依然会对我们的网页布局起作用。
    与 opacity 唯一不同的是它不会响应任何用户交互
        visible    元素正常显示
        hidden     隐藏元素，但是其他元素的布局不改变，相当于此元素变成透明。要注意若将其子元素设为 visibility: visible，则该子元素依然可见
    <h1 style="  visibility:hidden; ">1111111111111</h1>
    <h1>2222222222222</h1>

当然还有很多方式隐藏元素, 详细可以参考:
参考资料:   https://juejin.im/post/584b645a128fe10058a0d625


```
</details>





















<details>
<summary><b> position </b></summary>

```  

position: relative;   相对于自身进行定位,设置偏移量


居中: 
一个元素加上 position: relative 可以用  margin: 0 auto;
但是: position: absolute 就不可以用 margin: 0 auto;

当子元素相当于父元素position定位时,用left,right,top,bottom进行调整布局,
margin-left/right/top/bottom失效


参考资料 :  https://developer.mozilla.org/zh-CN/docs/Web/CSS/position

position: absolute :
	是根据网页的最顶端进行定位
	但是!!! 
	如果父元素加上了position: absolute(或者是relative),
	那么就根据父元素进行定位
	不为元素预留空间, 直接脱离文档流

position: relative:
	是根据自己本身进行定位
	但是不会脱离文档流,也就是说,原来的位置还在
	在不改变页面布局的前提下调整元素位置（因此会在此元素未添加定位时所在位置留下空白）

position: fixed
	是根据浏览器的窗口进行定位, 固定定位, 元素的位置在屏幕滚动时不会改变


```
</details>




























<details>
<summary><b> 浮动 / float </b></summary>

```

行内元素(比如span), 本身是不能设置宽高属性的, 
但是加上 float , 就可以设置宽高属性了



-----------------------------------   清除浮动方式1: overflow: hidden  ------------------------------------
  <div id="father" style="   background-color: yellow; overflow: hidden;">
    <div id="son" style="width: 100px; height: 100px; background-color: pink; float: right; ">son1</div>
    <div id="son" style="width: 100px; height: 100px; background-color: green; float: right; ">son2</div>
  </div>
  以上案例可以发现, 当子元素设置为 浮动 的时候, 父元素的高度为 0
  因为子元素脱离文档流了
  怎么才能让父元素有高度呢(自适应)
  方法之一就是: overflow: hidden, 让父类去感知子类的高度


-----------------------------------   清除浮动方式2: clear: both;  ------------------------------------
 <div id="father" style="   background-color: yellow; overflow: hidden;">
    <div id="son" style="width: 100px; height: 100px; background-color: pink; float: left; ">pink</div>
    <div id="son" style="width: 100px; height: 100px; background-color: green; float: left; ">green</div>
    <div id="son" style="width: 300px; height: 300px; background-color: red; clear: both; ">red</div>
  </div>
比如这个例子:
    两个小盒子设置为浮动, 最后一个大盒子没有设置为浮动, 那么大盒子就会隐藏在两个小盒子的后面, 
    如果要消除这种浮动产生的影响, 就使用 clear: both 
    (抵消其他元素浮动对当前元素产生的影响)

总结:
  常用清除浮动的方式:
    1 元素加 clear: both
    2 浮动元素的父级div定义: overflow: hidden
    3 浮动元素的父元素定宽高

```
</details>














<details>
<summary><b> flex 布局 </b></summary>

```
比较详细的教程:      https://www.ruanyifeng.com/blog/2015/07/flex-grammar.html

父元素设置:
    display: flex;
    flex-direction: row;

子元素设置:
    flex: 1;

    平均分成三行

```
</details>


















<details>
<summary><b> 区别 </b></summary>

```  

x[i].style.width = "100px";
x[i].style.height = "100px";
与
x[i].style.cssText = "width:100px;height:100px!important;"
两种方法上的差异是什么呢？重新渲染页面次数上的差异
前者2次，而后者1次
试想一下当属性增加到更多的时候，性能差异也就上去了

document.getElementById("kkk").style.cssText = " background-color:pink; width: 100px; height: 100px; ";


```
</details>
























<details>
<summary><b> 网页里面显示html代码 </b></summary>

```  

如果是需要 在网页里面显示html代码的话: pre和code都不管用
用 xmp才可以

<xmp style="font-size: 36px; font-weight: 800; " >
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	表示支持移动端网页
</xmp>


```
</details>

























<details>
<summary><b> 玄学 </b></summary>

```  

li
            width: 33.33%;
            float: left;
            text-align: center;
这样子, 哪怕屏幕压缩的再小, li*3 也会保持在同一行, 不会转向第二行


子元素设置了position: absolute 无法设置 max-width:640px;
在body加上一个 position: relative;
表示子元素定位以body为基准
效果好一点



css使用padding-left导致input框变长:
查代码发现，取消了padding-left：20px；之后就正常了。
解决方式，
改成缩进即可，text-indent:20px;


```
</details>
























<details>
<summary><b> 相对于自身偏移 </b></summary>

```  

相对于自身偏移50%
 transform: translate(-50%);

```
</details>
























<details>
<summary><b> first-of-type </b></summary>

```  

first-of-type 意思是: 第一个li元素的左外边距设置为0
        #aaa #first_ul li:first-of-type{
            margin-left: 0;
		}


```
</details>
























<details>
<summary><b> 文字超出部分, 用省略号来代替 </b></summary>

```  

css 文字超出部分, 用省略号来代替...
        #test2{
            display: -webkit-box;
            -webkit-box-orient: vertical;
            -webkit-line-clamp: 6;      	/* 你想要文字有多少行号, 2行就填写2   */
            overflow: hidden;
            width: 250px;
            border: 1px solid red;
            font-size: 30px;
        }		
		<div id="test2">asdasd阿斯打扫打扫大三大sd阿斯顿啊sd阿斯顿阿斯顿as大sd阿斯顿as大sd阿斯顿as的阿斯顿阿斯顿as答案是的阿斯顿</div>

```
</details>
























<details>
<summary><b> 强制不换行 </b></summary>

```  

css 
	强制不换行:
		 white-space: nowrap;  /*强制不换行*/
		 
		 
          display: -webkit-box;
          -webkit-box-orient: vertical;
          -webkit-line-clamp: 2; /* 你想要文字有多少行号, 2行就填写2   */
          overflow: hidden;
		  
		  
注意:  firefox没有 -webkit-line-clamp: 2; 这个东西. 
	只能用下面这个方案了, 将就一下把, 毕竟天猫都是这么做的....
		  功能: 超出一行, 用省略号来代替(...)
			  font-size: 16px;
			  line-height: 18px;
			  color: #333;
			  height: 18px;
			  overflow: hidden;
			  text-overflow: ellipsis;
			  white-space: nowrap;		

换行:
	word-wrap:break-word;


  https://www.html.cn/archives/2422
  http://www.alloyteam.com/2016/05/css-word-for-word-breaker-do-you-really-understand/
  使pre的内容自动换行, 被包围在 pre 元素中的文本通常会保留空格和换行符。而文本也会呈现为等宽字体。
  <pre> 标签的一个常见应用就是用来表示计算机的源代码
    pre {
      white-space: pre-wrap;
      word-break:keep-all;
    }
  就能使<pre>的内容自动换行了
  而且, 单词也可以保持完整, 
  不会把一个单词从中间强行打断 , 而达到暴力换行
    pre {
      background-color: black;
      color: #ffa31a;
      font-family: "Lucida Console", Monaco, monospace;
      width: 100%;
      margin: auto;
      font-size: 45px;
      line-height: 88px;
      padding: 15px;
      white-space: pre-wrap;
      word-break:keep-all;
    }


```
</details>
























<details>
<summary><b>行内元素 转 块级元素 </b></summary>

```  

一个行内元素, 如果想设置宽高, 需要转换成块级元素, 
三种办法:
	display: block;
	float: **;
	position:**;

```
</details>
























<details>
<summary><b> 居中 </b></summary>

```  

text-align: center; 用来居中详解:

当父元素是块级元素(比如div之类), 
	1-1.子元素是内联元素(span之类)的时候:
		text-align: center 加在内联元素上面, 是不起作用的, 
		必须加在父元素上

	1-2.但是子元素是块级元素的时候:
		text-align:center 加在父元素上, 或者子元素上, 都是可以的

		
margin: 0 auto 只能用于块级元素, 也就是说要设置成: display: block; 

默认父元素是块级元素(div之类的):
	1-1.子元素是内联元素(span之类):
		加 margin: 0 auto 是不起作用的
		
	1-2.子元素是块级元素(div之类的):
		 margin: 0 auto; 也是不起作用的(除非设置宽和高)

上下居中 : line-height: 40px;
左右居中 : text-align: center;
	div里面如果是行级元素,用text-align: center使子元素左右居中
	div里面如果是块级元素, 在块级元素上面加入 margin: 0 auto 使自己相对父元素左右居中

li 标签是行内元素,可以用text-align: center;来居中;
而margin:0 auto;没有效果  (margin: 0 auto 只能用于块级元素)
 

```
</details>



























# Demo
<details>
<summary><b> 折叠式菜单 </b></summary>

```

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>折叠式菜单3</title>
  <script src="https://s1.pstatp.com/cdn/expire-1-M/jquery/2.1.4/jquery.min.js" type="application/javascript"></script>
<link href="https://s2.pstatp.com/cdn/expire-1-M/twitter-bootstrap/3.4.0/css/bootstrap.min.css" type="text/css"  rel="stylesheet" />
<script src="https://s1.pstatp.com/cdn/expire-1-M/twitter-bootstrap/3.4.0/js/bootstrap.min.js" type="application/javascript"></script>
<script src="https://s0.pstatp.com/cdn/expire-1-M/vue/2.6.10/vue.min.js" type="application/javascript" ></script>
<script src="https://s1.pstatp.com/cdn/expire-1-M/layer/2.3/layer.js" type="application/javascript"></script>



  <style>
    * {
      padding: 0;
      margin: 0;
    }

    ul {
      list-style-type: none; 
      margin: 100px;   
    }

    .menu_head {
      width: 185px;
      height: 47px;
      line-height: 47px;
      padding-left: 38px;
      font-size: 17px;
      color: #475052;
      cursor: pointer;
      border: 1px solid #e1e1e1;
      position: relative;
      margin: 0px;
      font-weight: bold;
      background: #f1f1f1 url(../img/pro_left.png) center right no-repeat;
    }

    .menu_list .current {
      background: #f1f1f1 url(../img/pro_down.png) center right no-repeat;
    }

    .menu_body {
      width: 223px;
      height: auto;
      overflow: hidden;
      line-height: 38px;
      border-left: 1px solid #e1e1e1;
      background-color: #fff;
      border-right: 1px solid #e1e1e1;
    }

    .menu_body a {
      display: block;
      width: 223px;
      height: 38px;
      line-height: 38px;
      padding-left: 38px;
      color: #777;
      background: #fff;
      text-decoration: none;
      border-bottom: 1px solid #e1e1e1;
    }
  </style>
</head>

<body>
  <ul class="menu_list">
    <li>
      <p class="menu_head">目标管理</p>
      <div class="menu_body">
        <a href="">主题空间</a>
        <a href="">项目任务</a>
        <a href="">工作计划</a>
        <a href="">日程事件</a>
        <a href="">时间视图</a>
      </div>
    </li>
    <li>
      <p class="menu_head">会议管理</p>
      <div class="menu_body">
        <a href="">主题空间</a>
        <a href="">会议安排</a>
        <a href="">待开会议</a>
        <a href="">已开会议</a>
        <a href="">会议资源</a>
      </div>
    </li>
    <li>
      <p class="menu_head">知识社区</p>
      <div class="menu_body">
        <a href="">我的收藏</a>
        <a href="">知识广场</a>
        <a href="">文档中心</a>
        <a href="">我的博客</a>
        <a href="">文档库管理</a>
      </div>
    </li>
    <li>
      <p class="menu_head">我的工具</p>
      <div class="menu_body">
        <a href="">综合查询</a>
        <a href="">通讯录</a>
        <a href="">便签</a>
        <a href="">计算器</a>
        <a href="">万年历</a>
        <a href="">常用链接</a>
      </div>
    </li>
  </ul>
</body>



<script>
  //隐藏所有二级菜单
  $('.menu_head +div').hide();
  //显示当前，隐藏其它
  $('.menu_head').click(function () {
    var flag = $(this).next('div');
    //设置当前菜单右侧图标样式
    if (flag.is(':hidden')) {
      $(this).css('backgroundImage', 'url(img/pro_down.png)');
      $(this).next('div').slideDown();
    } else {
      $(this).css('backgroundImage', 'url(img/pro_left.png)');
      $(this).next('div').slideUp();
    }
  });
</script>

</html>


```
</details>



