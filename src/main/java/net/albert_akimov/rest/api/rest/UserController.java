package net.albert_akimov.rest.api.rest;

import net.albert_akimov.rest.api.model.User;
import net.albert_akimov.rest.api.rest.impl.AbstractControllerImpl;
import net.albert_akimov.rest.api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 22.03.2020
 * @Description:
 */

@RestController
@RequestMapping("/rest/api/v1/users")
public class UserController extends AbstractControllerImpl<User, UserService> {

    protected UserController(UserService service) {
        super(service);
    }

    @Override
    public ResponseEntity<User> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<User> save(User entity) {
        return super.save(entity);
    }

    @Override
    public ResponseEntity<User> update(User entity) {
        return super.update(entity);
    }

    @Override
    public ResponseEntity<User> delete(Long id) {
        return super.delete(id);
    }

    @Override
    public ResponseEntity<List<User>> getAll() {
        return super.getAll();
    }
}
