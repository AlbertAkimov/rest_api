package net.albert_akimov.rest.api.rest;

import net.albert_akimov.rest.api.dto.AuthenticationRequestDTO;
import net.albert_akimov.rest.api.model.User;
import net.albert_akimov.rest.api.rest.impl.AbstractControllerImpl;
import net.albert_akimov.rest.api.security.jwt.JwtTokenProvider;
import net.albert_akimov.rest.api.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Authot: Albert Akimov
 * @Date: 22.03.2020
 * @Description:
 */

@RestController
@RequestMapping(value = "/api/v1/auth/")
public class UserController extends AbstractControllerImpl<User, UserServiceImpl> {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    protected UserController(UserServiceImpl service, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        super(service);
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDTO requestDTO) {

        try {

            String username = requestDTO.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDTO.getPassword()));

            User user = service.findByUsername(username);

            if(user == null)
                throw new UsernameNotFoundException("User with username: " + username + "not found");

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return ResponseEntity.ok(response);

        }catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity register(@RequestBody AuthenticationRequestDTO requestDTO) {

        String username = requestDTO.getUsername();

        User verifiable = service.findByUsername(username);

        if(verifiable != null)
            throw new UsernameNotFoundException("username: " + username + " already exist");

        User user = new User();
        user.setUsername(requestDTO.getUsername());
        user.setPassword(requestDTO.getPassword());

        User registeredUser = service.register(user);

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDTO.getPassword()));

        Map<Object, Object> response = new HashMap<>();
        response.put("username", registeredUser.getUsername());

        return ResponseEntity.ok(response);

    }



}
