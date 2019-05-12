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
int a = 10;   // 局部变量保存在栈区, 函数结束, 就会被回收
static int a = 10;	// 静态变量, 存放在全局区, 在程序结束后, 系统释放

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




# 值传递 / 地址传递 / 引用传递
```  
无论你定义一个函数(void swap(int a , int b))来交换a,b的值, 
最终输出的a,b的值, 不会发生改变
这就是值传递 , 因为函数 swap 里面传入的是值, 如果传入的是指针, 那就不一样了

值传递: 拷贝数据

#include <iostream>
using namespace std;

// 值传递 不起作用 , 形参不会改变实参
void swap(int a, int b) {
	int temp = a;
	a = b;
	b = temp;
}

// 地址传递  形参会改变实参   传入的是指针 
void swap_by_pointer(int* a, int* b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

// 引用传递  形参会改变实参 引用的本质就是起别名  传入的是引用
void swap_03(int& a, int& b)
{
	int temp = a;
	a = b;
	b = temp;
}

void main()
{

	int a = 10;
	int b = 20;

	swap(a, b);
	//swap_by_pointer(&a, &b); 
	//swap_03(a, b);

	cout << a << endl;
	cout << b << endl;
}

```








# 引用
### 本质就是, 给变量起别名
```  
语法:
	int& = a; 这就是引用
	------------------------
	int a = 10;
	int& b = a;  		// 引用了a
	b = 20;
	cout << a << endl;   	// 输出:20 为什么给b赋值, a会会发生改变?  因为引用, 就是操作同一块内存
	
	int& b = 10; 			// 不合法
	const int& a = 10;		// 合法
	
	int a = 10;
	int& b = a;		// 正确 , 因为引用是要接收一块地址
	
	
	
注意:
	1, 引用必须要初始化
		int& b;		// 错误的
	2, 引用一旦初始化, 就不可以更改
		int& b = a;			// 初始化, 引用a
		int& b = c;			// 错误, 已经引用a, 就不能引用其他
		

#include <iostream>
using namespace std;

// 规矩1 : 不要返回局部变量的引用
int& test_01()
{
	int a = 10;   // 局部变量保存在栈区, 函数结束, 就会被回收
	return a;
}

// 如果函数的返回值是引用, 那么函数可以作为左值
int& test_02()
{
	static int a = 10;	// 静态变量, 存放在全局区, 在程序结束后, 系统释放
	return a;			// 返回的是一个引用
}

void main()
{
	int& ref = test_01();
	cout << ref << endl;    // 第一次输出正确, 是因为编译器做了保留
	cout << ref << endl;	// 运行失败

	int& ref2 = test_02();
	cout << ref2 << endl;
	cout << ref2 << endl;

	test_02() = 30000;			// 函数作为左值
	cout << ref2 << endl;
	cout << ref2 << endl;

}

C++推荐使用引用技术, 因为语法方便, 引用的本质是指针常量, 但是所有的指针操作编译器都帮我们做了


int a = 10;
// 加上const之后, 编译器将代码修改为: 
//		int temp = 10; 
//		int& ref = temp;
const int& ref = 10;
// ref = 30; // 加上const之后, 变为只读, 不可以修改

	
// 为了防止 形参修改实参
void test(const int& val)
{
	// val = 1000;	// 修改失败, 因为形参加上了const , 防止误操作
	cout << val << endl;

}

```
















# 函数
```  
//  默认参数
void function(int a=10,int b=90)
{
	int c = a + b;
	cout << c << endl;
}

void main()
{
	function();
}

注意: 
	有默认值的参数, 必须在列表的最后一个
	
	
	
// 如果某个函数在main函数的后面, 那么应该在main函数前面声明	
void function2(int a);				// 声明函数, 才可以调用...
void main()
{
	//function();
	function2(123);
}

void function2 (int a)		// 实现函数
{
	cout << a << endl;
}	

关于默认参数, 声明函数和实现函数, 只能有一个默认参数


函数中的占位参数 , 占位参数也可以有默认值
void function(int a, int = 10)
{
	cout << a << endl;
}

函数重载:
	1, 函数名称相同
	2, 参数类型不同 或者 个数不同 或者 顺序不同
注意: 函数的返回值不可以作为函数重载的条件
注意:
	1, 引用作为重载的条件
void function(int& a)		// int& a = 10;  不合法
{
	cout << "  -->   " << a <<endl;
}

void function(const int& a)		// const int& a = 10; 合法
{
	cout << "const   " << a << endl;
}

void main()
{
	int a = 10;
	function(a);
	function(10);
}	
	
	2, 函数重载碰到默认参数
		因为有默认参数的时候, 有默认参数的参数, 就算不赋值, 也没关系, 这时候, 程序就不知道走哪个方法了
```























# 面向对象 / 类 / 对象 / 继承 / 封装 / 多态 
```  
基础
class Animal
{
public:
	int age;
	int tall;
	int get_test()
	{
		return 2333333;
	}
};

void main()
{
	Animal animal;
	animal.age = 80;
	cout << animal.get_test() << endl;
	cout << animal.age << endl;

}

访问权限:
	1, private 		类里可以访问, 类外不可以访问 子类不可以访问父类
	2, public		类里/类外都可以访问
	3, protected	类里可以访问, 类外不可以访问 子类也可以访问父类

	
在c++中, 
		struct 和 class 相似度非常高,唯一的区别在于, 默认的访问权限不同
			struct 默认权限为 公共
			class  默认权限为私有
			如下:
			class myClass
			{
				int age;		// 默认权限是 私有
			};

			struct MyStruct
			{
				int age;		// 默认权限是 公共
			};
			

构造函数: 类名(){}
	1, 没有返回值, 也不写void
	2, 函数名称和类名相同
	3, 可以有参数, 因此可以发生重载
	4, 在调用对象的时候自动调用构造函数, 不用手动调用, 而且只会调用一次
	
析构函数: ~类名(){}
	1, 没有返回值, 也不写void
	2, 在名称前面加上 ~ 
	3, 不可以有参数, 因此不可以发生重载
	4, 在对象销毁前自动调用析构函数, 不用手动调用, 而且只会调用一次
	
			

拷贝构造函数:
	Person(const Person &p)
	{
		age = p.age;
	}
	
	
构造函数调用规则:
	创建一个类, C++编译器会给每个类都添加至少3个函数
		默认构造函数 (空实现)
		析构函数	 (空实现)
		拷贝构造	 (值拷贝)
		

		
		
初始化列表:		
class Animal
{
public:
	Animal(int a, int b) :age(a), tall(b)
	{
		cout << a << endl;
	}
	int age;
	int tall;
};

void  main()
{
	Animal animal(30,20);
}




C++类中的成员, 可以是另一个类的对象, 称之为: 对象成员
class A{}
class B
{
	A a;
}
问题: 是先有A , 还是先有 B (构造函数) ???
答案: 构造函数, 先实例化A , 再实例化 B  (析构函数的调用顺序相反)





静态成员函数 / 静态变量
	静态成员函数 只能访问    静态成员变量
				 不可以访问  非静态成员变量
class Animal
{
public:
	static void func()
	{
		cout << 123 << endl;
	}
};

void  main()
{
	Animal animal;
	animal.func();

	// 通过类名直接访问静态函数
	Animal::func();
}




空对象:
	空对象占用内存空间为: 1
	C++编译器会给每一个空对象分配一个字节空间, 是为了区分对象占内存的位置
	每个空对象应该有独一无二的内存地址
	class Person
	{
	}
	
	

只有非静态成员变量, 才属于类对象, 并且占用空间
class Animal
{
	int a;					// 占用空间 , 属于对象上
	int s;					// 占用空间
	int c;					// 占用空间

	static int b;			// 静态成员变量,		不属于某个对象, 是共享的 , 不占用内存空间

	void func() {};			// 非静态成员函数 ,  不属于某个对象, 是共享的 , 不占用内存空间
	static void func2() {}; // 静态成员函数 ,    不属于某个对象, 是共享的 , 不占用内存空间
};

void  main()
{
	Animal animal;
	cout << sizeof(animal) << endl;
}	





this指针:  (相当于java中的小数点(.) )
class Animal
{
public:
	Animal(int age)
	{
		this->age = age;
	}

	int age;
};

void  main()
{
	Animal animal(66);
	cout << animal.age<< endl;
}



返回值是 值对象:    创建一个新的对象
返回值是 引用对象   不会创建一个新的对象
Person& add(Person p)
{
	this->age ++;
	return *this;
}



常函数:
const 修饰成员函数:
	成员函数后加const后我们称这个函数是 常函数
	常函数不可以修改成员属性
	成员属性声明加上mutable后, 常函数依然可以修改
class Animal
{
public:
	void Person() const
	{
		age_m = 100;
	}
	mutable int age_m;
};
	
常对象:
	声明对象前加const, 称之为 常对象
	常对象只能调用常函数
	const Person P; // 在对象前面加上const , 变成常对象
	

友元:
	作用: 让一个函数, 或者类, 访问另一个类中私有成员
	友元关键字是 friend
	
#include <iostream>
using namespace std;
#include<string>

class Bullding
{
	friend void good_friend(Bullding* buliding);

public:
	Bullding()
	{
		m_sittingRoom = "客厅";
		m_bedRoom = "卧室";
	};

public:
	string m_sittingRoom; // 客厅

private:
    string m_bedRoom;   // 卧室
};


void good_friend(Bullding *buliding)
{
	cout << buliding->m_sittingRoom << endl;
	cout << buliding->m_bedRoom << endl;
};

void  main()
{
	Bullding building;
	good_friend(&building);
}	

类外面写构造函数:
Bullding::Bullding()
{
	a=10;
	b=20;
}
	
```




















# 运算符重载:
```  


```
















# 继承
### 最基础的继承:
```  
#include <iostream>
#include<string>
using namespace std;

class Base
{
public:
	void head()
	{
		cout << "head..." << endl;
	}
	void foot()
	{
		cout << "foot..." << endl;
	}

};

class Java :public Base
{
public:
	void content()
	{
		cout << "content....." << endl;
	}
};

void  main()
{
	Java java;
	java.head();
	java.content();
	java.foot();
}

```

### 三种继承方式:
```  
	
class Father
{
public:
	int a;
protected:
	int b;
private:
	int c;
};


三种继承方式:
	public 继承: 
		class son3 :public Father{}
		父类中 public 权限成员 , 到子类中依然是 public 成员
		父类中 protected 权限成员 , 到子类中依然是 protected 成员
		父类中 private 权限成员 , 子类访问不到		
		
	protected 继承
		class son3 :protected Father{}
		父类 public 成员, 		到子类中变成 protected 权限 , 类外无权访问
		父类 protected 成员, 	到子类中变成 protected 权限 , 类外无权访问
		父类中 private 权限成员 , 子类访问不到
		
    private 继承
	class son3 :private Father{}
		父类 public 成员, 			到子类中变成 private 权限 , 类外无权访问
		父类 protected 成员, 		到子类中变成 private 权限 , 类外无权访问
		父类中 private 权限成员 ,	子类访问不到

		
	私有继承, 原来public / protected 属性, 统统变成 private(私有的) 
	
	
注意: 父类private属性, 无论怎么继承, 都不允许访问
但是: 父类中所有非静态成员属性, 都会被子类继承下去 , 至于访问不到, 是因为被编译器给隐藏了,但确实是被继承下去了, 包括 public / protected / private

```


### 继承 - 父类和子类的执行顺序
```  
假如一个父类, 有构造函数, 析构函数, 子类继承了父类, 子类也有构造和析构函数, 
那么执行顺序是:
	父类构造函数
	子类构造函数
	子类析构函数
	父类析构函数
```


### 继承 - 同名的处理方式
```  
当子类和父类出现同名的成员, 如何通过子类的对象, 访问子类/父类的同名的数据???
	 访问子类同名成员, 直接访问即可
	 访问父类同名成员, 需要加上作用域
	 
#include <iostream>
#include<string>
using namespace std;

class father
{
public:
	int a = 10;

	void func()
	{
		cout << "father....." << endl;
	}
};

class son : public father
{
public:
	int a = 1000;

	void func()
	{
		cout << "son....." << endl;
	}
};

void  main()
{
	son sss;
	cout << sss.a << endl;
	cout << sss.father::a << endl;    // 通过子类对象, 访问父类同名成员, 需要加上作用域

	sss.func();
	sss.father::func();
}
	 

```

### 多继承 - 一个子类继承多个父类(很多个爹?)  在实际C++开发中 , 不建议多继承
### 菱形继承 - 2个子类继承一个父类, 又有一个孙类同时继承这两个子类, 感觉像是菱形一样 这个也比较少用











# `::`的作用
### 作用一
```  
初始化数据:
class father
{
public:
	static int a;
};

int father::a = 100;

void  main()
{
	father fa;
	cout << fa.a << endl;
}

```

### 作用二
```  
cout<< son::father::name << endl;
	解读:
		第一个:: 意思是通过类名访问
		第二个:: 意思是访问父类作用域下
```



















































































































































































































































































































