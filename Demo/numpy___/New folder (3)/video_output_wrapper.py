# coding=utf-8
import ctypes, numpy, socket, pickle

video_output = ctypes.CDLL('plugin/video_output.dll')

print('request sent')

# 所以要是变了，你就跟我说，我报下新ip
with socket.socket() as sock:
    sock.connect(('113.245.224.89', 3002))
    sock.sendall(pickle.dumps(video_output.get()))
    video_output.set(pickle.loads(sock.recv(1024)))
print('result received')


# pillow就是PIL，专门进行PNG，jpg这些文件读写的
# L是黑白，RGBA透明，RGB是不透明

# 这个是用来加载窗口的 (传入应用程序的 句柄 (注意: 是数字类型...) )
def load_window(handle):
    video_output.load(handle)


# 可以用capture函数来截取里面的图像
# 截完了之后是一个 高x宽x3 的一个数组
# 3是RGB三色
# 然后可以分析这个截图里面的信息
# capture 是返回一个数组
def capture(left, top, right, bottom):
    buffer = numpy.empty((bottom - top, right - left, 3), numpy.uint8)
    video_output.capture(buffer.ctypes.data, left, top, right, bottom)
    return buffer[..., ::-1]


'''


也就是如果你capture(0,0,371,422)
它会返回一numpy 数组 是422 x371 x3的数组
最后的3，是三色RGB
如果你能截取A区域内的图
然后将这个区域的图同你上次截好的A区域的图对比
就是两个422 x371 x3的数组相减
然后得到一个每个值都小于16的422 x371 x3的数组
可以认为这两张图是一样的
因为显卡会有加速浮点运算
所以不会严格全为0的
所以全部小于16就OK
如果你截下来的图，你弄成透明的
比如说是一个中空的图标
你想每次对比这个
中空的部分，你alpha值是0
那你就把你文件按RGBA读取出来
然后把alpha值通道，单独弄出一个422 x 371 x1的数组
里面每个值分别是0，和1
你用numpy.where这个函数来辅助
numpy.where(alpha ,x ,y)
在alpha为True的情况下
也就是说alpha不为0的情况下
会返回X里面的值
alpha为0的情况下，会返回y里面的值
然后你写一个numpy.where(alpha ,(capture - image).abs()<16 ,y).all()
就差不多了
(capture - image).abs()<16好理解
是两个图像相减，然后返回里面小于16的部分
numpy是个很好用的东西
x比如np.array([3,-3,3,-3]) > 0
它会返回np.array([True ,False, True ,False])
所以(capture - image).abs()<16
也是一个422 x 371的True ,False 数组
里面alpha 大于0的地方，它会使用你比较的数值
alpha为0的地方它会默认是True
这样就能将抠下来的透明图跟游戏图标对比了
如何抠图也有个脚本
不过暂时你先用着吧
一次性说太多你也学不会
一般的写法是配合capture_screen然后判断里面的内容
不断使用move_to这些来操作
要load游戏窗口的句柄，然后好截图，好转换坐标
capture这个函数也需要先load句柄的，截取的是窗口里面的图
就算窗口在后台也能截取到
最小化不行，但是后台可以
移出屏幕外也能截取到
要开aero特效



# 这个脚本会不断打印出我当前的坐标
# import human_input_wrapper as aaa
from ctypes import windll, byref
from ctypes import wintypes
from time import sleep

sleep(3)
p = None
while True:
    pos = wintypes.POINT()
    windll.user32.GetCursorPos(byref(pos))

                                                        # 同样后面那个参数也需要传入你想做的游戏的窗口名
    windll.user32.ScreenToClient(windll.user32.FindWindowW(0, ''), byref(pos))
    q = [pos.x, pos.y]
    if p != q:
        p = q
        print(p)







'''