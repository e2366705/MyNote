# Python
python 写起来挺舒服的, 属于脚本语言, 写完直接可以运行, 不像Java, 还需要编译, 所以写东西是很快的



	

	


<details>
<summary><b>  Request Headers Format  </b></summary>


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
</details>




















# 基础:
<details>
<summary><b> 字符串 : 基础 </b></summary>

```  

py 文件的开头:
#!/usr/bin/python3
# -*- coding: UTF-8 -*-



if __name__ == '__main__':
    下面开始写代码...



加上 r 表示忽略 \ , 单纯的字符串
r'C:\Users\SpringBoot\PycharmProjects\untitled1\English_Article_Spider\TEST.txt'


拼接字符串
    aaa = "aaa"
    bbb = "bbb"
    ccc = aaa+bbb
    print(ccc)



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



输出格式化:
    print('{}网址： "{}!"'.format('菜鸟教程', 'www.runoob.com'))
    print('{name}网址： {site}'.format(name='菜鸟教程', site='www.runoob.com'))


    aaa = 123
    print("哈哈哈:  ", aaa)
    print("哈哈哈: %s " % aaa)



注意: 
这样会报错:
def if_have_Chinese(str):
    if "序号" in str & "值" in str:
        return True
    else:
        return False

这样不会报错:
def if_have_Chinese(str):
    if ("序号" in str) & ("值" in str):
        return True
    else:
        return False



print(r'hello\nrunoob')     # 在字符串前面添加一个 r，表示原始字符串，不会发生转义



 python 没有自增运算符
 所以 count++ 是错误的写法
 正确应该是 count = count + 1
 


睡眠 / 暂停 (秒数)
sleep(3)                3 秒
time.sleep(5)           5 秒



python最具特色的就是使用缩进来表示代码块，不需要使用大括号 {}


Python 通常是一行写完一条语句，但如果语句很长，我们可以使用反斜杠(\)来实现多行语句，例如：
total = item_one + \
        item_two + \
        item_three

在 [], {}, 或 () 中的多行语句，不需要使用反斜杠(\)，例如：
total = ['item_one', 'item_two', 'item_three',
        'item_four', 'item_five']



word = '字符串'
sentence = "这是一个句子。"
paragraph = """这是一个段落，
               可以由多行组成"""        




执行下面的程序在按回车键后就会等待用户输入：
    input("\n\n按下 enter 键后退出。")



print 默认输出是换行的，如果要实现不换行需要在变量末尾加上 end=""：
print( y, end=" " )



Python 中的变量不需要声明。每个变量在使用前都必须赋值，变量赋值以后该变量才会被创建
在 Python 中，变量就是变量，它没有类型(弱类型语言/动态语言)，
我们所说的"类型"是变量所指的内存中对象的类型
counter = 100          # 整型变量
miles   = 1000.0       # 浮点型变量
name    = "runoob"     # 字符串



Python允许你同时为多个变量赋值。例如：
a = b = c = 1

也可以为多个对象指定多个变量。例如：
a, b, c = 1, 2, "runoob"



Python3 中有六个标准的数据类型：Number（数字） String（字符串） List（列表） Tuple（元组） Set（集合） Dictionary（字典）
Python3 的六个标准数据类型中：
    不可变数据（3 个）:     Number（数字）          String（字符串）              Tuple（元组）
    可变数据（3 个）:       List（列表）           Dictionary（字典）             Set（集合）



此外还可以用 isinstance 来判断：
isinstance(a, int)        # 返回 true or false




内置的 type() 函数可以用来查询变量所指的对象类型
aaa = 123
print(type(aaa))
>>> <class 'int'>



字段拼接
var1 = 'Hello World!'
print ("已更新字符串 : ", var1[:6] + 'Runoob!')
输出: Hello Runoob!


需要在字符中使用特殊字符时，python用反斜杠(\)转义字符
    \(在行尾时)	续行符
    \\	反斜杠符号
    \'	单引号
    \"	双引号
    \a	响铃
    \b	退格(Backspace)
    \000	空
    \n	换行
    \v	纵向制表符
    \t	横向制表符
    \r	回车



-----------------------------------   截取字符串   -----------------------------------

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









-----------------------------------   替换字符串   ----------------------------------- 

replace()方法语法：
str.replace(old, new[, max])
old -- 将被替换的子字符串
new -- 新字符串，用于替换old子字符串
max -- 可选字符串, 替换不超过 max 次

str = "this is AAisAA 123is123  string example....wow!!!"
print (str.replace("is", "was"))                # thwas was AAwasAA 123was123  string example....wow!!!







-----------------------------------   分割字符串   ----------------------------------- 
split():
string.split(str="", num=string.count(str))
    str -- 分隔符，默认为所有的空字符，包括空格、换行(\n)、制表符(\t)等
    num -- 分割次数。默认为 -1, 即分隔所有

#!/usr/bin/python
# -*- coding: UTF-8 -*- 
str = "Line1-abcdef \nLine2-abc \nLine4-abcd";
str.split( );       # 以空格为分隔符，包含 \n
>>> ['Line1-abcdef', 'Line2-abc', 'Line4-abcd']

str.split(' ', 1 ); # 以空格为分隔符，分隔成两个
>>> ['Line1-abcdef', '\nLine2-abc \nLine4-abcd']



txt = "Google#Runoob#Taobao#Facebook"
x = txt.split("#", 1)           # 第二个参数为 1，返回两个参数列表 
>>> ['Google', 'Runoob#Taobao#Facebook']


字符串格式化
在 Python 中，字符串格式化使用与 C 中 sprintf 函数一样的语法:
print ("我叫 %s 今年 %d 岁!" % ('小明', 10))

%d	 格式化整数
%s	 格式化字符串


f-string 是新的格式化字符串的语法
name = 'Runoob'
f'Hello {name}'  # 替换变量

>>> f'{1+2}'         # 使用表达式
'3'

>>> w = {'name': 'Runoob', 'url': 'www.runoob.com'}
>>> f'{w["name"]}: {w["url"]}'
'Runoob: www.runoob.com'

用了这种方式明显更简单了，不用再去判断使用 %s，还是 %d






center() 方法返回一个指定的宽度 width 居中的字符串，fillchar 为填充的字符，默认为空格。
str = "[www.runoob.com]"
str.center(40, '*')
输出 : ************[www.runoob.com]************


count() 方法用于统计字符串里某个字符出现的次数。可选参数为在字符串搜索的开始与结束位置
str.count(sub, start= 0,end=len(string))
    sub -- 搜索的子字符串
    start -- 字符串开始搜索的位置。默认为第一个字符,第一个字符索引值为0。
    end -- 字符串中结束搜索的位置。字符中第一个字符的索引为 0。默认为字符串的最后一个位置。
sub='run'
str.count(sub,0,10)



```
</details>

























<details>
<summary><b> 字符串: 判断/包含 中文 / 数字 / 英文 / 特殊字符</b></summary>

```  

---------------------------------   提取中文   ---------------------------------
把正则表达式改为 [a-z]+ 就可以变成 提取 英文的了
#!/usr/bin/python3
# -*- coding: UTF-8 -*-
import re

# 测试文本
test = '<h1>hello 你好, 123 #%%% , 123,qwe 00   qwe$^&^$#@# world 世界, [[哈哈哈 ]]]]</h1>'

# 中文匹配正则
chinese_pattern = '[\u4e00-\u9fa5]+'
says = re.findall(chinese_pattern, test)

# 输出提取的内容
hi = ''
for say in says:
    # print(say)
    hi += say + ','
hi = hi.strip(',')

# 打印结果：你好,世界,哈哈哈
print(hi)





-----------------------------------   是否存在某个字符(中文,英文,数字)   ----------------------------------- 
print('你' in test)         # 返回 True












判断是否全是英文?
    空格可以有
pattern = re.compile(r'[^a-zA-Z\s]+')
result1 = pattern.findall('runoob    asdasd    DASDASDAS      ')
print(len(result1))
>>> 0
# 返回 0 表示: 全英文




'H' in a 输出结果 True          是否包含
'M' not in a 输出结果 True      是否不包含

find(str, beg=0, end=len(string))   检测 str 是否包含在字符串中，如果指定范围 beg 和 end
index(str, beg=0, end=len(string))  跟find()方法一样，只不过如果str不在字符串中会报一个异常
isalnum()       如果字符串至少有一个字符并且所有字符都是字母或数字则返 回 True,否则返回 False
isalpha()        如果字符串至少有一个字符并且所有字符都是字母则返回 True, 否则返回 False
isdigit()       如果字符串只包含数字则返回 True 否则返回 False..
str.isdigit())  判断所有字符都是数字
str.isalnum()   判断所有字符都是数字或者字母
str.isalpha()   判断所有字符都是字母

print("asdasd.".encode('UTF-8').isalpha())                  > 返回 False
print("asda asdas asdasd".encode('UTF-8').isalpha())        > 返回 Fase ( 带空格了 )

str.isupper()   判断所有字符都是大写
str.islower()   判断所有字符都是小写
str.istitle()   判断所有单词都是首字母大写，像标题
str.isspace()   判断所有字符都是空白字符、\t、\n、\r
isnumeric()     如果字符串中只包含数字字符，则返回 True，否则返回 False
len(string)     返回字符串长度
lower()         转换字符串中所有大写字符为小写
upper()         转换字符串中的小写字母为大写
capitalize()    将字符串的第一个字母变成大写,其他字母变小写 str.capitalize()
lstrip()        截掉字符串左边的空格或指定字符。
max(str)        返回字符串 str 中最大的字母。  min(str) 反之
rstrip()        删除字符串字符串末尾的空格.
startswith(substr, beg=0,end=len(string))   检查字符串是否是以指定子字符串 substr 开头，是则返回 True，否则返回 False。
                                            如果beg 和 end 指定值，则在指定范围内检查

...                                            

还有好多好多, python内置了许多方法函数供人们调用,   https://www.runoob.com/python3/python3-string.html



```
</details>
























<details>
<summary><b> 字符串: 编码 </b></summary>

```  


参考资料 :   https://www.liaoxuefeng.com/wiki/1016959663602400/1017075323632896


# 对于单个字符的编码，Python提供了 ord() 函数获取字符的整数表示，chr()函数把编码转换为对应的字符：
print(ord('A'))         # 65
print(ord('中'))        # 20013
print(chr(20013))       # 中
print('\u52c7\u6c14')   # 勇气




转码:
print(b'\xe5\x8b\x87\xe6\xb0\x94'.decode('UTF-8'))    # 勇气
print('勇气'.encode('UTF-8'))                         # b'\xe5\x8b\x87\xe6\xb0\x94'




# Python的字符串类型是str，在内存中以Unicode表示，一个字符对应若干个字节
# 如果要在网络上传输，或者保存到磁盘上，就需要把str变为以字节为单位的bytes
# Python对bytes类型的数据用带b前缀的单引号或双引号表示：

x = b'ABC'
print(x)                         # b'ABC'




# 如果我们从网络或磁盘上读取了字节流，那么读到的数据就是bytes。要把bytes变为str，就需要用decode()方法:
print( b'ABC'.decode('ascii'))                                 # ABC

# 如果bytes中只有一小部分无效的字节，可以传入errors='ignore'忽略错误的字节：
print(b'\xe4\xb8\xad\xff'.decode('utf-8', errors='ignore'))    # 中


# 个中 文字符经过UTF-8编码后通常会占用3个字节，而1个英文字符只占用1个字节


# len()函数计算的是str的字符数，如果换成bytes，len()函数就计算字节数：
print(len(b'ABC'))                         # 3
print(len(b'\xe4\xb8\xad\xe6\x96\x87'))    # 6
print(len('勇气'.encode('utf-8')))         # 6




# 要计算str包含多少个字符，可以用len()函数
print(len('A'))               # 1
print(len('勇气'))            # 2



```
</details>




























<details>
<summary><b> 字符串: 随机数 / 随机选择</b></summary>

```  

import random
random.choice( seq  )           # seq -- 可以是一个列表，元组或字符串

小案例
#!/usr/bin/python3
import random

print ("从 range(100) 返回一个随机数 : ",random.choice(range(100)))                       # 96
print ("从 1 到 6 返回一个随机数 : ",random.choice(range(1, 6)))                          # 5
print ("从列表中 [1, 2, 3, 5, 9]) 返回一个随机元素 : ", random.choice([1, 2, 3, 5, 9]))    # 3
print ("从字符串中 'Runoob' 返回一个随机字符 : ", random.choice('Runoob'))                 # b



-----------------------------------      ------------------------------------




随机数
import random
random.randrange ([start,] stop [,step])
    start -- 指定范围内的开始值，包含在范围内
    stop -- 指定范围内的结束值，不包含在范围内
    step -- 指定递增基数


#!/usr/bin/python3
import random
 
# 从 1-100 中选取一个奇数
print ("randrange(1,100, 2) : ", random.randrange(1, 100, 2))
 
# 从 0-99 选取一个随机数
print ("randrange(100) : ", random.randrange(100))




-----------------------------------      -----------------------------------    



随机数 2
random() 方法返回随机生成的一个实数，它在[0,1)范围内。

#!/usr/bin/python3
import random

# 第一个随机数
print ("random() : ", random.random())

# 第二个随机数
print ("random() : ", random.random())

运行后输出结果为：
random() :  0.09690599908884856
random() :  0.8732120512570916




-----------------------------------      ----------------------------------- 



shuffle() 方法将序列的所有元素随机排序
#!/usr/bin/python3
import random
 
list = [20, 16, 10, 5];
random.shuffle(list)
print ("随机排序列表 : ",  list)
 
random.shuffle(list)
print ("随机排序列表 : ",  list)

运行后输出结果为：
随机排序列表 :  [20, 5, 16, 10]
随机排序列表 :  [5, 20, 10, 16]


-----------------------------------      ----------------------------------- 


uniform() 方法将随机生成下一个实数，它在 [x,y] 范围内
x -- 随机数的最小值。
y -- 随机数的最大值。


#!/usr/bin/python3
import random

print("uniform(5, 10) 的随机浮点数 : ", random.uniform(5, 10))      #  5.862043348826824
print("uniform(7, 14) 的随机浮点数 : ", random.uniform(7, 14))      #  9.637770266443788




-----------------------------------      -----------------------------------  


生成两位小数的浮点数：
import random
round(random.uniform(5, 10), 2)
输出: 6.63







-----------------------------------   随机数: 时间戳   ----------------------------------- 

import time  # 引入time模块
ticks = time.time()
print("当前时间戳为:", ticks)               #  1584112467.7476895
millis = int(round(time.time() * 1000))
print(millis)                              # 1584112467748


```
</details>































<details>
<summary><b> 时间 / 日期 : </b></summary>

```  

获取时间戳:
import time  # 引入time模块
ticks = time.time()
print("当前时间戳为:", ticks)               #  1584112467.7476895
millis = int(round(time.time() * 1000))
print(millis)                              # 1584112467748



时间戳单位最适于做日期运算。但是1970年之前的日期就无法以此表示了。太遥远的日期也不行，
UNIX和Windows只支持到2038年




import time


print (time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()))
>>> 2016-04-07 10:29:46

print (time.strftime("%a %b %d %H:%M:%S %Y", time.localtime()))
>>> Thu Apr 07 10:29:46 2016
  
将格式字符串转换为时间戳
a = "Sat Mar 28 22:24:24 2016"
print (time.mktime(time.strptime(a,"%a %b %d %H:%M:%S %Y")))
>>> 1459175064.0



```
</details>




























<details>
<summary><b> try / cache </b></summary>

```  

捕获异常
python 并不是 try/cache , 而是 try/except

while True:
    try:
        x = int(input("请输入一个数字: "))
        break
    except ValueError:
        print("您输入的不是数字，请再次尝试输入！")


try-finally 语句无论是否发生异常都将执行最后的代码。        

使用 raise 语句抛出一个指定的异常:
x = 10
if x > 5:
    raise Exception('x 不能大于 5。x 的值为: {}'.format(x))


```
</details>










<details>
<summary><b> 函数: </b></summary>

```  

 
 如何返回多个值:
    函数的return 语句只能返回一个值，可以是任何类型
    因此，我们可以“返回一个 tuple类型，来间接达到返回多个值 

    def F1 ():
        略...
        return ( a,b )     # 也可以写作 return a, b

    (c, d )= F1()          # 也可以写作 c , d = F1 ( 9, 4 )


函数参数的使用不需要使用指定顺序：
def printinfo( name, age ):
   "打印任何传入的字符串"
   print ("名字: ", name)
   print ("年龄: ", age)
   return
 
#调用printinfo函数
printinfo( age=50, name="runoob" )

默认参数
调用函数时，如果没有传递参数，则会使用默认参数。以下实例中如果没有传入 age 参数，则使用默认值:
def printinfo( name, age = 35 ):
   print ("名字: ", name)
   print ("年龄: ", age)
   return


不定长参数 ( 一个 * 号 ):
def printinfo( arg1, *vartuple ):
   "打印任何传入的参数"
   print ("输出: ")
   print (arg1)
   print (vartuple)

printinfo( 70, 60, 50 )
输出: 
70
(60, 50)



加了两个星号 ** 的参数会以字典的形式导入
def printinfo( arg1, **vardict ):
   "打印任何传入的参数"
   print ("输出: ")
   print (arg1)
   print (vardict)
 
# 调用printinfo 函数
printinfo(1, a=2,b=3)
输出: 
1
{'a': 2, 'b': 3}


```
</details>










<details>
<summary><b> 循环: </b></summary>

```  


languages = ["C", "C++", "Perl", "Python"] 
for x in languages:
     print (x)



for i in range(1, 5):
    print(i)
输出:
1
2
3
4



# 该条件永远为true，循环将无限执行下去
while True:
    print(123)



也可以使用range指定区间的值：
for i in range(5,9) :
    print(i)


也可以使range以指定数字开始并指定不同的增量(甚至可以是负数，有时这也叫做'步长'):
for i in range(0, 10, 3) 

break 语句可以跳出 for 和 while 的循环体。
如果你从 for 或 while 循环中终止，任何对应的循环 else 块将不执行。

continue 语句被用来告诉 Python 跳过当前循环块中的剩余语句，然后继续进行下一轮循环


```
</details>



































# List(列表) / Tuple(元组) / Set(集合) / Dictionary(字典)
<details>
<summary><b> 简介 </b></summary>

```  

总结:
    Dictionary(字典):       特点:无序, 键必须是唯一的，但值则不必, 键必须是不可变的，如字符串，数字或元组
    
    Set(集合):              无序的 , 不重复的

    list(列表):             特点: 有序, 元素是可以改变的 (元组使用小括号，列表使用方括号)
                                举例: list1 = ['Google', 'Runoob', 1997, 2000];

    Tuple(元组):            与列表类似，不同之处在于元组的元素不能修改 (同样的, 元组中的元素值是不允许删除的)
                            (虽然元素不可改变,但它可以包含可变的对象，比如list列表)
                            可以使用del语句来删除整个元组 (del tup)
                                举例 : tup1 = ('Google', 'Runoob', 1997, 2000)
                                          

```
</details>









<details>
<summary><b> 各种转换 (字符串, 集合, 字典, 列表......) </b></summary>

```  

转换成字符串:
value = ('www.runoob.com', 14)
s = str(value)


int -> string:
python并不能像java一样，
在做拼接的时候自动把类型转换为string类型
故而需要进行一个类型转换，
譬如将print(1+"a")改为print(str(1)+"a")就可以了


转换:
list(seq)           将元组转换为列表

各种转换:
使用 list() 来转换为列表，列表为字典中的所有值:
dict = {'Sex': 'female', 'Age': 7, 'Name': 'Zara'}
list(dict.values())
>>> ['female', 7, 'Zara']



```
</details>












<details>
<summary><b> List(列表) </b></summary>

```  

列表 List : 

    创建一个列表，只要把逗号分隔的不同的数据项使用方括号括起来即可。如下所示：
    list1 = ['Google', 'Runoob', 1997, 2000];


列表(list)中的元素是可以改变的：
    特点: 有序 , 可以改变

a = 10
b = 20
list = [1, 2, 3, 4, 5 ];
a in list           # bool类型


增
list.append(obj)                在列表末尾添加新的对象(增加数据)
[1, 2, 3] + [4, 5, 6]	        列表相加
list.insert(index, obj)         将对象插入列表(可以指定位置)
list.extend(L)	                通过添加指定列表的所有元素来扩充列表





查
list = ['Google', 'Runoob', 1997, 2000];
list[0]

3 in [1, 2, 3]	True	    元素是否存在于列表中
list.index(x)	            返回列表中第一个值为 x 的元素的索引
list.count(obj)             统计某个元素在列表中出现的次数
len([1, 2, 3])	            长度/大小/容量/列表元素个数:
max(list)                   列表元素最大值/最小值
min(list)








更新  列表数据(直接赋值)
list[2] = 2001




删
del list[2]                     删除第三个元素
list.clear()                    清空列表
list.pop([index=-1])            移除列表中的一个元素（默认最后一个元素），并且返回该元素的值
list.remove(obj)                移除列表中某个值的第一个匹配项




对原列表进行排序
list.sort( key=None, reverse=False)



list.copy()             复制列表
['Hi!'] * 4	                重复(乘法)




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





迭代
for x in [1, 2, 3]: 
    print(x, end=" ")

L=['Google', 'Runoob', 'Taobao']
L[2]	'Taobao'	            读取第三个元素
L[-2]	'Runoob'	            从右侧开始读取倒数第二个元素: count from the right
L[1:]	['Runoob', 'Taobao']	输出从第二个元素开始后的所有元素



```
</details>











 

<details>
<summary><b> Tuple(元组) </b></summary>

```  

Tuple（元组）:
    元组（tuple）与列表类似，不同之处在于元组的元素不能修改,
    虽然tuple的元素不可改变，但它可以包含可变的对象，比如list列表

    元组中只包含一个元素时，需要在元素后面添加逗号，否则括号会被当作运算符使用
    tup1 = (50,)

    元组创建很简单，只需要在括号中添加元素，并使用逗号隔开即可:
        tup1 = ('Google', 'Runoob', 1997, 2000)
        tup2 = (1, 2, 3, 4, 5 )
        tup3 = "a", "b", "c", "d"                       # 不需要括号也可以
        type(tup3)
        <class 'tuple'>

    元组可以使用下标索引来访问元组中的值
    tup1[0]
    tup2[1:5]


    len((1, 2, 3))	            计算元素个数
    max(tuple)                  返回元组中元素最大值  (min(tuple) 最小值 )
    (1, 2, 3) + (4, 5, 6)		连接
    ('Hi!',) * 4	        	复制
    3 in (1, 2, 3)	        	元素是否存在 (返回 true )

L = ('Google', 'Taobao', 'Runoob')
L[2]	'Runoob'	            读取第三个元素
L[-2]	'Taobao'	            反向读取，读取倒数第二个元素
L[1:]	('Taobao', 'Runoob')	截取元素，从第二个开始后的所有元素    



```
</details>












<details>
<summary><b> Dictionary(字典) </b></summary>

```  

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

len(dict)                               计算字典元素个数，即键的总数
str(dict)                               输出字典，以可打印的字符串表示
type(variable)                           返回输入的变量类型，如果变量是字典就返回字典类型
key in dict                              如果键在字典dict里返回true，否则返回false

radiansdict.get(key, default=None)      返回指定键的值，如果值不在字典中返回default值 
                                        print ("Age 值为 : %s" %  dict.get('Age'))



如果 key 在 字典中，返回对应的值。如果不在字典中，则插入 key 及设置的默认值 default
dict = {'Name': 'Runoob', 'Age': 7}
print ("Age 键的值为 : %s" %  dict.setdefault('Age', None))
print ("Sex 键的值为 : %s" %  dict.setdefault('Sex', None))
>>> {'Age': 7, 'Name': 'Runoob', 'Sex': None}





增:
dict['School'] = "菜鸟教程"              添加信息

update() 函数把字典参数 dict2 的 key/value(键/值) 对更新到字典 dict 里
dict = {'Name': 'Runoob', 'Age': 7}
dict2 = {'Sex': 'female' }
dict.update(dict2)
>>> {'Name': 'Runoob', 'Age': 7, 'Sex': 'female'}





删:
del dict                                删除字典

pop() 方法删除字典给定键 key 所对应的值，返回值为被删除的值。key值必须给出
site= {'name': '菜鸟教程', 'alexa': 10000, 'url': 'www.runoob.com'}
site.pop('name')
>>> 菜鸟教程

popitem() 方法随机返回并删除字典中的最后一对键和值
site= {'name': '菜鸟教程', 'alexa': 10000, 'url': 'www.runoob.com'}
site.popitem()
>>> ('url', 'www.runoob.com')

del dict['Name']                         删除键 'Name'
dict.clear()                            清空字典
radiansdict.clear()                      删除字典内所有元素






改:
dict['Age'] = 8                         修改 Age 的值






查:
dict['Name']                            取值









获取 key :
dict = {'Name': 'Runoob', 'Age': 7}
dict.keys()
>>> dict_keys(['Name', 'Age'])

list(dict.keys())            
>>> ['Name', 'Age']


radiansdict.items()                     以列表返回可遍历的(键, 值) 元组数组
dict = {'Name': 'Runoob', 'Age': 7}
dict.items()
>>> [('Age', 7), ('Name', 'Runoob')]



print (dict['one'])       # 输出键为 'one' 的值
print (dict[2])           # 输出键为 2 的值
print (tinydict)          # 输出完整的字典
print (tinydict.keys())   # 输出所有键
print (tinydict.values()) # 输出所有值

构造函数 dict() 可以直接从键值对序列中构建字典如下：
dict(Runoob=1, Google=2, Taobao=3)



遍历
字典遍历
knights = {'gallahad': 'the pure', 'robin': 'the brave'}
for k, v in knights.items():
    print(k, v)


在序列中遍历时，索引位置和对应值可以使用 enumerate() 函数同时得到：
for i, v in enumerate(['tic', 'tac', 'toe']):
    print(i, v)

0 tic
1 tac
2 toe




```
</details>










<details>
<summary><b> Set(集合)  </b></summary>

```  

Set（集合） :
    无序 , 不重复元素

创建一个空集合必须用 set() 而不是 { }，因为 { } 是用来创建一个空字典


增:
s.add( x )          添加元素

s.update( x )       也可以添加元素，且参数可以是列表，元组，字典等
thisset = set(("Google", "Runoob", "Taobao"))
thisset.update({1,3})
>>> {1, 3, 'Google', 'Taobao', 'Runoob'}




删:
s.remove( x )           移除元素             如果元素不存在，则会发生错误 
s.discard( x )          也是移除集合中的元素，如果元素不存在，不会发生错误
s.pop()                 随机删除集合中的一个元素 ,会对集合进行无序的排列，然后将这个无序排列集合的左面第一个元素进行删除
s.clear()               清空集合




x.symmetric_difference(y)       返回两个集合中不重复的元素集合，即会移除两个集合中都存在的元素
x.isdisjoint(y)                 判断两个集合是否包含相同的元素，如果没有返回 True，否则返回 False
x.union(y)                      返回两个集合的并集，即包含了所有集合的元素，重复的元素只会出现一次
x.union(y, z) 




查:
len(s)                  计算集合元素个数
x in s                  判断元素是否在集合中存在  存在返回 True，不存在返回 False



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





































































# Other
<details>
<summary><b> 迭代器与生成器 </b></summary>

```  
迭代是Python最强大的功能之一，是访问集合元素的一种方式
迭代器对象从集合的第一个元素开始访问，直到所有的元素被访问完结束。迭代器只能往前不会后退
迭代器有两个基本的方法：iter() 和 next()。


list=[1,2,3,4]
it = iter(list)    # 创建迭代器对象
print (next(it))   # 输出迭代器的下一个元素

迭代器对象可以使用常规for语句进行遍历：
list=[1,2,3,4]
it = iter(list)    # 创建迭代器对象
for x in it:
    print (x, end=" ")



import sys         # 引入 sys 模块
list=[1,2,3,4]
it = iter(list)    # 创建迭代器对象
while True:
    try:
        print (next(it))
    except StopIteration:
        sys.exit()


```
</details>















































<details>
<summary><b> IO </b></summary>

``` 


-----------------------------------   读写:   ----------------------------------- 
r+	打开一个文件用于读写。文件指针将会放在文件的开头

rb+	以二进制格式打开一个文件用于读写。文件指针将会放在文件的开头

w+	打开一个文件用于读写。如果该文件已存在则打开文件，并从开头开始编辑，即原有内容会被删除。如果该文件不存在，创建新文件

wb+	以二进制格式打开一个文件用于读写。
    如果该文件已存在则打开文件，并从开头开始编辑，即原有内容会被删除。如果该文件不存在，创建新文件

a+	打开一个文件用于读写。如果该文件已存在，文件指针将会放在文件的结尾。
    文件打开时会是追加模式。如果该文件不存在，创建新文件用于读写






-----------------------------------   只读:   ----------------------------------- 
r	以只读方式打开文件。文件的指针将会放在文件的开头。这是默认模式

rb	以二进制格式打开一个文件用于只读。文件指针将会放在文件的开头





-----------------------------------   只写:   ----------------------------------- 
w	打开一个文件只用于写入。如果该文件已存在则打开文件，并从开头开始编辑，即原有内容会被删除。如果该文件不存在，创建新文件。

wb	以二进制格式打开一个文件只用于写入。
    如果该文件已存在则打开文件，并从开头开始编辑，即原有内容会被删除。如果该文件不存在，创建新文件





-----------------------------------   追加:   ----------------------------------- 
ab+	以二进制格式打开一个文件用于追加。如果该文件已存在，文件指针将会放在文件的结尾。如果该文件不存在，创建新文件用于读写。

a	打开一个文件用于追加。
    如果该文件已存在，文件指针将会放在文件的结尾。
    也就是说，新的内容将会被写入到已有内容之后。如果该文件不存在，创建新文件进行写入

ab	以二进制格式打开一个文件用于追加。
    如果该文件已存在，文件指针将会放在文件的结尾。
    也就是说，新的内容将会被写入到已有内容之后。如果该文件不存在，创建新文件进行写入



指定写入格式 encoding="UTF-8" , 这样就不会乱码了

基本示例 - 写:
f = open("/tmp/foo.txt", "w", encoding="UTF-8")
f.write( "Python 是一个非常好的语言。\n是的，的确非常好!!\n" )
f.close()



基本示例 - 读:
f = open("/tmp/foo.txt", "r", encoding="UTF-8")
str = f.read()
print(str)
f.close()


```
</details>


























<details>
<summary><b> 操作 Windows 系统剪贴板 Clipboard </b></summary>

```  



向剪贴板写入字符串:
import os
def addToClipBoard(text):
    command = 'echo ' + text.strip() + '| clip'
    os.system(command)

#example
addToClipBoard('Hello, I am a string.')





向剪贴板写入系统时间:
import os
def addToClipBoard(text):
    command = 'echo ' + text.strip() + '| clip'
    os.system(command)

import time
timestr = time.strftime("%Y-%m-%d %H:%M:%S",time.localtime(time.time()))
addToClipBoard(timestr)






读取剪贴板的内容:
from tkinter import Tk
r = Tk()

# read the clipboard
c = r.clipboard_get()
print(c)


```
</details>


























<details>
<summary><b> 操作 json  </b></summary>

```  

https://www.runoob.com/python3/python3-json.html


```
</details>



















<details>
<summary><b> About SQL (数据库 MySQL)</b></summary>

```  

Python3 MySQL 数据库连接 - PyMySQL 驱动
可以使用以下命令安装最新版的 PyMySQL：
$ pip3 install PyMySQL


首先 , 新建一个数据库+数据表, 用来测试:

-- 删除数据库
drop database IF EXISTS `zzza9d2g5k4t1b0k`;

-- 创建 数据库:
CREATE DATABASE IF NOT EXISTS `zzza9d2g5k4t1b0k` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

-- 切换回
use `zzza9d2g5k4t1b0k`;

-- 创建表
CREATE TABLE IF NOT EXISTS `user`(
`id` int(20) unsigned not null DEFAULT 0,
`money` DECIMAL(20,2) NOT NULL DEFAULT '0.00',
`username` VARCHAR(100) not null DEFAULT '', 
`password` VARCHAR(40)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入insert数据:
insert into `user`(username,password) values('HUAWEI','mate20');
insert into `user`(username,password) values('APPLE','IPHONE_5S');
insert into `user`(username,password) values('OPPO','R11');		





然后, 测试一下有没有链接成功吧
#!/usr/bin/python3
import pymysql
# 打开数据库连接  主机地址 , 用户名(root) 密码(root) , 数据库名(zzza9d2g5k4t1b0k)
db = pymysql.connect("localhost", "root", "root", "zzza9d2g5k4t1b0k")  
cursor = db.cursor()                        # 使用 cursor() 方法创建一个游标对象 cursor
cursor.execute("SELECT VERSION()")          # 使用 execute()  方法执行 SQL 查询
data = cursor.fetchone()                    # 使用 fetchone() 方法获取单条数据
print("Database version : %s " % data)      # 打印输出 数据库的版本
db.close()      
成功输出:  Database version : 5.5.53 
连接成功!


接下来测试 CRUD (增删改查): 

增( 返回增加的条数 -> int 类型):
#!/usr/bin/python3
import pymysql
# 打开数据库连接  主机地址 , 用户名(root) 密码(root) , 数据库名(zzza9d2g5k4t1b0k)
db = pymysql.connect("localhost", "root", "root", "zzza9d2g5k4t1b0k")
cursor = db.cursor()                        # 使用 cursor() 方法创建一个游标对象 cursor
sql = """INSERT INTO user(username , password) VALUES ('MacOS', 'YXB')"""     # SQL 语句
try:
    aa = cursor.execute(sql)     # 执行sql语句
    db.commit()             # 提交到数据库执行
    print("成功 insert 了:   " , aa , "  条数据.")
except:
    db.rollback()           # 如果发生错误则回滚
db.close()                  # 关闭数据库连接






删
#!/usr/bin/python3
import pymysql
# 打开数据库连接                    账户    密码         数据库名称
db = pymysql.connect("localhost", "root", "root", "zzza9d2g5k4t1b0k")
cursor = db.cursor()            # 使用cursor()方法获取操作游标
sql = "DELETE FROM user WHERE username = '%s'  " % ('OPPO')      # SQL 删除语句
try:
   aaa = cursor.execute(sql)          # 执行SQL语句
   db.commit()                  # 提交修改
   print(aaa)                   # 成功的条数 (失败返回 0 )
except:
   db.rollback()                # 发生错误时回滚
db.close()                      # 关闭数据库连接









改
#!/usr/bin/python3
import pymysql
# 打开数据库连接                    账户    密码         数据库名称
db = pymysql.connect("localhost", "root", "root", "zzza9d2g5k4t1b0k")
cursor = db.cursor()            # 使用cursor()方法获取操作游标
sql = "UPDATE user SET password = 'R12'  WHERE username = '%s'  " % ('OPPO')      # SQL 更新语句
try:
   aaa = cursor.execute(sql)          # 执行SQL语句
   db.commit()                  # 提交到数据库执行
   print(aaa)                   # 成功的条数 (失败返回 0 )
except:
   db.rollback()                # 发生错误时回滚
db.close()                      # 关闭数据库连接







查
#!/usr/bin/python3
import pymysql

# 打开数据库连接                    账户    密码         数据库名称
db = pymysql.connect("localhost", "root", "root", "zzza9d2g5k4t1b0k")
cursor = db.cursor()            # 使用cursor()方法获取操作游标
sql = "SELECT * FROM `user`"    # SQL 查询语句
try:
    aaa = cursor.execute(sql)         # 执行SQL语句
    results = cursor.fetchall() # 获取所有记录列表
    print(aaa)                  # 查询到的总数:  8 条
    print(type(aaa))            # 变量类型   : int类型
    print(type(results))        # <class 'tuple'> 
    for row in results:         # 循环遍历
        username = row[2]
        password = row[3]
        print("username   =   %s,  password   =   %s " % (username, password))
except:
    print("Error: unable to fetch data")
db.close()                      # 关闭数据库连接









用面向对象的思维来写:
import pymysql
class DB():
    def __init__(self, host='localhost', port=3306, db='', user='root', passwd='root', charset='utf8'):
        self.conn = pymysql.connect(host=host, port=port, db=db, user=user, passwd=passwd, charset=charset)  # 建立连接
        self.cur = self.conn.cursor(cursor = pymysql.cursors.DictCursor)   # 创建游标，操作设置为字典类型

    def __enter__(self):
        return self.cur    # 返回游标

    def __exit__(self, exc_type, exc_val, exc_tb):
        self.conn.commit()    # 提交数据库并执行
        self.cur.close()      # 关闭游标
        self.conn.close()     # 关闭数据库连接

if __name__ == '__main__':
    with DB(host='localhost',user='root',passwd='root',db='zzza9d2g5k4t1b0k') as db:
        db.execute('select * from user')
        print(db)
        for i in db:
            print(i)









以下代码使用变量向SQL语句中传递参数:
好像 %s 要带上单引号?
user_id = "test123"
password = "password"
con.execute('insert into Login values( %s,  %s)' % \(user_id, password))
sql = "DELETE FROM user WHERE username = '%s'  " % ('OPPO')       要带上单引号?



```
</details>






































<details>
<summary><b> 正则表达式 </b></summary>

```  

前言:
    re.I 忽略大小写
    re.L 表示特殊字符集 \w, \W, \b, \B, \s, \S 依赖于当前环境
    re.M 多行模式
    re.S 即为' . '并且包括换行符在内的任意字符（' . '不包括换行符）
    re.U 表示特殊字符集 \w, \W, \b, \B, \d, \D, \s, \S 依赖于 Unicode 字符属性数据库
    re.X 为了增加可读性，忽略空格和' # '后面的注释





import re
print(re.match('www', 'www.runoob.com').span())  # 在起始位置匹配
print(re.match('com', 'www.runoob.com'))         # 不在起始位置匹配
>>> 
(0, 3)
None


line = "Cats are smarter than dogs"
matchObj = re.match( r'(.*) are (.*?) .*', line, re.M|re.I)      # .* 表示任意匹配除换行符（\n、\r）之外的任何单个或多个字符
 
if matchObj:
   print ("matchObj.group() : ", matchObj.group())          >>> Cats are smarter than dogs
   print ("matchObj.group(1) : ", matchObj.group(1))        >>> Cats
   print ("matchObj.group(2) : ", matchObj.group(2))        >>> smarter
else:
   print ("No match!!")




re.search方法
    扫描整个字符串并返回第一个成功的匹配









检索和替换
    re.sub用于替换字符串中的匹配项
import re
phone = "2004-959-559 # 这是一个电话号码"

# 删除注释
num = re.sub(r'#.*$', "", phone)
>>> 2004-959-559

# 移除非数字的内容
num = re.sub(r'\D', "", phone)
>>> 2004959559





compile 函数
    用于编译正则表达式，生成一个正则表达式（ Pattern ）对象，供 match() 和 search() 这两个函数使用

pattern = re.compile(r'\d+')                    # 用于匹配至少一个数字
pattern.match('one12twothree34four')            # 默认从头部查找，没有匹配

import re
pattern = re.compile(r'\d+')                                     用于匹配至少一个数字
m = pattern.match('one123456789twothree34four', 3, 99)           3, 99 意思是:  从哪里开始查找, 到哪里结束
print(m.group(0))               >>> 123456
print(m.start(0))               >>> 3
print(m.end(0))                 >>> 9
print(m.span(0))                >>> (3, 9)




pattern = re.compile(r'([a-z]+) ([a-z]+)', re.I)   # re.I 表示忽略大小写
m = pattern.match('Hello World Wide Web')
m.group(0)                  >>> 'Hello World'
m.group(2)                  >>> 'World'             返回第二个分组匹配成功的子串




findall
    在字符串中找到正则表达式所匹配的所有子串，并返回一个列表，如果没有找到匹配的，则返回空列表

re.findall(string[, pos[, endpos]])
    string 待匹配的字符串
    pos 可选参数，指定字符串的起始位置，默认为 0
    endpos 可选参数，指定字符串的结束位置，默认为字符串的长度

import re
pattern = re.compile(r'\d+')   # 查找数字
result1 = pattern.findall('runoob 123 google 456')              >>> ['123', '456']
result2 = pattern.findall('run88oob123google456', 0, 10)        >>> ['88', '12']


finditer
    和 findall 类似，在字符串中找到正则表达式所匹配的所有子串，并把它们作为一个迭代器返回
import re
it = re.finditer(r"\d+","12a32bc43jf3") 
for match in it: 
    print (match.group() )    
>>>
12 
32 
43 
3    







区别:
    re.match 与 re.search的区别:
        re.match只匹配字符串的开始，如果字符串开始不符合正则表达式，则匹配失败，函数返回None , 
        而re.search匹配整个字符串，直到找到一个匹配

    match 和 search 是匹配一次 
    findall 匹配所有


```
</details>
























<details>
<summary><b> 面向对象  </b></summary>

```  

__init__ 方法:
类有一个名为 __init__() 的特殊方法（构造方法），该方法在类实例化时会自动调用，像下面这样：
def __init__(self):
    self.data = []
类定义了 __init__() 方法，类的实例化操作会自动调用 __init__() 方法    


类的方法与普通的函数只有一个特别的区别: 
    它们必须有一个额外的第一个参数名称, 按照惯例它的名称是 self (这个是自己自定义的)
    self 代表的是类的实例，代表当前对象的地址，而 self.class 则指向类
class Test:
    def prt(self):
        print(self)
        print(self.__class__)
 
t = Test()
t.prt()


类的私有属性:
    __private_attrs：
        两个下划线开头，声明该属性为私有 , 不能在类的外部被使用或直接访问。
        在类内部的方法中使用时 self.__private_attrs

类的私有方法:
    __private_method：两个下划线开头，声明该方法为私有方法，只能在类的内部调用 ,
    不能在类的外部调用。self.__private_methods




```
</details>




























# 区别:
容易混淆的概念
<details>
<summary><b>is == 区别</b></summary>

```  

is 与 == 区别：
    is 用于判断两个变量引用对象是否为同一个， 
    == 用于判断引用变量的值是否相等

```
</details>

















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
<summary><b> Django </b></summary>

```  

这个教程可以, 简短, 不废话
    https://www.bilibili.com/video/av79764564?p=2

第一步: 安装
打开 Windows 的cmd , 输入指令:
pip install Django==3.0.3 -i https://pypi.tuna.tsinghua.edu.cn/simple

还可以从Github进行源码安装, 这里不再赘述, 网上有教程

查看 Django 是否安装成功?
cmd输入:
python -m django --version

输出 版本号, 表示安装成功




创建一个项目 (DemoTestYXB 为创建的项目名称):
django-admin startproject DemoTestYXB

创建一个应用 (vvv1 为应用的名称):
python manage.py startapp vvv1



settings.py 注册这个 app
在这里面:
INSTALLED_APPS = [
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
    'vvv1',
]

在 vvv1/views.py 里面的 写:
from django.http import HttpResponse
from django.shortcuts import render
def index_view(request):
    return HttpResponse('Hello YXB')
待会会访问这个函数




在 urls.py里面配置 path('hello/', views.index_view) 
urlpatterns = [
    path('admin/', admin.site.urls),
    path('hello/', views.index_view),
]


启动 Django 里面内置的服务器:
python manage.py runserver localhost:8866

浏览器访问:  http://localhost:8866
访问到 Django 默认的页面

浏览器访问:  http://localhost:8866/hello/ 
可以通过上面定义的 hello , 访问到 views.py 下面的 index_view 函数 , 
从而在页面上输出: Hello YXB




但是这种并不能直接访问页面, 而是以字符串的方式返回,
怎么才能访问html页面呢?

首先 ,
在应用 vvv1 下面, 新建一个 Templates 文件夹(注意, 必须是这个名称, 是固定写法),
然后新建一个html文档 , index.html

然后在 views.py 新建一个 函数 V_web:
表示跳转至 index.html
def V_web(request):
    context={
        'title':'hello i am html file...'
    }
    return render(request , 'index.html' , context)

在 index.html 中可以用 {{title}}  来取上面 V_web 里面 context 里面定义的 'title' 的值


然后在 urls.py 的 urlpatterns 里面写:
urlpatterns = [
    path('admin/', admin.site.urls),
    path('hello/', views.index_view),
    path('page/', views.V_web),
]
表示 浏览器访问 :   http://localhost:8866/page/  
可以跳转到 V_web 函数 , 从而跳转到 index.html


```
</details>














# Python 爬虫
<details>
<summary><b> 编码 / 乱码  </b></summary>

```  

写爬虫的时候会遇到 文件编码乱码的问题, 查看 字符串 那一章节有详细解决方法

```
</details>



















<details>
<summary><b> 获取网页源码 </b></summary>

```  

#!/usr/bin/python3
# -*- coding: UTF-8 -*-

import requests

url = 'https://gaokao.koolearn.com/yingyu/yuedu/6.html'
header = {"User-Agent": "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.133 Safari/534.16"}

con = requests.get(url, headers=header)
r = con.content
print(r.decode('utf-8'))

```
</details>























<details>
<summary><b> Xpath </b></summary>

```  

案例:
<a target="_blank" href="http://gaokao.koolearn.com" class="entry_tit">高考阅读理解真题—社会生活类第九篇</a>

# 找出 class='entry_tit' 的 a标签的 text (是一个列表)
xpath_code = html.fromstring(code)                        # 将源代码转换为 xpath 格式
h3 = xpath_code.xpath("//a[@class='entry_tit']/text()")
print(h3)
输出:
    ['高考阅读理解真题—社会生活类第十篇', '高考阅读理解真题—社会生活类第九篇']


# 找出 class='entry_tit' 的 a标签的 链接 (是一个列表)
h3 = xpath_code.xpath("//a[@class='entry_tit']/@href")
输出:
    ['http://gaokao.koolearn.com/20181227/1201859.html', 'http://gaokao.koolearn.com/20181227/1201845.html']


# 找出 class='xqy_core_text' 的 div 下面的 p 标签的 text
Article_content = xpath_code.xpath("//div[@class='xqy_core_text']/p/text()")


```
</details>









