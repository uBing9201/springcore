package com.study.springcore.chap04;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("westurn")
public class WesturnRestaurant implements Restaurant {

    private Chef chef;
    private Course courses;

    public WesturnRestaurant(@Qualifier("john") Chef chef, @Qualifier("w") Course courses) {
        this.chef = chef;
        this.courses = courses;
    }

    public void order() {
        System.out.println("안녕하세요. 서양 레스토랑 입니다.");

        chef.cook();

        courses.combineMenu();
    }
}
