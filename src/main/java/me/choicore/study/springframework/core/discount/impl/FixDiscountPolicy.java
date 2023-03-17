package me.choicore.study.springframework.core.discount.impl;

import me.choicore.study.springframework.core.discount.DiscountPolicy;
import me.choicore.study.springframework.core.member.entity.Grade;
import me.choicore.study.springframework.core.member.entity.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    @Override
    public int discount(final Member member, final int price) {
        if (member.getGrade() == Grade.VIP) {
            return 1000;
        } else {
            return 0;
        }
    }
}
