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
    void shouldBeAbleToCreateCard() throws InvalidCardCodeException, DuplicateCardException {
        // arrange
        String code = "H4";
        CardDto expected = new CardDto(code);

        // act
        CardDto actual = cardService.create(code);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenTryToCreateDuplicateCard() throws DuplicateCardException, InvalidCardCodeException {
        // arrange
        String code = "H4";

        // act
        cardService.create(code);

        // assert
        assertThrows(DuplicateCardException.class,()->cardService.create(code));
    }

    @Test
    void shouldBeAbleToGetCardByCode() throws DuplicateCardException, InvalidCardCodeException {
        // arrange
        String code = "C8";
        CardDto expected = new CardDto(code);
        cardService.create(code);

        // act
        CardDto actual = cardService.get(code);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetNullWhenCardNotFound(){
        // arrange
        String code = "C8";

        // act
        CardDto actual = cardService.get(code);

        // assert
        assertNull(actual);
    }
}