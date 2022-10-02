package spring.springstudy.repository;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spring.springstudy.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        // 테스트는 독립적으로 시행되어야 한다. 각 테스트마다 데이터를 클리어 해주어야 한다.
        repository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member();
        member.setName("test-spring");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);

    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("test1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        repository.save(member2);

        // when
        Member member = repository.findByName("test1").get();

        // then
        assertThat(member).isEqualTo(member1);
        //assertThat(member).isEqualTo(member2);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("test1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        repository.save(member2);

        //when
        List<Member> all = repository.findAll();

        //then
        assertThat(all.size()).isEqualTo(2);
    }
}