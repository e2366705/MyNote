# Ajax / jQuery / PHP
## JavaScript - 前端
```  
function edit_this_file(ev) {

      $.ajax({
          type: 'post',
          url: 'includes\\PHP_file\\Ajax\\Get_html_content.php',
          data: {name: 123, address: 589},        // -> 传入数据
          dataType: 'json',
          success: function (data) {
              if (data.status === 0) {
                  alert(data.msg);
              } else {
                  alert(data.msg);
              }
          },
          error: function () {
              alert("程序异常");
          }
      });
  }

```


## PHP - 后端
### 前端 Ajax使用  dataType: 'json',  那么后端硬顶要用 json_encode
```  

//   POST请求
$html_file_name = $_POST['html_file_name'];


//判断传过来的name是否为空来判断
if(!empty($_POST['name'])){
    $value = array("status"=>"1","msg"=>"保存成功");
    echo json_encode($value);
}
else {
    $value = array("status"=>"0","msg"=>"保存失败");
    echo json_encode($value);
}

```

