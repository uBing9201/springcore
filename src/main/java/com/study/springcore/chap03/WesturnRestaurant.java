package com.study.springcore.chap03;

public class WesturnRestaurant implements Restaurant {

    private Chef chef;
    private Course courses;

    public WesturnRestaurant(Chef chef, Course courses) {
        this.chef = chef;
        this.courses = courses;
    }

    public void order() {
        System.out.println("안녕하세요. 서양 레스토랑 입니다.");

        chef.cook();

        courses.combineMenu();
    }
}
