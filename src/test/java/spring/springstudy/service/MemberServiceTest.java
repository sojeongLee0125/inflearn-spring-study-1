package spring.springstudy.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spring.springstudy.domain.Member;
import spring.springstudy.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    // 테스트 케이스의 memberRepository는 service의 memberRepository와 서로 다른 객체
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    void clearEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("test1");

        // when
        Long id = memberService.join(member);

        // then
        Member findMember = memberService.findOne(id).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복회원검사() {
        // given
        Member member = new Member();
        member.setName("test1");

        Member member2 = new Member();
        member2.setName("test1");

        // when
        memberService.join(member);

        // then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}