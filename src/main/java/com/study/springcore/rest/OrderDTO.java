package com.study.springcore.rest;

// DTO: Data Transfer Object
// 비즈니스 로직 없이 순수하게 전달하고싶은 데이터를 담는 용도로 사용하는 객체
// 요청 DTO, 응답 DTO로 나누어 사용. 꼭 필요한 데이터만 정제해서 전달하는 용도로 사용한다.

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
public class OrderDTO {
    private String orderNum;
    private String goods;
    private int price;
    private int amount;

}
