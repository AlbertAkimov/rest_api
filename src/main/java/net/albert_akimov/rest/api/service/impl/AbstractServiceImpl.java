package net.albert_akimov.rest.api.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.albert_akimov.rest.api.model.AbstractEntity;
import net.albert_akimov.rest.api.model.Role;
import net.albert_akimov.rest.api.model.User;
import net.albert_akimov.rest.api.repository.AbstractRepository;
import net.albert_akimov.rest.api.service.abstract_interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @Authot: Albert Akimov
 * @Date: 21.02.2020
 * @Description:
 */
@Slf4j
public abstract class AbstractServiceImpl<E extends AbstractEntity, R extends AbstractRepository<E>>
        implements AbstractService<E> {

    protected final R repository;

    @Autowired
    public AbstractServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E getById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void save(E entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public List<E> getAll() {
        return repository.findAll();
    }

}
