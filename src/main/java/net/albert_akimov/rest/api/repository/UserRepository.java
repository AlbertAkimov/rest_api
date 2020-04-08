package net.albert_akimov.rest.api.repository;

import net.albert_akimov.rest.api.model.User;
import org.springframework.stereotype.Repository;

/**
 * @Authot: Albert Akimov
 * @Date: 22.03.2020
 * @Description:
 */
@Repository
public interface UserRepository extends AbstractRepository<User>  {
    User findByUsername(String username);
}
