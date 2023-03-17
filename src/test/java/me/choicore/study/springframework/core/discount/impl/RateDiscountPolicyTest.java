package me.choicore.study.springframework.core.discount.impl;

import me.choicore.study.springframework.core.member.entity.Grade;
import me.choicore.study.springframework.core.member.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_ok() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // when
        int discountedPrice = rateDiscountPolicy.discount(member, 10000);

        // then
        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되면 안된다.")
    void vip_no() {
        // given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        // when
        int discountedPrice = rateDiscountPolicy.discount(member, 10000);

        // then
        assertThat(discountedPrice).isEqualTo(0);
    }
}