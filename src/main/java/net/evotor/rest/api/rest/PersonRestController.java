package net.evotor.rest.api.rest;

import net.evotor.rest.api.model.Person;
import net.evotor.rest.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authot: Albert Akimov
 * @Date: 25.02.2020
 * @Description:
 */

@RestController
@RequestMapping("/api/v1/evotor/")
public class PersonRestController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Person person = this.personService.getById(id);

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
