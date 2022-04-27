# jpa-quickStart
"JPA Quick Start" 책을 보며 정리해보기


### Chapter01 실습 환경 구축 및 데이터베이스 기술 변화

<details>
<summary>Section01 실습환경구축</summary>

- 프로젝트 초기 설정
    - [x] 익숙하지 않은 Maven 프로젝트 관리 도구 사용
    - [x] 책에서는 Eclipse로  설명하지만, intellj는 포기 못해...
- h2 데이터베이스 설치

</details>

<details>
<summary>Section02 데이터베이스 연동 기술의 변화</summary>

### JDBC API 사용하기
- 자바에서 가장 오래된 DB 연동 기술
- 모든 관계형 DB 에서 동일한 자바코드 사용
- 다형성을 기반으로 동작
- 다음 그림은 JDBC 의 구현 및 동작원리를 정리한 것
    ![image](https://user-images.githubusercontent.com/91416897/165459524-aec8e255-77d3-4968-840a-e92cdae1b0ba.png)

---
- 과정
  - VO 클래스 작성 -> EmployeeVO 클래스
  - DAO 클래스 작성 -> EmployeeDAO 클래스
  -  Clinet 프로그램 작성 -> EmployeeServerClient 클래스
- JDBC의 문제점
  - 모든 데이터베이스 연동 메소드에 반복되는 코드 등장
  - SQL 구문들이 DAO 클래스에 포함되어 있음

### 롬복 적용하기
- VO 클래스의 getter/setter, toString 메소드들을 어노테이션 기반으로 줄일 수 있음

### 마이바티스 프레임워크 사용하기
- 마이바티스 프레임워크란?
  - 아파치에서 만든 아이바티스 프레임워크에서 파생된 **SQL 매퍼 프레임워크**
- 마이바티스 특징 2가지
  - JDBC의 반복적인 코드를 대신 처리해줌
  - 자바코드와 SQL을 분리함
    SQL 매퍼라는 XML파일을 만들어서, DAO 클래스에서 사용할 SQL을 저장하고 관리함
    이렇게 분리하면, SQL 명령어들을 한 곳에 모아서 관리하기 때문에 SQL 검색도 쉽고 수정도 용이
---
- 과정
  - SQL Mapper 작성
  - 마이바티스 메인 설정파일 작성
    - SQL Mapper XML 파일에서 사용할 별칭 설정
    - 데이터 소스 정보 설정
    - <mappers>로 작성한 SQL Mapper XML 파일 등록
  - DAO 클래스 작성
  - 클라이언트 프로그램 작성
- 단점
  - 하지만 아직도, 개발자가 직접 SQL을 관리해야 하기 때문에,
    데이터 구조가 변경되는 상황에서는 효율적이 대처가 불가능

</details>
