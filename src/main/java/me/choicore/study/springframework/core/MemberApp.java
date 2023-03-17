package me.choicore.study.springframework.core;

import me.choicore.study.springframework.core.member.entity.Grade;
import me.choicore.study.springframework.core.member.entity.Member;
import me.choicore.study.springframework.core.member.service.MemberService;

public class MemberApp {

    public static void main(String[] args) {
        Member member = new Member(1L, "memberA", Grade.VIP);
        AppConfig appConfig = AppConfig.getInstance();
        MemberService memberService = appConfig.memberService();
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
