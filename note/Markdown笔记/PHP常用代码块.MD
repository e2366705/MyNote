# 常用代码块



# PHP with IO:
```  
r	只读。在文件的开头开始。
w	只写。打开并清空文件的内容；如果文件不存在，则创建新文件。
x	只写。创建新文件。如果文件已存在，则返回 FALSE 和一个错误。

a	追加。打开并向文件末尾进行写操作，如果文件不存在，则创建新文件。
a+	读/追加。通过向文件末尾写内容，来保持文件内容。

r+	读/写。在文件的开头开始。
w+	读/写。打开并清空文件的内容；如果文件不存在，则创建新文件。
x+	读/写。创建新文件。如果文件已存在，则返回 FALSE 和一个错误。



```

## 写 - 追加模式 a
```  
$myfile = fopen("aaa.txt", "a") or die("Unable to open file!");
$txt = "Bill Gates\n";
fwrite($myfile, $txt);
fclose($myfile);

```

## 读 - 一次性读取全部  (方式1) [最简单]
## 适用于文本文件
```  

注意: 单个php文件运行 和 服务器版运行, 路径是不一样的...

php单文件运行
$str = file_get_contents("../HTML_File_Resource/0.html");//将整个文件内容读入到一个字符串中

服务器版本运行
$str = file_get_contents("../../../HTML_File_Resource/0.html");

echo $str;

```



## 读 - 逐行读取  (方式2)
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
// 删除一个文件 -
//          传入参数: 文件名
function Delete($file_name) {

    $folder_path = "..\\..\\..\\HTML_File_Resource\\";

    $filw_path = $folder_path . $file_name;

    $status = unlink($filw_path);
    if ($status) {
        echo "File deleted success";
    } else {
        echo "error...";
    }
}

Delete("3.html");

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


