package com.amaap.pokerbesthandextension.service;

import com.amaap.pokerbesthandextension.controller.dto.HttpStatus;
import com.amaap.pokerbesthandextension.controller.dto.Response;
import com.amaap.pokerbesthandextension.repository.CardRepository;
import com.amaap.pokerbesthandextension.repository.db.InMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import com.amaap.pokerbesthandextension.repository.impl.InMemoryCardRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardServiceTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    CardRepository cardRepository = new InMemoryCardRepository(inMemoryDatabase);
    CardService cardService = new CardService(cardRepository);

    @Test
    void shouldBeAbleToGetOkResponseWhenCardCreatedSuccessfully() throws InvalidCardCodeException, DuplicateCardException {
        // arrange
        String code = "H4";
        CardDto expected = new CardDto(code);

        // act
        CardDto actual = cardService.create(code);

        // assert
        assertEquals(expected,actual);
    }
}