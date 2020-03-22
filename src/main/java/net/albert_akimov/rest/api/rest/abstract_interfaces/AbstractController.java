package net.albert_akimov.rest.api.rest.abstract_interfaces;

import net.albert_akimov.rest.api.model.AbstractEntity;
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

    @GetMapping
    ResponseEntity<E> getById(@PathVariable("id") Long id);

    @PostMapping
    ResponseEntity<E> save(@RequestBody @Valid E entity);

    @PutMapping
    ResponseEntity<E> update(@RequestBody @Valid E entity);

    @DeleteMapping
    ResponseEntity<E> delete(@PathVariable("id") Long id);

    @GetMapping
    ResponseEntity<List<E>> getAll();
}
