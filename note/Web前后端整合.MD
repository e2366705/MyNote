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







Ajax:

# 前后端的相应代码应该是这样的:
### 前端
```  
$.ajax({
		type:"GET",
		url:"http://www.deardull.com:9090/getMySeat", //访问的链接
		dataType:"jsonp",  //数据格式设置为jsonp
		jsonp:"callback",  //Jquery生成验证参数的名称
		success:function(data){  //成功的回调函数
			alert(data);
		},
		error: function (e) {
			alert("error");
		}
	});

```


 
### 后端
```  
@ResponseBody
@RequestMapping("/getMySeat")
public String getMySeatSuccess(@RequestParam("callback") String callback){
	Gson gson=new Gson();
	Map<String,String> map=new HashMap<>();
	map.put("seat","1_2_06_12");
	logger.info(callback);
	return callback+"("+gson.toJson(map)+")";
}

```

 






































































































