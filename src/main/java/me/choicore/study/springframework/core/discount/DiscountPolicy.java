package me.choicore.study.springframework.core.discount;

import me.choicore.study.springframework.core.member.entity.Member;

public interface DiscountPolicy {

    /**
     *
     * @param member
     * @param price
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);


}
