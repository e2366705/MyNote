
# - - - - - - - - - - AngularJS 教程  - - - - - - - - - -


# 下载 / 安装 / 配置 angular:
```  

ng new xxxxx --skip-install       [ng new router-yxb --routing  (带一个路由器)]
cd .\xxxxx 

cnpm install  ( 注意: 有可能会install失败, 这时候把火绒安全/360卫士关掉 既可以了 )

ng serve
	(指定端口号 )
ng serve --port 4201


// 新建一个组件
ng g component test003

	
如果你还要早某个组件使用这个服务, 同样需要:
		import { XxxxxService } from '../xxxxx.service';
	然后 构造函数初始化:
		 constructor(public xxxxx:XxxxxService) { }
	就可以了
	

webstorm 打开 angular项目:
	先要 cnpm install 然后再去用webstorm打开


// 新建一个 service ( -m 意思是: 把我们新建的这个service 注册到 app.module里面去 , 因为service默认不注册 )
ng g service test_service -m app.module


如果多次install失败 可以尝试清除现有的安装缓存
npm cache clean --f
cnpm cache clean --f


卸载脚手架:
cnpm uninstall -g angular-cli
cnpm install -g @angular/cli@latest


// 终端清除历史消息 [windows端]
cls

// 终端清除历史消息 [macOS端]
clear


目前Angular CLI不支持删除组件的选项，您需要手动完成
    从app.module中删除每个组件的导入引用
    删除组件文件夹。
	
	
https://www.bilibili.com/video/av26814911?from=search&seid=116956447478051193
是学习新知识，尽量还是保持版本一致的好



图片在线生成
<img class="slide-image" src="http://placehold.it/800x300" >
```






# 基础:
```  
日期
public today:auy=new Date();

  构造函数:
  constructor() { 
    console.log(this.today);
  }
  
  
  
男 / 女   按钮切换
<input type="radio" value="1" name='sex' id="1" /> <span for='1'>man</span>
<input type="radio" value="2" name='sex' id="2"  /> <span for='2'>woman</span>


必须指定默认值:
public history_List:any[] = [];


推荐在这里面操作dom:
这个函数表示dom加载完成
ngAfterViewInit(): void {}

```



# 引入第三方库
```  
引入指定版本的依赖cmd指令：
cnpm install jquery@3.1.1 --save
cnpm install bootstrap@3.3.7 --save


cnpm install jquery --save
cnpm install bootstrap --save

-- angular.js默认是 Typescript, 所以不认识jquery的 $ 符号, 要下载这个依赖, 才可以不报错
cnpm install @types/jquery --save-dev

-- 同理不认识 bootstrap 需要下载这个
cnpm install @types/bootstrap --save-dev

-- 记得重启服务器

-- 然后 在你所需要用到jquery的组件里面, 声明
   declare var $   

angular6引入jquery的几种方式: https://blog.csdn.net/qq_43225030/article/details/83374721


注意:
	必须先引用jquery.min.js文件，然后再引用botstrap的js

-- 然后: 在 angular.json 的 scripts 中引入:
"styles": [
  "src/styles.less",
  "./node_modules/_bootstrap@4.0.0-alpha.6@bootstrap/dist/css/bootstrap.css"
],
"scripts": [
  "./node_modules/_jquery@3.4.1@jquery/dist/jquery.js",
  "./node_modules/_tether@1.4.6@tether/dist/js/tether.js",
  "./node_modules/_bootstrap@4.0.0-alpha.6@bootstrap/dist/js/bootstrap.js"
],	


```




# 快捷键:
```  

ngcli:
(click)="delete_history()"

```




# 绑定数据:
### xxxxx.cpmponent.ts
```  

export class Test001Component implements OnInit {

  public userinfo:object={
    username:"jack tom",
    age:23
  }
  
取值:
<h2>{{userinfo.username}}</h2>
  

```









# 绑定属性:
```  

xxxx.cpmponent.ts:
export class Test001Component implements OnInit {
public xxxxx:string='12312312312';

<div [title]='xxxxx'>
  div
</div>

```






# 解析html:
```  

public content:string="<h1>big words....<h1/>";

<span [innerHTML]='content'></span>

```




# 遍历数组
```  

public arr:any[]=['111','222','333'];



<ul>
  <li *ngFor="let item of arr">
    {{item}}
  </li>
</ul>

```


# 引入图片:
### 方式1:
```  

<img src="assets/img/1.JPG" alt="">


```
### 方式2:
```  

public img_src="http://attach.zhiyoo.com/forum/201902/27/1225427jegpzezfxjjf1f1.jpg";
<img [src]="img_src" alt="">


```



# 显示索引:
```  
  public list:any[]=[
    {
      "name":"tom"
    },
    {
      "name":"tom2"
    },
    {
      "name":"tom3"
    }
  ]
  
  
<ul>
  <li *ngFor="let item of list ; let key=index">
    {{key}}--------{{item.name}}
  </li>
</ul>

```




# 判断语句
```  
public flag:boolean=true;

<div *ngIf="flag">
  display.....
</div>

<div *ngIf="!flag">
  display = none;
</div>


<span *ngIf="key == 1" class="one">1111111111</span>
<span *ngIf="key == 2" class="two">1111111111</span>

```



# ngSwitch:
```  
public xxxxxx:number=1;     /* 1表示已经支付,   2表示已经发货   */ 

  <span [ngSwitch]="xxxxxx">
  <p *ngSwitchCase="1">
      表示已经支付
  </p>
  <p *ngSwitchCase="2">
      表示已经发货
  </p>
  <p *ngSwitchDefault>
    未知数.........
  </p>
  </span>

```


# ngClass
```  
public flag:boolean=false;


<div [ngClass]="{'red': flag , 'yellow':!flag}">
  font....color
</div>


<ul>
    <li *ngFor="let item of list ; let key=index" [ngClass]="{'red': key==0 , 'yellow': key==1}" >
      {{key}}--------{{item.name}}
    </li>
</ul>

```






# 操作CSS样式
```  
这里 red 也可以是一个变量 , 
	public colorrrr:string=blue;
	
<p [ngStyle]="{'color': 'red'}">color.....css....</p>

```









# 管道:
```  

public today:auy=new Date();

<h1>{{today | date:'yyyy-mm-dd hh:mm:ss'}}</h1>

```












# 事件 click:
```  
<button (click)="click_me()">点击我....</button>

  click_me(){
    alert('...................');
  }

```







# 表单事件
```  
<input type="text" (keydown)="keyDown_yxb($event)">


  keyDown_yxb(ev){
   console.log(ev.key);
   console.log(ev.keyCode);
   console.log(ev.target.value);
  }

```










# 双向数据绑定:
```  
第一步:
	在 app.module.tx 引入:  import { FormsModule } from '@angular/forms'

第二部: 
	在 @NgModule -> imports 里面声明这个模块, 不然没法使用:  
		 imports: [
			BrowserModule,
			FormsModule
		],
		
		

然后就可以使用了:
public keywords:string="这是默认值";
<input type="text" name="" id=""  [(ngModel)]="keywords" />
<h2>{{keywords}}</h2>




  public peopleinfo:any={
    username:'jack'
  }
<input type="text" [(ngModel)]="peopleinfo.username" />

{{peopleinfo | json}}   -> 使用管道


```












# angular 父子组件之间的通信:
```  

第一步:
	<app-head #head></app-head>
	父组件:
		import { Component, OnInit , ViewChild } from '@angular/core';
	
第二部:初始化
	@ViewChild('head') head:any;
	
第三部: 调用子组件的方法:
  ngAfterViewInit(): void {
	this.head.run();
  }

```













# 路由
### navbar.component.html
```
	<li><a [routerLink]="[ '/']">home</a></li>
	<li><a [routerLink]="[ '/user']">user</a></li>
```

### app.module.ts
```
import { RouterModule,Routes } from '@angular/router';

imports: [
	BrowserModule,
	RouterModule.forRoot(appRoutes)
],

const appRoutes:Routes = [
{path:"",component:HomeComponent},
{path:"user",component:UserComponent},
{path:"user/:id",component:UserDetailsComponent}
];

```

### app.component.html
```  
<app-navbar></app-navbar>
<router-outlet></router-outlet>

```













# 服务 service
####  app.module.ts
### 哪个组件需要用service , 就导入servcie , 并且一定要在构造函数初始化http对象
```  
xxx.component.ts初始化函数
constructor(public testService:TestService) { 
this.testService.getUsers().subscribe(users=>{
  // console.log(users);
  this.users = users;
})
}
```

#### 创建 service 服务
```
最好带上文件夹
ng g service xxxxxFolder/xxxxxName
ng g s service/user                 -> s 是简写

```

### 放入 app.module.ts
```
import { UserService } from './service/user.service';
providers: [UserService],
```


### 整体:
```  
import { Injectable } from '@angular/core';
import { HttpClient }    from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(public http:HttpClient) { }			--> 初始化 http 请求模块

	getUsers(){
		return this.http.get("http://jsonplaceholder.typicode.com/users");
	}

}

```












# app.module.ts
## 由这几部分组成
### 1.组件
```  
	import { UserComponent } from './user/user.component';
```

### 2.路由
```
	import { RouterModule,Routes } from '@angular/router';
```

### 3.Http请求模块
```  
	import { HttpClientModule }    from '@angular/common/http';
```

### 4.service 模块
```  
	import { TestService } from './service/test.service';
```


### 整体
```  
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';

import { RouterModule,Routes } from '@angular/router';

import { HttpClientModule }    from '@angular/common/http';
import { TestService } from './service/test.service';


const appRoutes:Routes = [				--> 路由
  {path:"",component:HomeComponent},
  {path:"user",component:UserComponent},
  {path:"user/:id",component:UserDetailsComponent}
];

@NgModule({
  declarations: [
    UserComponent,						--> 声明组件
    UserDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,					--> 导入模块
    RouterModule.forRoot(appRoutes)		--> 导入路由
  ],
  providers: [TestService],   			--> 提供 service
  bootstrap: [AppComponent]
})
export class AppModule { }

```












# 常用
```

app.module.ts 一般常用导入:
import { FormsModule } from "@angular/forms";
import { RouterModule,Routes } from '@angular/router';
import { HttpClientModule  } from '@angular/common/http';
import { HttpClient  } from '@angular/common/http';

```




# RESTful 风格 的请求:
```
// 1.获取所有用户信息
https://localhost:8080/users

// 2.获取id为1的用户信息
https://localhost:8080/users/1

// 3.获取公司所有信息
https://localhost:8080/companies

// 4.获取单个公司信息
https://localhost:8080/companies/1

// 5.获取所有公司 id=3 的用户
https://localhost:8080/companies/3/users

// 6.根据公司名称获取信息
https://localhost:8080/companies?name=Google

// 7.根据多个名称获取公司信息
https://localhost:8080/companies?name=Google&name=apple

// 一页中只有两条数据
https://localhost:8080/companies?_page=1&_limit=2

// 升序排序   desc降序
https://localhost:8080/companies?_sort=name&_order=asc

// 获取 年龄 30 及以上的
https://localhost:8080/users?age_gte=30

// 获取 年龄 30至40之间 
https://localhost:8080/users?age_gte=30&age_lte=40

```















