<?php
/**
 * Created by PhpStorm.
 * User: SpringBoot
 * Date: 2019/7/13
 * Time: 15:35
 */


require_once "CRUD.php";

// 删除文件
$html_file_name = $_POST['html_file_name'];

$return_result = Delete($html_file_name);

echo json_encode($return_result);