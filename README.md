# AuthSpringBoot

A small Spring Boot project to practice JWT authentication with Spring Security.

## What it does
- Register a user (password is stored with BCrypt)
- Login and get a JWT token (valid for 1 hour)
- Send the token in the `Authorization: Bearer <token>` header to use protected endpoints
- New users get the `USER` role by default (roles: `USER`, `ADMIN`)

## Tech
Java 17, Spring Boot, Spring Security, Spring Data JPA, MySQL, JJWT, Lombok

## Endpoints
| Method | URL | Auth |
|---|---|---|
| POST | /UserUs/register | no |
| POST | /UserUs/login | no |
| GET | /UserUs/health | no |
| GET | /UserUs/GetAll | yes |
| GET | /UserUs/GetById/{id} | yes |

Login body:
{ "userName": "nikhil", "password": "pass1234" }

## Run it
1. Create a MySQL database.
2. Add `src/main/resources/application.properties`:

spring.datasource.url=jdbc:mysql://localhost:3306/yourdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
jwt.secret=<base64 string, at least 32 bytes>

   You can make a secret with: `openssl rand -base64 32`

3. Run `./mvnw spring-boot:run`

## Not done yet
- Role based access on endpoints (roles exist but are not used yet)
