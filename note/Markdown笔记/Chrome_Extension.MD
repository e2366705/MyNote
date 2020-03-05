# Chrome Extension 
* 谷歌浏览器的插件编写

首先 : 
    新建一个文件夹, 名称随便取, 假设 文件夹为 TEST
    然后新建 manifest.json 文件, 这是入口文件(名称必须是manifest.json)
    然后 在Chrome浏览器打开 chrome://extensions/ , 打开开发者模式
    点击 `加载已解压的扩展程序` 
    选择 TEST 文件夹


manifest.json :
```  
{
    "name": "Getting Started Example",
    "version": "1.0",
    "description": "Build an Extension!",
    "manifest_version": 2,
    "content_scripts": [{
            "matches": ["https://*/*"],
            "js": ["contentScript.js"]
        }
    ]
}

```


contentScript.js:
```  
console.log("hello , my first chrome Extension....");

```


