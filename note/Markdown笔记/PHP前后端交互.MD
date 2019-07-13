# Ajax / jQuery / PHP
## JavaScript 
```  
function edit_this_file(ev) {

      $.ajax({
          type: 'post',
          url: 'includes\\PHP_file\\Ajax\\Get_html_content.php',
          data: {name: 123, address: 589},
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


## PHP
```  

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

