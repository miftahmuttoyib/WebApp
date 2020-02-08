set project_dir=D:\Project\WebApp\WebAppRepo
set web_xml=%project_dir%\web\WEB-INF

robocopy "%web_xml%" "%target_server%\WebApp\WEB-INF" web.xml /NFL /NDL /NJH /NJS /nc /ns /np