<?php
/**
 * Created by PhpStorm.
 * User: SpringBoot
 * Date: 2019/7/13
 * Time: 16:31
 */



require_once "CRUD.php";



$Add_model_new_html_file_name = $_POST['Add_model_new_html_file_name'];
$Add_model_textarea_html_code = $_POST['Add_model_textarea_html_code'];



$retrun_result = Add($Add_model_new_html_file_name , $Add_model_textarea_html_code);


echo json_encode($retrun_result);