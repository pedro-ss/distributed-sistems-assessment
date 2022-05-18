FROM openjdk:11

# Autor da imagem
LABEL key="pjess@discente.ifpe.edu.br"

# Argumento do jar gerado
ARG JAR_FILE=target/*.jar

# Copiando o jar para dentro do container
COPY ${JAR_FILE} app.jar

EXPOSE 8080

# Executando o jar
ENTRYPOINT ["java","-jar","/app.jar"]