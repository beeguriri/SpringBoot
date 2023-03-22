### SpringBoot 수업

### src/main/java/
> Application.java

### src/main/java/controller
> `@RestController` <br>
> 요청과 응답 처리
> DemoApplication 파일이 있는 하부 패키지의 클래스를 인스턴스로 생성
  + `Read` @GetMapping("/member") 
  + @GetMapping("/member/{id}")
    ```java
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

<br><br>
<hr>

#### local : C:\workspace\SpringBoot
