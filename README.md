# bowling-game

Readme

-Descomprimir el archivo .rar
-En la carpeta bowling-game abrir una ventana de comandos
-El mecanismo de construcción es gradle por lo que se lo compilará con el comando gradle build -x test
-Ubicarse en la direccion >build>libs
-Se encontrará el archivo bowling-game-0.0.1-SNAPSHOT.jar 
-Abrir una ventana de comandos en la ruta y ejecutar el jar con el siguiente comando:
		java -cp bowling-game-0.0.1-SNAPSHOT.jar -Dloader.main=com.bowling.MainApplication org.springframework.boot.loader.PropertiesLauncher
-El programa se ejecuta y se debe ingresar la ruta donde se encuentra el archivo a evaluar. (Ej: "C:\Users\...\Desktop\fileTest.txt")
