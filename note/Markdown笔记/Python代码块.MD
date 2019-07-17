# python 播放音频文件
```  
import time
import pygame

def Play_Aduio_File(Aduio_file_name):

    folder_path = ""

    Aduio_file_path = folder_path + Aduio_file_name

    pygame.mixer.init()  # 初始化音频
    track = pygame.mixer.music.load(Aduio_file_path)  # 载入音乐文件
    pygame.mixer.music.play()  # 开始播放
    time.sleep(2)  # 播放 xx 秒
    pygame.mixer.music.stop()  # 停止播放


# Play_Aduio_File("Link_Error.wav")

```



# 截取字符串
```  
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
