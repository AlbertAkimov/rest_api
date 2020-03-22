import net.albert_akimov.rest.api.ApplicationRest;
import net.albert_akimov.rest.api.model.Card;
import net.albert_akimov.rest.api.model.Person;
import net.albert_akimov.rest.api.service.abstract_interfaces.AbstractService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @Authot: Albert Akimov
 * @Date: 26.02.2020
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationRest.class)
@SpringBootConfiguration
@ContextConfiguration
public class TestPersonAPI{

    @Autowired
    private AbstractService personService;

    @Test
    public void addPerson() {
        Person person = new Person();
        person.setFirstName("Albert");
        person.setLastName("Akimov");
        person.setActive(true);
        person.setUuid_id(UUID.randomUUID().toString());

        Card card = new Card();
        card.setUuid_id(UUID.randomUUID().toString());
        card.setNumberCard("AA89997741555_[E-Marine][885522.87]");

        person.setCard(card);

        personService.save(person);
    }
}
