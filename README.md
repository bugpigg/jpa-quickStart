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

### 하이버네이트 프레임워크 사용하기
- 하이버네이트 프레임워크란?
  - 개발자가 직접 SQL 을 관리해야한다는 문제점을 해결하기 위해 등장
  - ORM(Object-Relational Mapping) 프레임워크
  - 간단하게 설명하면, 객체와 테이블의 ROW 를 자동으로 매핑해주는 프레임워크이다!

- 과정
  - 라이브러리 의존성 추가
    - 우리는 `hibernate-entitymanager` 를 가져왔지만, 추가적으로 `core`나 `jpa` 등도 동시에 다운로드 됨
    - 최신 버전(`5.6.8.FINAL`)으로 했더니, 추후 테스트코드에서 오류 발생 (`ERROR: Column "start_value" not found [42122-212]`)
      - 해당 코드에서는 `5.4.9.FINAL` 버전 사용
  - VO 클래스 작성
  - 하이버네이트 메인 설정파일 작성
  - DAO 클래스 작성
  - 테이블 구조 변경
    - 개발자는 데이터 구조가 변경되는 사항에 대해서 기존 소스에 미치는 영향은 거의 없다!
    - 새로운 칼럼을 추가할때, VO 클래스에 필드를 추가하면 된다!
      - 그러면 실제 DB 테이블에 해당 칼럼으로 매핑되어 추가된다!
      - **더이상 데이터 관리에 얽매이지 않게 되었다!!**
</details>

<br>

### Chapter02 JPA 퀵스타트 및 JPA 설정

<details>
<summary>Section01 JPA 퀵스타트</summary>

- ORM
  - 하이버네이트를 떠올리기 쉽지만, 프레임워크 중 하나일 뿐
  - 자바 표준은 JPA
- 영속성
  - 데이터가 메모리가 아닌 데이터베이스에 저장되어 지속되려는 성질을 의미

### JPA 퀵스타트
- JPA는 JDBC 처럼 데이터베이스 연동을 지원하는 API
- 다음 그림은 JPA 위치와 동작방식을 묘사한 것
  ![image](https://user-images.githubusercontent.com/91416897/166636358-ab31336e-0f7c-4f00-a5e4-05436ac8db4a.png)
  - JPA 구현체를 얼마든지 다른것으로 교체 가능
- JPA 초기환경 설정
- 엔티티 클래스 작성 및 테이블 매핑
- JPA의 메인 설정파일
  - `META-INF/persistence.xml` 
- JPA를 이용한 등록,수정, 삭제 작업
  - 반드시 해당 작업이 트랜잭션 안에서 수행되어야 함
- 영속성 설정파일
  - 다음 그림은 애플리케이션에서 EntityManger 객체를 획득하는 과정
    ![image](https://user-images.githubusercontent.com/91416897/166643992-4c120711-0d1a-4a0f-85d0-c85eb2bd489e.png)
  - 상세 코드는 `/src/test/java/com/rubypaper/chapter02/EmployeeSeviceClient.java` 참고
  - 엔티티 클래스 등록 코드
    `<class>com.rubypaper.chapter02.domain.Employee</class>`
    - 클래스 패스 상에 존재하는 엔티티 클래스를 자동으로 인지하도록 JPA가 하고 있다.
    그렇기에 생략 가능하다
  - Dialect 클래스 설정
    - 데이터베이스가 변경되면 관련 SQL을 수정해야할 가능성이 높다.
    - 하지만 JPA에서는 필요한 SQL을 자동으로 생성해주기에 변경 가능하다.
    - JPA가 특정 데이터베이스에 특화된 SQL을 생성할 수 있는 것은 영속성 유닛에 설정된 Dialect 클래스 때문이다.
  - SQL 관련 설정
    - `hdm2ddl.auto` 설정
      - create
        - app 실행할때, 기존 테이블 삭제하고 엔티티에 설정된 매핑 정보 참조하여 테이블 생성
      - create-drop
        - create와 같지만, 종료 직전에 생성된 테이블 삭제
      - update
        - 기존 테이블이 존재한다면, 재사용
- 엔티티 매핑 설정하기
  - `@Entity` 와 `@Id`
    - 다른 엔티티와 구분하기 위한 유일한 엔티티 이름이 필요
    - `name` 속성이 지정되어 있지 않으면, 자동으로 클래스 이름 사용
    - 이는 후에 JPQL을 활용할 때 고려해야할 사항
  - `@Table`
    - 엔티티 이름과 테이블 이름을 매핑하기 위해 사용
    - `uniqueConstraints` 
      - 결합 unique 제약 조건을 지정하기 위해 사용
  - `@Column`
    - 클래스 멤버 변수와 테이블 칼럼을 매핑하기 위해 사용
    - NULL 방지를 위해서도 사용
  - `@Temporal`
    - `java.util.Date` 타입의 변수에 사용 가능
    - 날짜는 `DATE`, 시간은 `TIME`, 날짜와 시간은 `TIMESTAMP`
    - 설정하지 않으면, 기본값은 `TIMESTAMP`
  - `@Transient` 
    - 임시로 사용되는 변수들
    - 매핑에서 제외되어야 하는 변수들
  - `@Access`
    - JPA가 엔티티의 멤버변수에 접근하는 방식을 설정
    - 만약 생략하면,
      - `@Id` 가 설정된 위치를 기준으로 자동 결정
        - 필드위에 있으면 `AccessType.FIELD`로 적용
          - 멤버 변수에 직접 접근
        - Getter 메소드에 설정되면 `AccessType.PROPERTY`로 적용
          - Getter, Setter 메소드를 통해 접근
    - 가독성을 위해서는, `AccessType.FIELD` 를 활용하자

</details>
