# ==========================================
# ETAPA 1 — Build da aplicação
# ==========================================
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copia primeiro o pom para aproveitar o cache do Docker
COPY pom.xml .

# Baixa as dependências antes de copiar o código
RUN mvn dependency:go-offline -B

# Agora copia o código-fonte
COPY src ./src

# Compila e gera o JAR
RUN mvn clean package -DskipTests


# ==========================================
# ETAPA 2 — Imagem final
# ==========================================
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copia o JAR gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Render e outros ambientes podem fornecer
# a porta através da variável PORT.
EXPOSE 8080

# Inicia o Liberbook
ENTRYPOINT ["java", "-jar", "app.jar"]