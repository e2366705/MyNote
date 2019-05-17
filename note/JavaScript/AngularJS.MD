
# - - - - - - - - - - AngularJS 教程  - - - - - - - - - -


# 下载 / 安装 / 配置 angular:
```  

ng new xxxxx --skip-install       [ng new router-yxb --routing  (带一个路由器)]
cd .\xxxxx 
cnpm install  ( 注意: 有可能会install失败, 这时候把火绒安全/360卫士关掉 既可以了 )
ng serve
	(指定端口号 )
ng serve --port 4201



// 新建一个.....组件????
ng g component test003



// 新建一个 service ( -m 意思是: 把我们新建的这个service 注册到 app.module里面去 , 因为service默认不注册 )
ng g service test_service -m app.module



坑: 必须要有空格 
  test() {
    console.log('qq');
  }


  
  		下载 jquery
cnpm install jquery --save
		angular.js默认是 Typescript, 所以不认识jquery的 $ 符号, 要下载这个依赖, 才可以不报错
cnpm install @types/jquery --save-dev
		记得重启服务器


		下载 bootstrap
cnpm install bootstrap --save
		同理 Typescript 不认识 bootstrap 需要下载这个
cnpm install @types/bootstrap --save-dev
		记得重启服务器


angular.json文件引入:
      "scripts": [
              "../node_modules/jquery/dist/jquery.js",
              "../node_modules/bootstrap/dist/js/bootstrap.js"
            ],

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
引入指定版本的依赖cmd指令：
cnpm install jquery@3.1.1 --save
cnpm install bootstrap@3.3.7 --save	


图片在线生成
<img class="slide-image" src="http://placehold.it/800x300" >



```



