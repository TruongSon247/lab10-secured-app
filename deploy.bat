@echo off
setlocal

set "PROJECT_DIR=S:\VSCode\HocJava\lab10-secured-app"
set "CATALINA_HOME=S:\Downloads\Tomcat10"
set "WAR_NAME=lab10-secured-app.war"
set "APP_NAME=lab10-secured-app"

echo ===== Dung Tomcat =====
call "%CATALINA_HOME%\bin\shutdown.bat"
timeout /t 3 /nobreak >nul

echo ===== Build Lab10 =====
cd /d "%PROJECT_DIR%"
call mvn clean package
if errorlevel 1 (
    echo BUILD THAT BAI - khong deploy.
    exit /b 1
)

echo ===== Xoa ban Lab10 cu =====
if exist "%CATALINA_HOME%\webapps\%WAR_NAME%" del /q "%CATALINA_HOME%\webapps\%WAR_NAME%"
if exist "%CATALINA_HOME%\webapps\%APP_NAME%" rmdir /s /q "%CATALINA_HOME%\webapps\%APP_NAME%"

echo ===== Copy WAR vao Tomcat =====
copy /y "%PROJECT_DIR%\target\%WAR_NAME%" "%CATALINA_HOME%\webapps\%WAR_NAME%"
if errorlevel 1 (
    echo COPY WAR THAT BAI.
    exit /b 1
)

echo ===== Khoi dong Tomcat =====
call "%CATALINA_HOME%\bin\startup.bat"

echo.
echo HOAN TAT: http://localhost:8080/%APP_NAME%/
endlocal
pause
