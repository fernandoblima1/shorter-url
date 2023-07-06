# Etapa de compilação
FROM maven:3.8.3-openjdk-17

WORKDIR /app

COPY . .

RUN mvn package -DskipTests

# Etapa final de execução
COPY target/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
