package spring.springstudy.repository;

import org.springframework.stereotype.Repository;
import spring.springstudy.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    // 동시성 문제를 고려해서 실무에서는 ConcurrentHashMap을 사용한다.
    private static Map<Long, Member> store = new HashMap<>();
    // 동시성 문제를 고려해서 실무에서는 AtomicLong을 사용한다.
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
