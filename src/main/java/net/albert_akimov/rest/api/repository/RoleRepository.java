package net.albert_akimov.rest.api.repository;

import net.albert_akimov.rest.api.model.Role;
import org.springframework.stereotype.Repository;

/**
 * @Authot: Albert Akimov
 * @Date: 22.03.2020
 * @Description:
 */
@Repository
public interface RoleRepository extends AbstractRepository<Role> {
    Role findByName(String name);
}
