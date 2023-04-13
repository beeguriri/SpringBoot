## 💜 Springboot
+ File -> New -> Others -> SpringBoot -> `Spring Starter Project`

## 💜 Springboot 프로젝트 작업 순서
#### 0. application.properties 작성 (db, sql 관련 설정 등)
#### 1. domain 파일 생성(`@Entity`, `@Builder`)
#### 2. repository 파일 생성(`extends CrudRepository<Board, Long>`)
#### 3. service 파일 생성(`@Service`)
#### 4. controller 파일 생성(`@RestController`)

## 💜 Springboot - View 프로젝트 작업 순서
### 📰 Chapter06JSP
#### 0.1 JSP 사용 준비
+ pom.xml에 jsp관련 dependency 추가
  + (Tomcat embeded jasper, jstl)
  + (springboot에서 jpa를 기본적으로 지원하지 않음)
+ 폴더 구조 생성
  + src > main > webapp > WEB-INF > board
  + WEB-INF 폴더는 외부에서 접근 할 수 없는 폴더
#### 0.2 application.properties 작성
  + db, sql 관련 설정 등
  + 사용 편의를 위하여 `spring.mvc.view.prefix=/WEB-INF/`, `spring.mvc.view.suffix=.jsp` 추가
#### 1. domain 파일 생성(`@Entity`, `@Builder`)
#### 2. repository 파일 생성(`extends CrudRepository<Board, Long>`)
#### 3. service 파일 생성(`@Service`)
#### 4. controller 파일 생성(`@Controller`)
   + `@Controller` 어노테이션 사용 시, GetMapping, PostMapping만 사용할 수 있음
   + return type String (jsp 호출)
   + controller에서 view 호출(return .jsp)
      + forward: 컨트롤러로 돌아오지 않고 다음 요청 수행 (request와 response, httpSession 객체 모두 유지)
      + redirect: 컨트롤러로 돌아와서 다음 요청 수행   
      + 참고자료 : https://doublesprogramming.tistory.com/63
      
### 📰 Chapter06TH
#### 0. application.properties 작성 (db, Thymeleaf 관련 설정 등)
#### 1. domain 파일 생성(`@Entity`)
#### 2. repository 파일 생성(`extends CrudRepository<Board, Long>`)
#### 3. service 파일 생성(`@Service`)
#### 4. controller 파일 생성(`@RestController`)
#### 5. html 파일 작성 (src\main\resources\templates)
   + th tag속성 이용하여 작성하기
   ```html
   <html xmlns:th="http://www.thymeleaf.org"> 
   <td th:text="${board.seq}">
   <tr th:each="board : ${boardList}">
   <a th:href="@{/getBoardList}">
   <form th:action="insertBoard" method="post">
   ```  

## 💜 Springboot 기본
### src/main/java/
> Application.java

### src/main/java/controller
> `@RestController` <br>
> 요청과 응답 처리
> DemoApplication 파일이 있는 하부 패키지의 클래스를 인스턴스로 생성
  + `Read` @GetMapping("/member") / @GetMapping("/member/{id}")
    ```java
    @GetMapping("/member")
    public MemberVO getMember(@PathVariable Integer id) {
		  return service.getMember(id);
	  }
    ```
  + `Create` @PostMapping("/member")
  + `Update` @PutMapping("/member")
  + `Delete` @DeleteMapping("/member/{id}")
  
### src/main/java/service
> `@Service` <br>
> `@Autowired` 객체 생성

### src/main/java/edu/pnu/dao
> `@Repository` <br>
+ 내부에서 자바 로직 처리

### src/main/java/edu/pnu/domain
> 데이터I/O

### src/test/java/
```java
@SpringBootTest
class Mission2ApplicationTests {

	@Autowired
	MemberDAO memberDao;
	
	@Test
	void contextLoads() {
		System.out.println("이것은 테스트 입니다.");
	}
	
	@Test
	void testMemberDAO() {
		System.out.println("이것은 MemberDAO를 테스트 합니다.");
		MemberDAO memberDAO = new MemberDAO();
		//test하고자 하는 DAO의 메서드 호출
	}
}
```

### 패키징 생성
+ 프로젝트에서 우클릭 -> RunAs -> `maven install`
+ target/Mission2-SNAPSHOT.jar 생성 확인
+ jar파일에서 우클릭 -> show in terminal
+ `java -jar Mission2-0.0.1-SNAPSHOT.jar` 실행

### src/main/resources > "application.properties"
+ logging 메시지 level 옵션 설정
```java
logging.level.edu.pnu = "error / warn/ info / debug / trace 중 선택"
```

## 💜 JPA
+ File -> New -> Others -> Maven -> `Maven Project`
+ SQL 쿼리 간단하게 작성

### 관련파일
+ persistence.xml
   + 데이터베이스 접속정보 등
+ pom.xml
+ `@Entity` class : 데이터베이스의 테이블과 매치
   + EntityManagerFactory 
   + EntityManager


#### local : C:\workspace\SpringBoot
