package cothe.deploymanager.repository;

import cothe.deploymanager.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jeongjin Kim
 * @since 2019-10-15
 */
public interface ProgramRepository extends JpaRepository<Program, String> {
}
