package net.albert_akimov.rest.api.service;

import net.albert_akimov.rest.api.model.Card;
import net.albert_akimov.rest.api.repository.CardRepository;
import net.albert_akimov.rest.api.service.impl.AbstractServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Authot: Albert Akimov
 * @Date: 27.02.2020
 * @Description:
 */

@Service
public class CardService extends AbstractServiceImpl<Card, CardRepository> {

    public CardService(CardRepository repository) {
        super(repository);
    }
}
