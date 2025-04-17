package com.study.springcore.chap04;

import org.springframework.stereotype.Component;

// 스프링이 자동으로 객체를 생성하고, 그 객체의 생명주기 및 기타 등등을 관리하게 하겠다
// 같은 타입의 객체를 여러개 등록 할때에는 별칭을 지어주는게 좋다
@Component("john")
public class JohnChef implements Chef {

    public void cook() {
        System.out.println("안녕하세요. John 쉐프입니다.");
        System.out.println("요리를 시작합니다.");
    }
}
