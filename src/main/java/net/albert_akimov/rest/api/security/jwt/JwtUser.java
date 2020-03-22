package net.albert_akimov.rest.api.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * @Authot: Albert Akimov
 * @Date: 22.03.2020
 * @Description:
 */
public class JwtUser implements UserDetails {

    private final Long id;
    private final String uuid_id;
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Date lastPasswordResetDate;
    private final boolean enabled;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(
            Long id,
            String uuid_id,
            String username,
            String password,
            String firstName,
            String lastName,
            String email,
            Date lastPasswordResetDate,
            boolean enabled,
            Collection<? extends GrantedAuthority> authorities)
    {
        this.id = id;
        this.uuid_id = uuid_id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public String getUuid_id() {
        return uuid_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
