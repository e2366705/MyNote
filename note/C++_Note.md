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


# static 修饰的变量, 会记住上一次的值, 直到下一次运算:
	
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
