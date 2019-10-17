package cothe.deploymanager.repository;

import cothe.deploymanager.domain.DeployRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jeongjin Kim
 * @since 2019-10-15
 */
public interface DeployRequestRepository extends JpaRepository<DeployRequest, Long> {
}
