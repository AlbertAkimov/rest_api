import net.albert_akimov.rest.api.ApplicationRest;
import net.albert_akimov.rest.api.model.Card;
import net.albert_akimov.rest.api.model.Customer;
import net.albert_akimov.rest.api.model.Status;
import net.albert_akimov.rest.api.service.abstract_interfaces.AbstractService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * @Authot: Albert Akimov
 * @Date: 26.02.2020
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationRest.class)
@SpringBootConfiguration
@ContextConfiguration
public class TestCustomerAPI {

    @Autowired
    private AbstractService<Customer> personService;
    private List<Card> cards = new ArrayList<>();

    @Test
    public void addPerson() {
        Customer customer = new Customer();
        customer.setFirstName("Albert");
        customer.setLastName("Akimov");

        Card card = new Card();
        card.setNumberCard("AA89997741555_[E-Marine][885522.87]");
        card.setStatus(Status.ACTIVE);
        card.setCustomer(customer);


        cards.add(card);

        Card card2 = new Card();
        card2.setNumberCard("AA89997741555_[E-Marine][885522.87]_2");
        card2.setStatus(Status.ACTIVE);
        card2.setCustomer(customer);

        cards.add(card2);

        customer.setCards(cards);

        personService.save(customer);
    }

    @Test
    public void getCustomerById() {

        Customer customer = personService.getById(1L);

    }
}
