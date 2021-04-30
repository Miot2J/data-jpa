package study.datajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//  실무에서 엔티티에는 게터세터를 왠만하면 사용하지 말고 네이밍 메서드 사용
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    private String username;

    protected Member(Long id) {
        this.id = id;
    }
    // 아래와같은 방식을 사용하면 세터를 사용 안할 수 있음
    public Member(String username) {
        this.username = username;
    }

}
