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
## PHP开发中，经常会查看变量的值，因此经常会将变量的值输出到页面以便于查看。
## 常用的输出方式有：echo 、print 、print_r 、var_dump 、var_exprot 等；
## echo和print常用来输出字符串；
## 查看数组常用print_r、var_dump、var_exprot
## 若使用echo和print输出数组时则，结果只能显示"Array"，不会显示数组的结构。


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

# 结论: 推荐使用 : var_export($a); 
# 因为 结构清晰, 数据类型也是一眼可见