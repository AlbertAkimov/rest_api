package net.albert_akimov.rest.api.service;

import net.albert_akimov.rest.api.model.Person;
import net.albert_akimov.rest.api.repository.PersonRepository;
import net.albert_akimov.rest.api.service.impl.AbstractServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Authot: Albert Akimov
 * @Date: 26.02.2020
 * @Description:
 */

@Service
public class PersonService extends AbstractServiceImpl<Person, PersonRepository> {

    public PersonService(PersonRepository repository) {
        super(repository);
    }
}
