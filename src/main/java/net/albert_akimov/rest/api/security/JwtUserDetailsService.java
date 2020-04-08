package net.albert_akimov.rest.api.security;

import lombok.extern.slf4j.Slf4j;
import net.albert_akimov.rest.api.model.User;
import net.albert_akimov.rest.api.security.jwt.JwtUser;
import net.albert_akimov.rest.api.security.jwt.JwtUserFactory;
import net.albert_akimov.rest.api.service.UserService;
import net.albert_akimov.rest.api.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Authot: Albert Akimov
 * @Date: 22.03.2020
 * @Description:
 */
@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if(user == null)
            throw new UsernameNotFoundException("User with username: " + username + " not found");

        JwtUser jwtUser = JwtUserFactory.create(user);

        //log

        return jwtUser;
    }
}
