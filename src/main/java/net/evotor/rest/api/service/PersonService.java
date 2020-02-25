package net.evotor.rest.api.service;

import net.evotor.rest.api.model.Person;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 21.02.2020
 * @Description:
 */
public interface PersonService {

    Person getById(Long id);
    void save(Person person);
    void delete(Long id);
    List<Person> getAll();

}
