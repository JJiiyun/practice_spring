package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

//회원 객체를 저장하는 저장소
public interface MemberRepository {
    Member save(Member member); // 회원을 저장하면 저장된 회원이 반환됨
    //Optional은 Java8 에 들어가 있는 기능으로 null을 그대로 반환하는 방법 대신 Optional 이라는 걸로 감싸서 반환하는 방법
    Optional<Member> findById(Long id); //아이디로 회원을 찾는 메소드
    Optional<Member> findByName(String name); //이름으로 회원을 찾는 메소드
    List<Member> findAll(); //저장된 모든 회원을 반환해줌.
}
