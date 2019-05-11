# C++ notes....

```  
vs2019 快捷键

    F10：逐过程
    F11：逐语句
    Ctrl + Shift + F9：删除全部断点
	
	快捷键F10：进行下一句代码
	快捷键F11：进入当前代码所调用的方法，如果没有则进行下一句
	快捷键F5：跳过本断点。有时候断点看到之后就不想在调试，可以使用F5跳过本次断点
	
	ctrl+k,d：格式化代码
	Ctrl+E,F：格式化选中的代码
	Shift+F5: 停止调试
	Ctrl+Shift+F9: 删除全部断点
	Ctrl+Shift+L: 删除当前行

```

# 基础
```  
sizeof			查看数据类型占用多大数据空间
	用法:	
	int arr[10] = { 99,23,1,888,45,568,38,64,356,76125 };
	int len = sizeof(arr);
	cout << len << endl;   			// 输出: 40 	因为int占用4个字节, 数组有10个int数据, 所以sizeof为: 40
	
const			修饰常量

```

# 查看数组的长度:
```  
int arr[10] = { 99,23,1,888,45,568,38,64,356,76125 };
int len = sizeof(arr) / sizeof(arr[0]);
cout << len << endl;
	
```




# static 修饰的变量, 会记住上一次的值, 有时希望函数中的局部变量的值在函数调用结束后不消失而保留原值,在下一次该函数调用时,该变量保留上一次函数调用结束时的值
	
  ```
  #include <iostream>
	using namespace std;
	int f(int a)  //定义f函数,a为形参
	{

		static int b = 0; //定义b为自动变量
		static int c = 0;//定义c为静态局部变量
		b = b + 1;
		c = c + 1;
		return a + b + c;

	}

	int main()
	{
		int a = 0, i;
		for (i = 0; i < 3; i++) {
			cout << "f(a)==> " << f(a) << "\n";
		}
		cout << endl;
		return 0;
	}
	
	输出:
	f(a)==> 2
	f(a)==> 4
	f(a)==> 6
  ```
  
  
  ```
  	#include <iostream>
	// 函数声明 
	void func(void);
	static int count = 10; /* 全局变量 */

	int main()
	{
		while (count--)
		{
			func();
		}
		return 0;
	}
	// 函数定义
	void func(void)
	{
		static int i = 5; // 局部静态变量
		i++;
		std::cout << "变量 i 为 " << i;
		std::cout << " , 变量 count 为 " << count << std::endl;
	}
  ```
  
  
  

# auto 修饰的变量, 每一次会自动返回原位:
```  
	#include <iostream>
	using namespace std;
	int f(int a)  //定义f函数,a为形参
	{
		auto  b = 0; //定义b为自动变量
		static int c = 0;//定义c为静态局部变量
		b = b + 1;
		c = c + 1;
		return a + b + c;

	}

	int main()
	{
		int a = 0, i;
		for (i = 0; i < 3; i++) {
			cout << "f(a)==> " << f(a) << "\n";
		}
		cout << endl;
		return 0;
	}
	
	输出:
	f(a)==> 2
	f(a)==> 3
	f(a)==> 4

```



# 用extern声明外部变量
### 在main后面定义了全局变量a,b,但由于全局变量定义的位置在函数main之后,因此如果没有程序的第5行,在main函数中是不能引用全局变量a和b的｡现在我们在main函数第2行用extern对a和b作了提前引用声明,表示a和b是将在后面定义的变量｡这样在main函数中就可以合法地使用全局变量a和b了｡如果不作extern声明,编译时会出错,系统认为a和b未经定义｡一般都把全局变量的定义放在引用它的所有函数之前,这样可以避免在函数中多加一个extern声明

``` 

#include <iostream>
using namespace std;
int max(int, int);  //函数声明
void main()
{
	extern int a, b;//对全局变量a,b作提前引用声明
	cout << max(a, b) << endl;
}
int a = 15, b = -7;//定义全局变量a,b
int max(int x, int y)
{
	int z;
	z = x > y ? x : y;
	return z;
}

```



#thread_local 存储类 使用 thread_local 说明符声明的变量仅可在它在其上创建的线程上访问。 变量在创建线程时创建，并在销毁线程时销毁 每个线程都有其自己的变量副本




```  
资料 :  https://www.runoob.com/cplusplus/cpp-operators.html

A =   0011 1100
B =   0000 1101
---------------------
A&B = 0000 1100
总结:
	都为 1或0  	 => 取 1或0
	 一边为1   	 => 取 0



A =   0011 1100
B =   0000 1101
---------------------
A|B = 0011 1101
总结:
	都是1   =>   取 1
	一边为1 =>   取 1
	


A =   0011 1100
B =   0000 1101
---------------------
A^B = 0011 0001
总结:
	一边为1   =>   取 1
	都为1     =>   取 0



A =   0011 1100
B =   0000 1101
---------------------
~A  = 1100 0011
总结:
	都为0    =>   取 1 
	都为1    =>   取 0 
	一边是1  =>   取 0

```


# 右移操作:   
```  

>>	二进制右移运算符。左操作数的值向右移动右操作数指定的位数

假设变量 A 的值为 60 ( 0011 1100 )
 A >> 2 将得到 15，即为 0000 1111
 
 
 [  简单来记: 整个数字向右(看箭头[>>]的方向)移动, 右边多余的部分去掉, 左边不够的地方加上  ]
 60( 0011 1100 )   =>   60>>2   =>   0000 1111   
 
 [ 向左(<<)2位 ]
 60( 0011 1100 )   =>   60<<2   =>   1111 0000

```



# 循环
```  

int my_array[5] = { 1, 2, 3, 4, 5 };

// auto 类型也是 C++11 新标准中的，用来自动获取变量的类型
for (auto& x : my_array) {
	x *= 2;
	cout << x << endl;
}

无限循环:
	for( ; ; )
	{
	  printf("This loop will run forever.\n");
	}
	可以按 Ctrl + C 键终止一个无限循环



// for语句遍历一个字符串，并将所有字符全部变为大写
void main()
{
	string str("some string");
	// range for 语句  
	for (auto& c : str)
	{
		c = toupper(c);
	}
	cout << str << endl;
}




// 局部变量声明
int a = 10;
do
{
	cout << "a 的值：" << a << endl;
	a = a + 1;
} while (a < 20);   // 当a<20的时候, 会一直执行....




break		 	破环的意思, 就是把循环完全打破了, 打断了 (会使程序退出最内层循环 , 多层嵌套不起作用...)
continue 		继续的意思, 就是跳过这次循环, 继续下一次循环
	int a = 10;
	do
	{
		if (a == 15)
		{
			// 跳过迭代
			a = a + 1;
			break;
		}
		cout << "a 的值：" << a << endl;
		a = a + 1;
	} while (a < 20);
	
	

goto 语句: 有点调用函数的意思: 
	LOOP:
		{
			printf("loop is run ........");
		}
	goto LOOP;	
	
goto 语句一个很好的作用是退出深嵌套例程。例如，请看下面的代码片段：
	for(...) {
	   for(...) {
		  while(...) {
			 if(...) goto stop;
			 .
			 .
			 .
		  }
	   }
	}
	stop:
	cout << "Error in program.\n";
	消除 goto 会导致一些额外的测试被执行。一个简单的 break 语句在这里不会起到作用，因为它只会使程序退出最内层循环

```



## 函数还有很多叫法，比如方法、子例程或程序，等等



# 传值调用 / 指针调用 / 引用调用
```  

#include <iostream>
using namespace std;

// 函数声明
void swap(int x, int y);

int main()
{
	// 局部变量声明
	int a = 100;
	int b = 200;

	cout << "交换前，a 的值：" << a << endl;
	cout << "交换前，b 的值：" << b << endl;

	// 调用函数来交换值
	swap(a, b);

	cout << "交换后，a 的值：" << a << endl;
	cout << "交换后，b 的值：" << b << endl;

	return 0;
}


void swap(int x, int y)
{
	int temp;

	temp = x; /* 保存 x 的值 */
	x = y;    /* 把 y 赋值给 x */
	y = temp; /* 把 x 赋值给 y */

	return;
}
上面的实例表明了，虽然在函数内改变了 a 和 b 的值，但是实际上 a 和 b 的值没有发生变化 [ 传值调用 ]





#include <iostream>
using namespace std;

// 函数声明
void swap(int* x, int* y);

int main()
{
	// 局部变量声明
	int a = 100;
	int b = 200;

	cout << "交换前，a 的值：" << a << endl;
	cout << "交换前，b 的值：" << b << endl;

	/* 调用函数来交换值
	 * &a 表示指向 a 的指针，即变量 a 的地址
	 * &b 表示指向 b 的指针，即变量 b 的地址
	 */
	swap(&a, &b);

	cout << "交换后，a 的值：" << a << endl;
	cout << "交换后，b 的值：" << b << endl;

	return 0;
}


// 函数定义
void swap(int* x, int* y)
{
	int temp;
	temp = *x;    /* 保存地址 x 的值 */
	*x = *y;        /* 把 y 赋值给 x */
	*y = temp;    /* 把 x 赋值给 y */

	return;
}
以上为 指针调用;






#include <iostream>
using namespace std;

// 函数声明
void swap(int& x, int& y);

int main()
{
	// 局部变量声明
	int a = 100;
	int b = 200;

	cout << "交换前，a 的值：" << a << endl;
	cout << "交换前，b 的值：" << b << endl;

	/* 调用函数来交换值 */
	swap(a, b);

	cout << "交换后，a 的值：" << a << endl;
	cout << "交换后，b 的值：" << b << endl;

	return 0;
}


// 函数定义
void swap(int& x, int& y)
{
	int temp;
	temp = x; /* 保存地址 x 的值 */
	x = y;    /* 把 y 赋值给 x */
	y = temp; /* 把 x 赋值给 y  */

	return;
}
以上为: 引用调用

参考资料:  https://www.runoob.com/cplusplus/cpp-function-call-by-reference.html
```

# Lambda 函数与表达式
### Lambda 表达式把函数看作对象,Lambda 表达式可以像对象一样使用，比如可以将它们赋给变量和作为参数传递，还可以像函数一样对其求值





# c++ 随机数
### 在许多情况下，需要生成随机数。关于随机数生成器，有两个相关的函数。一个是 rand()，该函数只返回一个伪随机数。生成随机数之前必须先调用 srand() 函数

### 下面是一个关于生成随机数的简单实例。实例中使用了 time() 函数来获取系统时间的秒数，通过调用 rand() 函数来生成随机数：

```  
#include <iostream>
#include <ctime>
#include <cstdlib>

using namespace std;

int main()
{
	int i, j;

	// 设置种子
	srand((unsigned)time(NULL));

	/* 生成 10 个随机数 */
	for (i = 0; i < 10; i++)
	{
		// 生成实际的随机数
		j = rand();
		cout << "随机数： " << j << endl;
	}

	return 0;
}


```



# 指针
```  
int  var = 20;   // 实际变量的声明
int * ip;       	 // 指针变量的声明
ip = &var;       // 加个 & 转换成指针地址 , 赋值给指针变量
*ip				 // 指针前面加 * 代表解引用, 找到指针指向的内存的数据

简写: 
	int a = 10;
	int* p = &a;
	cout << "sizeof p = " << sizeof(p);		// 查看指针占用多少个字节 => 4个字节
	cout << "sizeof p = " << sizeof(float *); 		// 也是 4 个字节
	

周所周知, 指针也是数据(比如:0x1100) , 
	在32位操作系统下 , 不管什么类型的指针, 都占用4个字节
	在64位操作系统下, 占用8个字节
	
空指针: 
	指向变量为0 的内存空间 , 空指针指向的这快内存是不可以访问的(0到255之间的这块内存是系统独占的, 一旦访问, 就会出错)
	
野指针:
	int* p = (int *)0x1100;  就好比这段代码, 指针p, 指向一块没有定义的内存空间, 那就是野指针 , 运行会报错, 没有权限
	cout << *p;
	

常量指针: const int* p = &a; (注意: 指针指向的值不可以修改)
	特点: 指针的指向可以修改, 但是指针指向的值不可以改, 什么意思呢? 如下:
		*p 可以指向 	0x1234 (数据是10 ) 
		   也可以指向	0x5678 (数据也是10 )
		p = &b			正确: 可以改变指针指向
		*p = 20			错误: 指针指向的值不可以改
		
指针常量: int* const p = &a;  (注意: 指针指向不可以改)
	特点: 指针的指向不可以改 , 指针指向的值可以改
		p = &b			错误: 指针指向不可以改
		*p = 20			正确: 指向的值可以改
		
const即修饰指针, 又修饰常量: const int* const p = &a;
	特点: 指针的指向 + 指针指向的值, 都不可以改
		*p = 20 	错误
		p  = &b 	错误	
		
指针小案例:
	int arr[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	cout << "常规方式访问数组:" << arr[0] << endl;

	// arr 就是数组首地址
	int* p = arr;  
	cout << "用指针访问第一个元素(需要加* 解引用):  " << *p << endl;
	
	// 让指针往后偏移 4 个字节 
	p++;
	cout << "用指针访问第2个元素(需要加* 解引用):  " << *p << endl;
	
	// 用指针的方式遍历
	for (int i = 0; i < 10; i++) {
		cout << *p << endl;
		p++;
	}		
		
```




# 值传递 / 地址传递
```  
无论你定义一个函数(void swap(int a , int b))来交换a,b的值, 
最终输出的a,b的值, 不会发生改变
这就是值传递 , 因为函数 swap 里面传入的是值, 如果传入的是指针, 那就不一样了


小案例:
#include <iostream>

using namespace std;

void swap(int a , int b) {
	int temp = a;
	a = b;
	b = temp;
}

void swap_by_pointer(int* a, int* b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

void main()
{

	int a = 10;
	int b = 20;

	// 值传递 不起作用
	//swap(a, b);

	// 指针改变, 称之为 地址传递   a b 发生改变
	swap_by_pointer(&a, &b);

	cout << a << endl;
	cout << b << endl;

}

```










































































































































































































































































































































































