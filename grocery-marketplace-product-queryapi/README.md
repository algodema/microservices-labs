# Grocery Marketplace Product Query API

This is a simple Spring Boot based application providing restful api for grocery marketplace product.

## 🚀 Prerequisites

Ensure you have the following installed:

- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)

## 🐘 Start PostgreSQL with Docker

Run the following command to start a PostgreSQL container:

```sh
docker run -d \
  --name postgres-db \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=grocery-marketplace \
  -p 5432:5432 \
  postgres:latest
```

This will:

- Create a container named `postgres-db`
- Set username: `postgres`, password: `postgres`
- Create a database: `grocery-marketplace`
- Expose PostgreSQL on port `5432`

### 🛑 Stop & Remove Container

To stop:

```sh
docker stop postgres-db
```

To remove:

```sh
docker rm postgres-db
```

## 🔧 Configure Database in Spring Boot

Update `src/main/resources/application.yml`:

```yaml
spring:
  application:
    name: grocery-marketplace-product-queryapi
  datasource:
    url: jdbc:postgresql://localhost:5432/grocery-marketplace
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
    platform: postgres
    initialization-mode: always
```

## 🏃 Run the Application

Use **Maven** to build and start the Spring Boot application:

```sh
mvn clean spring-boot:run
```

Or build a JAR and run it:

```sh
mvn clean package
java -jar target/*.jar
```

## ✅ Verify the Application

Once running, access the API at:

```
http://localhost:8080/grocery/marketplace/query/api/v1
```

## 📜 License

This project is licensed under the MIT License.

---

🚀 Happy Coding!

