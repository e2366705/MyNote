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





遍历键值对:
前提是 result_json 也必须是键值对 hashmap
<div id="Article_content">
    <div  v-for="key , value in result_json">
        <h1>{{key}}</h1>
        <h1>{{value}}</h1>
    </div>
</div>

new Vue({
    el: '#Article_content',
    data: {
        result_json: result_json
    }
});







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
				site: "菜鸟教程",					// 可以是字符串
				url: "www.runoob.com",			   
				checkedNames: [],					// 可以是 array
				checked : true,						// 可以是 bool 布尔
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
		资料来源:   https://www.runoob.com/vue2/vue-class-style.html
v-bind 来设置样式属性 , 比如:
	class
	id
	href		<a v-bind:href="url">菜鸟教程</a>

	HTML 属性中的值应使用 v-bind 指令
			完整语法:
				<a v-bind:href="url"></a>
			缩写:
				<a :href="url"></a>

案例:
isActive 设置为 true 显示了一个绿色的 div 块，如果设置为 false 则不显示：
	.active {
		width: 100px;
		height: 100px;
		background: green;
	}
	div v-bind:class="{ active: isActive }"></div>
	data: {
		isActive: true
	}

											.text-danger {background: GREEN;}
<div class="static" v-bind:class="{ active: 'text-danger': true }"></div>	
<div class="static active text-danger"></div>			// 编译后的 div 的 class

 v-bind:style 直接设置样式:
	<div v-bind:style="{ color: activeColor, fontSize: fontSize + 'px' }">菜鸟教程</div>
	编译后:
	<div style="color: green; font-size: 30px;">菜鸟教程</div>

直接绑定到一个样式对象，让模板更清晰：
<div v-bind:style="styleObject">菜鸟教程</div>
data: {
    styleObject: {
      color: 'green',
      fontSize: '30px'
    }
}

















v-model:
	资料来源:   https://www.runoob.com/vue2/vue-forms.html
	v-model 指令用来在 input、select、textarea、checkbox、radio 等表单控件元素上创建双向数据绑定

案例 1
<p>{{ message }}</p>
<input v-model="message">
data: {
	message: 'Runoob'
}


案例 2
<input type="checkbox" id="checkbox" v-model="checked">
<label for="checkbox">{{ checked }}</label>
data: {
	checked : true
}


案例 3
 <select v-model="selected" name="fruit">
    <option value="">选择一个网站</option>
    <option value="www.runoob.com">Runoob</option>
    <option value="www.google.com">Google</option>
  </select>

   <div id="output">
      选择的网站是: {{selected}}
  </div>

   data: {
	selected: '' 
  }


.number
如果想自动将用户的输入值转为 Number 类型（如果原值的转换结果为 NaN 则返回原值），
可以添加一个修饰符 number 给 v-model 来处理输入值：

<input v-model.number="age" type="number">
这通常很有用，因为在 type="number" 时 HTML 中输入的值也总是会返回字符串类型。

.trim
如果要自动过滤用户输入的首尾空格，可以添加 trim 修饰符到 v-model 上过滤输入：
<input v-model.trim="msg">

















v-on:
	按钮的事件我们可以使用 v-on 监听事件，并对用户的输入进行响应
	<button v-on:click="reverseMessage">反转字符串</button>
	完整语法:
		<a v-on:click="doSomething"></a>
	缩写:
		<a @click="doSomething"></a>

案例:
<button v-on:click="counter += 1">增加 1</button>
<p>这个按钮被点击了 {{ counter }} 次。</p>	
data: {
    counter: 0
}	


<!-- greet 是在下面定义的方法名 -->
<button v-on:click="greet">Greet</button>
  data: {
    name: 'Vue.js'
  },
  // 在 `methods` 对象中定义方法
  methods: {
    greet: function (event) {
      // `this` 在方法里指当前 Vue 实例
      alert('Hello ' + this.name + '!')
      // `event` 是原生 DOM 事件
	  if (event) {
		  alert(event.target.tagName)
	  }
    }
  }


方法传值: 
<button v-on:click="say('hi')">Say hi</button>
<button v-on:click="say('what')">Say what</button>

  methods: {
    say: function (message) {
      alert(message)
    }
  }


<!-- 只有在 keyCode 是 13 时调用 vm.submit() -->
<input v-on:keyup.13="submit">

<!-- 同上 -->
<input v-on:keyup.enter="submit">









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





Vue.js 自定义指令
除了默认设置的核心指令( v-model 和 v-show ), Vue 也允许注册自定义指令
下面我们注册一个全局指令 v-focus, 该指令的功能是在页面加载时，元素获得焦点：
<div id="app">
    <p>页面载入时，input 元素自动获取焦点：</p>
    <input v-focus>
</div>

<script>
// 注册一个全局自定义指令 v-focus
Vue.directive('focus', {
  // 当绑定元素插入到 DOM 中。
  inserted: function (el) {
    // 聚焦元素
    el.focus()
  }
})
// 创建根实例
new Vue({
  el: '#app'
})
</script>

也可以在实例使用 directives 选项来注册局部指令，这样指令只能在这个实例中使用：
<div id="app">
  <p>页面载入时，input 元素自动获取焦点：</p>
  <input v-focus>
</div>
 
<script>
// 创建根实例
new Vue({
  el: '#app',
  directives: {
    // 注册一个局部的自定义指令 v-focus
    focus: {
      // 指令的定义
      inserted: function (el) {
        // 聚焦元素
        el.focus()
      }
    }
  }
})
</script>









```
</details>






















<details>
<summary><b>  键盘事件  </b></summary>

```  


<!-- 只有在 keyCode 是 13 时调用 vm.submit() -->
<input v-on:keyup.13="submit">


记住所有的 keyCode 比较困难，所以 Vue 为最常用的按键提供了别名：
<!-- 同上 -->
<input v-on:keyup.enter="submit">


全部的按键别名：
.enter
.tab
.delete (捕获 "删除" 和 "退格" 键)
.esc
.space
.up
.down
.left
.right
.ctrl
.alt
.shift
.meta
实例

<p><!-- Alt + C -->
<input @keyup.alt.67="clear">
<!-- Ctrl + Click -->
<div @click.ctrl="doSomething">Do something</div>





```
</details>



















































<details>
<summary><b> 组件 </b></summary>

```  

详细教程 : https://www.runoob.com/vue2/vue-component.html

组件（Component）是 Vue.js 最强大的功能之一
组件可以扩展 HTML 元素，封装可重用的代码

注册一个全局组件语法格式如下：
Vue.component(tagName, options)

tagName 为组件名，options 为配置选项。注册后，我们可以使用以下方式来调用组件：
<tagName></tagName>

注册一个简单的全局组件 runoob，并使用它：
	<div id="app">
		<runoob></runoob>
	</div>
	
	<script>
	// 注册
	Vue.component('runoob', {
	template: '<h1>自定义组件!</h1>'
	})
	// 创建根实例
	new Vue({
	el: '#app'
	})
	</script>











```
</details>




