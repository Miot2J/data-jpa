package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
//  실무에서 엔티티에는 게터세터를 왠만하면 사용하지 말고 네이밍 메서드 사용
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    // JPA fetch는 왠만하면 지연 로딩을 선택하자 실무에서 성능 튜닝하기가 용이하다.
    @ManyToOne(fetch = FetchType.LAZY)
    //외래키 이름 지정
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username) {
        this(username, 0);
    }

    public Member(String username, int age) {
        this(username, age, null);
    }

    // 아래와같은 방식을 사용하면 세터를 사용 안할 수 있음
    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }

    //멤버는 팀을 변경 할 수 있다.
    public void changeTeam(Team team) {
        this.team = team;
        //변경시 팀에 있는 멤버도 변경이 되어야함
        team.getMembers().add(this);
    }
}

