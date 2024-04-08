package cicd.cicdtest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {
    @Id
    @Column(name = "member_id")
    private String id;

    private String password;
    private String name;

    private Integer money;

    public Member(String id, String password, String name, Integer money) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.money = money;
    }

    public void addMoney(){
        this.money++;
    }
}
