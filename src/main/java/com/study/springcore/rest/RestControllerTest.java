package com.study.springcore.rest;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // 빈 등록을 해야 요청이 들어올 때 메서드를 호출할 수 있다.
// RestController 안에 있는 모든 메서드는 return 값이 JSON으로 변환되어
// 클라이언트엘게 전송됩니다. -> 더이상 백엔드는 화면에 관여하지 않는다
public class RestControllerTest {

    @GetMapping("/rest/list")
//    @ResponseBody -> 클라이언트로 데이터를 JSON로 변환 후 바로 던지는 문법.
    public List<String> method1() {

        List<String> list = List.of("hello", "world", "spring", "boot", "java");

        return list;
    }

    @PostMapping("/rest/object")
    public Person method2() {
        Person person = new Person();

        person.setAge(30);
        person.setName("김춘식");
        person.setHobbies(List.of("놀기", "밥먹기", "독서"));

        return person;
    }

    // 클라이언트(리액트)단에서 JSON 데이터를 보내고 있다.
    // 1. JSON 형태로 생긴 클래스가 있다 -> 그 객체로 받으면 되고
    // 2. JSON 형태로 생긴 클래스가 없다 -> Map으로 받으면 된다
    // 3. 클라이언트가 전송하는 데이터가 JSON이라면 @RequestBody를 붙여야
    // 자바 객체로 변환이 가능하다 -> 안붙이면 텅텅 빈 객체를 확인할 수 있다
    @PostMapping("/rest/regist")
    public String method3(@RequestBody Person person) {

        System.out.println(person);

        return "ok";
    }

    // url에 포함되어있는 특정 정보 얻어오기
    // @PathVariable: url에 포함되어있는 특정 값을 얻어옴
    @GetMapping("/rest/posts/{bno}")
    public String method4(@PathVariable String bno) {
        System.out.println("bno: " + bno);
        return "ok";
    }

}
