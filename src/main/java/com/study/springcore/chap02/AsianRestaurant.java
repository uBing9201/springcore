package com.study.springcore.chap02;

public class AsianRestaurant implements Restaurant {

    private KimChef chef = new KimChef();

    private SushiCourse course = new SushiCourse();

    public void order() {
        System.out.println("안녕하세요. 아시아 레스토랑 입니다.");
        chef.cook();
        course.combineMenu();
    }

}
