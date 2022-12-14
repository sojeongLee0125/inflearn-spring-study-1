package spring.springstudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.springstudy.aop.TimeTraceAOP;
import spring.springstudy.repository.MemberRepository;
import spring.springstudy.service.MemberService;

@Configuration
public class SpringConfig {

    //private DataSource dataSource;
    //private EntityManager em;
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

  /*  @Bean
    public MemberRepository memberRepository() {
        // 스프링의 DI (Dependencies Injection)을 사용하면 기존 코드를 전혀 손대지 않고,
        // 설정만으로 구현 클래스를 변경할 수 있다.
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
    }*/
}
