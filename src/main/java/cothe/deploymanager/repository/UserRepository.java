package cothe.deploymanager.repository;

import cothe.deploymanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jeongjin Kim
 * @since 2019-10-15
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String name);
}
