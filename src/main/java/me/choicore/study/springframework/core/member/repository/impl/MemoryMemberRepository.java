package me.choicore.study.springframework.core.member.repository.impl;

import me.choicore.study.springframework.core.member.entity.Member;
import me.choicore.study.springframework.core.member.repository.MemberRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(final Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(final Long memberId) {
        return store.get(memberId);
    }
}
