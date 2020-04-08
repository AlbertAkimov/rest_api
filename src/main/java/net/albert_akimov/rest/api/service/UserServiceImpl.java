package net.albert_akimov.rest.api.service;

import net.albert_akimov.rest.api.model.Role;
import net.albert_akimov.rest.api.model.Status;
import net.albert_akimov.rest.api.model.User;
import net.albert_akimov.rest.api.repository.RoleRepository;
import net.albert_akimov.rest.api.repository.UserRepository;
import net.albert_akimov.rest.api.service.impl.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 22.03.2020
 * @Description:
 */
@Service
public class UserServiceImpl extends AbstractServiceImpl<User, UserRepository> implements UserService  {

    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        super(repository);
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user) {

        Role roleUser = roleRepository.findByName("ROLE_USER");

        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        save(user);

        return user;
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
