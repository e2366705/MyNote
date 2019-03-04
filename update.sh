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




# 备注:
# 脚本自动化更新代码到 Github =>
# ---------------------------------------
echo '(=^_^=)  Auto Updata Code...  (=^_^=) '
echo 'input => ./update.sh toStart Updata Code...'

# 清空缓存      (Git命令)
echo '----------------------- rm -f --cached -----------------------'
git rm -f --cached .

# 所有文件加入暂存区      (Git命令)
echo '----------------------- add -f * -----------------------'
git add -f *

# 动态获取时间
# 申请变量
Update_Date_String='Last_Updata:'$today;
echo $Update_Date_String;   # 加上 $ 引用变量

# 提交Git更新说明[ 附件最后更新日期 ]      (Git命令)
echo '----------------------- commit -m -----------------------'
git commit -m $Update_Date_String;

# 最后一步:推送      (Git命令)
echo '----------------------- push -u origin master -----------------------'
git push -u origin master



# 注意:
# shell 编程中, 字符串类型,不允许出现空格, 比如字符串 A B C 是错误的,要改写成: A_B_C 才不会编译错误
# 
# 
# 
# 
# 
# 
# 
