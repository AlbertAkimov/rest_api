package net.evotor.rest.api.service;

import lombok.extern.slf4j.Slf4j;
import net.evotor.rest.api.model.Person;
import net.evotor.rest.api.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 21.02.2020
 * @Description:
 */
@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonsRepository personsRepository;

    @Override
    public Person getById(Long id) {
        return personsRepository.findOne(id);
    }

    @Override
    public void save(Person person) {
        personsRepository.save(person);
    }

    @Override
    public void delete(Long id) {
        personsRepository.delete(id);
    }

    @Override
    public List<Person> getAll() {
        return personsRepository.findAll();
    }
}
