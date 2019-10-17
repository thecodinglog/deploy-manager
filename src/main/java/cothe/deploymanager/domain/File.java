package cothe.deploymanager.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

/**
 * @author Jeongjin Kim
 * @since 2019-10-15
 */
@Embeddable
@AllArgsConstructor
@Getter
public class File {
    private String file;
    private String fileName;
    public File() {
    }
}
