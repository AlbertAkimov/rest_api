package net.albert_akimov.rest.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Authot: Albert Akimov
 * @Date: 26.02.2020
 * @Description:
 */

@Entity
@Table(name = "cards")
@Getter
@Setter
@ToString
public class Card extends AbstractEntity {

    @Column(name = "number_card")
    private String numberCard;

/*    @OneToOne(mappedBy = "card", cascade = CascadeType.ALL)
    private Person person;*/

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

/*    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }*/
}
