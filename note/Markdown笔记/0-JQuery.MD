# jQuery
---

### jQuery Templates plugin
> 定义好 html 模版，然后使用这个插件在对应的模版中填充数据
* GitHub 地址:   https://github.com/BorisMoore/jquery-tmpl
* 资料:          https://www.cnblogs.com/think8848/archive/2011/07/17/2108570.html
<details>
<summary><b>基本用法:</b></summary>

```  

    html 头部文件 引入 :
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script>



	<div id="movieList"></div>
	
	    var markup = "<li>${Name} --- ${ReleaseYear}</li>";
	
	    $.template("movieTemplate", markup);
	
	    $.ajax({
	        dataType: "jsonp",
	        url: moviesServiceUrl,
	        jsonp: "$callback",
	        success: showMovies
	    });
	
	    function showMovies(data) {
	        $.tmpl("movieTemplate", data).appendTo("#movieList");
	    }



=====================================================================================================


html:
    <div id="movieList"></div>

JavaScript:    
    var movies = [
        { Name: "The Red Violin", ReleaseYear: "1998" },
        { Name: "Eyes Wide Shut", ReleaseYear: "1999" },
        { Name: "The Inheritance", ReleaseYear: "1976" }
    ];

    var markup = "<li>${Name} --  ${ReleaseYear}</li>";
    $.template("movieTemplate", markup);
    $.tmpl("movieTemplate", movies).appendTo("#movieList");

页面 html 输出:
    The Red Violin -- 1998
    Eyes Wide Shut -- 1999
    The Inheritance -- 1976    




这种情况怎么搞???  一维数组...
怎么依次取值遍历?
     var movies =  ["2020-02-10", "2020-02-08", "2020-02-09"]
     var markup = "<li>???</li>";

    $.template("movieTemplate", markup);
    $.tmpl("movieTemplate", movies).appendTo("#movieList");





        
    var  phrase= [
        { Number: "0" ,  phrase: "phrase", chinese_meaning: "中文意思" }
    ];

    for (var i = 1; i < localStorage.length; i++) {
        phrase.push({ "Number": i , "phrase" : localStorage.key(i) ,  "chinese_meaning": localStorage.getItem(localStorage.key(i))});
    }

    var markup =  "<tr><td>${Number}</td><td>${phrase}</td><td> ${chinese_meaning}</td></tr>";

    $.template("movieTemplate", markup);

    $.tmpl("movieTemplate", phrase).appendTo("#table");           // 添加到 id = 'table' 的节点上

        

=====================================================================================================        
        


        <div id="div_template1"></div>
        <script id="template1" type="text/x-jquery-tmpl">
            <a href="${Link}" target="_blank">${Text}</a>
        </script>

        <ul id="div_template2"></ul>
        <script id="template2" type="text/x-jquery-tmpl">
            <li>${ID}.<span>${Name}</span></li>
        </script>
            


        <script type="text/javascript">
            $(function () {
                var link = { Text: '京东', Link: 'http://www.jd.com/' };
                var users = [{ ID: '1', Name: 'xishuai1' }, { ID: '2', Name: 'Jack' }, { ID: '3', Name: '小明' }];

                $('#template1').tmpl(link).appendTo('#div_template1');
                $('#template2').tmpl(users).appendTo('#div_template2');
            });
        </script>




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







