package net.albert_akimov.rest.api.dto;

import lombok.Data;

/**
 * @Authot: Albert Akimov
 * @Date: 22.03.2020
 * @Description:
 */

@Data
public class AuthenticationRequestDTO {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

}
