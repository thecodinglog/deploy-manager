package cothe.deploymanager.repository;

import cothe.deploymanager.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jeongjin Kim
 * @since 2019-10-15
 */
public interface FileRepository extends JpaRepository<File, String> {
}
