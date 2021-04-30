package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testMember(){

        Member member = new Member("memberA");
        Member savedMember = memberRepository.save(member);

        // 조회
        // 기본적으로 상속 받은 jpaMemberRepository 에서 findById 제공해준다 리턴 타입은 Optional(객체가 없는 경우 널을 반환해야해서)
        Optional<Member> byId = memberRepository.findById(savedMember.getId());
        Member member1 = byId.get();


        //검증
        assertThat(member1.getId()).isEqualTo(member.getId());
        assertThat(member1.getUsername()).isEqualTo(member.getUsername());
        assertThat(member1).isEqualTo(member);
    }

}
