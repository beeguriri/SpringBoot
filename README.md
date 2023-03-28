### SpringBoot 수업

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
> 내부에서 자바 로직 처리

### src/main/java/edu/pnu/domain
> 데이터I/O

<br><hr>
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
<br><hr>
### 패키징 생성
+ 프로젝트에서 우클릭 -> RunAs -> `maven install`
+ target/Mission2-SNAPSHOT.jar 생성 확인
+ jar파일에서 우클릭 -> show in terminal
+ `java -jar Mission2-0.0.1-SNAPSHOT.jar` 실행
<br><hr>

### src/main/resources > "application.properties"
+ logging 메시지 level 옵션 설정
```java
logging.level.edu.pnu = "error / warn/ info / debug / trace 중 선택"
```


#### local : C:\workspace\SpringBoot
