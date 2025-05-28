# Criar rede docker para sistema hr
```
docker network create hr-net
```
# Postgresql
```
docker pull postgres:12-alpine

docker run postgres:12-alpine -p 5432:5432 --name hr-worker-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_worker
```

# Testando perfil dev com Postgresql no Docker


docker pull postgres:12-alpine

docker run -p 5432:5432 --name hr-worker-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_worker postgres:12-alpine

docker run -p 5432:5432 --name hr-user-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_user postgres:12-alpine

# Comandos e códigos para executar e criar os containers dos respectivos projetos :

●●● hr-config-server ●●●
```
● Na pasta principal do projeto ( botão direito do mouse ) ,deverá criar um arquivo "File" com o nome "Dockerfile" e adicionado o código abaixo e salvar.

FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/hr-config-server-0.0.1-SNAPSHOT.jar hr-config-server.jar
ENTRYPOINT ["java","-jar","/hr-config-server.jar"]
``` 
```
● Utilizar os comandos abaixo no "Docker" para iniciar a "imagem" atraves do arquivo .JAR que foi buildado via maven do File "Dockerfile"

mvnw clean package

docker build -t hr-config-server:v1 .

docker run hr-config-server:v1 -p 8888:8888 --name hr-config-server --network hr-net -e GITHUB_USER=acenelio -e GITHUB_PASS=
```

●●● hr-eureka-server ●●●
```
● Na pasta principal do projeto ( botão direito do mouse ) ,deverá criar um arquivo "File" com o nome "Dockerfile" e adicionado o código abaixo e salvar.

FROM openjdk:11
VOLUME /tmp
EXPOSE 8761
ADD ./target/hr-eureka-server-0.0.1-SNAPSHOT.jar hr-eureka-server.jar
ENTRYPOINT ["java","-jar","/hr-eureka-server.jar"]
``` 
```
● Utilizar os comandos abaixo no "Docker" para iniciar a "imagem" atraves do arquivo .JAR que foi buildado via maven do File "Dockerfile"

mvnw clean package

docker build -t hr-eureka-server:v1 .

docker run hr-eureka-server:v1 -p 8761:8761 --name hr-eureka-server --network hr-net
```

●●● hr-worker ●●●
```
● Na pasta principal do projeto ( botão direito do mouse ) ,deverá criar um arquivo "File" com o nome "Dockerfile" e adicionado o código abaixo e salvar.

FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-worker-0.0.1-SNAPSHOT.jar hr-worker.jar
ENTRYPOINT ["java","-jar","/hr-worker.jar"]
``` 
```
● Utilizar os comandos abaixo no "Docker" para iniciar a "imagem" atraves do arquivo .JAR que foi buildado via maven do File "Dockerfile"

mvnw clean package -DskipTests

docker build -t hr-worker:v1 .

docker run hr-worker:v1 -P --network hr-net
```


●●● hr-user ●●●
```
● Na pasta principal do projeto ( botão direito do mouse ) ,deverá criar um arquivo "File" com o nome "Dockerfile" e adicionado o código abaixo e salvar.

FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-user-0.0.1-SNAPSHOT.jar hr-user.jar
ENTRYPOINT ["java","-jar","/hr-user.jar"]

● Utilizar os comandos abaixo no "Docker" para iniciar a "imagem" atraves do arquivo .JAR que foi buildado via maven do File "Dockerfile"

mvnw clean package -DskipTests

docker build -t hr-user:v1 .

docker run -P --network hr-net hr-user:v1


●●● hr-payroll ●●●

● Na pasta principal do projeto ( botão direito do mouse ) ,deverá criar um arquivo "File" com o nome "Dockerfile" e adicionado o código abaixo e salvar.

FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-payroll-0.0.1-SNAPSHOT.jar hr-payroll.jar
ENTRYPOINT ["java","-jar","/hr-payroll.jar"]

● Utilizar os comandos abaixo no "Docker" para iniciar a "imagem" atraves do arquivo .JAR que foi buildado via maven do File "Dockerfile"

mvnw clean package -DskipTests

docker build -t hr-payroll:v1 .

docker run -P --network hr-net hr-payroll:v1


●●● hr-oauth ●●●

● Na pasta principal do projeto ( botão direito do mouse ) ,deverá criar um arquivo "File" com o nome "Dockerfile" e adicionado o código abaixo e salvar.

FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-oauth-0.0.1-SNAPSHOT.jar hr-oauth.jar
ENTRYPOINT ["java","-jar","/hr-oauth.jar"]

● Utilizar os comandos abaixo no "Docker" para iniciar a "imagem" atraves do arquivo .JAR que foi buildado via maven do File "Dockerfile"

mvnw clean package -DskipTests

docker build -t hr-oauth:v1 .

docker run -P --network hr-net hr-oauth:v1


●●● hr-api-gateway-zuul ●●●

● Na pasta principal do projeto ( botão direito do mouse ) ,deverá criar um arquivo "File" com o nome "Dockerfile" e adicionado o código abaixo e salvar.

FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/hr-api-gateway-zuul-0.0.1-SNAPSHOT.jar hr-api-gateway-zuul.jar
ENTRYPOINT ["java","-jar","/hr-api-gateway-zuul.jar"]

● Utilizar os comandos abaixo no "Docker" para iniciar a "imagem" atraves do arquivo .JAR que foi buildado via maven do File "Dockerfile"

mvnw clean package -DskipTests

docker build -t hr-api-gateway-zuul:v1 .

docker run -p 8765:8765 --name hr-api-gateway-zuul --network hr-net hr-api-gateway-zuul:v1


●●●Alguns comandos Docker●●●
Criar uma rede Docker

docker network create <nome-da-rede>
Baixar imagem do Dockerhub

docker pull <nome-da-imagem:tag>
Ver imagens

docker images
Criar/rodar um container de uma imagem

docker run -p <porta-externa>:<porta-interna> --name <nome-do-container> --network <nome-da-rede> <nome-da-imagem:tag> 
Listar containers

docker ps

docker ps -a
Acompanhar logs do container em execução

docker logs -f <container-id>
