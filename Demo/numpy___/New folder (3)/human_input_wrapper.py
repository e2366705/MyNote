from ctypes import CDLL, c_short, c_wchar, byref, wintypes
import ctypes, pickle, socket, time


#   https://zhidao.baidu.com/question/266291349.html ->  对应键盘 ASCII 值
#   0x77 ->  F8
#  如果按下 F8键 就报一个异常 , 并且终止程序
def get_state():
    if winapi.GetAsyncKeyState(0x77) & 1:
        raise Exception


winapi = ctypes.windll.user32


# 调用 dll 库
human_input = CDLL('./plugin/human_input.dll')


print('request sent')


with socket.socket() as sock:
    sock.connect(('113.245.224.89', 3002))
    sock.sendall(pickle.dumps(human_input.get()))
    human_input.set(pickle.loads(sock.recv(1024)))
print('result received')


def get_virtual_key_code(char):
    return c_short(winapi.VkKeyScanW(c_wchar(char))).value


def press(*args):
    # 键入字符，支持组合键
    get_state()
    if not len(args):
        return
    key = get_virtual_key_code(args[0]) if isinstance(args[0], str) else args[0]
    try:
        human_input.key_down(key, True)
        time.sleep(0.1)
        press(*args[1:])
    finally:
        human_input.key_down(key, False)
        time.sleep(0.1)


# 键入字符串，仅支持大小写字母及数字 (参数 , 你要输入的字符串 )
def type(string):
    get_state()
    for char in string:
        key = get_virtual_key_code(char)
        print(key)
        if key < 0:
            continue
        if key & 0x100:
            press(0xa0, key & 0xff)
        else:
            press(key & 0xff)


 # 鼠标点击：1左键，2右键
def click(button):
    get_state()
    human_input.button_click(button)


# 滚轮滚动 (正数往上 , 负数往下 )
def scroll(count):
    get_state()
    human_input.mouse_scroll(count)



# 找到引用程序 -> 返回一串数字
# 没找到 -> 返回 0
# 参数是: 句柄
def get_window(handle):
    p,q = winapi.FindWindowW(0, handle) , winapi.FindWindowW(0 , handle)
    #哪其中有一个是0的时候会返回另外一个
    return p if p else q
    # 0 是桌面句柄
    # return 0


# 鼠标移动到指定位置(严格模式)
def move_to_ex(args):
    print("move_to_ex 调用了.....")
    get_state()
    p = wintypes.POINT(*args)
    winapi.ClientToScreen(get_window(), byref(p))
    human_input.move_absolute(p.x, p.y)


# 鼠标移动到指定位置
# 比如说，游戏里面有个按钮要点击 你需要move_to([371,422]) 如果完全忠实执行 每次都移动到这个点，再点击 就会被行为检测
# 人类行为不会那么准的 于是我加了个(-3,3)范围内的偏移  也就是move_to_ex才是真正的move_to 就有一定机率0会偏移到负数轴那边
# 所以我这个move_to里面还有个转换坐标的设计
def move_to(args):
    get_state()
    print("move_to函数调用......")
    import numpy as np
    return move_to_ex(np.array(args) + np.random.binomial(6, 0.5, 2) - 3)


 # 鼠标进行指定偏移
def move_relative(args):
    get_state()
    human_input.move_relative(*args)


# 使用剪切板粘贴文字
def write_clipboard(string):
    get_state()
    human_input.write_clipboard(string)
    press(0xa2, 'v')


 # 读取剪切板上的文字
def read_clipboard():
    get_state()
    buffer = ctypes.create_unicode_buffer(1000)
    human_input.read_clipboard(buffer)
    return buffer.value


# for _ in range(10):
    # print(123)
    # time.sleep(1)

    # move_to([3, 3])
    # time.sleep(2)

    # move_to([700,200])
    # time.sleep(2)
