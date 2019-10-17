package cothe.deploymanager.repository;

import cothe.deploymanager.domain.Chain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.Transient;

/**
 * @author Jeongjin Kim
 * @since 2019-10-15
 */
public interface ChainRepository extends JpaRepository<Chain, String> {
}
