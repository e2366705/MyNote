# Git 的具体操作:
```

查看路径：pwd

YXB

查看有哪些文件：ls  ( ll 同理 )

查看用户的信息：git config -l

查看用户的用户名：git config user.name

查看用户的邮箱：$git config user.email

修改用户名和邮箱地址：
$ git config --global user.name "username"
$ git config --global user.email "email"

```


## idea 把项目上传到GitHub:
### 教程转载自:  https://blog.csdn.net/u011853294/article/details/53228720
```  

找到菜单栏的 : VCS -> import into version control -> creat Git repository

这时项目目录中的文件名会变成红色，表示文件为提交到本地git

右击工程文件 ->git->add，这时文件名会变成绿色

右击工程文件 ->git->commit,提交到本地git。至此，本地git已commit完毕


```










# 下载 GitHub 单个文件夹 / 单个文件
```  

有时候下载 github 上面的项目, 不需要下载全部, 我需要下载单独的某个文件夹, 但是 GitHub 并没有直接提供这个功能 
所以,
需要插件帮我实现这个功能:
Google chrome 浏览器插件 :  GitZip for github
双击你要下载的文件夹, 左边会出现一个小勾勾,
右下角会出现一个下载按钮
点击就可以直接下载单个文件夹了   


```








# 教程1 (共计2):
```

新建Github,推送流程 ( 更新仓库教程在下面 ):

文件夹右键, 点击 git bash here
清空 删除 缓存:                git rm -r --cached .
初始化git暂存区                git init
添加所有文件                   git add -f *
添加备注信息                   git commit -m "xxxxxxxxx"
连接到你Github新建的仓库        git remote add origin https://github.com/e2366705/xxxxxx.git
推送                          git push -u origin master
最后: 推送完成
PS:
      这一步可可能会报错: warning: LF will be replaced by CRLF in xxx 
      用下面这句代码来解决:
      git config --global core.autocrlf false

      这一步可可能会报错: This is usually caused by another repository pushing to the same ref.
      解决方法:
               git pull origin master --allow-unrelated-histories  (意思是: 允许不相关的历史)
               然后再去执行: git push -u origin master	


```



# 教程2 (共计2):
## 更新仓库文件 怎么操作???
```

git rm -r --cached .
git add -f *
git commit -m "git commit -m..Emmmm...YOU know that..."
git push -u origin master
以上内容:更新仓库文件4连发,一步都少不了!!!
PS:
   查看 哪些文件改变了:
   git status

```



# 删除操作：
```

在github上只能删除仓库,却无法删除文件夹或文件, 所以只能通过命令来解决:
首先进入你的master文件夹下, Git Bash Here ,打开命令窗口
git remote add origin https://github.com/e2366705/xxxxx.git
git rm -f --cached [按下 Tab键]   # 查看还有哪些文件夹
git rm -r --cached target            # 删除target文件夹
git commit -m '删除了target'      # 提交,添加操作说明
git push -u origin master 	  # 修改完了,记得提交!!!不然不生效

但你要删除某个文件时候:
	rm xxxxx.txt
	git add xxxxx.txt
	./update.sh

```



# clone 克隆/下载/拉取 操作:
```

1:git clone 不指定分支:
git clone https://github.com/somebody/XXXXXX.git

2.git clone 指定分支 [nnnname__ 是仓库的指定分区(比如master之类的) ]:
git clone -b nnnname__ https://github.com/somebody/XXXXXX.git
```


# Github README 添加 图片
```

![Image text](https://raw.githubusercontent.com/e2366705/aaa/master/image/readme.png)
![Image text]()


```



# 其他：
```

1.查看本地分支 git branch
2.查看远程分支 git branch -r

删除本地分支(这里的 BranchName 是指的是你的分支名称)
git branch -d BranchName
   + 
删除远程分支(这里的 BranchName 是指的是你的分支名称)
git push origin --delete BranchName

//清空 Git 缓存: [删除]
git rm -r --cached .

删除 本地git目录:
rm .git -rf


如何在git中删除指定的文件和目录
部分场景中，我们会希望删除远程仓库（比如GitHub）的目录或文件。

拉取远程的Repo到本地（如果已经在本地，可以略过）
git clone https://github.com/e2366705/ShiYanLou.git

在本地仓库删除文件
git rm 我的文件

在本地仓库删除文件夹
git rm -r 我的文件夹/
此处-r表示递归所有子目录，如果你要删除的，是空的文件夹，此处可以不用带上-r 提交代码

git commit -m"我的修改"

推送到远程仓库（比如GitHub）
git push origin 分支名称


这篇文章非常好
https://blog.csdn.net/maguanghui_2012/article/details/79457281



强制push:
git push -u origin master -f


```