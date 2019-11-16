:: set my_date=%date:~10,14%-%date:~4,2%-%date:~7,2%
set project_dir=D:\Project\WebApp\WebApp
set source_war=%project_dir%\build\libs
set target_server=C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps
:: set log_file = C:\Program Files\Apache Software Foundation\Tomcat 7.0\logs\catalina.%my_date%.log



:START
if exist "%target_server%\WebApp.war" @DEL "%target_server%\*WebApp.war"
if exist "%target_server%\WebApp" @RMDIR /Q /S "%target_server%\WebApp"
robocopy "%source_war%" "%target_server%" *.war /NFL /NDL /NJH /NJS /nc /ns /np

::if exist "%target_server%\WebApp" GOTO WAIT
::robocopy "%source_war%" "%target_server%" *.war /NFL /NDL /NJH /NJS /nc /ns /np

::DEP
::if exist "%target_server%\*WebApp.war" GOTO WAIT
::GOTO START