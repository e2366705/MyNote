# CSS
看起来简单, 实际复杂的没边...












### 本地服务器
<details>
<summary><b> Anywhere 随启随用的静态文件服务器 </b></summary>

```
Anywhere - 随时随地将你的当前目录变成一个静态文件服务器的根目录(手机调试非常方便)
https://github.com/JacksonTian/anywhere

安装它:
npm install anywhere -g

然后,

新建一个文件夹, 里面新建一个 index.html (默认页面)


Windows 10 系统打开cmd命令行, 输入 ipconfig  回车:
无线局域网适配器 WLAN:
   连接特定的 DNS 后缀 . . . . . . . :
   本地链接 IPv6 地址. . . . . . . . : fe80::5ca8:78fe:1c7d:a8cb%5
   IPv4 地址 . . . . . . . . . . . . : 192.168.1.100
   子网掩码  . . . . . . . . . . . . : 255.255.255.0
   默认网关. . . . . . . . . . . . . : 192.168.1.1

IPv4 地址 . . . . . . . . . . . . : 192.168.1.100  -> 就是自己的 ip 地址了,

然后命令行输入:  anywhere -h  192.168.1.100 -p 8888  启动服务器, 会自动打开里面的 index.html

手机 电脑访问 http://192.168.1.100:8888/

```
</details>








<details>
<summary><b> 常用颜色 </b></summary>

```

半透明 - 方式 1 :
background-color: rgba(0, 0, 0, .5);

半透明 - 方式 2 :
background-color: #111;
opacity: 0.5;


深蓝色: #19497d
深蓝色: #3b5998

京东红: #f30213
淘宝橙: #FF4200
美团黄: #FFC300
P*hub黄: #f90
微软蓝: #0067b8
脸书蓝: #3b5998
滨客蓝: #003580  (booking.com 滨客网站主题色)
intel蓝:#0071c5


#F5F5F5 浅灰色
skyblue 天蓝色
pink    粉红色
#FFF	  白色
#000	  黑色
#e0e0e0 边框的颜色

绿色: #00bf6f
绿色: #26A65B

红色 #D24D57  危险
橙色 #EB7347  警告
黑色 #2C3E50  默认
橙红色 #FC9D99 温馨

```
</details>






















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

<img src="https://dummyimage.com/300x500/ffffff/000000" alt="">

<img src="https://dummyimage.com/1266x666/FF7F00/1C86EE&text=2333333" alt="">

<div>
    <img src="https://picsum.photos/360/460?random=1" alt="">
</div>

<div>
    <img src="https://picsum.photos/360/460?random=2" alt="">
</div>

<div>
    <img src="https://picsum.photos/360/460?random=3" alt="">
</div>

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


Transform : 属性应用于元素的2D或3D转换。这个属性允许你将元素旋转，缩放，移动，倾斜等
transition:width 2s;  动画


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
  background-color: #19497d;
  color: #FFF;
  width: 200px;
  height: 50px;
  border: none;
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


CSS 文本显示省略号总是不生效？记下这个固定属性组合：
    text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
    width: 100px;


HTML 表单中的复选框太小很难点？试试把 input 放到 label 中:
    <label>
      <input type="checkbox">null
    </label>



使用 <datalist>标签实现 input 输入框自动提示:
    <input type="text" list="AAA" name="" id="" placeholder="input something...">
    <datalist id="AAA">
      <option value="javaScript"></option>
      <option value="python"></option>
      <option value="php"></option>
      <option value="java"></option>
    </datalist>


<ol>标签，
  有序列表，有start属性可以指定起始序号，也可以用reverse反转顺序:
    <ol>
      <li>AAAAAAA</li>
      <li>BBBBBBB</li>
      <li>CCCCCCC</li>
    </ol>

    <ol start="6">
      <li>AAAAAAA</li>
      <li>BBBBBBB</li>
      <li>CCCCCCC</li>
    </ol>

    <ol reversed>
      <li>AAAAAAA</li>
      <li>BBBBBBB</li>
      <li>CCCCCCC</li>
    </ol>


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
<summary><b> 图标 </b></summary>

```

三道杠:
    <span style="font-size:66px;" >&#9776; 打开</span>
乘号(x):
    <span style="font-size:66px;" >&times;</span>


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
<summary><b> BFC </b></summary>

```

详细讲解: https://zhuanlan.zhihu.com/p/137926413?utm_source=ZHShareTargetIDMore&utm_medium=social&utm_oi=578296302983450624


<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>YXB</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            text-decoration: none;
            list-style-type: none;
        }

        .wrap {
            width: 200px;
            border: 1px solid #333;
        }

        .wrap:after {
            content: '2333333';
            display: block;
            clear: both;
        }

        .left {
            float: left;
            background: blue;
            height: 100px;
            width: 100px;
        }

        .right {
            float: left;
            background: red;
            height: 50px;
            width: 100px;
        }
    </style>
</head>

<body>
    <h1>Hello World~</h1>

    <div class='wrap'>
        <div class="left"></div>
        <div class="right"></div>
    </div>

</body>
<script></script>

</html>

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
<summary><b> 隐藏一个元素: display / opacity / visibility </b></summary>

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


消失/显示太快的话:
visibility: hidden;
transition: 0.3s;

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


有时候加上 position: fixed 会导致空间塌缩, 元素都会缩在一起, 这时候使用:
    width: 100%;
即可
position: fixed;


position:sticky;
    但是 position:fixed 也是有问题的, 因为这个属性是默认是相对浏览器窗口定位的,
    怎么实现相对父级元素定位呢?
    父级设置position:relative不管用,
    这时候, 就有了一个新属性: sticky
    position:sticky;    相对定位 + 固定定位
    bottom: 0;

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


这篇文章讲得非常详细:
https://zhuanlan.zhihu.com/p/93644624?utm_source=ZHShareTargetIDMore&utm_medium=social&utm_oi=578296302983450624


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




































<details>
<summary><b> position: fixed; bottom: 0; 固定在底部 </b></summary>

```

<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>YXB</title>

	<style type="text/css">
		* {
            margin: 0;
            padding: 0;
        }
        body{
            max-width:640px;
			min-width:320px;
			border:green solid 1px;
			margin:0 auto;
        }




/*        方案1 :  固定失败          */
		/* #Root{
			position: fixed;
		}
		footer{
			border: red solid 1px;
			width: 100%;
			position: relative;
		} */



/*        方案1 :  固定成功          */
		footer{
			border: red solid 1px;
			width: 640px;
			position: fixed;
			/* position: relative; */
			bottom: 0;
		}

		.nav_left {
				display: flex;
				width: 40%;
				text-align: center;
				background-color: pink;
		}
		.shop_and_cart {
			margin: 10px auto;
		}
		.img_pic {
			  margin: 1px auto;
			  width: 20px;
			  height: 20px;
		}
		.img_pic img {
			width: 100%;
			height: 100%;
		}


		.nav_right {
		  width: 60%;
		  height: 100%;
		  position: absolute;
		  top: 0;
		  right: 0;
		}
		#buy_now {
			width: 50%;
			height: 100%;
			background-color: rgb(255, 190, 35);
			border: 0;
			outline: none;
		}
		#Add_to_shoppingCart {
			width: 50%;
			height: 100%;
			float: right;
			background-color: rgb(243, 85, 75);
			border: 0;
			outline: none;
		}
    </style>
</head>

<body>

	<h1>position: fixed; bottom: 0; 固定在底部失败.... </h1>


	<div id="Root">
		<footer>
			<div class="nav_left">
				<div class="shop_and_cart">
					<div class="img_pic">
						<img
							src="data:image/png;base64,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">
					</div>
					<div class="word">购物车</div>
				</div>
				<div class="shop_and_cart">
					<div class="img_pic">
						<img
							src="data:image/png;base64,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">
					</div>
					<div class="word">店铺</div>
				</div>
			</div>

			<div class="nav_right">
				<button id="buy_now">立即购买</button>
				<button id="Add_to_shoppingCart">加入购物车</button>
			</div>
		</footer>
	</div>


<p>123123123</p>

<p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p>


</body>

<script type="text/javascript" src=""></script>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>

</html>


```
</details>




































<details>
<summary><b> 电商搜索框 position: fixed </b></summary>

```

<html>
<head>
    <meta charset="UTF-8">
    <title>搜索框的制作</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
            text-decoration: none;
            list-style-type: none;
        }

        .nav {
            position: fixed;
            bottom: 10px;
            left: 10px;
            background: #f40;
            width: 80%;
            color: #FFF;
        }


/*           左边部分             */
        .nav .left {
            width: 100px;
            line-height: 50px;
            text-align: center;
        }



/*           中间部分             */
        .nav .mid {
            height: 50px;
            position: absolute;
            left: 100px;
            right: 100px;
            top: 0;
        }
        .nav .mid input {
            width: 100%;
            height: 70%;
            outline: none;
            border: none;
            margin-top: 7px;
            border-radius: 200px;
            padding-left: 20px;
            padding-right: 20px;
        }


/*           右边部分             */
        .nav .right {
            top: 0;
            right: 0;
            position: absolute;
            width: 100px;
            line-height: 50px;
            text-align: center;
        }
    </style>
</head>
<body>

    <div class="nav">
        <div class="left">淘宝网</div>
        <div class="mid"><input type="" name="" id="" value="" /></div>
        <div class="right">登陆</div>
    </div>

    <p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p><p>占位符</p>
</body>
</html>


```
</details>


























<details>
<summary><b> position:sticky : </b></summary>

```

<html lang="zh">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>YXB</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            text-decoration: none;
            list-style-type: none;
        }

        body {
            border: red solid 1px;
            max-width: 640px;
            min-width: 320px;
            margin: 0 auto;
        }

        button{
            background-color: #19497d;
            color: #FFF;
            width: 200px;
            height: 50px;
            border: none;
            font-size: 30px;
            line-height: 50px;
            text-align: center;
            cursor: pointer;  /* 鼠标放上去有个小手 */
        }

        #filter_side_nav {
            height: 100%;
            width: 0%;
            height: 100%;
            z-index: 1;
            position: fixed;
            top: 0;
            left: 0;
            background-color: pink;
            overflow-x: hidden;
            transition: 0.2s;
        }        
        #filter_side_nav footer {
            position:sticky;
            bottom: 0;
            width: 100%;
            display: flex;
        }
        #filter_side_nav footer .button{
            flex:1;
        }
        #filter_side_nav footer .button button{
            width: 100%;
        }

        #filter_side_nav_mask {
            height: 100%;
            width: 20%;
            height: 100%;
            z-index: 1;
            position: fixed;
            visibility: hidden;
            top: 0;
            right: 0;
            background-color: #111;
            opacity: 0;
            overflow-x: hidden;
        }


    </style>
</head>
<body>

    <div id="root">

        <button onclick="Filter()" >多条件筛选</button>

        <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>       <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>     <span onclick="TEST()">点击it</span>      <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>         <span onclick="TEST()">点击it</span>        
        <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>       <h1>  主页面 </h1>      

        <div id="filter_side_nav">

            <h1> 点击取消按钮 </h1>    <h1> 点击取消按钮 </h1>    <h1> 点击取消按钮 </h1>    <h1> 点击取消按钮 </h1>    <h1> 点击取消按钮 </h1>    <h1> 点击取消按钮 </h1>    <h1> 点击取消按钮 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>    <h1> 筛选框 </h1>   

            <footer>
                <div class="button">
                    <button onclick="Cancel()">取消</button>
                </div>
                <div class="button">
                    <button>确定</button>
                </div>
            </footer>
        </div>
        <div id="filter_side_nav_mask"></div>

    </div>
</body>


<script>
    function Filter() {
        document.getElementById('filter_side_nav').style.width = '80%';
        document.getElementById('filter_side_nav').style.height = '100%';
        document.getElementById("filter_side_nav_mask").style.cssText = "  visibility: visible;  opacity:0.5;  transition: 2s linear; ";
    }
    function Cancel(){
        document.getElementById('filter_side_nav').style.width = '0%';
        document.getElementById('filter_side_nav').style.height = '100%';
        document.getElementById("filter_side_nav_mask").style.cssText = "  visibility: hidden;   opacity:0; ";
    }
    function TEST(){
        console.log("2333333333333~");        
    }

</script>
</html>


```
</details>

























<details>
<summary><b> 折叠式侧边栏: style.width = 300px </b></summary>

```

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title> 折叠式侧边栏 </title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: #f4f4f4;
            overflow-x: hidden;
        }

        .navbar {
            /* float: left; */
            background-color: #3b5998;
            overflow: hidden;
            height: 63px;
            position: fixed;
            width:100%;
        }

        .navbar a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            text-decoration: none;
            font-size: 17px;
            padding: 14px 16px;
        }

        .navbar ul {
            margin: 8px 0 0 0;
            list-style: none;
        }

        .navbar a:hover {
            background-color: #ddd;
            color: #000;
        }

        .side-nav {
            height: 100%;
            width: 0;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #111;
            opacity: 0.9;
            overflow-x: hidden;
            padding-top: 60px;
            transition: 0.5s;
        }

        .side-nav a {
            padding: 10px 10px 10px 30px;
            text-decoration: none;
            font-size: 22px;
            color: #ccc;
            display: block;
            transition: 0.3s;
        }

        .side-nav a:hover {
            color: orange;
        }

        .side-nav .btn-close {
            position: absolute;
            top: 0;
            right: 22px;
            font-size: 36px;
        }

        #main {
            transition: margin-left 0.5s;
            padding: 20px;
        }

        @media(max-width: 568px) {
            .navbar-nav {
                display: none;
            }
        }

        /* @media(min-width: 568px) {
    .open-side{
        display: none;
    }
} */
    </style>
</head>

<body>
    <nav class="navbar">
        <span class="open-side">
            <a href="#" onclick="openSideMenu()">
                <svg width="30" height="30">
                    <path d="M0,5 30,5" stroke="#fff" stroke-width="5" />
                    <path d="M0,14 30,14" stroke="#fff" stroke-width="5" />
                    <path d="M0,23 30,23" stroke="#fff" stroke-width="5" />
                </svg>
            </a>
        </span>

        <ul class="navbar-nav">
            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Services</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
    </nav>

    <div id="side-menu" class="side-nav">
        <a href="#" class="btn-close" onclick="closeSideMenu()">&times;</a>
        <a href="#">AAA</a>
        <a href="#">BBBBB</a>
        <a href="#">CCCCs</a>
        <a href="#">DDDDD</a>
    </div>

    <div id="main">
        <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   <h1>Lorem t quas excepturi.</h1>   

    </div>

    <script>
        function openSideMenu() {
            document.getElementById('side-menu').style.width = '250px';
            // document.getElementById('main').style.marginLeft = '250px';
        }

        function closeSideMenu() {
            document.getElementById('side-menu').style.width = '0';
            document.getElementById('main').style.marginLeft = '0';
        }
    </script>
</body>
</html>

```
</details>


































<details>
<summary><b> 折叠式侧边栏: .style['margin-left'] = 300px </b></summary>

```

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title> 折叠式侧边栏 </title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }
        body {
            max-width: 1920px;
        }

        #button___ {
            position: absolute;
            top: 22%;
            left: 298px;
            height: 75px;
            width: 50px;
            border: 0;
            border-left: 1px solid rgb(23, 32, 43, 0.2);
            background: #AA3344;
            color: #fff;
            cursor: pointer;
        }

        .box {
            float: left;
            position: relative;
            left: -300px;
            height: 1000px;
            width: 300px;
            margin-left: 0;
            display: block;
            background-color: #a34;
            -moz-transition: margin-left 0.5s;
            transition: margin-left 0.5s;
        }

        aside ul li {
            height: 40px;
            line-height: 40px;
            border-top: 1px solid #fff;
            border-bottom: 1px solid #fff;
            list-style-type: none;
            text-align: center;
        }

        aside ul li a {
            width: 100%;
            height: 100%;
            text-decoration-line: none;
            color: #fff;
            display: block;
        }

        aside ul li a:hover {
            background: yellow;
        }
    </style>
</head>
<body>

    <aside class="box" id="test">
        <button id="button___">三</button>
        <ul>
            <li>
                <h3>ZZES</h3>
            </li>
            <li><a href="#">MENU TITLE 1</a></li>
            <li><a href="#">MENU TITLE 2</a></li>
            <li><a href="#">MENU TITLE 3</a></li>
            <li><a href="#">MENU TITLE 4</a></li>
            <li><a href="#">MENU TITLE 5</a></li>
            <li><a href="#">MENU TITLE 6</a></li>
            <li><a href="#">MENU TITLE 7</a></li>
        </ul>
    </aside>

</body>
<script>

    var box = document.getElementById("test")
    var btn = document.getElementById("button___")

    btn.onclick = function () {
        if (box.offsetLeft == 0) {
            box.style['margin-left'] = 0 + "px";
        }
        if (box.offsetLeft == -300) {
            box.style['margin-left'] = 300 + "px";
        }
    }

</script>
</html>

```
</details>
































<details>
<summary><b> 折叠式侧边栏 : 左边可以滑动 </b></summary>

```

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>IconFont</title>
    <style>
        html,
        body {
            width: 100vm;
            height: 100vh;
            margin: 0px;
            background-color: 0 lightblue;
        }

        #side-menu {
            background-color: pink;
            display: block;
            position: fixed;
            overflow: scroll;
            top: 0px;
            left: 0px;
            bottom: 0px;
            width: 350px;
            transition: transform 200ms ease-in;
            transform: translateX(calc(-100% + 12px));
        }

        #side-menu:hover {
            transform: translateX(0px);
        }

        #side-menu-inner {}
    </style>
</head>

<body>
    <div id="side-menu">
        <div id="side-menu-inner">
            <ul>
                <li style="margin-top: 66px;"><a href="#">为什么滑动不了?</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link 0</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link 1</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">Link</a></li><li style="margin-top: 66px;"><a href="#">滑动...滑动....滑动...</a></li>
            </ul>
        </div>
    </div>

    <h1>怎么才可以让左边的内容也可以滑动?</h1>
    <h1> ---> Answer is: 正确答案是: 加上 overflow: scroll 就可以滑动啦~~~ </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1><h1>啊实asd asd sum do实 asdasd asd 阿松大dfghdfg大 </h1>

</body>
</html>

```
</details>






































<details>
<summary><b> CSS: 制作笔记本横线效果 </b></summary>

```

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Notebook</title>
    <style>
        .note-book {
            width: 240px;
            margin: 0 auto;
            background: #FEF9E7;
            padding: 16px 24px;
            border-radius: 4px;
            box-shadow: 0 0 4px #B2BABB;
        }

        .note-book .cntr {
            /* 实现横线效果 */
            background: linear-gradient(transparent 95%, #424949 0);
            line-height: 1.5em;
            background-size: 100% 1.5em;
            background-attachment: local;
            /*  这里需要根据 textarea 的内容进行滚动 */
            /* textarea样式修改 */
            width: 100%;
            resize: none;
            font-size: 0.9em;
            font-family: inherit;
            outline: none;
            border: none;
            color: #2874A6;
            word-break: break-all;
            overflow-x: hidden;
        }
    </style>
</head>

<body>
    <div class="note-book">
        <textarea name="note" cols="30" rows="15"  class="cntr">我们遇到什么困难也不要怕，微笑着面对它！消除恐惧的最好办法就是面对恐惧！坚持，才是胜利。加油！奥利给！</textarea>
    </div>
</body>
</html>

```
</details>






















<details>
<summary><b> 半透明背景幕布 </b></summary>

```

<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>YXB</title>
    <script src="https://s1.pstatp.com/cdn/expire-1-M/jquery/2.1.4/jquery.min.js"
        type="application/javascript"></script>
    <script src="http://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script>
    <script src="https://s0.pstatp.com/cdn/expire-1-M/vue/2.6.10/vue.min.js" type="application/javascript"></script>
    <link href="https://s2.pstatp.com/cdn/expire-1-M/twitter-bootstrap/3.4.0/css/bootstrap.min.css" type="text/css"
        rel="stylesheet" />
    <script src="https://s1.pstatp.com/cdn/expire-1-M/twitter-bootstrap/3.4.0/js/bootstrap.min.js"
        type="application/javascript"></script>
    <script src="https://s1.pstatp.com/cdn/expire-1-M/layer/2.3/layer.js" type="application/javascript"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
            text-decoration: none;
            list-style-type: none;
        }

        #shadow {
            font-family: -apple-system, Helvetica, sans-serif;
            -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
            position: fixed;
            top: 0;
            bottom: 0;
            right: 0;
            left: 0;
            transition: 0.5s;
            z-index: 111;
            opacity: 1;
            background-color: rgba(0, 0, 0, .7);
        }

        #change_shadow {
            position: absolute;
            z-index: 222;
        }
    </style>
</head>

<body>
    <h1>Hello World~</h1>
    <div id="shadow">============</div>
    <button id="change_shadow" onclick="change_shadow()">change_shadow</button>


</body>
<script>


    function getCss(curEle, attr) {
        var val = null, reg = null;
        if ("getComputedStyle" in window) {
            val = window.getComputedStyle(curEle, null)[attr];
        } else {   //ie6~8不支持上面属性  
            //不兼容  
            if (attr === "opacity") {
                val = curEle.currentStyle["filter"];   //'alpha(opacity=12,345)'  
                reg = /^alphaopacity=(\d+(?:\.\d+)?)opacity=(\d+(?:\.\d+)?)$/i;
                val = reg.test(val) ? reg.exec(val)[1] / 100 : 1;
            } else {
                val = curEle.currentStyle[attr];
            }
        }
        reg = /^(-?\d+(\.\d)?)(px|pt|em|rem)?$/i;
        return reg.test(val) ? parseFloat(val) : val;
    }

    const box = document.querySelector('#shadow');
    console.log(getCss(box, 'opacity'));

    function change_shadow() {
        var opacity_ = getCss(box, 'opacity')
        if (opacity_ === 1) {
            document.getElementById("shadow").style.cssText = "  opacity: 0.5;  ";
        } else {
            document.getElementById("shadow").style.cssText = " opacity: 1; ";
        }

    }

</script>
</html>

```
</details>





























<details>
<summary><b> 伸缩侧边栏:right: -300px </b></summary>

```

<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            position: relative;
            left: 0;
            padding: 0;
            margin: 0;
            /*overflow-x:hidden;*/
        }

        aside {
            width: 300px;
            height: 100%;
            position: fixed;
            right: 0;
            top: 0;
            background: #d4d4d4;
            transition: right 0.5s ease;
            z-index: 333;
        }

        #button___ {
            position: absolute;
            top: 50%;
            right: 300px;
            background-color: #19497d;
            color: #FFF;
            width: 50px;
            height: 120px;
            border: none;
            font-size: 30px;
            line-height: 50px;
            text-align: center;
            cursor: pointer;
            /* 鼠标放上去有个小手 */
        }

        .open {
            right: 0;
        }

        .close {
            right: -300px;
        }
    </style>
</head>

<body>

    <h1>问题1: 怎么适应各种屏幕? </h1>

    <aside id="aside">
        <button id="button___" onclick="toggle()">三</button>
        <ul>
            <li>list</li>
            <li><img src="https://dummyimage.com/120x120/FF7F00/1C86EE" alt=""></li>
            <li>list</li>
            <li>list</li>
            <li>list</li>
            <li>list</li>
        </ul>
    </aside>

</body>
<script>

    var aside = document.getElementById("aside");
    var button___ = document.getElementById("button___");
    var state = "close";

    aside.setAttribute("class", state);

    function toggle() {
        console.log(state);
        if (state === "close") {
            aside.setAttribute("class", "open");
            state = "open";
            return null;
        }
        if (state === "open") {
            aside.setAttribute("class", "close");
            state = "close";
            return null;
        }
    }

</script>
</html>


```
</details>




































<details>
<summary><b> 伸缩侧边栏: 纯CSS, 无 JavaScript </b></summary>

```
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style type="text/css">
        /*隐藏checked复选框*/
        #sidemenu {
            display: none;
        }

        #sidemenu:checked+aside {
            /*为被选中的sidemenu后的aside设置属性（紧邻）*/
            left: 0;
            /*点击按钮即选中checked后,侧边栏位置变为贴着左边,配合ease-out使用,有渐变滑出的效果*/
        }

        #sidemenu:checked~#close_open {
            /*为被选中的sidemenu后的close_open设置属性（非紧邻）*/
            padding-left: 220px;
        }

        aside {
            /*侧边栏,初始位置为-200px，即隐藏效果*/
            position: absolute;
            top: 0;
            bottom: 0;
            left: -200px;
            width: 200px;
            background: black;
            transition: 0.3s ease-out;
            /*动画效果的执行方式是ease-out，即侧边栏滑动效果为渐变式，而不是生硬的突然变化*/
        }

        h2 {
            color: white;
            text-align: center;
            font-size: 2em;
        }

        /*控制侧边栏进出的按钮（外部包裹）*/
        #close_open {
            margin-left: 20px;
            padding: 10px;
            transition: 0.3s ease-out;
        }

        /*控制侧边栏进出的按钮（内部文字样式）*/
        label {
            /*控制侧边栏进出的按钮*/
            background: white;
            border-radius: 70px;
            color: orange;
            cursor: pointer;
            display: block;
            font-family: Courier New;
            font-size: 2em;
            width: 1.5em;
            height: 1.5em;
            line-height: 1.5em;
            text-align: center;
            display: inline-block;
        }

        label:hover {
            background: #000;
        }

        #sideul li {
            list-style: none;
            color: white;
            width: 100%;
            height: 1.8em;
            font-size: 1.5em;
            text-align: center;
        }

        #sideul li:hover {
            color: orange;
        }
    </style>
</head>

<body>
    <input type='checkbox' id='sidemenu'>
    <aside>
        <h2>主菜单</h2>
        <br />
        <ul id="sideul">
            <a href="##"><li>首页</li></a>
            <a href="##"><li style="color: orange;">导航1</li></a>
            <a href="##"><li>导航2</li></a>
            <a href="##"><li>导航3</li></a>
        </ul>
    </aside>


    <div id='close_open'>
        <label id='sideMenuControl' for='sidemenu'>x</label>
        <!--for 属性规定 label 与哪个表单元素绑定，即将这个控制侧边栏进出的按钮与checkbox绑定-->
    </div>

</body>
</html>

```
</details>




























<details>
<summary><b> 京东筛选框 </b></summary>

```

<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            position: relative;
            left: 0;
            padding: 0;
            margin: 0;
            /*overflow-x:hidden;*/
        }

        aside {
            width: 85%;
            height: 100%;

            position: fixed;
            width: 85%;
            top: 0;
            left: 100%;

            background: #d4d4d4;
            transition: 0.5s ease;
            z-index: 222;
            transform: translate3d(100%,0,0);
        }

        #Background_Shadow {
            position: fixed;
            top: 0;
            bottom: 0;
            right: 0;
            left: 0;

            transition: 0.5s ease;
            /* transition: opacity .5s ease, visibility .5s ease; */
            -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
            background-color: rgba(0, 0, 0, .7);
            z-index: 111;
            opacity: 1;
            visibility: hidden;
        }
    </style>
</head>

<body>

    <h3>关键技术点: </h3>
    <h4>left: 100% </h4>
    <h4>transition: 0.5s ease </h4>
    <h4>transform: translate3d(100%,0,0)  - 分别是 x轴, y轴   </h4>
    <h4>opacity: 1</h4>

    <button id="open_box">展开</button>
    <div class="" id="Background_Shadow"></div>
    <aside id="aside">
        <ul>
            <li>list</li>
            <li><img src="https://dummyimage.com/120x120/FF7F00/1C86EE" alt=""></li>
            <li>list</li><li>list</li><li>list</li> <li>list</li>                    
        </ul>
    </aside>

</body>
<script>

    var aside = document.getElementById("aside");
    var Background_Shadow = document.getElementById("Background_Shadow");
    var state = "close";

    aside.setAttribute("class", state);

    document.getElementById("Background_Shadow").onclick = function () {
        document.getElementById("Background_Shadow").style.cssText = "      opacity: 0; visibility: hidden;    ";
        document.getElementById("aside").style.cssText = "   transform: translate3d(100%,0,0);    ";
    }

    document.getElementById("open_box").onclick = function(){
        document.getElementById("Background_Shadow").style.cssText = "      opacity: 1; visibility: visible;    ";
        document.getElementById("aside").style.cssText = "   transform: translate3d(-100%,0,0);    ";
    }
</script>
</html>

```
</details>
