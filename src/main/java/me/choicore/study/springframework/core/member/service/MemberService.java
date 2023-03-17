package me.choicore.study.springframework.core.member.service;

import me.choicore.study.springframework.core.member.entity.Member;

public interface MemberService {

    void join(Member meber);

    Member findMember(Long memberId);

}
