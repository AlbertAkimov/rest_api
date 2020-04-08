package net.albert_akimov.rest.api.rest.abstract_interfaces;

import net.albert_akimov.rest.api.model.AbstractEntity;
import net.albert_akimov.rest.api.model.Role;
import net.albert_akimov.rest.api.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 26.02.2020
 * @Description:
 */
public interface AbstractController<E extends AbstractEntity> {

    ResponseEntity<E> getById(Long id);

    ResponseEntity<E> save(E entity);

    ResponseEntity<E> update(E entity);

    ResponseEntity<E> delete(Long id);

    ResponseEntity<List<E>> getAll();

}
