# Use a imagem do OpenJDK 17
FROM eclipse-temurin:17-jdk-jammy

# Diretório de trabalho no contêiner
WORKDIR /app

# Copia o JAR gerado para dentro do contêiner
COPY target/employeeApp-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta do Spring Boot
EXPOSE 8080

# Comando para rodar o JAR
ENTRYPOINT ["java","-jar","app.jar"]
