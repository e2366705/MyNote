# Vue
> 一种简单好用的前端框架
---






# 基本:
<details>
<summary><b> 基础  </b></summary>

```  


循环遍历 + a 标签 href 改变
如何在a标签的href中传入需要的参数?

<ul class="dropdown-menu" id="app">
    <li v-for="date_list in date_list">
        <a :href = "get_date_Href(date_list)" >{{ date_list }}</a>
    </li>
</ul>

new Vue({
    el: '#app',
    data: {
        date_list: date_list
    },
    methods:{
        get_date_Href:function(val){
            return '/Phrase_Controller/index?Date='+val
        }
    }
})




data 用于定义属性
methods 用于定义的函数，可以通过 return 来返回函数值
{{ }} 用于输出对象属性和函数返回值
{{xxx}}             表示取值
{{details()}}       调用方法


	<div id="vue_det">
		<h1>site : {{site}}</h1>
		<h1>url : {{url}}</h1>
		<h1>{{details()}}</h1>
	</div>

	<script type="text/javascript">
		var vm = new Vue({
			el: '#vue_det',
			data: {
				site: "菜鸟教程",
				url: "www.runoob.com"
			},
			methods: {
				details: function() {
					return  this.site + " - 学的不仅是技术，更是梦想！";
				}
			}
		})
	</script>





Vue.js 模板语法

v-html:
	使用 v-html 指令用于输出 html 代码：
	<div id="app">
		<div v-html="message"></div>
	</div>
	<script>
	new Vue({
	el: '#app',
	data: {
		message: '<h1>菜鸟教程</h1>'
	}
	})
	</script>


v-bind:
	HTML 属性中的值应使用 v-bind 指令
			完整语法:
				<a v-bind:href="url"></a>
			缩写:
				<a :href="url"></a>
		比如:
			class
			id
			href		<a v-bind:href="url">菜鸟教程</a>


v-model:
	v-model 指令用来在 input、select、textarea、checkbox、radio 等表单控件元素上创建双向数据绑定
	<p>{{ message }}</p>
	<input v-model="message">


v-on:
	按钮的事件我们可以使用 v-on 监听事件，并对用户的输入进行响应
	<button v-on:click="reverseMessage">反转字符串</button>
	完整语法:
		<a v-on:click="doSomething"></a>
	缩写:
		<a @click="doSomething"></a>



v-if  v-else  :
	指令是带有 v- 前缀的特殊属性
		指令用于在表达式的值改变时，将某些行为应用到 DOM 上。如下例子：
	<div id="app">
		<p v-if="seen">现在你看到我了</p>
	</div>
	data: {
		seen: true
	}

	随机生成一个数字，判断是否大于0.5，然后输出对应信息
		<div v-if="Math.random() > 0.5">
			Sorry
		</div>
		<div v-else>
			Not sorry
		</div>

	v-else-if 在 2.1.0 新增，顾名思义，用作 v-if 的 else-if 块。可以链式的多次使用
	<div v-else-if="type === 'B'">
      B
    </div>
    

v-show 
	指令来根据条件展示元素
	<h1 v-show="ok">Hello!</h1>
	data: {
    	ok: true
  	}




循环 / 遍历:
v-for:
 	<li v-for="site in sites">
      {{ site.name }}
    </li>
	sites: [
      { name: 'Runoob' },
      { name: 'Google' },
      { name: 'Taobao' }
    ]

	<li v-for="value in object">
    	{{ value }}
    </li>
	object: {
    	name: '菜鸟教程',
      	url: 'http://www.runoob.com',
      	slogan: '学的不仅是技术，更是梦想！'
    }

	键值对:
	<li v-for="(value, key) in object">
    	{{ key }} : {{ value }}
    </li>

	键值对(带上索引):
	<li v-for="(value, key, index) in object">
    	{{ index }}. {{ key }} : {{ value }}
    </li>



Vue.js 监听属性
	 监听属性 watch，我们可以通过 watch 来响应数据的变化
	<p style = "font-size:25px;">计数器: {{ counter }}</p>
	<button @click = "counter++" style = "font-size:25px;">点我</button>
	
	data: {
       counter: 1
    }

	vm.$watch('counter', function(nval, oval) {
		alert('计数器值的变化 :' + oval + ' 变为 ' + nval + '!');
	});









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








