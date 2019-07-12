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
