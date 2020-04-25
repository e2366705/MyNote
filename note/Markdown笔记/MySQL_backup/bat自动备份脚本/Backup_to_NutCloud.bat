@set folder_path=C:\Users\YXB\Documents\我的坚果云\笔记\Github_Notes\MyNote\note\Markdown笔记\MySQL_backup\bat自动备份脚本\SQL备份

@echo 删除 xxxx 这个文件夹
rd /s /Q %folder_path%

@echo 新建一个 xxxxx 文件夹
md %folder_path%

@set d=%date:~0,10%
@set d=%d:-=%
@set d=%d: =0%
@set d=%d:/=_%
@set t=%time:~0,8%
@set t=%t::=_%
@echo 当前的日期/时间是:          %p%%d%__%t%

@forfiles /p "D:\MySQL_BackUp" /m backup_*.sql -d -30 /c "cmd /c del /f @path"
@set "time=%date:~0,4%-%date:~5,2%-%date:~8,2%-%time:~1,1%%time:~3,2%%time:~6,2%"
@"C:\phpstudy_pro\Extensions\MySQL5.7.26\bin\mysqldump" --opt --single-transaction=TRUE --user=root --password=root --host=127.0.0.1 --protocol=tcp --port=3306 --default-character-set=utf8 --single-transaction=TRUE --routines --events "study_english_database" > "%folder_path%\study_english_database_%p%%d%__%t%.sql"

@echo %time%
@echo auther:YXB
@echo 教程来源 : https://blog.csdn.net/freezingxu/article/details/78884962
@echo ================ 分割线 =====================
@echo Test : 中文(Chinese)会乱码吗???
@echo 因为 Windows下默认的bat的编码格式是UTF-8，这时只需将其转换成ANSI 格式即可
@echo 右击bat文件 -> 编辑 -> 另存为 -> ANSI格式 -> 保存即可
@echo 注意!! 一定要用 Windows 自带的文本编辑器打开, 用别的编辑器打开会乱码(比如 VS Code)
@pause

