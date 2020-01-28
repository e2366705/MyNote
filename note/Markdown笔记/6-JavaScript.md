#  移动端页面开发的两种方式   https://www.cnblogs.com/jasmine-95/p/7235186.html

# 新窗口打开  /  原窗口打开
```  
<a href="链接的页面" target="_blank">新窗口打开</a>
<a href="链接的页面" target="_parent">原窗口打开</a>

```
# JavaScript 实战小项目   https://github.com/visugar/FrontEnd-examples


# 刷新这个页面
```  
 location.reload();                     //   刷新这个页面

```






# 睡眠 暂停 :
```  
 function sleep(d){
  for(var t = Date.now();Date.now() - t <= d;);
}
sleep(5000); //当前方法暂停5秒

```


# JavaScript 返回上一页:
```  
document.getElementById("span1").onclick = function (ev) {
    window.history.go(-1);
}

或者:
    history.go(-1);

```


 
# JavaScript 给 CSS设置样式表( 两种方式):
```  
document.getElementById("kkk").style.cssText = " background-color:pink; width: 100px; height: 100px; ";
document.getElementsByClassName('div2')[0].style.background = 'pink';

```


  
# JavaScript获取body节点
```  
比如 : document.body.style.background

```



# JavaScript 新增一个节点
```  
    window.onload = function() {
        var childNode = document.createElement('p');
        childNode.innerHTML = '<h1>这里是提示信息〜〜</h1>';

        //childNode.setAttribute('class', 'alerts');
        //childNode.setAttribute('onclick', 'this.style.display = "none"');
        childNode.className = 'alerts';
        childNode.onclick = function () {
            this.style.display = 'none';
        };
        document.getElementsByTagName('body')[0].appendChild(childNode);
    };
```

# JavaScript 播放音频文件 mp3 Audio文件
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

```




# JavaScript 匿名函数 闭包 
## 终于可以不用为函数起什么名字烦恼了 (以减少全局变量的使用)
```  

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




# JavaScript遍历节点元素,并且绑定点击事件
```  
var list=document.getElementsByClassName('li_new');
for(var i in list){
	list[i].onmouseover=grayBack;
	list[i].onmouseout=noGrayBack;
}

```

# 按下回车的时触发事件
```  
function keyDown(e) {

    var keycode = e.which;   //取得对应的键值（数字）

    var realkey = String.fromCharCode(e.which); //取得代表改键的真正字符

    alert("按键码: " + keycode + " 字符: " + realkey);

    if (keycode === 82){
        alert("你按下了 R ...")
    }
}

document.onkeydown = keyDown

```


# 使用JavaScript动态改变DOM节点属性 (使用模板会更加好):
```  
<a href="#" target="_self" id="test">测试</a>
document.getElementById("test").attributes["target"].nodeValue="_blank";

JavaScript DOM setAttribute() 方法:
document.getElementsByTagName("INPUT")[0].setAttribute("type","button");

```

# 用JavaScript 将后台返回的string数据,解析成JSON数据:
```  
var index_page_json_data = JSON.parse(xhr.responseText),
xhr.responseText ==> 是string类型
然后呢??
转换成json数据之后,怎么根据键(或者是值) 取出相对应的值(键)呢?
用:
index_page_json_data['2019_01_11_15_30_21']); ==> 根据键 取出 值
然后呢??
console.log(index_page_json_data);  ==> 输出: {2019_01_11_19_53_07: "自定义模版2333"}
然后...怎么遍历呢? [遍历json]
for (var key in index_page_json_data) {
	console.log(key + "==>" + index_page_json_data[key]);
}

```



# JavaScript 分割字符串:
```  
var str="How are you doing today?";
var n=str.split(" ");

```



# 当你要引入外部 js 文件时候,一定要把<script></script>放在body下面,
```  
<script  type="text/javascript"  src="../js/upload_title_and_code.js"></script>
../css/index.css 表示从根目录开始引入

```


# JavaScript Format :
```  
var formData = new FormData();
var myfile = '123';
formData.append('username', myfile);  // 添加自定义数据
document.write(formData.get('username'))

```



# JavaScript 高级
```  
JavaScript设置自定义属性:
   // 创建 a 标签 class='add_screenshots'
   var add_screenshots_a = document.createElement('a');  => 创建一个a标签
   add_screenshots_a.className = 'add_screenshots';  => 设置classname名字
   add_screenshots_a.innerHTML = '添加截图';
   add_screenshots_a.setAttribute("onclick", "dddd(this)");  => 动态绑定点击事件dddd(this)
	 
	 function dddd(thisss){
    console.log(thisss.innerHTML);  => 这个元素的 innerHTML
		console.log(thisss.previousSibling); => 这个节点元素的 上一个同类节点(object类型)
		console.log(thisss.previousSibling.innerHTML); =>上一个同类节点的 innerHTML
		console.log(thisss.getAttribute('class')); => 获取名为'class' 的属性值 (string类型)
}

```



# JavaScript获取元素的绝对位置(相对于父元素)
```  
var self = document.getElementById("eID");
var left = self.getBoundingClientRect().left + document.documentElement.scrollLeft;
var top = self.getBoundingClientRect().top + document.documentElement.scrollTop + self.offsetHeight;

```




# JavaScript 定位到某个位置:
```  
document.getElementById("hhh").onclick = function () {
	//scrollTo() 方法可把内容滚动到指定的坐标
	window.scrollTo(0, 10000);
}

```



# other
```  
获取 input 值是.value
赋值是.innerHTML
document.getElementById('title_input').value
document.getElementById('title_input').innerHTML

按照索引取值:
 console.log(document.getElementsByTagName('input').valueOf()[0].value);

```

# JavaScript 这两个方法是有区别的:
```  
document.getElementsByClassName('btn-default')[0].click();
document.getElementsByClassName('btn-default')[0].onclick() = function(){ ...... };
click()---->单纯的点击,比如某个按钮
onclick---->绑定点击事件

```


# onclick 和 addEventListener 的区别:
```  
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



# 给每个class添加(绑定) 事件
```  
var  obj_list = document.getElementsByClassName('button');

for (var i in obj_list){
    //注册第一个点击事件
    obj_list[i].addEventListener('click',function () {
        console.log('1111111111111')
    });
    //注册第二个点击事件
    obj_list[i].addEventListener("click",function(){
        console.log("-----------------------");
    });
}

```


# 禁止自动翻译
```  
<html lang="zh-CN"> ==>

```


# 给class绑定事件一定要加上[0]
```  
 document.getElementsByClassName('btnn')[0].onclick = function() {
 	alert('btnnnnn');
 }

```

# JavaScript:网页加载完,再去运行js代码:
```  
 <script type="text/javascript">
    window.onload = function(){
            alert(2233333);
    }
</script>

```


 #  一个html页面包含另外一个html页面:
 ```  
 window.onload = function() {
 	$('.asasas').load('a.html');
 }

 ```


 
# 移动web禁止滑动 + 开启滑动
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

 



# JavaScript 在新标签页中打开链接URL
```  
window.open(url, '_blank').location; 

```





# JavaScript 获取 点击的节点 的属性 ( this target e)
```  
    <h1 onclick="changetext(this)">点击文本!------111</h1>

    <h1 id="test001">点击文本!------222</h1>

    function changetext(ev) {
        ev.innerHTML = "Ooops!";
    }

    document.getElementById("test001").onclick = function(e){
        e.target.innerHTML = "222222222";
    }
```




# parse:解析
```  
JSON.stringify({a:10,b:30})     返回==> "{"a":10,"b":30}"
JSON.parse('{"a":10,"b":30}')   返回==> {a: 10, b: 30}

```


# Javascript中绑定click事件的四种方式介绍:
```  
一：HTML中添加onclick	
    <button id="vv" onclick="myfunction()" >哈哈</button>

二：JS中定义函数绑定事件	
    var funcc = function () {
      alert('我爱编程')
      }
    var aa = document.getElementById('vv')
    aa.onclick = funcc

三：直接定义函数与内容	
    document.getElementById('vv').onclick = function () {
      alert('hasssshhaa ')
      }

四：利用addEventListener	
    document.getElementById('vv').addEventListener('click',funcc);
    //或者：
    document.getElementById('vv').addEventListener('click',function () {
      alert('hahah')
      })

```





# tagName nodeName 区别:
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




# 区别:
```  
innerHTML  输出当前标签的文本内容，如果标签内有子标签，会连子标签本身和子标签内的文本内容一起输出
outerHTML  输出当前标签的本身和标签内的文本内容，如果有子标签，那么子标签本身和标签内的文本内容也将一起输出

innerText     只输出当前标签内的文本内容，如果标签内有子标签，那么也只输出子标签内的文本内容
outerText     只输出当前标签内的文本内容，如果标签内有子标签，那么也只输出子标签内的文本内容

ps:
    innerHTML是符合W3C标准的属性，
    而innerText只适用于IE浏览器，因此，尽可能地去使用innerHTML，而少用innerText，

```




# event对象中 target和currentTarget 属性的区别
```  
首先本质区别是：

    event.target返回触发事件的元素
    event.currentTarget返回绑定事件的元素

    event.currentTarget的作用是什么呢，我觉得他和this 的作用是差不多的，始终返回的是绑定事件的元素

```




# 获取当前第几个元素:
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



# 获得一个元素的高度值:
```  
注意:   querySelector只会选中第一个元素
document.querySelector(".slideshow").offsetHeight  

```


# 获取整个网页向上滚动了多少距离??
```  
console.log("向上滚动了   "+document.documentElement.scrollTop);

```


# JavaScript 高级测试:
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



# 移动端页面禁止网页滑动:
```  
var mo = function(e){
    e.preventDefault();
};
//直接默认不让滑动
stop();
    
//不允许页面滑动
function not_allow_slide(){
    document.body.style.overflow='hidden';
    document.addEventListener("touchmove",mo,false);
}

// 允许滑动
function allow_slide(){
    document.body.style.overflow='';//出现滚动条
    document.removeEventListener("touchmove",mo,false);
}

```






# cookie 操作:
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