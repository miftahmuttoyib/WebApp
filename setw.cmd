set project_dir=D:\Project\WebApp\WebAppRepo
set web_xml=%project_dir%\web\WEB-INF
set targetF=C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\WebApp

robocopy "%web_xml%" "%target_server%\WebApp\WEB-INF" web.xml /NFL /NDL /NJH /NJS /nc /ns /np
robocopy "%project_dir%" "%targetF%" index.html /NFL /NDL /NJH /NJS /nc /ns /np