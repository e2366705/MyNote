#!/bin/sh



# 备注:
# 动态获取今天的时间+日期
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

echo $today;
echo $dates_30_ago;

# 申请变量
Update_Date_String='Last Updata:'$today;
echo $Update_Date_String;   # 加上 $ 引用变量