package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.Member;

// extends<타입, id가 매핑된 pk 타입>
//인터페이스만 만들면 구현체를 스프링 데이터 JPA가 만들어서 넣어준다.
//즉 MemberJpaRepository 처럼 우리가 직접 만들지 않고 해결이 가능하다
public interface MemberRepository extends JpaRepository<Member,Long> {

}
