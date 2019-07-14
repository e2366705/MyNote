<?php
/**
 * Created by PhpStorm.
 * User: SpringBoot
 * Date: 2019/7/13
 * Time: 15:35
 */




// -----------------------------------------------------------------------------------------------------------------------------------




// Add
// 添加一个文件
// 参数: 你要删除的文件名 / 文件的内容
function Add($file_name , $file_content){

    $folder_path = "..\\..\\..\\HTML_File_Resource\\";
    $file_path = $folder_path   . $file_name;


    // 检查这个文件是否存在
    $bool_exists = file_exists($file_path);

    if ($bool_exists == true){
        return "file_exists";
    }else{
        // w	只写。打开并清空文件的内容；如果文件不存在，则创建新文件
        $myfile = fopen($file_path, "w") or die("Unable to open file!");
        fwrite($myfile, $file_content);
        fclose($myfile);

        return "creat_file_success";
    }
}




// -----------------------------------------------------------------------------------------------------------------------------------






// Delete
// 删除一个文件
// 参数: 你要删除的文件名
function Delete($file_name) {

    $folder_path = "..\\..\\..\\HTML_File_Resource\\";
    $filw_path = $folder_path . $file_name;

    $status = unlink($filw_path);
    if ($status) {
        return "Deleted_success";
    } else {
        return "Deleted_error";
    }
}



// -----------------------------------------------------------------------------------------------------------------------------------



// update 更新
// 参数:
//               旧名字       新名字     更新的内容
function Update($old_name , $new_name , $content){


    $folder_path = "..\\..\\..\\HTML_File_Resource\\";
    $old_file_path = $folder_path . $old_name;
    $new_file_path = $folder_path . $new_name;

    // 首先 , 更新文件内容 , 按照旧名字
    $myfile = fopen($old_file_path, "w") or die("Unable to open file!");
    fwrite($myfile, $content);
    fclose($myfile);


    if ($old_name == $new_name){
        // 更新成功
        return "Update_success";
    }else{

        // 判断 新的文件名 是否已经存在
        if (file_exists($new_file_path)){
            return "file_already_exists";
        }else{
            $state = rename($old_file_path , $new_file_path);

            // 更新成功 -> 返回 Update_success
            return $state ? "Update_success" : 'Unknown_error';
        }
    }
}


