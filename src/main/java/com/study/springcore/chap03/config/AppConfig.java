package com.study.springcore.chap03.config;

import com.study.springcore.chap03.AsianRestaurant;
import com.study.springcore.chap03.Chef;
import com.study.springcore.chap03.Course;
import com.study.springcore.chap03.Hotel;
import com.study.springcore.chap03.KimChef;
import com.study.springcore.chap03.JohnChef;
import com.study.springcore.chap03.Restaurant;
import com.study.springcore.chap03.SushiCourse;
import com.study.springcore.chap03.WesturnCourse;
import com.study.springcore.chap03.WesturnRestaurant;

// 객체 생성의 제어권을 모두 이 클래스에 작성할 예정
public class AppConfig {

    // 쉐프 객체 생성
    public Chef chef1() {
        return new KimChef();
    }

    public Chef chef2() {
        return new JohnChef();
    }

    // 요리 코스 객체 생성
    public Course courses1() {
        return new SushiCourse();
    }

    public Course courses2() {
        return new WesturnCourse();
    }

    // 레스토랑 객체 생성
    public Restaurant restaurant1() {
        return new WesturnRestaurant(chef2(),  courses2());
    }

    public Restaurant restaurant2() {
        return new AsianRestaurant(chef1(), courses1());
    }

    // 호텔 객체 생성
    public Hotel hotel() {
        return new Hotel(restaurant2(), chef1());
    }
}
