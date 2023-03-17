package me.choicore.study.springframework.core;

import me.choicore.study.springframework.core.discount.DiscountPolicy;
import me.choicore.study.springframework.core.discount.impl.FixDiscountPolicy;
import me.choicore.study.springframework.core.member.repository.impl.MemoryMemberRepository;
import me.choicore.study.springframework.core.member.service.MemberService;
import me.choicore.study.springframework.core.member.service.impl.MemberServiceImpl;
import me.choicore.study.springframework.core.order.repository.impl.MemoryOrderRepository;
import me.choicore.study.springframework.core.order.service.OrderService;
import me.choicore.study.springframework.core.order.service.impl.OrderServiceImpl;

public class AppConfig {
    private static volatile AppConfig INSTANCE;

    protected AppConfig() {
        // private 생성자
    }

    public static AppConfig getInstance() {
        if (INSTANCE == null) {
            synchronized (AppConfig.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppConfig();
                }
            }
        }
        return INSTANCE;
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memoryMemberRepository(), memoryOrderRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

    public MemoryMemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }

    public MemoryOrderRepository memoryOrderRepository() {
        return new MemoryOrderRepository();
    }

}
