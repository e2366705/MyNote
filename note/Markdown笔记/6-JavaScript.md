# JavaScript 

### chrome F12 可以直接调试小代码片段 很方便

#### 移动端页面开发的两种方式   https://www.cnblogs.com/jasmine-95/p/7235186.html
#### JavaScript 实战小项目   https://github.com/visugar/FrontEnd-examples




```



DOM 操作 




```
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
<summary><b> 给 CSS设置样式表( 两种方式):</b></summary>

```  
document.getElementById("kkk").style.cssText = " background-color:pink; width: 100px; height: 100px; ";
document.getElementsByClassName('div2')[0].style.background = 'pink';
```
</details>




<details>
<summary><b>动态改变DOM节点属性 (使用模板会更加好):</b></summary>

```  
<a href="#" target="_self" id="test">测试</a>
document.getElementById("test").attributes["target"].nodeValue="_blank";

JavaScript DOM setAttribute() 方法:
document.getElementsByTagName("INPUT")[0].setAttribute("type","button");

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
<summary><b>遍历节点元素,并且绑定点击事件</b></summary>

```  
var list=document.getElementsByClassName('li_new');
for(var i in list){
	list[i].onmouseover=grayBack;
	list[i].onmouseout=noGrayBack;
```
</details>






<details>
<summary><b>设置自定义属性:</b></summary>

```  
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
<summary><b>click / onclick</b></summary>

```  
document.getElementsByClassName('btn-default')[0].click();
document.getElementsByClassName('btn-default')[0].onclick() = function(){ ...... };
click()---->单纯的点击,比如某个按钮
onclick---->绑定点击事件
```
</details>





<details>
<summary><b>onclick 和 addEventListener 的区别:</b></summary>

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
</details>







<details>
<summary><b>给每个class添加(绑定) 事件</b></summary>

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
</details>







<details>
<summary><b>给class绑定事件一定要加上[0]</b></summary>

```  
 document.getElementsByClassName('btnn')[0].onclick = function() {
 	alert('btnnnnn');
 }
```
</details>





<details>
<summary><b>获取 点击的节点 的属性 ( this target e)</b></summary>

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
</details>






<details>
<summary><b>中绑定click事件的四种方式介绍:</b></summary>

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
















































```  



          字符串操作: 
          https://www.runoob.com/jsref/jsref-obj-string.html


          
```
<details>
<summary><b>字符串 操作:</b></summary>

```  
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
    
    var str="How are you doing today?";
    var n=str.split(" ");

    // 分割完可能会出现这种情况...
    var arr = ['','','',1,2,3,4,5,'','',''];
    for(var i = 0; i < arr.length; i++){
        if(arr[i] === ''){
            arr.splice(i,1);
            i = i-1;
        }
    }
    console.log(arr);
```
</details>














































# 集合对象(Array、Map、Set):
<details>
<summary><b>About Array </b></summary>

```  
添加:
fruits.push('Mango');

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







































































```


            Others:



```
<details>
<summary><b>新窗口打开  /  原窗口打开</b></summary>

```  
<a href="链接的页面" target="_blank">新窗口打开</a>
<a href="链接的页面" target="_parent">原窗口打开</a>
```
</details>










<details>
<summary><b>刷新这个页面</b></summary>

```  
location.reload(); 
```
</details>





<details>
<summary><b>睡眠 / 暂停</b></summary>

```  
function sleep(d){
  for(var t = Date.now();Date.now() - t <= d;);
}
sleep(5000); //当前方法暂停5秒
```
</details>





<details>
<summary><b>返回上一页:</b></summary>

```  
document.getElementById("span1").onclick = function (ev) {
    window.history.go(-1);
}

或者:
    history.go(-1);
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
localStorage.key(3)          索引(index)为3的 key 的值
localStorage.value(3);       没有这种用法

第三个是否包含 apple 这个字符串(返回布尔类型):
localStorage.key(5).includes("apple") === true

遍历:
    for (var i = 0; i < localStorage.length; i++) {
        
    }
    
```
</details>







<details>
<summary><b>JavaScript 播放音频文件 mp3 Audio文件</b></summary>

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
<summary><b>JavaScript 匿名函数 闭包 </b></summary>

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
<summary><b>键盘事件: 按下 / 松开</b></summary>

```  
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









// 键盘事件: 按下回车的时触发事件
document.onkeydown = function(e) {
    var keycode = e.which;   //取得对应的键值（数字）
    var realkey = String.fromCharCode(e.which); //取得代表改键的真正字符
    alert("按键码: " + keycode + " 字符: " + realkey);
    if (keycode === 82){
        alert("你按下了 R ...")
    }
}







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
<summary><b>用JavaScript 将后台返回的string数据,解析成JSON数据:</b></summary>

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






