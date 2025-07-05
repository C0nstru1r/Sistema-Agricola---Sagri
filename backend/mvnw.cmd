@echo off

set DIRNAME=%~dp0
set MAVEN_WRAPPER_JAR=%DIRNAME%.mvn\wrapper\maven-wrapper.jar

REM Automatically download Maven if not found
if not exist "%MAVEN_WRAPPER_JAR%" (
  echo Maven wrapper not found, downloading Maven...
  curl -SL https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.8.4/maven-wrapper-3.8.4.jar -o "%MAVEN_WRAPPER_JAR%"
)

java -Dmaven.multiModuleProjectDirectory="%DIRNAME%" -cp "%MAVEN_WRAPPER_JAR%" org.apache.maven.wrapper.MavenWrapperMain %*