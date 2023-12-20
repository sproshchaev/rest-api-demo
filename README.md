# rest-api-demo
REST API с использованием Spring Security

### 1. Настройки секретов c использованием Jasypt

1) Клиент:
```bash
c:
cd \..\rest-api-demo\client
mvn jasypt:encrypt-value "-Djasypt.encryptor.password=sk091254" "-Djasypt.plugin.value=remote"
```

2) Сервер: 
```bash
c:
cd \..\rest-api-demo\server
mvn jasypt:encrypt-value "-Djasypt.encryptor.password=sk091254" "-Djasypt.plugin.value=Dp12345678"
```

3) Дополнительные опции: @EnableEncryptableProperties, application.yml (jasypt-encryptor-password, ENC(..)).

### References
1. Погружение в Spring Security для Servlet API https://alexkosarev.name/2023/05/27/deep-dive-into-spring-security-for-servlet-api-part-1/
2. RESTful API Authentication with Spring Security https://shzhangji.com/blog/2023/01/15/restful-api-authentication-with-spring-security/
3. Basic Authentication with the RestTemplate https://www.baeldung.com/how-to-use-resttemplate-with-basic-authentication-in-spring
4. Использование Basic Authentication с RestTemplate в Spring https://habr.com/ru/companies/otus/articles/655739/
5. How to consume basic-authentication protected Restful web service via feign client https://stackoverflow.com/questions/39606744/how-to-consume-basic-authentication-protected-restful-web-service-via-feign-clie
6. Spring Boot Password Encryption using Jasypt https://javatechie4u.medium.com/spring-boot-password-encryption-using-jasypt-9ee731701e70
7. Jasypt Maven plugin: "Unknown lifecycle phase" https://stackoverflow.com/questions/68573806/jasypt-maven-plugin-unknown-lifecycle-phase