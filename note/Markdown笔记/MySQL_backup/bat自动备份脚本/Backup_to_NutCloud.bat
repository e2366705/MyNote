@set folder_path=C:\Users\YXB\Documents\�ҵļ����\�ʼ�\Github_Notes\MyNote\note\Markdown�ʼ�\MySQL_backup\bat�Զ����ݽű�\SQL����

@echo ɾ�� xxxx ����ļ���
rd /s /Q %folder_path%

@echo �½�һ�� xxxxx �ļ���
md %folder_path%

@set year=%date:~6,4%
@set month=%date:~3,2%
@set day=%date:~0,2%
@set date=%year%_%month%_%day%

@set hour=%time:~0,2%
@set minute=%time:~3,2%
@set second=%time:~6,2%
@set time=%hour%_%minute%_%second%

@set date__time=%date%__%time%
@echo ��ǰ������/ʱ����:     %date__time%

@forfiles /p "D:\MySQL_BackUp" /m backup_*.sql -d -30 /c "cmd /c del /f @path"
@"C:\phpstudy_pro\Extensions\MySQL5.7.26\bin\mysqldump" --opt --single-transaction=TRUE --user=root --password=root --host=127.0.0.1 --protocol=tcp --port=3306 --default-character-set=utf8 --single-transaction=TRUE --routines --events "study_english_database" > "%folder_path%\study_english_database_%date__time%.sql"

@echo auther:YXB
@echo �̳���Դ : https://blog.csdn.net/freezingxu/article/details/78884962
@echo ================ �ָ��� =====================
@echo Test : ����(Chinese)��������???
@echo ��Ϊ Windows��Ĭ�ϵ�bat�ı����ʽ��UTF-8����ʱֻ�轫��ת����ANSI ��ʽ����
@echo �һ�bat�ļ� -> �༭ -> ���Ϊ -> ANSI��ʽ -> ���漴��
@echo ע��!! һ��Ҫ�� Windows �Դ����ı��༭����, �ñ�ı༭���򿪻�����(���� VS Code)

@pause

