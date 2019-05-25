import numpy, PIL.Image


# 读取图片
# read_image('./1.png','RGBA')
# 比如这样，就是读取1.png，以RGBA的格式
def read_image(path, mode):
    return numpy.asarray(PIL.Image.open(path).convert(mode))





def save_image(path, image):
    return PIL.Image.fromarray(image).save(path)
