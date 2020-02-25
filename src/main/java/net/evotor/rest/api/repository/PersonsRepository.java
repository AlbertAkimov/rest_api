package net.evotor.rest.api.repository;

import net.evotor.rest.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Authot: Albert Akimov
 * @Date: 21.02.2020
 * @Description: Repository interface for {@link net.evotor.rest.api.model.Person}
 */
public interface PersonsRepository extends JpaRepository<Person, Long> {


}
