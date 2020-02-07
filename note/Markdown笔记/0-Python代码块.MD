# Python
> python 写起来挺舒服的, 属于脚本语言, 写完直接可以运行, 不像Java, 还需要编译, 所以写东西是很快的


```  

基本:

第一类: 字符串类 / 日期类
	注释
	
	大写
	小写
	
	暂停/睡眠
    time.sleep(1)

	当前时间
	当前日期

	正则表达式
	替换字符串

	截取字符串
	分割字符串

	随机数
	
	
第二类: IO类:
	读
	写
	
	
第三类: 数据库类
	增
	删
	改
	查





	
第四类: 集合(重点):
	循环 / 遍历
	添加 / 删除
	可重复 / 不可重复
	key / value
	...







面向对象

other:
	json	
	



```





# Request Headers Format
```  
Request Headers 自动格式化生成器,
    自动加上 '' 单引号
    自动加上 , 逗号

    第一行 不能自动加上 '   ,  可以用 IDE 的多行编辑实现


str = """
Accept: */*
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7
Cache-Control: no-cache
Connection: keep-alive
Cookie: bid=K5fi0MbUeqg; douban-fav-remind=1; __utmz=30149280.1560688098.3.3.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); __utmc=30149280; __utmc=223695111; __utmz=223695111.1563177607.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); ll="118270"; _vwo_uuid_v2=DB87145441C1517FFD365DF5C2065668E|cf988ab652b4c68eca60a7d60c2111b9; ct=y; ap_v=0,6.0; _pk_ses.100001.4cf6=*; __utma=30149280.2006237161.1560261678.1563255935.1563257739.7; __utmb=30149280.0.10.1563257739; __utma=223695111.1246596334.1563177607.1563255935.1563257739.4; __utmb=223695111.0.10.1563257739; _pk_id.100001.4cf6=e9f0aa52136e09bb.1563177606.4.1563258061.1563255935.
Host: movie.douban.com
Pragma: no-cache
Referer: https://movie.douban.com/explore
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36 OPR/62.0.3331.43
X-Requested-With: XMLHttpRequest
"""

# 去掉 空格
#  把 :                    =>                  ':'
#  把 换行符                =>                ',\n
print(str.replace(" ", "").replace(":", "':'").replace("\n" , "',\n"))

print("记得去掉  https://movie.douban.com/explore   中间的冒号 => :  ")

```










<details>
<summary><b>基础 / 字符串 / 日期时间</b></summary>

```  


#!/usr/bin/python3 
# 第一个注释
print ("Hello, Python!") # 第二个注释



关于注释: 
# 第一个注释
 
'''
第三注释
第四注释
'''
 
"""
第五注释
第六注释
"""
print ("Hello, Python!")


python最具特色的就是使用缩进来表示代码块，不需要使用大括号 {}


Python 通常是一行写完一条语句，但如果语句很长，我们可以使用反斜杠(\)来实现多行语句，例如：
total = item_one + \
        item_two + \
        item_three

在 [], {}, 或 () 中的多行语句，不需要使用反斜杠(\)，例如：
total = ['item_one', 'item_two', 'item_three',
        'item_four', 'item_five']


str = '0123456789'
print("字符串是:    0123456789")
print("截取第一位到第三位的字符:   " + str[0:3])
print("截取字符串的全部字符   "+str[:])
print("截取第七个字符到结尾   "+str[6:])
print("截取从头开始到倒数第三个字符之前   "+str[:-3])
print("截取第三个字符   "+str[2])
print("截取倒数第一个字符   "+str[-1])
print("创造一个与原字符串顺序相反的字符串    "+str[::-1])
print("截取倒数第三位与倒数第一位之前的字符    "+str[-3:-1])
print("截取倒数第三位到结尾    "+str[-3:])
print("逆序截取    "+str[:-5:-3])

print(r'hello\nrunoob')     # 在字符串前面添加一个 r，表示原始字符串，不会发生转义


word = '字符串'
sentence = "这是一个句子。"
paragraph = """这是一个段落，
可以由多行组成"""


执行下面的程序在按回车键后就会等待用户输入：
#!/usr/bin/python3
input("\n\n按下 enter 键后退出。")


print 默认输出是换行的，如果要实现不换行需要在变量末尾加上 end=""：
print( y, end=" " )

Python 中的变量不需要声明。每个变量在使用前都必须赋值，变量赋值以后该变量才会被创建
在 Python 中，变量就是变量，它没有类型(弱类型语言/动态语言)，我们所说的"类型"是变量所指的内存中对象的类型
counter = 100          # 整型变量
miles   = 1000.0       # 浮点型变量
name    = "runoob"     # 字符串


Python允许你同时为多个变量赋值。例如：
a = b = c = 1

也可以为多个对象指定多个变量。例如：
a, b, c = 1, 2, "runoob"

Python3 中有六个标准的数据类型：Number（数字） String（字符串） List（列表） Tuple（元组） Set（集合） Dictionary（字典）
Python3 的六个标准数据类型中：
    不可变数据（3 个）：Number（数字）、String（字符串）、Tuple（元组）；
    可变数据（3 个）：List（列表）、Dictionary（字典）、Set（集合）。

内置的 type() 函数可以用来查询变量所指的对象类型
print(type(a))

此外还可以用 isinstance 来判断：
isinstance(a, int)        # 返回 true or false




```
</details>







<details>
<summary><b> List(列表) / Tuple(元组) / Set(集合) / Dictionary(字典)</b></summary>

```  



==================================================================================================


Dictionary(字典):
    特点:无序, 
        它是一个无序的 键(key) : 值(value) 的集合, 
        键(key)必须使用不可变类型, 在同一个字典中，键(key)必须是唯一的
        创建空字典使用 { }

    内置的函数，
        clear()
        keys()
        values()

dict = {}
tinydict = {'name': 'runoob','code':1, 'site': 'www.runoob.com'}
dict['one'] = "菜鸟教程"
dict[2]     = "菜鸟工具"       

print (dict['one'])       # 输出键为 'one' 的值
print (dict[2])           # 输出键为 2 的值
print (tinydict)          # 输出完整的字典
print (tinydict.keys())   # 输出所有键
print (tinydict.values()) # 输出所有值

构造函数 dict() 可以直接从键值对序列中构建字典如下：
dict(Runoob=1, Google=2, Taobao=3)



==================================================================================================

列表 List : 

列表(list)中的元素是可以改变的：
    特点: 有序 , 可以改变

a = 10
b = 20
list = [1, 2, 3, 4, 5 ];
a in list           # bool类型

Tuple（元组）:
    元组（tuple）与列表类似，不同之处在于元组的元素不能修改,
    虽然tuple的元素不可改变，但它可以包含可变的对象，比如list列表


  list = ['html', 'js', 'css', 'python']
    # 遍历列表方法1
    for i in list:
        print("序号：%s   值：%s" % (list.index(i) + 1, i))

    # 遍历列表方法2
    for i in range(len(list)):
        print("序号：%s   值：%s" % (i + 1, list[i]))

    # 遍历列表方法3
    for i, val in enumerate(list):
        print("序号：%s   值：%s" % (i + 1, val))

    # 遍历列表方法3 （设置遍历开始初始位置，只改变了起始序号
    for i, val in enumerate(list, 2):
        print("序号：%s   值：%s" % (i + 1, val))


==================================================================================================

Set（集合） :
不能有重复的元素:
student = {'Tom', 'Jim', 'Mary', 'Tom', 'Jack', 'Rose'}
print(student)   # 输出集合，重复的元素被自动去掉

# 成员测试
if 'Rose' in student :
    print('Rose 在集合中')
else :
    print('Rose 不在集合中')


# set可以进行集合运算
a = set('abracadabra')
b = set('alacazam')
 
print(a)
 
print(a - b)     # a 和 b 的差集
print(a | b)     # a 和 b 的并集
print(a & b)     # a 和 b 的交集
print(a ^ b)     # a 和 b 中不同时存在的元素   




```
</details>










<details>
<summary><b>About SQL (数据库 MySQL)</b></summary>

```  

#!/usr/bin/python3
import pymysql

# 打开数据库连接                    账户    密码         数据库名称
db = pymysql.connect("localhost", "root", "root", "study_english_database")

# 使用cursor()方法获取操作游标
cursor = db.cursor()

# SQL 查询语句
sql = "SELECT `word` , `chinese_meaning` FROM `phrase`"
try:
    # 执行SQL语句
    cursor.execute(sql)

    # 获取所有记录列表
    results = cursor.fetchall()
    
    for row in results:
        word = row[0]
        chinese_meaning = row[1]
        print("word=%s,chinese_meaning=%s " % (word, chinese_meaning))
except:
    print("Error: unable to fetch data")

# 关闭数据库连接
db.close()


增
删
改
查

```
</details>







---
# 区别:
> 容易混淆的概念
<details>
<summary><b>is == 区别</b></summary>

```  

is 与 == 区别：
    is 用于判断两个变量引用对象是否为同一个， 
    == 用于判断引用变量的值是否相等

```
</details>






---
# Other
<details>
<summary><b>播放音频文件</b></summary>

```  

import time
import pygame

def Play_Aduio_File(Aduio_file_name):

    file = 'Aduio/Link_Error.wav'

    Aduio_file_path = folder_path + Aduio_file_name

    pygame.mixer.init()  # 初始化音频
    track = pygame.mixer.music.load(Aduio_file_path)  # 载入音乐文件
    pygame.mixer.music.play()  # 开始播放
    time.sleep(2)  # 播放 xx 秒
    pygame.mixer.music.stop()  # 停止播放


# Play_Aduio_File("Link_Error.wav")

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>







