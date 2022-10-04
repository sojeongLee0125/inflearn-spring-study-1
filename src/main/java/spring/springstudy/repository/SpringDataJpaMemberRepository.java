package spring.springstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.springstudy.domain.Member;

import java.util.Optional;

// 스프링 데이터 JPA가 SpringDataJpaMemberRepository 를 스프링 빈으로 자동 등록해준다
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
