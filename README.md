# SANHAK Backend SpringBoot
### Purpose
- 프론트엔드 구현에 필요한 데이터 조회 Api 구현
- 단순 조회만을 담당

### Apis
- CA
  - `/api/CAs/all`: cafe_article 테이블의 모든 데이터 반환
  - `/api/CAs/{ca_id}`: 특정 Cafe Article의 상세 데이터 반환 
  - `/api/CAs/statistics`: Cafe Article 관련 통계 데이터 반환
- RO
  - `/api/ROs/all`: repair_order 테이블의 모든 데이터 반환
  - `/api/ROs/statistics`: RepairOrder 관련 통계 데이터 반환

### Getting started

```
src/main/resources/application-dev.yml 작성

server:
  port: 

spring:
  datasource:
    url: 
    username: 
    password: 
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: create // 최초 실행 후 validate
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.MySQL8Dialect
    database-platform: org.hibernate.dialect.MySQL8Dialect

  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
```

- 이후 윈도우의 경우 cmd 프로젝트 루트 접근 후  `gradlew.bat build -x test` 빌드 진행
- 리눅스의 경우 프로젝트 루트에서 `./gradlew build -x test` 빌드 진행
- 빌드 완료 후 build/libs/ 이동 후 `java -jar sanhak-0.0.1-SNAPSHOT.jar`로 실행