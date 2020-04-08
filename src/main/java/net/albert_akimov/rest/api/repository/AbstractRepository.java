package net.albert_akimov.rest.api.repository;

import net.albert_akimov.rest.api.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Authot: Albert Akimov
 * @Date: 21.02.2020
 * @Description: Repository interface for {@link net.albert_akimov.rest.api.model.AbstractEntity}
 */
@NoRepositoryBean
public interface AbstractRepository<E extends AbstractEntity> extends JpaRepository<E, Long> {
}
