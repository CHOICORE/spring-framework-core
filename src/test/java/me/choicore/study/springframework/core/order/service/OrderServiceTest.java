package me.choicore.study.springframework.core.order.service;

import me.choicore.study.springframework.core.AppConfig;
import me.choicore.study.springframework.core.member.entity.Grade;
import me.choicore.study.springframework.core.member.entity.Member;
import me.choicore.study.springframework.core.member.service.MemberService;
import me.choicore.study.springframework.core.order.entity.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {

    AppConfig appConfig = AppConfig.getInstance();
    MemberService memberService = appConfig.memberService();

    OrderService orderService = appConfig.orderService();

    @Test
    @DisplayName("주문 생성 테스트")
    void createOrder() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
        assertThat(order.calculatedPrice()).isEqualTo(9000);
    }

}