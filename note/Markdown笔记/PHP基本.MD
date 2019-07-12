# PHP基本:		

## php中"=>"的作用: 数组键值对:
```  
$css=array('style'=>'s0','color' => 'blue');
$css['style'] = 's1';
$css['color'] = 'red';
print_r($css);

```



## php中:->的用法:
### ->用来引用对象的成员（属性与方法）；
```  
小例子:
	class aaaa{
		public $aa = "AAA";
		public $bb = "BBB";
	}
	$test = new aaaa();
	print_r($test->aa);

```


	
## PHP中的‘::’是一种内置的语法解析符号:
### 小例子	
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



## 测试代码
```  
$a = array ('a' => 'apple', 'b' => 123, 'c' => array ('x', 'y', 'z'));

```


## print_r($a);
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


## var_export($a);
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


## var_dump($a);
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


# 字符串之间的的链接
```  

在 PHP 中，只有一个字符串运算符。
并置运算符 (.) 用于把两个字符串值连接起来。

$txt1="Hello world!"; 
$txt2="What a nice day!"; 
echo $txt1 . " " . $txt2; 

```


# 获取字符串的长度
```  
echo strlen("Hello world!"); 

```

# 获取数组的长度
```  
$cars=array("Volvo","BMW","Toyota");
echo count($cars);

```

# 遍历数组
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


# 数组排序
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


# 函数
```  
function add($x, $y)
{
    $total = $x + $y;
    return $total;
}

echo "1 + 16 = " . add(1, 16);

```




# strpos() 函数
```  
strpos() 函数用于在字符串内查找一个字符或一段指定的文本。
如果在字符串中找到匹配，该函数会返回第一个匹配的字符位置。如果未找到匹配，则返回 FALSE。

echo strpos("Hello world!","world"); 

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





