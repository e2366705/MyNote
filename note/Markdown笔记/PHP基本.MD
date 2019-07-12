# PHP基本:		


# namespace的上面(前面)不能有任何的文字,方法


# 检测这个变量是否赋值
```  
isset($aa)
```


# 字符串 / 数组(array) 的 转换
### 数组 => 字符串
```  
$array = array('lastname', 'email', 'phone');
$comma_separated = implode(",", $array);


$arr = array('Hello','World!','Beautiful','Day!');
echo join("=>",$arr);   
输出:   Hello=>World!=>Beautiful=>Day!

```

### 字符串 => 数组
```  
$str = "www.runoob.com";
print_r(explode(".", $str));

语法:
                   $分隔符     $字符串     可有可无
function explode ($delimiter, $string, $limit = null) {}
         explode('/', 'image/png')[1];  ==> png
```


# PHP中文乱码怎么办? 
```  
header("content-type:text/html;charset=utf-8");

```


# 输出上一级目录
```  
exit(dirname(dirname(__FILE__)));

```


# 把一个字符串打乱   
```  
str_shuffle("ABCDEFGHIJKRMN");

```

 
# 截取字符串
```  
substr("ABCDEFGHIJKRMN", 2,6);

```



# __FILE__ 和 __DIR__ 和 dirname的区别/关系
```  
var_dump(dirname(__FILE__));
var_dump(__FILE__);
var_dump(__DIR__);


输出:
string(60) "C:\phpStudy\PHPTutorial\WWW\thinkphp5\application\index\Test"
string(72) "C:\phpStudy\PHPTutorial\WWW\thinkphp5\application\index\Test\Test001.php"
string(60) "C:\phpStudy\PHPTutorial\WWW\thinkphp5\application\index\Test"

```



## 获取时间:
```  
//需要设置时区,不然获取的时间是不准的
date_default_timezone_set('PRC');
echo date("Y-m-d H:i:s")."\n";
echo "当前时间是 " . date("h:i:sa")."\n";

```



# 查看数据类型
### JavaScript查看数据类型:
```  
typeof(xxx)

```

### PHP 查看数据类型:
```  
var_dump(xxx)

```


 

# 判断是否是数字
```  
is_numeric('string');

```




# return后面的语句不再执行
```  
echo $AAA;
return $AAA;      
echo $BBB;

```


# JavaScript 打印后台传输过来的数据
```  
document.write(xhr.responseText);

```






# => / -> / :: 是什么意思?
### -> 的作用  用来引用对象的成员（属性与方法）
```  
	class aaaa{
		public $aa = "AAA";
		public $bb = "BBB";
	}
	$test = new aaaa();
	print_r($test->aa);

```


### "=>"的作用: 数组键值对:
```  
$css=array('style'=>'s0','color' => 'blue');
$css['style'] = 's1';
$css['color'] = 'red';
print_r($css);

```

	
###  :: 的作用
```  
1: 类正常访问静态成员:
		class Heima{
			public static $heima = '黑马';                 //静态属性
			public static function getHeima(){           //静态方法
				//内部使用::
				echo self::$heima;                       //self代表Heima类，同Heima::$heima
			}
		}
		//外部访问
		echo Heima::$heima;                //访问静态属性，输出黑马
		Heima::getHeima();                 //访问静态方法，输出黑马
		
2: '::'也可以类访问普通方法, 但是系统不建议，有风险!!!!	

```


# 几种输出方式:

```  
PHP开发中，经常会查看变量的值，因此经常会将变量的值输出到页面以便于查看。

常用的输出方式有：
echo
print
print_r
var_dump
var_exprot
 等；

 echo和print常用来输出字符串；  
 查看数组常用print_r、var_dump、var_exprot  
 
  若使用echo和print输出数组时则，结果只能显示"Array"，不会显示数组的结构。

```


# echo 调试的时候会用到
```  
echo "<h1>TEST.....</h1>";

```

# 输出方式 : exit / die 会暂停
```  
exit("qweqweqwe");  		输出后退出, 不再执行下面的代码
die("123123123");   		输出后退出

```



## 测试代码
```  
$a = array ('a' => 'apple', 'b' => 123, 'c' => array ('x', 'y', 'z'));

```


##  第1种输出方式:  print_r($a);
```  
Array
(
    [a] => apple
    [b] => 123
    [c] => Array
        (
            [0] => x
            [1] => y
            [2] => z
        )

)

```


## 第2种输出方式:   var_export($a);
```  
array (
  'a' => 'apple',
  'b' => 123,
  'c' => 
  array (
    0 => 'x',
    1 => 'y',
    2 => 'z',
  ),
)

```


## 第3种输出方式:   var_dump($a);
```  

// 带上格式 + 并且显示数据类型


array(3) {
  ["a"]=>
  string(5) "apple"
  ["b"]=>
  int(123)
  ["c"]=>
  array(3) {
    [0]=>
    string(1) "x"
    [1]=>
    string(1) "y"
    [2]=>
    string(1) "z"
  }
}


```

# 结论: 推荐使用 : var_export($a);    因为 结构清晰, 数据类型也是一眼可见


# == 和 ===
```  
松散比较：使用两个等号 == 比较，只比较值，不比较类型。
严格比较：用三个等号 === 比较，除了比较值，也比较类型。

```

# 常量 
```  
常量值被定义后，在脚本的其他任何地方都不能被改变。

// 区分大小写的常量名
define("GREETING", "欢迎访问 Runoob.com");
echo GREETING;    // 输出 "欢迎访问 Runoob.com"
echo '<br>';
echo greeting;   // 输出 "greeting"


// 不区分大小写的常量名
define("GREETING", "欢迎访问 Runoob.com", true);
echo greeting;  // 输出 "欢迎访问 Runoob.com"


常量是全局的
常量在定义后，默认是全局变量，可以在整个运行的脚本的任何地方使用。
在函数内使用常量，即便常量定义在函数外也可以正常使用常量。

```


# 字符串操作
## 字符串之间的的链接
```  
在 PHP 中，只有一个字符串运算符。
并置运算符 (.) 用于把两个字符串值连接起来。

$txt1="Hello world!"; 
$txt2="What a nice day!"; 
echo $txt1 . " " . $txt2; 

```


## 字符串内查找一个字符或一段指定的文本。
```  
strpos() 函数用于在字符串内查找一个字符或一段指定的文本。
如果在字符串中找到匹配，该函数会返回第一个匹配的字符位置。如果未找到匹配，则返回 FALSE。

echo strpos("Hello world!","world"); 

```


## 获取字符串的长度
```  
echo strlen("Hello world!"); 

```

# 数组操作
## 移除数组中重复的值
```  
$a = array(
    "a" => "red",
    "b" => "green",
    "c" => "red"
);
print_r(array_unique($a));

```


## 数组合并:
```  
$aaa = array(1,2,3);
$bbb = array(11,22,33);
$ccc = array_merge($aaa,$bbb);

```


## 获取数组的长度
```  
$cars=array("Volvo","BMW","Toyota");
echo count($cars);

```

## 遍历数组
```  
* 第一种
$cars = array("Volvo", "BMW", "Toyota");

for ($x = 0; $x < count($cars); $x++) {
    echo $cars[$x];
    echo "\n";
}



* 第二种
$age = array("Peter" => "35", "Ben" => "37", "Joe" => "43");

foreach ($age as $x => $x_value) {
    echo "Key=" . $x . ", Value=" . $x_value;
    echo "\n";
}

```


## 数组排序
```  
sort() - 对数组进行升序排列
rsort() - 对数组进行降序排列
asort() - 根据关联数组的值，对数组进行升序排列
ksort() - 根据关联数组的键，对数组进行升序排列
arsort() - 根据关联数组的值，对数组进行降序排列
krsort() - 根据关联数组的键，对数组进行降序排列

教程:
https://www.runoob.com/php/php-arrays-sort.html

```


# 基础的函数
```  
function add($x, $y)
{
    $total = $x + $y;
    return $total;
}

echo "1 + 16 = " . add(1, 16);

```




# array 转换成 json:
## json_encode
```  
$data = array();
$data['a'] = 'test';
$data['b'] = 'bbb';

$json_string = json_encode($data);

```

# php json_encode 中文乱码怎么办???
```  
加上:JSON_UNESCAPED_UNICODE
echo json_encode($title_ID_Array , JSON_UNESCAPED_UNICODE);

```


# json 转换成 array
## json_decode
```  
$json_string = file_get_contents('../JSON/JSON.json');
$data = json_decode($json_string, true);
var_dump($data);

```



# 解析json
## Javascript :
```  
    JSON.parse()   json->对象
    JSON.stringify()； 对象->json

```



## PHP:
```  
json_encode()   php关联数组（对象） ->json
json_decode();  json->php 对象

```






# 魔术常量
```  
文件中的当前行号。
echo '这是第 " '  . __LINE__ . ' " 行';

文件的完整路径和文件名。如果用在被包含文件中，则返回被包含的文件名。
echo '该文件位于 " '  . __FILE__ . ' " ';

文件所在的目录。如果用在被包括文件中，则返回被包括的文件所在的目录。
echo '该文件位于 " '  . __DIR__ . ' " ';


返回该函数的名字
function test() {
    echo  '函数名为：' . __FUNCTION__ ;
}
test();

返回该方法的名字
function test() {
    echo  '函数名为：' . __METHOD__ ;
}
test();


返回当前命名空间的名称:
namespace MyProject;
echo '命名空间为："', __NAMESPACE__, '"'; 


返回该类被定义时的名字
class test {
    function _print() {
        echo '类名为：'  . __CLASS__ . "<br>";
        echo  '函数名为：' . __FUNCTION__ ;
    }
}
$t = new test();
$t->_print();

```







# PHP常量详解：define和const的区别
## https://my.oschina.net/wangyongtao/blog/525507



# POST提交数据太大
```  
其实后来最终的解决方案是修改服务器的配置文件。
POST数据按道理说是没有大小限制的，只是取决于浏览器或服务器的配置，tomcat的解决方式参考方案2.
－－－－－－－－－－－－－－－－－－分割线－－－－－－－－－－－－－－－－－
场景：之前帮客户做接口，等真正上线的时候，才发现客户提交过来的数据超出测试范围。因为客户发过来的数据有几张base64编码格式的照片。整体2.2M。
解决方案：
方案1:最初网上查发现也有人出现过类似情况。说是request.getParameter底层是一个map，map集合装不了那么大的字符串，所以map集合崩溃了。用request.getInputStream流读出来就好了。该兄正是通过此种方法解决，于是我就信了。map装不了过大数据。
用request.getInputStream来接收数据。但是这时候又出现个问题。用request.getInputStream的方式，之前的小数据又接收不到了，传过来的为“”。
方案2:针对方案1出现的问题，考虑到还是不能放弃request.getParameter。于是我又去查map是不是真的有限制大小。查API好像没有说Map有最大限制什么的。不过通过map.size() 方法时，有这样的注解：返回此映射中的键-值映射关系数。如果该映射包含的元素大于 Integer.MAX_VALUE，则返回 Integer.MAX_VALUE。于是又觉得map有希望了。后来想是不是跟服务器设置有关系？于是通过网上查找，设置server.xml中Connector中的属性，maxPostSize的值。
https://blog.csdn.net/yapingge2014/article/details/52052574
https://blog.csdn.net/gy__my/article/details/68944009

```





# 
```  


```



# 
```  


```



# 
```  


```



# 
```  


```



# 
```  


```



# 
```  


```





