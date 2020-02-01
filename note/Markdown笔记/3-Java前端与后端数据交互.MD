# 前端:
### html
```  
<input  class="btn btn-primary" ng-click="edit(row.id)" value="编辑" type="button" />
<input  class="btn btn-danger"  ng-click="del(row.id)" value="删除" type="button" />

```


# 注意: SpringBoot是不用自己去配置Tomcat的!!!
## 妈的, 我在2020-01-23这一天折腾了好几个小时, 死活配置不好Tomacat, 突然想起来SpringBoot是不用配置Tomcat的....

### js (angular)
```  
//删除 (服务器数据)
$scope.del = function(id) {
	$http({
		url : '/delete?id=' + id,
		method : 'POST',
	}).success(function(r) {
		//删除成功后移除数据
		$scope.remove(r.id);
	});
};

```


### 后台(java)
```  
@PostMapping("/delete")
public @ResponseBody Map<String, Object> delete(String id) {
	Map<String, Object> result = new HashMap<>();
	Dao.delete(id);
	result.put("id", id);
	return result;
}

```







# Ajax + springBoot + jquery :
## 前后端的相应代码应该是这样的:
### 前端
```  
    var params = {};                   //params.XX必须与Spring Mvc controller中的参数名称一致 , 否则在controller中使用@RequestParam绑定
    params.num = 111;
    params.id = 222;
    params.amount = 333;

    $.ajax({
        async:false,
        type: "POST",
        url: "/update",         // 路径
        data:params,
        dataType:"json",
        success:function(data){
            if(data.result === 'SUCCESS'){
                alert(data.result);
                params = data;                
            }else{
                alert("修改失败，失败原因【" + data + "】");
            }
        },
        error:function(data){
            alert(data.result);
        }
    });

    return params;
    
    需要把 data 赋值给 params, 再去返回值, 不然直接 return data 是没有作用的
	
```


### 后端
```  
    @RequestMapping("update")
    @ResponseBody           //此注解不能省略 否则ajax无法接受返回值
    public Map<String,Object> update(Long num, Long id, BigDecimal amount){

        System.err.println(num);
        System.err.println(id);
        System.err.println(amount);

        Map<String,Object> resultMap = new HashMap<String, Object>();

        if(num == null || amount == null){
            resultMap.put("result", "参数不合法！");
            return resultMap;
        }

        String result = "SUCCESS";
        resultMap.put("result", result);
        return resultMap;
    }

```



# 前后端数据交互
## 前端
```  
    <form action="/file/test3" method="GET">
        <input type="text" class="form-control" placeholder="Text input" name="username">
        <input class="btn btn-danger" type="submit" value="提交"/>
        <input type="reset" value="重置"/>
    </form>
    
```

## 后端
```  
@Controller
@RequestMapping(value="/file")
public class Article_list_Controller {

    @ResponseBody
    @RequestMapping(value="/test3",method=RequestMethod.GET)
    public String add(HttpServletRequest request, HttpServletResponse response){

        System.err.println("asdasdasdasdasdasdasdasdasdasdasdasdasdasda");

        System.err.println(request.getParameter("username"));

        return null;
    }

```

 


# 前端循环遍历后端传过来的数据
### 注意:  html文件记得加上:
```
<html xmlns:th="http://www.thymeleaf.org">
```

### 后端:
```
@Controller
@RequestMapping(value="/Article_list_Controller")
public class Article_list_Controller {

    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String index(Model model){
        ArrayList<String> all_files =  getFiles.Start(path);
        model.addAttribute("result" , all_files);
        return "English_Article_list";
    }

}

```

### 前端: 
```  
    <li th:each="result : ${result}">
        <h3><a target="_blank"  th:href="@{/English_Article_Controller/Read_Article/(file_name=${result})}"  th:text="${result}" style="color: #5FB878; "></a></h3>
        <!--<button class="btn" th:onlick="'getName(\''+${person.name}+'\');'">获得名字</button>-->
    </li>
```

### 前端 2
```  
 interStat  系统自带

<table>
    <tr th:each="user, interStat : ${result}">
        <td th:text="${interStat.index}"></td>
        <td th:text="${user.id}"></td>
        <td th:text="${user.name}"></td>
        <td th:text="${user.phone}"></td>
    </tr>
</table>

```

### JavaScript 取值
```  
<script th:inline="javascript">
    var message = [[${result}]];
    console.log(result);
</script>

注：script标签中 th:inline 一定不能少，通常在取值的前后会加上不同的注释

```

### 后端 + 前端
```  
@GetMapping("/message")
public String getMessage(Model model){
    model.addAttribute("message","This is your message");
    return "index";
}

<p th:text="#{message}">default message</p>

```

































