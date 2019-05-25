import human_input_wrapper as human
import video_output_wrapper as screen_shots
import image_wrapper
import time

# 填写你要 截图的句柄
handle =  human.get_window("Windows 任务管理器")
print(handle)

# time.sleep(5)

# 加载 句柄
screen_shots.load_window(handle)

# 选择 截屏的范围
pic_data = screen_shots.capture(0,0,1800,600)
# print(pic_data)

# 保存图片
image_wrapper.save_image('./1.png' , pic_data)


































