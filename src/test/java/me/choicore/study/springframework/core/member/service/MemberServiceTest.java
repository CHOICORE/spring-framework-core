package me.choicore.study.springframework.core.member.service;

import me.choicore.study.springframework.core.AppConfig;
import me.choicore.study.springframework.core.member.entity.Grade;
import me.choicore.study.springframework.core.member.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class MemberServiceTest {

    MemberService memberService = AppConfig.getInstance().memberService();

    @Test
    @DisplayName("회원가입을 한다.")
    void join() {

        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        // then
        assertThat(member).isEqualTo(findMember);
    }


}