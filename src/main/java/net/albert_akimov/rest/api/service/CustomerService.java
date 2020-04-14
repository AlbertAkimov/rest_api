package net.albert_akimov.rest.api.service;

import net.albert_akimov.rest.api.model.Customer;
import net.albert_akimov.rest.api.repository.CustomerRepository;
import net.albert_akimov.rest.api.service.impl.AbstractServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Authot: Albert Akimov
 * @Date: 26.02.2020
 * @Description:
 */

@Service
public class CustomerService extends AbstractServiceImpl<Customer, CustomerRepository> {

    public CustomerService(CustomerRepository repository) {
        super(repository);
    }
}
