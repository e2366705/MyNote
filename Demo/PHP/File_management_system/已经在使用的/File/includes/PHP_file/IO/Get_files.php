<?php
/**
 *
 * 获取这个文件夹的所有的文件
 *
 * User: SpringBoot
 * Date: 2019/7/13
 * Time: 12:42
 */

$filePath = array();//文件路径数组

function traverse($path = '.')
{
    //得到外部定义的数组
    global $filePath;

    //opendir()返回一个目录句柄,失败返回false
    $current_dir = opendir($path);

    //readdir()返回打开目录句柄中的一个条目
    while (($file = readdir($current_dir)) !== false) {
        if ($file == '.' || $file == '..') {
            continue;
        } else {    //如果是文件,直接输出路径和文件名
            $filePath[$file] = $file;//把文件路径赋值给数组
        }
    }
    return $filePath;
}


$array = traverse("C:\phpStudy\PHPTutorial\WWW\File\HTML_File_Resource");
foreach ($array as $key => $val) {
//    var_dump($val);
}
