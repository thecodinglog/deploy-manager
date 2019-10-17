package cothe.deploymanager.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Jeongjin Kim
 * @since 2019-10-15
 */
@Entity
@AllArgsConstructor
@Getter
@Setter
public class Program {
    @Id
    private String programId;
    @ManyToOne
    private Chain chain;
    private String programName;

    public Program() {
    }
}
