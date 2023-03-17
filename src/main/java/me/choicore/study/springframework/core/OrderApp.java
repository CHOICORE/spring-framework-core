package me.choicore.study.springframework.core;

import me.choicore.study.springframework.core.member.entity.Grade;
import me.choicore.study.springframework.core.member.entity.Member;
import me.choicore.study.springframework.core.member.service.MemberService;
import me.choicore.study.springframework.core.order.entity.Order;
import me.choicore.study.springframework.core.order.service.OrderService;

public class OrderApp {

    public static void main(String[] args) {

        // 시작 시간
        long start = System.currentTimeMillis();


        AppConfig appConfig = AppConfig.getInstance();

        MemberService memberService = appConfig.memberService();

        OrderService orderService = appConfig.orderService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);


        Order order = orderService.createOrder(member.getId(), "itemA", 10000);
        order.calculatedPrice();

        // 종료 시간
        long end = System.currentTimeMillis();

        System.out.println("실행 시간 : " + (end - start) + "ms");


        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatedPrice());


    }
}
