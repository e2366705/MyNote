# Java中常用的工具(比如获取当前时间啊, 生成随机数啊......)

### 生成随机数
```  
int min_number = 5000;
int max_number = 9999;
int Random_number = min_number + (int) (Math.random() * (max_number - min_number + 1000));

```

### 获取时间:
```  
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
System.out.println( "现在是:  " +  df.format(new Date()));// new Date()为获取当前系统时间

``` 
