# JavaScript 

### chrome F12 可以直接调试小代码片段 很方便

#### 移动端页面开发的两种方式   https://www.cnblogs.com/jasmine-95/p/7235186.html
#### JavaScript 实战小项目   https://github.com/visugar/FrontEnd-examples



# 规范:
* 指的是代码过程中需要注意的小细节...提升代码质量, 便于后期维护
<details>
<summary><b>注意!!!!</b></summary>

```  



JavaScript 中 :
\n 和 \\n 是不一样的



如果一个变量是需要全局有效的，那么使用全局变量。
但全局变量会导致代码的耦合度比较高，不方便维护，所以尽量少用,
有些看似需要使用全局变量的场景，其实使用函数的参数传递更合理




需要经常刷新整个页面的, 不要使用 Ajax 从后台获取主要数据,
因为一刷新, 数据都没了, 
推荐使用 访问地址 + 参数来访问, 这样即使整个页面刷新了, 数据还是照样存在
比如:
    http://www.xxxxx.com/user/page?id=1
Ajax 适用于加载一些临时性的数据 (优点是不刷新整个网页)    



个人推荐使用这种方法绑定 点击事件, 
这样从按钮上就直接一眼看出绑定了哪些函数/方法, 不用一个一个去大量的 js 文件去找
甚至在 idea 等 IDE 中, 按住 Ctrl + 鼠标就可以直接定位到函数/方法, 非常方便
    <button id="vv" onclick="myfunction()" >哈哈</button>

这种就要一个一个去大量的 js 文件去找, 有时候眼睛都看花了
    document.getElementById('vv').onclick = function () {
        alert('hasssshhaa ')
    }



<script>

    function myFunction() {
        alert("hello world!!!");
    }

注意:
    这两个方式调用函数, 效果是不一样的
    document.getElementById("click_me").onclick = myFunction();     // 方式一
    document.getElementById("click_me").onclick = myFunction;       // 方式二

    方式一, 会在网页一开始加载的时候, 就执行 myFunction 方法, 然后点击命令不会执行
    方式二, 只有在点击的时候, 才会执行 myFunction 方法, 方法二比较常用
</script>




```
</details>

















# DOM 操作 
<details>
<summary><b>下拉框 select 发生改变时 的值 </b></summary>

```  
<select id="testSelect">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
</select>

    $("#testSelect").change(function(ev){
        console.log(ev.target.value);
    });
```
</details>






















<details>
<summary><b> 操作 CSS </b></summary>

```  

document.getElementById("kkk").style.cssText = " background-color:pink; width: 100px; height: 100px; ";
document.getElementsByClassName('div2')[0].style.background = 'pink';


推荐使用 jQuery , 可以直接操作全部的 class
    document.getElementsByClassName("test")[0].style.color = "red";

原生 JavaScript 只能操作单个 class 元素:
    $(".test").css("color","red");
    

```
</details>

































<details>
<summary><b>获取body节点</b></summary>

```  
    document.body.style.background

```
</details>




















<details>
<summary><b> 新增一个节点</b></summary>

```  
    window.onload = function() {
        var childNode = document.createElement('p');
        childNode.innerHTML = '<h1>这里是提示信息??</h1>';

        //childNode.setAttribute('class', 'alerts');
        //childNode.setAttribute('onclick', 'this.style.display = "none"');
        childNode.className = 'alerts';
        childNode.onclick = function () {
            this.style.display = 'none';
        };
        document.getElementsByTagName('body')[0].appendChild(childNode);
    };
```
</details>






























<details>
<summary><b> 属性 </b></summary>

```  

第一种方式:
    <h1 onclick="changetext(this)">点击文本!------111</h1>
    function changetext(ev) {
        ev.innerHTML = "Ooops!";
    }

第二种方式:
    <h1 id="test001">点击文本!------222</h1>
    document.getElementById("test001").onclick = function(e){
        e.target.innerHTML = "222222222";
    }







动态改变DOM节点属性 (使用模板会更加好)

<a href="#" target="_self" id="test">测试</a>
document.getElementById("test").attributes["target"].nodeValue="_blank";

JavaScript DOM setAttribute() 方法:
document.getElementsByTagName("INPUT")[0].setAttribute("type","button");








// 创建 a 标签 class='add_screenshots'
var add_screenshots_a = document.createElement('a');            创建一个a标签

    add_screenshots_a.className = 'add_screenshots';            设置 class 属性
    add_screenshots_a.innerHTML = '添加截图';               
    add_screenshots_a.setAttribute("onclick", "dddd(this)");    动态绑定点击事件dddd(this)
 
function dddd(thisss){
    console.log(thisss.innerHTML);  => 这个元素的 innerHTML
    console.log(thisss.previousSibling); => 这个节点元素的 上一个同类节点(object类型)
    console.log(thisss.previousSibling.innerHTML); =>上一个同类节点的 innerHTML
    console.log(thisss.getAttribute('class')); => 获取名为'class' 的属性值 (string类型)
}


```
</details>































<details>
<summary><b>获取元素的绝对位置(相对于父元素)</b></summary>

```  
var self = document.getElementById("eID");
var left = self.getBoundingClientRect().left + document.documentElement.scrollLeft;
var top = self.getBoundingClientRect().top + document.documentElement.scrollTop + self.offsetHeight;

```
</details>






















<details>
<summary><b>定位到某个位置:</b></summary>

```  
document.getElementById("hhh").onclick = function () {
	//scrollTo() 方法可把内容滚动到指定的坐标
	window.scrollTo(0, 10000);
}
```
</details>



































<details>
<summary><b> 点击事件 </b></summary>

```  


------------------------------   click onclick 的区别   ------------------------------

    document.getElementsByClassName('btn-default')[0].click();
    document.getElementsByClassName('btn-default')[0].onclick() = function(){ ...... };
    click()---->单纯的点击,比如某个按钮
    onclick---->绑定点击事件



给单个class添加(绑定) 事件
     document.getElementsByClassName('btnn')[0].onclick = function() {
        alert('btnnnnn');
     }


给每个class添加(绑定) 事件:
    原生JavaScript比较复杂, 需要遍历节点元素,并且绑定点击事件
    var list = document.getElementsByClassName('li_new');
      for (var i in list) {
        list[i].onmouseover = aaa;
        list[i].onmouseout = bbb;
      }
      
    function bbb(){
      console.log("---------------");
    }

    jQuery 方便很多:
    $(".li_new").click(function(){
    console.log("==================");
    })



中绑定click事件的几种种方式介绍
* HTML中添加onclick (推荐 , 一目了然 )
    <button id="vv" onclick="myfunction()" >哈哈</button>
    function myfunction(){
        console.log("hahahahahaha.....");
    }


* 直接定义函数与内容 
    document.getElementById('vv').onclick = function () {
      alert('hasssshhaa ')
      }


* 利用addEventListener    
    document.getElementById('vv').addEventListener('click',funcc);
    //或者：
    document.getElementById('vv').addEventListener('click',function () {
      alert('hahah')
    })





------------------------------   onclick 和 addEventListener 的区别   ------------------------------

onclick不支持多次赋值,绑定的是最后一次点击事件
addEventListener 支持多次绑定,全部触发点击事件
    var  obj = document.getElementById('h1');

    // obj.onclick = function () {
    //     console.log('11111111111')
    // }
    // obj.onclick = function () {
    //     console.log('2222222222')
    // }

    //注册第一个点击事件 绑定点击事件
    obj.addEventListener("click",function(){
        console.log("11111111111");
    });
    //注册第二个点击事件
    obj.addEventListener("click",function(){
        console.log("22222222222222");
    });


```
</details>


























<details>
<summary><b>tagName nodeName 区别:</b></summary>

```  
总结： tagName 只能用在元素节点上，而nodeName可以用在任何节点上，
可以说nodeName涵盖了tagName，并且具有更多的功能，因此建议总是使用nodeName。
小例子:
  <div id="box1">box1
      <div class="son">son1</div>
  </div>  

      for (var i = 0; i < father.length ; i++) {
            console.log(father[i].tagName)
      }
      返回: 
          undefined
          DIV
          undefined
  但是:
        for (var i = 0; i < father.length ; i++) {
            console.log(father[i].nodeName)
        }      
        返回:
            #text
            DIV
            #text
  建议使用nodeName
      ps:多余一个text是因为有一个回车换行符
```
</details>























<details>
<summary><b>innerHTML / outerHTML / innerText / outerText </b></summary>

```  
innerHTML  输出当前标签的文本内容，如果标签内有子标签，会连子标签本身和子标签内的文本内容一起输出
outerHTML  输出当前标签的本身和标签内的文本内容，如果有子标签，那么子标签本身和标签内的文本内容也将一起输出

innerText     只输出当前标签内的文本内容，如果标签内有子标签，那么也只输出子标签内的文本内容
outerText     只输出当前标签内的文本内容，如果标签内有子标签，那么也只输出子标签内的文本内容

ps:
    innerHTML是符合W3C标准的属性，
    而innerText只适用于IE浏览器，因此，尽可能地去使用innerHTML，而少用innerText，
```
</details>





















<details>
<summary><b>event对象中 target和currentTarget 属性的区别</b></summary>

```  
首先本质区别是：

    event.target返回触发事件的元素
    event.currentTarget返回绑定事件的元素

    event.currentTarget的作用是什么呢，我觉得他和this 的作用是差不多的，始终返回的是绑定事件的元素

```
</details>





















<details>
<summary><b>获取当前第几个元素:</b></summary>

```  
<ul id="list">
    <li>YXB_____QAQ---1</li>
    <li>YXB_____QAQ---2</li>
    <li>YXB_____QAQ---3</li>
    <li>YXB_____QAQ---4</li>
    <li>YXB_____QAQ---5</li>
</ul>

    var ul =  document.getElementById("list");

    ul.addEventListener('click',function(e){
        var item = e.target;
        var lists = Array.from(ul.querySelectorAll('li'));
        console.log(lists.indexOf(item));
    })
```
</details>






















<details>
<summary><b>获取整个网页向上滚动了多少距离??:</b></summary>

```  
console.log("向上滚动了   "+document.documentElement.scrollTop);

```
</details>












<details>
<summary><b> 高级测试:</b></summary>

```  
网页尺寸为: 2472*6708
chrome浏览器模拟移动端: 
	宽:320		高: 568

测试代码:
<html lang="zh"><head><style>        * {            margin: 0;            padding: 0;            text-decoration: none;            list-style-type: none;        }        #box1{            width: 115px;            height: 115px;            margin-left: 36px;            background-color: pink;        }</style><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge"><title>YXB</title></head><body><h1>YXB</h1><div id="box1"></div><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><span>qwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqwqwerqweqweqw</span><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p><p>123123123</p></body><script>    console.log(document.getElementById("box1").offsetWidth);    console.log(document.getElementById("box1").offsetHeight);    console.log(document.getElementById("box1").offsetLeft);    console.log(document.getElementById("box1").offsetTop);</script></html>
	
document.body.clientWidth;        //网页可见区域宽(body)   						返回 320
document.body.clientHeight;       //网页可见区域高(body)						返回 569

document.body.offsetHeight;      //网页可见区域宽(body)，包括border、margin等	返回 2472
document.body.scrollWidth;        //网页正文全文宽，包括有滚动条时的未见区域	返回 6708
document.body.scrollHeight;       //网页正文全文高，包括有滚动条时的未见区域	返回 2472

document.body.offsetWidth;       //网页可见区域宽(body)，包括border、margin等  无论怎么滑动, 返回 320

document.body.scrollTop;           //网页被卷去的Top(滚动条)					返回 88.5
document.body.scrollLeft;           //网页被卷去的Left(滚动条)					返回 3762

window.screenTop;                     //浏览器距离Top							返回 
window.screenLeft;                     //浏览器距离Left							返回 

window.screen.height;                //屏幕分辨率的高							返回 568
window.screen.width;                 //屏幕分辨率的宽							返回 320

window.screen.availHeight;          //屏幕可用工作区的高						返回 568
window.screen.availWidth;           //屏幕可用工作区的宽						返回 320


    console.log(document.getElementById("box1").offsetWidth);
    console.log(document.getElementById("box1").offsetHeight);
    console.log(document.getElementById("box1").offsetLeft);
    console.log(document.getElementById("box1").offsetTop);
	
	注意:
		document.documentElement.scrollTop 在chrome浏览器中, 不起作用
		document.body.scrollTop			   在chrome浏览器中可以用

		parseInt 小数转化成整数
```
</details>


















































# 字符串操作: 
* https://www.runoob.com/jsref/jsref-obj-string.html
<details>
<summary><b>字符串之 : 基本操作:</b></summary>

```  

大小写转换:
    phrase_array[i] = phrase_array[i].toUpperCase();     // 正确的
    phrase_array[i].toUpperCase();                       // 错误的, 别忘了重新赋值, 不然会报错

    长度:
    var txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    var sln = txt.length;
    
    
    某个指定的字符串值在字符串中首次出现的位置
    var str="Hello world, welcome to the universe.";
    var n=str.indexOf("welcome");
    
    在字符串第五个位置开始查找字符 "e" 第一次出现的位置:
    var str="Hello world, welcome to the universe.";
    var n=str.indexOf("e",5);
    
    查找字符串是否包含 "Runoob" (true / false):
    var str = "Hello world, welcome to the Runoob。";
    var n = str.includes("world");
    
    从第 12 个索引位置开始查找字符串:
    var str = "Hello world, welcome to the Runoob.";
    var n = str.includes("world", 12);
    
    等等........
    


    var str="How are you doing                    today?";
    var array = str.split(" ");
    >>> ["How", "are", "you", "doing", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "today?"]


    // 分割完可能会出现这种情况...
    var arr = ['','','',1,2,3,4,5,'','',''];
    for(var i = 0; i < arr.length; i++){
        if(arr[i] === ''){
            arr.splice(i,1);
            i = i-1;
        }
    }
    console.log(arr);


    JavaScript 替换字符串:
        详情见 下面的 字符串之 : 正则表达式
        replace() 方法



```
</details>

























<details>
<summary><b> 字符串之 : 正则表达式</b></summary>

```  


详细教程:        https://www.runoob.com/js/js-regexp.html




------------------>   search()   <------------------
使用正则表达式搜索 "Runoob" 字符串，且不区分大小写:
var str = "Visit Runoob!"; 
var n = str.search(/Runoob/i);
>>> n = 6



------------------>   replace()   <------------------
使用正则表达式且不区分大小写将字符串中的 Microsoft 替换为 Runoob :
"microsoftAAAAAAAA".replace(/microsoft/i,"Runoob");
>>> "RunoobAAAAAAAA"

这种写法也是可以的:
"microsoftAAAAAAAA  microsoft  microsoft asdasd microsoft".replace("microsoft","Runoob");
>>> "RunoobAAAAAAAA  microsoft  microsoft asdasd microsoft"

但是, 这种只是替换一次, 怎么实现全局替换呢?
答案是: 加 g
如下:
"microsoftAAAAAAAA  microsoft  microsoft asdasd microsoft".replace(/microsoft/g,"Runoob");
>>> "RunoobAAAAAAAA  Runoob  Runoob asdasd Runoob"






------------------>   test()   <------------------
用于检测一个字符串是否匹配某个模式，如果字符串中含有匹配的文本，
返回 true 或 false

实例用于搜索字符串中的字符 "e"：
var patt = /e/;
patt.test("The best things in life are free!");
>>> true

检测是否是中文:
var bool = (new RegExp("^[\u4e00-\u9fa5]$")).test("所");
console.log(bool);
>>> true




------------------>   exec()   <------------------
方法用于检索字符串中的正则表达式的匹配
该函数返回一个数组，其中存放匹配的结果。
如果未找到匹配，则返回值为 null

实例用于搜索字符串中的字母 "e":
/e/.exec("The best things in life are free!");
字符串中含有 "e"，所以该实例输出为:
e




------------------>   match()   <------------------
var str="Is this all there is?";
var patt1=/is/g;            // g 区分大小写
str.match(patt1);
>>>   ["is", "is"]

var str="Is this all there is?";
var patt1=/is/gi;           // gi 不区分大小写
str.match(patt1);
>>>  ["Is", "is", "is"]







i	    执行对大小写不敏感的匹配
g	    执行全局匹配（查找所有匹配而非在找到第一个匹配后停止）
m	    执行多行匹配
[abc]	查找方括号之间的任何字符
[0-9]	查找任何从 0 至 9 的数字
(x|y)	查找任何以 | 分隔的选项
\d	    查找数字
\s	    查找空白字符
\b	    匹配单词边界
\uxxxx	查找以十六进制数 xxxx 规定的 Unicode 字符
n+	    匹配任何包含至少一个 n 的字符串
n*	    匹配任何包含零个或多个 n 的字符串
n?	    匹配任何包含零个或一个 n 的字符串





判断输入是否为数字、字母、下划线组成:
    /^\w+$/.test("1234abd__");
    >>> true

    /^\w+$/.test("$32343");
    >>> false

判断字符串是否全部为字母 (不允许有空格):
    /^[a-zA-Z]+$/.test("QAQ");                 返回 true
判断字符串是否全部为字母 (允许有空格): 
    /^[a-zA-Z\s]+$/.test("asd           ");    返回 true
    

判断字符串是否全部为数字
     /^\d+$/.test("123123");

判断字符串是否包含中文汉字:
    /[\u4E00-\u9FA5\uF900-\uFA2D]/.test("12312a啊sda.^&(&*(^&*^%^&sd");
    >>> true



更多:
/*是否带有小数*/
function    isDecimal(strValue )  {  
   var  objRegExp= /^\d+\.\d+$/;
   return  objRegExp.test(strValue);  
}  

/*校验是否中文名称组成 */
function ischina(str) {
    var reg=/^[\u4E00-\u9FA5]{2,4}$/;   /*定义验证表达式*/
    return reg.test(str);     /*进行验证*/
}

/*校验是否全由8位数字组成 */
function isStudentNo(str) {
    var reg=/^[0-9]{8}$/;   /*定义验证表达式*/
    return reg.test(str);     /*进行验证*/
}





```
</details>






































<details>
<summary><b> 字符串之 :  Unicode 转换 </b></summary>

```  



  //  字符串 -> Unicode
  function String_to_Unicode(str) {
    var unicodeString = '';
    for (var i = 0; i < str.length; i++) {
      var theUnicode = str.charCodeAt(i).toString(16).toUpperCase();
      while (theUnicode.length < 4) {
        theUnicode = '0' + theUnicode;
      }
      theUnicode = '\\u' + theUnicode;
      unicodeString += theUnicode;
    }
    return unicodeString;
  }
  console.log(String_to_Unicode("我我我我我我"));    //  \u6211\u6211\u6211\u6211\u6211\u6211





  // Unicode -> 字符串
  function Unicode_to_string(unicode) {
    return eval("'" + unicode + "'");
  }
  console.log(Unicode_to_string("\u6211\u6211\u6211\u6211\u6211\u6211"));     // 我我我我我我





Unicode:
中文 Unicode 对照表:  http://www.chi2ko.com/tool/CJK.htm
我		6211
哈		54C8
不		4E0D

英文 Unicode 预览:
参考资料: https://zh.wikipedia.org/wiki/Unicode%E5%AD%97%E7%AC%A6%E5%88%97%E8%A1%A8
A(拉丁字母A)    U+0041	 	\u41
a(拉丁字母a)    U+0061		\u61
=(等于号)	   U+003D		\u3d
+(加号)         U+002B 		\u2b
 空格           U+0020      \u20
\(反斜杠)       U+005C      \u5c
n(拉丁字母n)    U+006E      \u6e


关于 Unicode 中的回车/换行:
结论:
    在 Windows 系统下, 
    \ud\ua  就是文本文件的换行

不过:
在 JavaScript 中  
A
A
转化成 Unicode 是:
\u0041\u000D\u000A\u0041

也就是说:
在 JavaScript 中:  
    \u000D\u000A  是回车换行


```
</details>






























<details>
<summary><b>字符串之 : 将后台返回的string数据,解析成JSON数据</b></summary>

```  



  var index_page_json_data = JSON.parse("{\"We do not have anything\":\"我们没有病\",\"How do you know?\":\"你怎么知道?\",\"Do we look like it?\":\"我们看起来像有病吗?\"}");
  console.log(index_page_json_data);                   // 将字符串格式 -> json格式

  var Get_value = index_page_json_data['We do not have anything'];    //  根据键 取出 值
  console.log("根据键 取出 值:   " + Get_value);

  for (var key in index_page_json_data) {
    console.log(key + ' : ' + index_page_json_data[key]);
  }
  


```
</details>











































# 集合对象(Array、Map、Set):
<details>
<summary><b> Array </b></summary>

```  

多维的:
    var movies = [
        { Name: "The Red Violin", ReleaseYear: "1998" },
        { Name: "Eyes Wide Shut", ReleaseYear: "1999" },
        { Name: "The Inheritance", ReleaseYear: "1976" }
    ];

    // 添加数据
    movies.push({"Name" : "AAAAAAA" ,  "password": "1234567890"});

    // 打印出来:
    console.log(movies);
            0: {Name: "The Red Violin", ReleaseYear: "1998"}
            1: {Name: "Eyes Wide Shut", ReleaseYear: "1999"}
            2: {Name: "The Inheritance", ReleaseYear: "1976"}
            3: {Name: "AAAAAAA", password: "1234567890"}    
    
    console.log(typeof movies);
            object




=====================================================================================================   




数组去掉重复的:
    const deDupe = (myArray) => [... new Set(myArray)];
    phrase_array = deDupe(phrase_array);    // 别忘了重新赋值, 不然无效


Array中全部转成大小写:
    var tempArr=['Hello','World'];
    for(var i=0;i<tempArr.length;i++){
    tempArr[i]= tempArr[i].toUpperCase();
    }


添加:
    user.push('jack');


遍历
    var arr = [1,2,4,6]
    for(var i = 0, len = arr.length; i < len; i++){
        console.log(arr[i])
    }


删除:
    JavaScript中并没有直接提供删除某个元素的API, 需要通过索引删除某个元素: 
    var removedItem = fruits.splice(index, 1); 

找出某个元素在数组中的索引:
    var pos = fruits.indexOf('iPhone');

直接删除某个元素, 需要自己手动实现:
    delete方式 1:
    var array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];

    function arrayRemove(arr, value) {
    return arr.filter(function(ele){
        return ele != value;
    });
    }

    var result = arrayRemove(array, 6);
    console.log(result)



delete方式 2:
    Array.prototype.remove = function(val) {
    var index = this.indexOf(val);
    if (index > -1) {
    this.splice(index, 1);
    }
    };

    var emp = ['abs','dsf','sdf','fd']

    emp.remove('fd');
    console.log(emp);



把一个 array 打乱: (系统不自带, 需要自己实现)
    var aaa = [0,1,2,3,4,5];
    aaa.sort(function() {
        return .5 - Math.random();
    });


经典的 Fisher-Yates 打乱算法(最佳):
    var arr = [0, 1, 2, 3, 4, 5];
    for (let i = 1; i < arr.length; i++) {
        const random = Math.floor(Math.random() * (i + 1));
        [arr[i], arr[random]] = [arr[random], arr[i]];
    }
    console.log(arr);    

```
</details>














<details>
<summary><b>Set</b></summary>


```  

资料来源: https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Set

Set 不能有重复的数据(所有 Set 集合中的每一元素都必须不同),它具有更快的运行时间
Set.size: size属性的默认值为0

增:
var mySet = new Set();
mySet.add(1);
mySet.add(5).add("some text"); // 可以链式调用

let o = {a: 1, b: 2};
mySet.add(o);
mySet.add({a: 1, b: 2}); // o 指向的是不同的对象，所以没问题


mySet.has("Some Text".toLowerCase()); // true


清空:
mySet.clear();

是否有某个值: 返回布尔类型
mySet.has("foo"); // true

删:
成功删除返回 true，否则返回 false
var mySet = new Set();
mySet.add("foo");
mySet.delete("bar"); // 返回 false，不包含 "bar" 这个元素


循环 / 迭代:
var mySet = new Set();
mySet.add("0");
mySet.add(123);

for (var v of mySet) {
  console.log(v);
}


容量 size:
mySet.size;



Set 与 Array 转换:
let myArray = ["value1", "value2", "value3"];

// 用Set构造器将Array转换为Set
let mySet = new Set(myArray);

mySet.has("value1"); // returns true

// 用...(展开操作符)操作符将Set转换为Array
console.log([...mySet]); // 与myArray完全一致




数组去重:
// 用于从数组中删除重复的元素
const numbers = [2,3,4,4,2,3,3,4,4,5,5,6,6,7,5,32,3,4,5]
console.log([...new Set(numbers)]) 
// [2, 3, 4, 5, 6, 7, 32]


string相关:
let text = 'India';
let mySet = new Set(text);  // Set {'I', 'n', 'd', 'i', 'a'}
mySet.size;  // 5





Set 之间的比较:
function isSuperset(set, subset) {
    for (let elem of subset) {
        if (!set.has(elem)) {
            return false;
        }
    }
    return true;
}

function union(setA, setB) {
    let _union = new Set(setA);
    for (let elem of setB) {
        _union.add(elem);
    }
    return _union;
}

function intersection(setA, setB) {
    let _intersection = new Set();
    for (let elem of setB) {
        if (setA.has(elem)) {
            _intersection.add(elem);
        }
    }
    return _intersection;
}

function symmetricDifference(setA, setB) {
    let _difference = new Set(setA);
    for (let elem of setB) {
        if (_difference.has(elem)) {
            _difference.delete(elem);
        } else {
            _difference.add(elem);
        }
    }
    return _difference;
}


//Examples
let setA = new Set([1, 2, 3, 4]),
    setB = new Set([2, 3]),
    setC = new Set([3, 4, 5, 6]);

超集?
isSuperset(setA, setB); // => true

合并:
union(setA, setC); // => Set [1, 2, 3, 4, 5, 6]

交集:
intersection(setA, setC); // => Set [3, 4]

去掉相同的, 差异化
symmetricDifference(setA, setC); // => Set [1, 2, 5, 6]


```
</details>







<details>
<summary><b>Map</b></summary>

```  

资料来源: https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Map

Map.length
默认length 的值为 0 


var myMap = new Map();

增:
set(key, value)
myMap.set("bar", "baz");
myMap.set(1, "foo");

容量:
myMap.size;       // 2


清空:
myMap.clear();


删:
myMap.delete("bar"); // 返回 true。成功地移除元素

查:
Map.prototype.get(key) 返回键对应的值，如果不存在，则返回undefined
myMap.get("baz");  // 返回 undefined

是否有这个字符串:
myMap.has("bar"); // true





循环 / 迭代:
let myMap = new Map();
myMap.set(0, "zero");
myMap.set(1, "one");

将会显示两个log。一个是"0 = zero"另一个是"1 = one"
for (let [key, value] of myMap) {
  console.log(key + " = " + value);
}



将会显示两个log。 一个是 "0" 另一个是 "1"
for (let key of myMap.keys()) {
  console.log(key);
}



将会显示两个log。 一个是 "zero" 另一个是 "one"
for (let value of myMap.values()) {
  console.log(value);
}


Map也可以通过forEach()方法迭代：
将会显示两个logs。 一个是 "0 = zero" 另一个是 "1 = one"
myMap.forEach(function(value, key) {
  console.log(key + " = " + value);
})



Map 与 Array:
let kvArray = [["key1", "value1"], ["key2", "value2"]];

// 使用常规的Map构造函数可以将一个二维键值对数组转换成一个Map对象
let myMap = new Map(kvArray);

myMap.get("key1"); // 返回值为 "value1"

```
</details>








































































---
# Others:
<details>
<summary><b>新窗口打开 / 原窗口打开 / JavaScript页面跳转</b></summary>

```  
<a href="链接的页面" target="_blank">新窗口打开</a>
<a href="链接的页面" target="_parent">原窗口打开</a>


window.location.href = "https://www.taobao.com";            // 本窗口打开
window.location.href = "/Phrase_Controller/index";          // 跳转到本网页
window.open("http://www.JD.com");                           // 新窗口打开


```
</details>





























<details>
<summary><b>弹窗 (确认框) / 输入框(自带的) </b></summary>

```  

获取输入:
    var input = prompt("请输入：");
    var result1 = !isNaN(input);

确认框:
    function myFunction() {
        var txt;
        if (confirm("你确定这样子做吗? 这样子对你的计算机有很大的风险, 你是否继续???")) {
            txt = "您按了确定";
        } else {
            txt = "您按了取消";
        }
        document.getElementById("demo").innerHTML = txt;
    }

    document.getElementById("click_me").onclick = myFunction;

```
</details>











































<details>
<summary><b>获取页面URL信息 (当前页面链接地址) </b></summary>

```  


参考资料:  https://www.jianshu.com/p/073f79c5e438

完整链接:  http://localhost:8081/Word/Remember?Date=2020-02-10

var test = window.location.href;
console.log(test);
>>> http://localhost:8081/Word/Remember?Date=2020-02-10

var test1 = window.location.pathname;
console.log(test1);
>>> /Word/Remember

var test2 = window.location.search;
console.log(test2);
>>> ?Date=2020-02-10


获取url中的参数值*
    console.log(GetQueryString("Date"));
    >>> 2020-02-10

    function GetQueryString(name) {
        var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
        var r = window.location.search.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2]);
        }
        return null;
    }










Springboot 中 thymeleaf 使用:

假设 url：http://localhost:8080/CarsiLogCenter_new/idpstat.jsp?action=idp.sptopn
	request.getRequestURL()              http://localhost:8080/CarsiLogCenter_new/idpstat.jsp
	request.getRequestURI()              /CarsiLogCenter_new/idpstat.jsp
	request.getContextPath()             /CarsiLogCenter_new
	request.getServletPath()             /idpstat.jsp
	request.getQueryString()             action=idp.sptopn




假设 url：
	http://localhost:8081/Article/Read_Article?name=YXB&password=12345

	<h1 th:text="${#httpServletRequest.getScheme()}"></h1>
	http

	<h1 th:text="${#httpServletRequest.getServerName()}"></h1>
	localhost

	<h1 th:text="${#httpServletRequest.getServerPort()}"></h1>
	8081

	<h1 th:text="${#request.getSession().getServletContext().getRealPath('/')}"></h1>
	C:\Users\SpringBoot\AppData\Local\Temp\tomcat-docbase.4234408327941048660.8081\

	<h1 th:text="${#request.getRequestURI()}"></h1>
	/Article/Read_Article

	<h1 th:text="${#request.getQueryString()}"></h1>
	name=YXB&password=12345







thymeleaf 中 跳转链接
    <a th:href="@{'/menu/getMenu?pageNum='+ ${pageInfo.firstPage}}" >首页</a>



方式二:
    这种方式也行:
    <a th:href="'?page=1'">首页</a>   =>   http://localhost:8081/Article/Read_Article?page=1
  
    <td th:if="${pageInfo.hasPreviousPage}">
        <a th:href="'?page='+${pageInfo.prePage}">上一页</a>
    </td>    


```
</details>



























<details>
<summary><b>睡眠 / 暂停</b></summary>

```  

这种方法会阻塞线程, 这是最简单粗暴的实现，确实 sleep 了，也确实卡死了，CPU 会飙升
function sleep(d){
  for(var t = Date.now();Date.now() - t <= d;);
}
sleep(5000); //当前方法暂停5秒



第二种:  setInterval 方式实现
var i = 0;
var test = setInterval(function(){
    console.log(i);
    i++;
    if(i == 5){
        clearInterval(test);
    }
}, 1200)



```
</details>

















<details>
<summary><b>返回上一页 / 刷新当前页面 </b></summary>

```  
document.getElementById("span1").onclick = function (ev) {
    window.history.go(-1);
}

或者:
    history.go(-1);


刷新当前页面
location.reload(); 


```
</details>















<details>
<summary><b>localStorage</b></summary>

```  
存   localStorage.setItem('myCat', 'Tom');     两个参数(必填项), key - value 形式存在
取   localStorage.getItem('myCat');            获取key对应的value
删   localStorage.removeItem('myCat');         
清空 localStorage.clear();

localStorage.length          获取localStorage一共有多少条数据

localStorage.key(3)          索引(index)为3的 key 的值  (只能获取 key 的值, 得不到 value 的值) 
                             初始值为localStorage.key(0)

localStorage.value(3);       没有这种用法

第三个是否包含 apple 这个字符串(返回布尔类型):
localStorage.key(5).includes("apple") === true

遍历:
    for (var i = 0; i < localStorage.length; i++) {
        
    }
    
```
</details>

















<details>
<summary><b>播放音频文件 mp3 Audio文件</b></summary>

```  
            // 创建一个 audio 节点
        var childNode = document.createElement('audio');
        childNode.setAttribute('controls', '');
        childNode.setAttribute('id', 'TTS_audios');
        childNode.innerHTML = '<source src="https://fanyi.so.com/audio?from=en&to=zh&voice=5&cate=uk-speech&key=93f725a07423fe1c889f448b33d21f46&query=java">';
        document.getElementsByTagName('body')[0].appendChild(childNode);
        
        // Ee.paused;   // 是否暂停
        audio.remove(); // 移除这个播放框

        var myAuto = document.getElementById("TTS_audios");
        myAuto.play();     // 播放它

        var audio = document.getElementById("TTS_audios");
        audio.loop = false;

        // 判断是否播放完毕
        audio.addEventListener('ended', function () {
            console.log("=====   播放完毕...   ============");
            audio.remove();
        }, console.log("还在播放...")  ,  false );


        

        方式二:  更加简洁快速
        var url = "http://www.joereddington.com/testsound/hope.wav?cb=" + new Date().getTime();
        var audio = new Audio(url);
        audio.load();
        audio.play(); 

        示例:
            播放英语音频 (有道单词发音接口):
                var url = "http://dict.youdao.com/dictvoice?audio=hello";
                var audio = new Audio(url);
                audio.load();
                audio.play(); 


```
</details>





























<details>
<summary><b>每隔一段时间执行某个 function setInterval setTimeout</b></summary>

```  
区别:
setTimeout(function, time)，延时一段时间后执行function，只执行一次；
setInterval(function, time)，以time为时间间隔，反复执行 function

setInterval(function(){
    console.log("hello  world   ");
}, 1000);

setInterval(say_hello , 900);

function say_hello(){
    console.log("say_hello  YXB ^_^  ");
}


Q: 如何让 setInterval 刚加载就执行？  https://segmentfault.com/q/1010000008206368
function runThis () {
    //这个是要执行的内容
}
var interval;
//先执行一次，然后再设置5秒执行一次
runThis();
clearInterval(interval);
interval = setInterval(runThis, 5000);
```
</details>





<details>
<summary><b>匿名函数 闭包 </b></summary>

```  
终于可以不用为函数起什么名字烦恼了 (以减少全局变量的使用)

带参数:
(function(x, y) {
    alert(x + y);
})(2,3);

不带参数:
(function() {
    alert(123);
})();

例子:
<button onclick="(function(){
    aaa();   // 调用 aaa 函数
    function aaa() {
      alert(123123);
    }
})()" > start  </button>

<h1 style="font-size: 150px; font-weight: bolder;" onclick="(function(e){
    e.innerHTML = 123;
})(this)">miss</h1>

```
</details>

















<details>
<summary><b> JavaScript键盘鼠标之: 键盘 </b></summary>

```  



console出键盘的对应的键盘代号:
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
</body>
<script>
  document.onkeydown = function (e) {
    var keycode = e.which;   //取得对应的键值（数字）
    var realkey = String.fromCharCode(e.which); //取得代表改键的真正字符
    console.log("按键码: " + keycode + " 字符: " + realkey);
  }
</script>
</html>






资料来源:     https://www.cnblogs.com/youyoui/p/10381457.html
按下 => 显示
松开 => 隐藏

        // 键盘按下时触发
        document.onkeydown = function (event) {
            // console.log('key down');
        };

        // 键盘按住时触发
        document.onkeypress = function (event) {
            console.log('key press');
            console.log(event.key);
            console.log(event.code);
            console.log(event.keyCode);
            document.getElementById("test").style.display = "block";
        };

        // 键盘弹起时触发
        document.onkeyup = function (event) {
            console.log('key up');
            document.getElementById("test").style.display = "none";
        };

         <h1 id="test" style="display: none;">aAAAAAAAAAAAAA</h1>




注意:
    大小写的字母的按键码是不同的
    按键码: 82 字符: R
    按键码: 114 字符: r

    推荐使用 onkeydown , 不要使用 onkeypress
        因为 onkeydown 可以捕捉到 按下 Ctrl 键的反应
        onkeypress 就捕捉不到

// 键盘事件
// 推荐使用 onkeydown
document.onkeydown = function(e) {
    var keycode = e.which;   //取得对应的键值（数字）
    var realkey = String.fromCharCode(e.which); //取得代表改键的真正字符
    console.log("按键码: " + keycode + " 字符: " + realkey);
    if (keycode === 82){
        alert("你按下了 R ...")
    }
}


// 键盘事件 方式二
// 不推荐使用 onkeypress
document.onkeypress = function (event) {
    var keycode = event.which;   //取得对应的键值（数字）
    var realkey = String.fromCharCode(event.which); //取得代表改键的真正字符
    console.log("按键码: " + keycode + " 字符: " + realkey);
};





    按住 -> 显示
    松开 -> 隐藏

// 键盘空格键 按住时触发 ( 键盘是 32 )
document.onkeypress = function (event) {
    var keycode = event.which;   //取得对应的键值（数字）
    var realkey = String.fromCharCode(event.which); //取得代表改键的真正字符
    // alert("按键码: " + keycode + " 字符: " + realkey);
    if (keycode === 32){
        document.getElementById("phrase").style.display = "block";
        document.getElementById("chinese_meaning").style.display = "block";
    }
};

// 键盘空格键 弹起时触发 ( 键盘是 32 )
document.onkeyup = function (event) {
    var keycode = event.which;   //取得对应的键值（数字）
    var realkey = String.fromCharCode(event.which); //取得代表改键的真正字符
    // alert("按键码: " + keycode + " 字符: " + realkey);
    if (keycode === 32){
        // console.log('key up');
        document.getElementById("phrase").style.display = "none";
        document.getElementById("chinese_meaning").style.display = "none";
    }
};




```
</details>





























<details>
<summary><b>JavaScript键盘鼠标之: 鼠标 </b></summary>

```  


屏蔽系统自带的右键菜单:
  window.onload = function () {
    //右键菜单
    document.oncontextmenu = function (event) {
      var event = event || window.event;
      console.log("鼠标系统自带右键菜单已经屏蔽...");
      alert("鼠标系统自带右键菜单已经屏蔽...");
      return false;             // 屏蔽系统自带的右键菜单
    }
  }




鼠标事件 (左键 / 右键 / 中键 ):
<div class="right">
    在这段文字区域鼠标右键/左键点击
</div>

<script>
window.onload = function(){
   var right = document.querySelector('.right');
   //去掉默认的contextmenu事件，否则会和右键事件同时出现。
   right.oncontextmenu = function(e){
       e.preventDefault();
   };

   right.onmousedown = function(e){
       if(e.button ==2){
           alert("你点了右键");
       }else if(e.button ==0){
           alert("你点了左键");
       }else if(e.button ==1){
           alert("你点了滚轮");
       }
   }
}
</script>





===========================================   鼠标 Demo   ===========================================
                           获取网页上选择的文字, 然后点击鼠标右键输出选择的文字:
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>

<body>
  <p>随便复制一段文字, 然后点击鼠标右键 , 打开控制台查看console.log();</p>
</body>
<script>
  function Select_Text() {
    var Select_txt;
    if (document.selection) {
      Select_txt = document.selection.createRange().text
    } else {
      Select_txt = window.getSelection() + '';
    }
    if (Select_txt) {
      return Select_txt;
    } else {
      return "没有选择任何文字... =_= ";
    }
  }


  window.onload = function () {
    //右键菜单
    document.oncontextmenu = function (event) {
      var event = event || window.event;
      // console.log("鼠标系统自带右键菜单已经屏蔽...");
      // alert("鼠标系统自带右键菜单已经屏蔽...");
      var Select_txt = Select_Text();
      alert(Select_txt);
      return false;             // 屏蔽系统自带的右键菜单
    }
  }
</script>
</html>












                                            单击选中文本, 自动弹出 ( 强烈推荐!! , 非常智能 ) 
<body>
  <p>随便复制一段文字, 然后点击鼠标右键 , 打开控制台查看console.log();</p>
  <h1>miss miss </h1>
</body>

<script>
  select(document, tanchu);
  /*=select[[ 
  * 跨浏览器选中文字事件 
  * object o 响应选中事件的DOM对象，required 
  * function fn(sText,target,mouseP)选中文字非空时的回调函数，required 
  * |-@param 
  * |-sText 选中的文字内容 
  * |-target 触发mouseup事件的元素 
  * |-mouseP 触发mouseup事件时鼠标坐标 
  */
  function select(o, fn) {
    o.onmouseup = function (e) {
      var event = window.event || e;
      var target = event.srcElement ? event.srcElement : event.target;
      if (/input|textarea/i.test(target.tagName) && /firefox/i.test(navigator.userAgent)) {
        //Firefox在文本框内选择文字 
        var staIndex = target.selectionStart;
        var endIndex = target.selectionEnd;
        if (staIndex != endIndex) {
          var sText = target.value.substring(staIndex, endIndex);
          fn(sText, target);
        }
      }
      else {
        //获取选中文字 
        var sText = document.selection == undefined ? document.getSelection().toString() : document.selection.createRange().text;
        if (sText != "") {
          //将参数传入回调函数fn 
          fn(sText, target);
        }
      }
    }
  }
  /*]]select=*/
  function tanchu(txt, tar) {
    alert("文字属于" + tar.tagName + "元素，选中内容为：" + txt);
  }
</script>








                                            右键自定义菜单 Demo : 

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title></title>
  <script src="https://s1.pstatp.com/cdn/expire-1-M/jquery/2.1.4/jquery.min.js" type="application/javascript"></script>
  <script src="http://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script>
  <script src="https://s0.pstatp.com/cdn/expire-1-M/vue/2.6.10/vue.min.js" type="application/javascript"></script>
  <link href="https://s2.pstatp.com/cdn/expire-1-M/twitter-bootstrap/3.4.0/css/bootstrap.min.css" type="text/css"
    rel="stylesheet" />
  <script src="https://s1.pstatp.com/cdn/expire-1-M/twitter-bootstrap/3.4.0/js/bootstrap.min.js"
    type="application/javascript"></script>
</head>
<style type="text/css">
  * {
    margin: 0;
    padding: 0;
  }

  .menu {
    width: 100px;
    border: 1px solid #ccc;
    position: absolute;
    box-shadow: 0 0 5px rgba(0, 0, 0, .2);
    padding: 10px 0;
    transition: all .1s ease;
  }

  .menu li {
    list-style: none;
    width: 100%;
  }

  .menu li a {
    display: inline-block;
    text-decoration: none;
    color: #555;
    width: 100%;
    padding: 10px 0;
    text-align: center;
  }

  .menu li:first-of-type {
    border-radius: 5px 5px 0 0;
  }

  .menu li a:hover,
  .menu li a:active {
    background: #eee;
    color: #0AAF88;
  }
</style>

<body>
  <ul class="menu" id="menu">
    <li><a href="###">复制</a></li>
    <li><a href="###">粘贴</a></li>
    <li><a href="###">剪切</a></li>
    <li><a href="###">刷新</a></li>
  </ul>
</body>
<script>
  window.onload = function () {

    //获取可视区宽度
    var winWidth = function () {
      return document.documentElement.clientWidth || document.body.clientWidth;
    }
    //获取可视区高度
    var winHeight = function () {
      return document.documentElement.clientHeight || document.body.clientHeight;
    }

    var menu = document.getElementById('menu');
    menu.style.display = 'none';

    document.addEventListener('click', function () {
      menu.style.display = 'none';
    })

    menu.addEventListener('click', function (event) {
      var event = event || window.event;
      event.cancelBubble = true;
    })
    
    //右键菜单
    document.oncontextmenu = function (event) {
      var event = event || window.event;
      menu.style.display = 'block';
      var l, t;
      l = event.clientX;
      t = event.clientY;
      if (l >= (winWidth() - menu.offsetWidth)) {
        l = winWidth() - menu.offsetWidth;
      } else {
        l = l
      }
      if (t > winHeight() - menu.offsetHeight) {
        t = winHeight() - menu.offsetHeight;
      } else {
        t = t;
      }
      menu.style.left = l + 'px';
      menu.style.top = t + 'px';

      console.log("鼠标系统自带右键菜单已经屏蔽...");
      return false;              // 屏蔽系统自带的右键菜单
    }
  }
</script>
</html>





```
</details>



















































<details>
<summary><b> JavaScript 使用 Ajax  </b></summary>

```  

具体详见 另外一个 笔记:   0-前后端交互.MD


```
</details>
























<details>
<summary><b>当你要引入外部 js 文件时候,一定要把<script></script>放在body下面,</b></summary>

```  
<script  type="text/javascript"  src="../js/upload_title_and_code.js"></script>
../css/index.css 表示从根目录开始引入
```
</details>





<details>
<summary><b> JavaScript Format :</b></summary>

```  
var formData = new FormData();
var myfile = '123';
formData.append('username', myfile);  // 添加自定义数据
document.write(formData.get('username'))
```
</details>






<details>
<summary><b>禁止 chrome 自动翻译</b></summary>

```  
<html lang="zh-CN">
```
</details>






<details>
<summary><b>JavaScript:网页加载完,再去运行js代码:</b></summary>

```  
 <script type="text/javascript">
    window.onload = function(){
            alert(2233333);
    }
</script>
```
</details>





<details>
<summary><b>移动web禁止滑动 + 开启滑动</b></summary>

```  
    // 首先，建立一个函数
    function bodyScroll(event){
        event.preventDefault();
    }

    // 禁止页面滚动
    function stop_rolling(){
        document.body.addEventListener('touchmove',bodyScroll,false);
        document.body.style.position = 'fixed';
        document.body.style.width = '100%';
	}

    // 开启页面滚动
    function start_rolling(){
        document.body.removeEventListener('touchmove',bodyScroll,false);
        document.body.style.position = 'static';
        document.body.style.width = 'auto';
    }
```
</details>





<details>
<summary><b>JavaScript 在新标签页中打开链接URL</b></summary>

```  
window.open(url, '_blank').location; 
```
</details>




































<details>
<summary><b>日历 / 日期</b></summary>

```  

你可以通过  min 和 max 属性去限制用户的可选日期范围。
在随后的例子中，我们将设定日期最小值为 2017-04-01 最大值为 2017-04-30 
<form>
  <div>
    <label for="party">Choose your preferred party date:</label>
    <input type="date" id="party" name="party" min="2017-04-01" max="2017-04-30">
  </div>
</form>


<input id="date" type="date" onchange="fn()" value="" placeholder="取款日期填写今日往后三天的时间">
当日历发生变化时候, 获取当前选择的日期:
function fn() {
    var date = document.getElementById('date').value;
    console.log(date);
}    




可以使用 required 属性强制填写日期, 如果你尝试提交一个未填写日期的域那么将会抛出错误。 
至少在大多数浏览器是可以工作的
让我们看一个例子 — 我们设置了日期的最大和最小值, 并且设定为必填:

<form>
    <div style="font-size: 56px;">
        <label for="party">Choose your preferred party date (required, April 1st to 20th):</label>
        <input type="date" id="party" name="party" min="2017-04-01" max="2017-04-20" required>
        <span class="validity"></span>
    </div>
    <div>
        <input type="submit">
    </div>
</form>
点击提交时候, 后台 请求链接是:   SpringBoot/Desktop/TEST.html?party=2017-04-19






======================================================================================================





获取当前日期:
var d = new Date();
d.getFullYear();        // 年份: 2020 (当前是 xxx 年)


您可以使用名称数组，并使用 getMonth() 将月份作为名称返回：
    var d = new Date();
    d.getMonth();           // 月份: 2 () 在 JavaScript 中，第一个月（1 月）是月号 0，因此 12 月返回月号 11)
    var d = new Date();
    var months = 
                [
                "January", "February", "March", "April", "May", "June", 
                "July", "August", "September", "October", "November", "December"
                ];
    document.getElementById("demo").innerHTML = months[d.getMonth()];



var d = new Date();
d.getDate();            // xxx 号

var d = new Date();
d.getHours();           // 小时数 , 比如 14 就是下午 2 点

var d = new Date();
d.getMinutes();         // 分钟数 , 35分, 就是35分

var d = new Date();
d.getSeconds();         // 秒数

var d = new Date();
d.getMilliseconds();    // 毫秒数 


在 JavaScript 中，一周的第一天（0）表示“星期日”，即使世界上的一些国家认为周的第一天是“星期一”。
您可以使用名称数组，并使用 getDay() 将星期名作为名称返回：
    var d = new Date();
    d.getDay();             // 星期几

    var d = new Date();
    var days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    document.getElementById("demo").innerHTML = days[d.getDay()];



获取时间戳:
getTime() 方法返回自 1970 年 1 月 1 日以来的毫秒数：
    var d = new Date();
    d.getTime();





======================================================================================================

格式化日期
1、yyyy-MM-dd

 Date.prototype.Format = function (fmt) {
        var o = {
            "M+": this.getMonth() + 1, // 月份
            "d+": this.getDate(), // 日
            "h+": this.getHours(), // 小时
            "m+": this.getMinutes(), // 分
            "s+": this.getSeconds(), // 秒
            "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
            "S": this.getMilliseconds()
            // 毫秒
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
                .substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) :
                    (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }

    console.log(new Date().Format('yyyy-MM-dd hh:mm'));
    console.log(new Date().Format('yyyy-MM-dd'));  






======================================================================================================

显示时钟效果(动态效果)
首先新建一个 标签:
    <h1 id="date_now"></h1>

     function getMyDate() {
        var d = new Date();
        var mydiv = document.getElementById("date_now");
        mydiv.innerText = d.getFullYear() + "年" + (d.getMonth() + 1) + "月" + d.getDate() + "日" + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    }

    function getTime() {
        getMyDate();
        setInterval("getMyDate()", 1000);//每隔一秒调用一次
    }
    getTime();
大功告成~~








=====================================   日期排序   =============================================



    // 日期排序
    // 教程来源:  https://www.softwhy.com/article-7210-1.html

    var arr = ['2020-02-09', '2020-02-15', '2020-02-16', '2020-02-08'];
    console.log(arr);

    // 时间日期 从小到大排序   (代码是网上抄的, 从大到小暂时还不会)
    Array.prototype.small_to_big = function () {
        var arr2 = []           // 声明一个数组用来声明时间戳
        var json = {};
        for (var index = 0, len = this.length; index < len; index++) {
            json[new Date(this[index]).getTime()] = this[index];
            arr2.push(new Date(this[index]).getTime());     // 把时间戳压入数组。
        }
        arr2.sort();

        for (var j = 0; j < arr2.length; j++) {
            this[j] = json[arr2[j]];
        }
        return this;
    }
    console.log(arr.small_to_big())






```
</details>
* 参考资料:  https://segmentfault.com/a/1190000015381362














<details>
<summary><b>cookie 操作:</b></summary>

```  
JavaScript 遍历所有cookie:
    function get_all_cookies() {

        var aCookie = document.cookie.split(";");
        var re = '';
        for (var i = 0; i < aCookie.length; i++) {
            var aCrumb = aCookie[i].split("=");
            if (aCrumb[0].toString().trim() === 'order_list') {
                continue;
            }
            re += (aCrumb[0] + " = " + unescape(aCrumb[1]) + '\n');    /*   unescape  处理中文乱码问题             */
        }
        console.log(re);
    }
	
	
拿到cookie
    function getCookie(cookie_name) {
        if (document.cookie.length > 0) {
            c_start = document.cookie.indexOf(cookie_name + "=");
            if (c_start != -1) {
                c_start = c_start + cookie_name.length + 1;
                c_end = document.cookie.indexOf(";", c_start);
                if (c_end == -1) c_end = document.cookie.length;
                return unescape(document.cookie.substring(c_start, c_end))
            }
        }
        return ""
    }
	
	
	
	function save_into_cookies(cookie_name, value, expiredays) {
        var exdate = new Date();
        exdate.setDate(exdate.getDate() + expiredays);
        document.cookie = cookie_name + "=" + escape(value) + ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString())
    }

```
</details>









---
# 遇到的坑:
> 花了很长时间才解决的...
<details>
<summary><b>删除 array 的元素</b></summary>

```  
需求:
    删除数组AAA里面所有 bbb 有的元素:

    var AAA = ["irrigation", "project", "modernized", "production", "cancer", "treatment", "short", "break", "metals", "expand", "border", "with", "germany", "passengers", "and", "crew", "was", "a", "deliberate", "federal", "republic", "highly", "praised", "version", "of", "the", "accident", "consulted", "your", "lawyer", "individual", "tastes", "arrogant", "runner", "employment", "problems", "conceded", "defeat", "concern", "about", "changes", "wildlife", "conservation", "he", "consoled", "her", "flowers", "school", "cafeteria", "wide", "use", "reduce", "decay", "tutor", "at", "university", "verify", "theory", "attempt", "to", "embarrass", "research", "luxury", "cruise", "liner", "paperwork", "bureaucracy", "sheer", "number", "tourists", "justification", "for", "sacking", "estimate", "total", "math", "competition", "sport", "recreation", "gauge", "weight", "initial", "reaction", "wedding", "outfit"];
    
    var bbb = ["if", "and", "or", "there", "were", "on", "in", "be", "will", "at", "one", "twe", "of", "for", "to", "too", "about", "from", "with", "under", "into", "without", "over", "was", "the", "that", "not", "say", "see", "my", "you", "he", "her", "do", "other", "food", "it", "they", "many", "agree", "people", "get", "post", "hot", "a", "low", "your", "project", "number", "school", "sport", "version", "use"];




网上抄的删除函数:
    参数: 你要删除的元素
Array.prototype.remove = function (val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};

实现需求:
    嵌套循环遍历:
    for (var i = 0; i < AAA.length; i++) {
        for (var ii = 0; ii < bbb.length; ii++) {
            if (AAA[i] === bbb[ii]) {
                AAA.remove(AAA[i]);
            }
        }
    }
    console.log(AAA);    

这时候, 坑的地方来了, 多次测试发现, 总有一个元素删不干净, 其他的都可以删除干净, 刚好就一个删除不干净...
折腾了好几个小时, 
后来仔细一想, 
这个删除数组元素的函数, 原理是通过 索引index 来删除,
而我的嵌套循环删除了一个元素之后, 索引向后增加了一个, 
所以应该把索引减去一个,
所以嵌套循环应该这样写:

    for (var i = 0; i < AAA.length; i++) {
        for (var ii = 0; ii < bbb.length; ii++) {
            if (AAA[i] === bbb[ii]) {
                AAA.remove(AAA[i]);
                i--;
            }
        }
    }
    console.log(AAA);

折腾了几个小时, 真是伤脑筋......
无语...

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






