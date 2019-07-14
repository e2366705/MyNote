<?php


?>


<?php include 'includes/PHP_file/IO/Get_files.php'; ?>


<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <style>
        * {
            margin: 0;
            padding: 0;
            text-decoration: none;
            list-style-type: none;
        }
    </style>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>YXB</title>
    <link rel="styleSheet" href="" type="text/css">

    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>

    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <script src="https://cdn.bootcss.com/layer/2.3/layer.js"></script>

</head>
<body>

<?php foreach ($array as $item): ?>
    <h1>
        <a target="_blank" href="\File\HTML_File_Resource\<?php echo $item ?>">
            <?php echo $item ?>
        </a>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#Edit_model" onclick='edit_this_file(this)'>Edit 编辑</button>
        <button class="btn btn-danger" data-toggle="modal" data-target="#Delete_model"    onclick='Delete_this_file(this)'   >X</button>
    </h1>
<?php endforeach ?>




<!--           Add 增加按钮              -->
<button  id="Add_button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#Add_model"   style="position: fixed;  top: 20px; right: 20px;" >
    Add
</button>

<!--              Add - 模态框                     -->
<div id="Add_model" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Add_model</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">

                    <label for="new_html_file_name" class="col-md-2 control-label">新的文件名称: </label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="Add_model_new_html_file_name" placeholder="name_name">
                    </div>
                </div>

                <br>
                <br>

                <div>
                    <textarea class="form-control" rows="12" id="Add_model_textarea_html_code"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-default">清空</button>
                <button type="button" class="btn btn-success" id="Add_model_submit">Add_添加文件</button>
            </div>
        </div>
    </div>
</div>






<!--              edit - 编辑的 - 模态框                     -->
<div class="modal fade bs-example-modal-lg" id="Edit_model" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Edit_model</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <h4>
                        <span>旧的名称: </span> <span id="old_html_file_name"></span>
                    </h4>

                    <br>

                    <label for="new_html_file_name" class="col-md-2 control-label">新的文件名称: </label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="new_html_file_name" placeholder="name_name">
                    </div>
                </div>

                <br>
                <br>

                <div>
                    <textarea class="form-control" rows="12" id="textarea_html_code"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-default">清空</button>
                <button type="button" class="btn btn-primary" onclick="Update_button()">Update</button>
            </div>
        </div>
    </div>
</div>





<!--    删除 - Modal -->
<div class="modal fade" id="Delete_model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <div class="modal-title" id="myModalLabel">文件名: <span id="file_name" style="font-size: 25px; "></span></div>
            </div>
            <div class="modal-body">
                <h1>你确定要删除吗?</h1>
                <h3>该操作没法撤销!!!</h3>
                <br><br>
                <h4>删除成功, 网页会自动刷新</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger"  id="determine_Delete" >确定删除</button>
            </div>
        </div>
    </div>
</div>



</body>
<script type="text/javascript">


    // Add 按钮
    document.getElementById("Add_model_submit").onclick = function () {

        // 获取 文件名称
        var Add_model_new_html_file_name = document.getElementById("Add_model_new_html_file_name").value;
        Add_model_new_html_file_name = Add_model_new_html_file_name.replace(/^\s+|\s+$/g,"");           // 去掉两头的空格
        // console.log(Add_model_new_html_file_name);

        // 获取 textarea 文本框的内容
        var Add_model_textarea_html_code = document.getElementById("Add_model_textarea_html_code").value;
        // console.log(Add_model_textarea_html_code);

        $.ajax({
            type: 'post',
            url: 'includes\\PHP_file\\IO\\Add.php',
            data: {Add_model_new_html_file_name: Add_model_new_html_file_name , Add_model_textarea_html_code: Add_model_textarea_html_code},
            dataType: 'json',
            success: function (data) {
                if (data === "file_exists") {
                    // 文件已经存在
                    layer.msg("<h1>错误: 文件名已存在!</h1>");
                }
                if (data === "creat_file_success"){
                    location.reload();                     //  Add成功 -> 刷新这个页面
                }
                console.log(data);
            },
            error: function () {
                // alert("程序异常");
            }
        });


    };















    // edit 编辑按钮
    function edit_this_file(ev) {

        //  html - 文件名字
        var html_file_name = ev.parentNode.childNodes[1].innerText;
        // console.log(html_file_name);

        // 旧名字
        document.getElementById("old_html_file_name").innerText = html_file_name;

        // 请输入 新名字(input)
        document.getElementById("new_html_file_name").value = html_file_name;

        $.ajax({
            type: 'post',
            url: 'includes\\PHP_file\\Ajax\\Get_html_content.php',
            data: {html_file_name: html_file_name},
            dataType: 'json',
            success: function (data) {
                console.log(data.html_content);
                document.getElementById("textarea_html_code").innerHTML = data.html_content;
            },
            error: function () {
                // alert("程序异常");
            }
        });
    }

    // update 按钮
    function Update_button(ev) {

        // 旧名字
        var old_html_file_name = document.getElementById("old_html_file_name").innerText;
        // console.log(old_html_file_name);

        // 新名字 - input
        var new_html_file_name = document.getElementById("new_html_file_name").value;
        // 去掉两头的空格
        new_html_file_name = new_html_file_name.replace(/^\s+|\s+$/g,"");
        // console.log(new_html_file_name);

        // 更新的内容
        var textarea_html_code = document.getElementById("textarea_html_code").value;
        // console.log(textarea_html_code);


        $.ajax({
            type: 'post',
            url: 'includes\\PHP_file\\IO\\Update.php',
            data: {old_html_file_name:old_html_file_name , new_html_file_name:new_html_file_name , textarea_html_code:textarea_html_code},
            dataType: 'json',
            success: function (data) {
                
                if (data === "file_already_exists"){
                    layer.msg("<h1>文件名已经被占用</h1>");
                }
                if (data === "Unknown_error"){
                    layer.msg("<h1>未知错误</h1>");
                }
                if (data === "Update_success"){
                    location.reload();                     //   刷新这个页面
                }
            },
            error: function () {
                // alert("程序异常");
            }
        });
    }











    // Delete  -  X 按钮
    function Delete_this_file(ev) {

        //  html - 文件名字
        var html_file_name = ev.parentNode.childNodes[1].innerText;
        html_file_name = html_file_name.replace(/^\s+|\s+$/g,"");       // 去掉两头的空格
        // console.log(html_file_name);

        document.getElementById("file_name").innerHTML = html_file_name;
    }

    // 确定删除按钮
    document.getElementById("determine_Delete").onclick = function () {

        // 获取要删除的文件名:
        var file_name = document.getElementById("file_name").innerText;
        // console.log(file_name);

        $.ajax({
            type: 'post',
            url: 'includes\\PHP_file\\IO\\Delete.php',
            data: {html_file_name:file_name},
            dataType: 'json',
            success: function (data) {

                console.log(data);

                if (data === "Deleted_success") {
                    location.reload();                     //  更新成功 -> 刷新这个页面
                }
            },
            error: function () {
                // alert("程序异常");
            }
        });
    };

</script>
</html>

