REM @echo off

@title resign JuggleMasterPro.jar...

if exist "..\applet\sJuggleMasterPro.jar" @del /F /Q "..\applet\sJuggleMasterPro.jar" >nul 2>&1

if exist "C:\Program Files\Java\jdk\bin\jar.exe" (
	@call createJuggleMasterPro.jar.bat
	@title sign JuggleMasterPro.jar

	if not exist "JuggleMasterProStore" (
		@echo Usual passphrase for keystore: JuggleMaster Pro
		@"C:\Program Files\Java\jdk\bin\keytool.exe" -genkey -alias JuggleMasterProSignature -keystore "JuggleMasterProStore"
	)
	@cd "..\applet"
	@copy "JuggleMasterPro.jar" "sJuggleMasterPro.jar" >nul
	@echo Usual passphrase for keystore: JuggleMaster Pro
	@"C:\Program Files\Java\jdk\bin\jarsigner.exe" -keystore "..\tools\JuggleMasterProStore" -verbose -signedjar "JuggleMasterPro.jar" "sJuggleMasterPro.jar" JuggleMasterProSignature
	@"C:\Program Files\Java\jdk\bin\jar.exe" -i "JuggleMasterPro.jar"
	if exist "sJuggleMasterPro.jar" @del /F /Q "sJuggleMasterPro.jar" >nul 2>&1
	@cd "..\tools"
	@pause
	@exit
)