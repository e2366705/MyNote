@set folder_path=C:\Users\YXB\Documents\�ҵļ����\�ʼ�\Github_Notes\MyNote\note\Markdown�ʼ�\MySQL_backup\bat�Զ����ݽű�\SQL����

@echo ɾ�� xxxx ����ļ���
rd /s /Q %folder_path%

@echo �½�һ�� xxxxx �ļ���
md %folder_path%

@set d=%date:~0,10%
@set d=%d:-=%
@set d=%d: =0%
@set d=%d:/=_%
@set t=%time:~0,8%
@set t=%t::=_%
@echo ��ǰ������/ʱ����:          %p%%d%__%t%

@forfiles /p "D:\MySQL_BackUp" /m backup_*.sql -d -30 /c "cmd /c del /f @path"
@set "time=%date:~0,4%-%date:~5,2%-%date:~8,2%-%time:~1,1%%time:~3,2%%time:~6,2%"
@"C:\phpstudy_pro\Extensions\MySQL5.7.26\bin\mysqldump" --opt --single-transaction=TRUE --user=root --password=root --host=127.0.0.1 --protocol=tcp --port=3306 --default-character-set=utf8 --single-transaction=TRUE --routines --events "study_english_database" > "%folder_path%\study_english_database_%p%%d%__%t%.sql"

@echo %time%
@echo auther:YXB
@echo �̳���Դ : https://blog.csdn.net/freezingxu/article/details/78884962
@echo ================ �ָ��� =====================
@echo Test : ����(Chinese)��������???
@echo ��Ϊ Windows��Ĭ�ϵ�bat�ı����ʽ��UTF-8����ʱֻ�轫��ת����ANSI ��ʽ����
@echo �һ�bat�ļ� -> �༭ -> ���Ϊ -> ANSI��ʽ -> ���漴��
@echo ע��!! һ��Ҫ�� Windows �Դ����ı��༭����, �ñ�ı༭���򿪻�����(���� VS Code)
@pause

