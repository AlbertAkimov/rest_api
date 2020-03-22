package net.albert_akimov.rest.api.service.abstract_interfaces;

import net.albert_akimov.rest.api.model.AbstractEntity;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 21.02.2020
 * @Description:
 */
public interface AbstractService<E extends AbstractEntity> {

    E getById(Long id);
    void save(E entity);
    void delete(Long id);
    List<E> getAll();
    E findByName(String name);

}
