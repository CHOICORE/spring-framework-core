package me.choicore.study.springframework.core.member.repository;

import me.choicore.study.springframework.core.member.entity.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
