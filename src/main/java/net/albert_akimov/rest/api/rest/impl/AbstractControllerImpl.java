package net.albert_akimov.rest.api.rest.impl;

import net.albert_akimov.rest.api.model.AbstractEntity;
import net.albert_akimov.rest.api.model.Role;
import net.albert_akimov.rest.api.model.User;
import net.albert_akimov.rest.api.rest.abstract_interfaces.AbstractController;
import net.albert_akimov.rest.api.service.abstract_interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 26.02.2020
 * @Description:
 */
public abstract class AbstractControllerImpl<E extends AbstractEntity, S extends AbstractService<E>>
        implements AbstractController<E> {

    protected final S service;

    @Autowired
    protected AbstractControllerImpl(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<E> getById(@PathVariable("id") Long id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        E entity = this.service.getById(id);

        if (entity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<E>(entity, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<E> save(@RequestBody @Valid E entity) {

        HttpHeaders headers = new HttpHeaders();

        if(entity == null) {
            return new ResponseEntity<E>(HttpStatus.BAD_REQUEST);
        }

        this.service.save(entity);
        return new ResponseEntity<>(entity, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<E> update(@RequestBody @Valid E entity) {

        HttpHeaders headers = new HttpHeaders();

        if (entity == null) {
            return new ResponseEntity<E>(HttpStatus.BAD_REQUEST);
        }

        this.service.save(entity);

        return new ResponseEntity<E>(entity, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<E> delete(@PathVariable("id") Long id) {

        E entity = service.getById(id);

        if(entity == null)
            return new ResponseEntity<E>(HttpStatus.NOT_FOUND);

        this.service.delete(id);

        return new ResponseEntity<E>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<E>> getAll() {

        List<E> entities = this.service.getAll();

        if(entities.isEmpty())
            return new ResponseEntity<List<E>>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<E>>(entities, HttpStatus.OK);
    }

}
