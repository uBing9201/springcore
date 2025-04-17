package com.study.springcore.chap02;

/**
 * @solution
 * - 먼저 OCP와 DIP를 해결하기 위해 구체적인 객체 대신
 *  추상적인 역할에 의존하게끔 코드를 개선 (인터페이스 생성)
 *
 * @problem - 추상화를 했지만 여전히 의존 객체를 바꾸려면
 *            코드를 직접 변경해야 한다.
 */
public class Hotel {

    // 레스토랑
    private final Restaurant restaurant = new WesturnRestaurant();

    // 헤드쉐프
    private final Chef headChef = new JohnChef();

    // 호텔을 소개하는 기능
    public void inform() {
        System.out.printf("우리 호텔의 레스토랑은 %s 입니다. 그리고 헤드 쉐프는 %s입니다.\n",
                restaurant.getClass().getSimpleName(),
                headChef.getClass().getSimpleName()); // 단순 클래스명 뽑아오기

        restaurant.order();
    }
}
