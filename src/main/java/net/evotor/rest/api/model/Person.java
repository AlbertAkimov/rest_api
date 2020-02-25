package net.evotor.rest.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Authot: Albert Akimov
 * @Date: 21.02.2020
 * @Description:
 */

@Entity
@Table(name = "persons")
@Getter
@Setter
@ToString
public class Person extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
