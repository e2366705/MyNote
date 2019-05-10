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




























































































































































































































































































































































































