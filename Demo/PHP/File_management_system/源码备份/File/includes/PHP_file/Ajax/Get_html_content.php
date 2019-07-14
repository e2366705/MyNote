<?php
/**
 * Created by PhpStorm.
 * User: SpringBoot
 * Date: 2019/7/13
 * Time: 13:17
 */


//   要读取的文件 - 名字
$html_file_name = $_POST['html_file_name'];



//判断传过来的name是否为空来判断
if(!empty($html_file_name)){

    //将整个文件内容读入到一个字符串中
    $str = file_get_contents("../../../HTML_File_Resource/" . $html_file_name);

    $value = array("status"=>"1","msg"=>"success" , "html_content"=>$str);
    echo json_encode($value);
}
else {
    $value = array("status"=>"0","msg"=>"保存失败");
    echo json_encode($value);
}
