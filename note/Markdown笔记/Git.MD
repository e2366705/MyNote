# Git
   <details>
   <summary><b> 基本 </b></summary>

   ```
   查看路径：pwd

   查看有哪些文件：ls  ( ll 同理 )

   查看用户的信息：git config -l

   查看用户的用户名：git config user.name

   查看用户的邮箱：$git config user.email

   修改用户名和邮箱地址：
   $ git config --global user.name "username"
   $ git config --global user.email "email"
      [不需要输入密码, 密码框会自己弹出来]

   ```
   </details>

















   <details>
   <summary><b> clone 克隆/下载/拉取 </b></summary>

   ```
   1:git clone 不指定分支:
   git clone https://github.com/somebody/XXXXXX.git

   2.git clone 指定分支 [nnnname__ 是仓库的指定分区(比如master之类的) ]:
   git clone -b nnnname__ https://github.com/somebody/XXXXXX.git

   ```
   </details>






















<details>
<summary><b> idea 把项目上传到GitHub </b></summary>

```
教程转载自:  https://blog.csdn.net/u011853294/article/details/53228720

找到菜单栏的 : VCS -> import into version control -> creat Git repository

这时项目目录中的文件名会变成红色，表示文件为提交到本地git

右击工程文件 ->git->add，这时文件名会变成绿色

右击工程文件 ->git->commit,提交到本地git。至此，本地git已commit完毕

```
</details>






















<details>
<summary><b> Github README 添加 图片 </b></summary>

```

![Image text](https://raw.githubusercontent.com/e2366705/aaa/master/image/readme.png)
![Image text]()

```
</details>






















<details>
<summary><b> 一键更新脚本 </b></summary>

```
#!/bin/sh

# 备注:
# 动态获取今天的时间+日期
# ---------------------------------------
function get_date_30daysbefore(){
 sec=`date -d $1 +%s`
 sec_30daysbefore=$((sec - 86400*30))
 days_before=`date -d @$sec_30daysbefore +%F`
 echo $days_before
}

if [ $# == 1 ]; then
 today=$1
 dates_30_ago=`get_date_30daysbefore $1`
else
 today=`date -d -1days '+%Y-%m-%d'`
 dates_30_ago=`date -d -30days '+%Y-%m-%d'`
fi

echo $today
echo $dates_30_ago
# ---------------------------------------



echo -e "\033[44m 显示为:蓝底白字 -背景颜色范围:40-47 \033[0m"

# 备注:
# 脚本自动化更新代码到 Github =>
# ---------------------------------------
echo -e "\033[44m (=^_^=)  Auto Updata Code...  (=^_^=) \033[0m"
echo -e "\033[44m input => ./update.sh toStart Updata Code... \033[0m"
echo " "
echo " "

# 清空缓存      (Git命令)
echo -e "\033[44m----------------------- 1: rm -f --cached -----------------------\033[0m"
git rm -f --cached .

# 所有文件加入暂存区      (Git命令)
echo -e "\033[44m ----------------------- 2: git add . ----------------------- \033[0m"
git add .

# 动态获取时间
# 申请变量
Update_Date_String='Last_Updata:'$today;
echo $Update_Date_String;   # 加上 $ 引用变量

# 提交Git更新说明[ 附件最后更新日期 ]      (Git命令)
echo -e "\033[44m ----------------------- 3: commit -m ----------------------- \033[0m"
git commit -m $Update_Date_String;

# 最后一步:推送      (Git命令)
echo -e "\033[44m ----------------------- 4: push -u origin master ----------------------- \033[0m"
git push -u origin master



# 注意:
# shell 编程中, 字符串类型,不允许出现空格, 比如字符串 A B C 是错误的,要改写成: A_B_C 才不会编译错误
#

```
</details>






















<details>
<summary><b> 下载 GitHub 单个文件夹 / 单个文件 </b></summary>

```
有时候下载 github 上面的项目, 不需要下载全部, 我需要下载单独的某个文件夹, 但是 GitHub 并没有直接提供这个功能
所以,
需要插件帮我实现这个功能:
Google chrome 浏览器插件 :  GitZip for github
双击你要下载的文件夹, 左边会出现一个小勾勾,
右下角会出现一个下载按钮
点击就可以直接下载单个文件夹了   

```
</details>



















<details>
<summary><b> 新建Github,推送流程 </b></summary>

```
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
</details>






















<details>
<summary><b>  更新仓库文件 </b></summary>

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
</details>


















<details>
<summary><b> 删除 </b></summary>

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
</details>


























# Other
<details>
<summary><b> 其他 </b></summary>

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
</details>
