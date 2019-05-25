package com.example.demo.test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/*
        创建一个数据库,  并且创建一个同名的数据表
 */

public class creadatabase {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String database_nameee_start = "mysql";        //一开始必须填一个已经存在的数据库

        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/" + database_nameee_start + "?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";

        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stat = conn.createStatement();

        // 数据库 名字
        String Database_name = "zzz00000" + getCurrentTimeMillis();
        Write_to_txt(Database_name);

        // 创建数据库sql语句
        String creat_Database_SQL = "create database " + Database_name;

        // use 数据库
        String use_database = "use " + Database_name;

        // 创建数据库
        stat.executeUpdate(creat_Database_SQL);

        // use 数据库
        stat.executeUpdate(use_database);

        // 创建数据表
        String Creat_table_SQL = Creat_table(Database_name);
        stat.executeUpdate(Creat_table_SQL);

        stat.close();
        conn.close();
    }


    public static String getCurrentTimeMillis(){
        long randomNum = System.currentTimeMillis();
        return Long.toString(randomNum);
    }


    public static void Write_to_txt(String database_name )  throws Exception{
        String system_path = System.getProperty("user.dir");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());

        File f = new File("data_SQL.txt");
        if (f.exists()) {
            System.out.println("文件存在");
        } else {
            System.out.println("文件不存在");
            f.createNewFile();// 不存在则创建
            System.out.println("项目已经生成在:"+system_path + " 目录下面!!!");
        }

        BufferedWriter output = new BufferedWriter(new FileWriter(f,true));//true,则追加写入text文本
        output.write("文件创建于: " + date + " : " + database_name);
        output.write("\r\n");//换行

        output.close();
    }


    public  static String Creat_table( String database_name ){

        String creat_table_SQL =
                "CREATE TABLE `t_order` (\n" +
                "  `order_id` varchar(36) NOT NULL,\n" +
                "  `order_no` varchar(50) DEFAULT NULL,\n" +
                "  `order_date` datetime DEFAULT NULL,\n" +
                "  `quantity` int(11) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`order_id`)\n" +
                ") ENGINE=MyISAM DEFAULT CHARSET=utf8;";


        System.err.println(creat_table_SQL);
        return creat_table_SQL;
    }
}

/*

            CREATE TABLE IF NOT EXISTS `table1`(
               `tableID` INT UNSIGNED AUTO_INCREMENT,
               `username` VARCHAR(100) NOT NULL,
               `password` VARCHAR(40) ,
               PRIMARY KEY ( `tableID` )
            )ENGINE=InnoDB DEFAULT CHARSET=utf8;

 */



class YXB_get{

    public String YXB_getCity() {
        System.out.println("生成一个随机的城市(中文):  ");
        String citys[] = {"北京", "广东", "山东", "江苏", "河南", "上海", "河北", "浙江", "香港", "山西", "陕西", "湖南", "重庆", "福建", "天津", "云南", "四川", "广西", "安徽", "海南", "江西", "湖北", "山西", "辽宁", "内蒙古"};
        Random random = new Random();
        int randomInt = random.nextInt(10000) % citys.length;
        return citys[randomInt];
    }


    public String  YXB_getAge(){
        System.out.println("生成一个随机的年龄(数字):  ");
        //假设你要产生5到10之间的随机数，可以用下面方法：
        int Min = 18;
        int Max = 45;

        int age = Min + (int)(Math.random() * ((Max - Min) + 1));

        return Integer.toString(age);
    }


    public String YXB_getGender() {
        System.out.println("生成一个随机的性别(男/女):  ");
        String man = "man";
        String woman = "woman";

        int random_number = (int) (Math.random() * 100);
        if (random_number % 2 == 0) {
            return "man";
        } else {
            return "woman";
        }
    }

    public static String base = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static String firstName="赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
    private static String girl="秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
    public static String boy="伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
    public static final String[] email_suffix="@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");

    public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }


    public int YXB_random_getNum() {
        System.out.println("生成一个随机的数字():  ");
//        制定随机数的范围
        int start = 300;
        int end = 2;
        return (int)(Math.random()*(end-start+1)+start);
    }

    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

    public  String YXB_getTelephone() {
        System.out.println("生成一个随机的电话号码(数字):  ");
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String thrid=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+thrid;
    }

    public static String name_sex = "";


    public  String YXB_getChineseName() {
        System.out.println("生成一个随机的名字(中文):  ");
        int index = getNum(0, firstName.length() - 1);
        String first = firstName.substring(index, index + 1);
        int sex = getNum(0, 1);
        String str = boy;
        int length = boy.length();
        if (sex == 0) {
            str = girl;
            length = girl.length();
            name_sex = "女";
        } else {
            name_sex = "男";
        }
        index = getNum(0, length - 1);
        String second = str.substring(index, index + 1);
        int hasThird = getNum(0, 1);
        String third = "";
        if (hasThird == 1) {
            index = getNum(0, length - 1);
            third = str.substring(index, index + 1);
        }
        return first + second + third;
    }



    private String Random_string_abcde(){
        String abcde = "abcdefghijklmnopqrstuvwxyz";

        Random random=new Random();
        StringBuffer stringBuffer=new StringBuffer();

        for(int i=0;i< abcde.length();i++){
            int number1 = random.nextInt(26);      // 选取的范围 0-62个字符
            char charAt = abcde.charAt(number1);
            stringBuffer.append(charAt);
        }

        String random_string = stringBuffer.substring(1 , 20);

        // 返回 20 位随机数   (小写字母)
        return random_string;
    }


    // 生成随机数 (小写)
    public String YXB_Random_string_abcde(){
        System.out.println("生成的随机数(小写):  ");

        String random_string_abcde =  Random_string_abcde();

        return random_string_abcde;
    }


    // 生成随机数 (大写)
    public String YXB_Random_string_ABCDE(){
        System.out.println("生成的随机数(大写):  ");
        // 小写字母
        String abcde = Random_string_abcde();

        // 转换成为大写字母
        String ABCDE = abcde.toUpperCase();

        // 返回 20 位随机数 (大写字母)
        return ABCDE;
    }


    public void YXB_get_All(){
        System.out.println(YXB_getChineseName());
        System.out.println("\n");


        System.out.println(YXB_getGender());
        System.out.println("\n");


        System.out.println(YXB_Random_string_ABCDE());
        System.out.println("\n");


        System.out.println(YXB_Random_string_abcde());
        System.out.println("\n");


        System.out.println(YXB_getAge());
        System.out.println("\n");


        System.out.println(YXB_getCity());
        System.out.println("\n");


        System.out.println(YXB_getTelephone());
        System.out.println("\n");


        System.out.println(YXB_random_getNum());
        System.out.println("\n");

    }
}

