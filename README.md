# springboot-testing-demo

一个可运行的 Spring Boot 测试样例工程，包含：
- `@WebMvcTest`（控制器切片测试 + `MockMvc`）
- `@SpringBootTest`（随机端口集成测试 + `TestRestTemplate`）
- `@DataJpaTest`（JPA 仓库切片测试，H2 内存数据库）
- 基于 `application-test.yml` 的 **测试 profile**

## 运行

```bash
# 1. 运行测试
./mvnw -q -DskipTests=false test   # 如果没有 wrapper，则: mvn test

# 2. 启动应用（dev 配置，H2 数据库）
mvn spring-boot:run
# 打开 http://localhost:8080/api/greet?name=amwtke
```

## 结构
```
src/main/java/...           # 应用代码（Controller / Service / JPA）
src/test/java/...           # 测试代码（WebMvc / SpringBootTest / DataJpaTest）
src/main/resources/*.yml    # 应用配置
src/test/resources/*.yml    # 测试配置（覆盖）
```

## 版本
- Java 17
- Spring Boot 3.3.x
- JUnit 5 + Mockito
