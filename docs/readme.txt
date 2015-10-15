Pasos para correr el proyecto:

1. Tener instalado el JDK y el Netbeans 7.X (bajar la última versión de netbeans.org) elegir la opción de JavaEE
2. Copiar el directorio (spring_webmvc) que está en la carpeta properties a la carpeta lib/ del tomcat instalado
3. En el file recientemente copiado cambiar los siguientes parametros:

jdbc.driverClassName=org.hsqldb.jdbcDriver
jdbc.url=jdbc:hsqldb:file:/home/gian/databases/springweb
jdbc.username=sa
jdbc.password=
jdbc.initializeDatabase=false

driverClassName es el tipo de conector a usar
url es la bd que van a usar (jdbc:hsqldb:file:/home/gian/databases/springweb) ojo que tiene la ruta de mi PC cambiarla a la apropiada
username y password son los standard
initializeDatabase se setea a true cuando se quiere iniciar la BD por primera vez (TENGAN en cuenta que este proceso deben hacerlo 1 sola vez para
que la BD no se esté regenerando cada vez que levanta el sistema).

