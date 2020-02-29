# CSS
* 看起来简单, 实际复杂的没边...



<details>
<summary><b> 隐藏一个元素? </b></summary>

```  

怎么隐藏一个元素?? 



第一种:  display: none
经典的display隐藏元素,这个是彻底的隐藏了元素，不占据空间，也就不影响布局，当然也无法响应事件
但是这个元素会从页面消失, 也没法去点击
    <h1 style="display: none; ">1111111111111</h1>
    <h1>2222222222222</h1>


    <hr>
    <hr>
    <hr>
    <hr>
    <hr>

第二种:  opacity:0;
    opacity是用来设置元素透明度的，但当设置成0的时候也就相当于隐藏元素了
    因此，元素依然存在原来的位置，占据空间也可响应事件
    占据空间，可以点击
    <h1 style="  opacity:0; ">1111111111111</h1>
    <h1>2222222222222</h1>


    <hr>
    <hr>
    <hr>
    <hr>
    <hr>

第三种: visibility:hidden;
    opacity 属性，被隐藏的元素依然会对我们的网页布局起作用。
    与 opacity 唯一不同的是它不会响应任何用户交互
        visible    元素正常显示
        hidden     隐藏元素，但是其他元素的布局不改变，相当于此元素变成透明。要注意若将其子元素设为 visibility: visible，则该子元素依然可见
    <h1 style="  visibility:hidden; ">1111111111111</h1>
    <h1>2222222222222</h1>

当然还有很多方式隐藏元素, 详细可以参考:
参考资料:   https://juejin.im/post/584b645a128fe10058a0d625






```
</details>
