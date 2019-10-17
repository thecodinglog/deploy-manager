package cothe.deploymanager.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Jeongjin Kim
 * @since 2019-10-15
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
public final class Chain {
    @Id
    private String chainId;
    private String chainName;

    public Chain() {
    }
}
