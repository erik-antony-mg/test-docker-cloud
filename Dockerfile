#que imagen descargara para ejecutar el proyecto
#FROM eclipse-temurin:17-alpine
## nombre del autor
#LABEL authors="erik.antony"
##copiar el jar generado de la carpeta target y al costado lo renombras
##en este caso lo renombramos a products.jar
#COPY target/products-0.0.1-SNAPSHOT.jar products.jar
##aqui van los comandos a ejecutarse cuando se genera un contenedor
##con esta imagen (asi se ejecuta el proyecto)
#ENTRYPOINT ["java","-jar","/products.jar"]

# Dockerfile
# usa la imagen de maven para genera el jar del proyecto
# y le agregamos un alias llamaso build
FROM maven:3.8.4-openjdk-17-slim AS build
#copia los archivos del src a una carpeta llamada
# /home/app/src y el pom hacia /home/app
COPY src /home/app/src
COPY pom.xml /home/app

#USARLO CUANDO TU BD ESTA EN LOCAL O NUBE
# este compila el proyecto usando el pomxml
# de la ruta /home/app (-f indica usa este archivo)
#RUN mvn -f /home/app/pom.xml clean package
#USARLO CUANDO TU BD ESTA EN UN CONTENEDOR
RUN mvn -f /home/app/pom.xml clean package -DskipTests

#que imagen usara a la hora de crear el contenedor
FROM eclipse-temurin:17-alpine
#autores del proyecto
LABEL authors="erik_antony"
#copia un archivo jar de la ejecucion anterior y
# asu vez da un apodo al jar
COPY --from=build /home/app/target/products-0.0.1-SNAPSHOT.jar /usr/local/lib/products.jar
#Cuando el contenedor se inicia, ejecuta este comando
#para correr en el contenedor
ENTRYPOINT ["java","-jar","/usr/local/lib/products.jar"]
