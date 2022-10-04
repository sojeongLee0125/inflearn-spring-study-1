package spring.springstudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.springstudy.repository.JdbcMemberRepository;
import spring.springstudy.repository.JdbcTemplateMemberRepository;
import spring.springstudy.repository.MemberRepository;
import spring.springstudy.repository.MemoryMemberRepository;
import spring.springstudy.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // 스프링의 DI (Dependencies Injection)을 사용하면 기존 코드를 전혀 손대지 않고,
        // 설정만으로 구현 클래스를 변경할 수 있다.
        // return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
