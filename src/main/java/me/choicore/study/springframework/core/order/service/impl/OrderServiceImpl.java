package me.choicore.study.springframework.core.order.service.impl;

import me.choicore.study.springframework.core.discount.DiscountPolicy;
import me.choicore.study.springframework.core.member.entity.Member;
import me.choicore.study.springframework.core.member.repository.MemberRepository;
import me.choicore.study.springframework.core.order.entity.Order;
import me.choicore.study.springframework.core.order.repository.OrderRepository;
import me.choicore.study.springframework.core.order.service.OrderService;


public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;// = new MemoryMemberRepository();

    private final OrderRepository orderRepository; // = new OrderRepositoryImpl();

    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy; // = new RateDiscountPolicy();

public OrderServiceImpl(final MemberRepository memberRepository, final OrderRepository orderRepository, final DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.orderRepository = orderRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(final Long memberId, final String itemName, final int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountedPrice = discountPolicy.discount(member, itemPrice);

        Order order = new Order(1L, memberId, itemName, itemPrice, discountedPrice);
        orderRepository.save(order);
        return orderRepository.findById(order.getOrderId());

    }
}
