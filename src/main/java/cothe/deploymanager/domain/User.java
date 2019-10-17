package cothe.deploymanager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Jeongjin Kim
 * @since 2019-10-15
 */
@Entity
public class User {
    @Id @GeneratedValue
    private Long userId;
    @Setter
    @Getter
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public User() {
    }
}
