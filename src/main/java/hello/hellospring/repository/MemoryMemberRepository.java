package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository
{
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //0, 1, 2와 같이 key 값을 생성해줌

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
                .findAny(); //하나라도 찾으면 Optional로 반환이 됨.
    }

    @Override
    public List<Member> findAll() { //loop 돌리기 편해서 실무에서 많이 사용함.
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
