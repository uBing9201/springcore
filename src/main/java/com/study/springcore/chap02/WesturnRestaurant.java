package com.study.springcore.chap02;

public class WesturnRestaurant implements  Restaurant {

    private JohnChef chef = new JohnChef();

    private WesturnCourse courses = new WesturnCourse();

    public void order() {
        System.out.println("안녕하세요. 서양 레스토랑 입니다.");

        chef.cook();

        courses.combineMenu();
    }
}
