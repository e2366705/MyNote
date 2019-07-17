# 前端:
### html
```  
<input  class="btn btn-primary" ng-click="edit(row.id)" value="编辑" type="button" />
<input  class="btn btn-danger"  ng-click="del(row.id)" value="删除" type="button" />

```

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
            }else{
                alert("修改失败，失败原因【" + data + "】");
            }
        },
        error:function(data){
            alert(data.result);
        }
    });
	
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
说明  thymeleaf ： th:each="obj,stat:${objects}" 分别代表单个实例,状态(可省略),待遍历对象
<div th:each="user:${userList}">
    <input type="hidden" name="userId" th:value="${user.userId}"/>
    用户姓名：<input type="text" name="password" th:value="${user.username}"/>
    登录密码：<input type="text" name="username" th:value="${user.password}"/>
</div>

```


































