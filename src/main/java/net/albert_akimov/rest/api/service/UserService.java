package net.albert_akimov.rest.api.service;

import net.albert_akimov.rest.api.model.User;

/**
 * @Authot: Albert Akimov
 * @Date: 06.04.2020
 * @Description:
 */
public interface UserService {

    User findByUsername(String username);
}
