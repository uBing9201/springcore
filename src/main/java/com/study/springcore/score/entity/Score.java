package com.study.springcore.score.entity;

/*
    stu_num int primary key auto_increment,
	stu_name varchar(30) not null,
	kor int not null default 0,
	ent int not null default 0,
	math int not null default 0,
	total int not null default 0,
	average float,
	grade varchar(1)
*/

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 데이터베이스 테이블과 1:1로 매칭되는 필드를 가진 객체: Entity
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Score {

    private int stuNum;
    private String stuName;
    private int kor;
    private int eng;
    private int math;
    private int total;
    private double average;
    private Grade grade;

    public Score(String stuName, int kor, int eng, int math) {
        this.stuName = stuName;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}
