package hello.hellospring;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
        // MemberRepository 는 인터페이스이고 인스턴스 생성을 하기 위해서는 MemoryMemberRepository를 해야함.
    }

    //Controller 는 스프링이 관리하는 거기 때문에 @Controller로 두면 컴포넌트 스캔으로 올라감. 오토 와이어로 해야함.

}
