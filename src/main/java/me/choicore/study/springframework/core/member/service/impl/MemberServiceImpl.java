package me.choicore.study.springframework.core.member.service.impl;

import me.choicore.study.springframework.core.member.entity.Member;
import me.choicore.study.springframework.core.member.repository.MemberRepository;
import me.choicore.study.springframework.core.member.service.MemberService;


/**
 * DIP를 위반한 서비스 구현체
 */
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository; // = new MemoryMemberRepository();


    public MemberServiceImpl(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(final Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(final Long memberId) {
        return memberRepository.findById(memberId);
    }
}
