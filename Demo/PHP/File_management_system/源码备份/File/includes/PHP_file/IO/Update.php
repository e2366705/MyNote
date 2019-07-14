<?php
/**
 * Created by PhpStorm.
 * User: SpringBoot
 * Date: 2019/7/13
 * Time: 15:35
 */



// 更新文件思路参考
//   先是删除这个文件
//   然后再新建个文件...
// 实现更新功能...

require_once "CRUD.php";




//   要读取的文件 - 名字
$old_html_file_name = $_POST['old_html_file_name'];
$new_html_file_name = $_POST['new_html_file_name'];
$textarea_html_code = $_POST['textarea_html_code'];




$return_result = Update($old_html_file_name , $new_html_file_name , $textarea_html_code);



echo json_encode($return_result);
//echo json_encode("VVVVVVVVVVVVVVVVVVV");