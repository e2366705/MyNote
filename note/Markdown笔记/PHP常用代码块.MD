# 常用代码块



# PHP with IO:
```  
r	只读。在文件的开头开始。
r+	读/写。在文件的开头开始。
w	只写。打开并清空文件的内容；如果文件不存在，则创建新文件。
w+	读/写。打开并清空文件的内容；如果文件不存在，则创建新文件。
a	追加。打开并向文件末尾进行写操作，如果文件不存在，则创建新文件。
a+	读/追加。通过向文件末尾写内容，来保持文件内容。
x	只写。创建新文件。如果文件已存在，则返回 FALSE 和一个错误。
x+	读/写。创建新文件。如果文件已存在，则返回 FALSE 和一个错误。

```

## 写 - 追加模式 a
```  
$myfile = fopen("aaa.txt", "a") or die("Unable to open file!");
$txt = "Bill Gates\n";
fwrite($myfile, $txt);
fclose($myfile);

```



## 读
```  
r : 表示只读
$myfile = fopen("../TXT/aaa.txt", "r") or die("Unable to open file!");
// 输出单行直到 end-of-file
while(!feof($myfile)) {
    echo fgets($myfile);
}
fclose($myfile);

```



# PHP删除文件:
```  
$file = "aaa.txt";
if (!unlink($file)) {
    echo("delete_error");
} else {
    echo("delete_success");
}

```




# PHP 链接 MySQL:
```  
$servername = "localhost";
$username = "root";
$password = "root";
// 创建连接
$conn = new mysqli($servername, $username, $password);
// 检测连接
if ($conn->connect_error) {
    die("连接失败: " . $conn->connect_error);
}
echo "连接成功";
//关闭链接
$conn->close();

```


