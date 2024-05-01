package com.amaap.pokerbesthandextension.repository.impl;

import com.amaap.pokerbesthandextension.repository.db.InMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InMemoryCardRepositoryTest {

    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    InMemoryCardRepository inMemoryCardRepository = new InMemoryCardRepository(inMemoryDatabase);

    @Test
    void shouldBeAbleToAddCardIntoRepository() throws DuplicateCardException {
        // arrange
        String code = "H4";
        CardDto expected = new CardDto(code);

        // act
        CardDto actual = inMemoryCardRepository.add(expected);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenTryToAddDuplicateCardIntoRepository() throws DuplicateCardException {
        // arrange
        String code = "H4";
        CardDto card = new CardDto(code);


        // act
        inMemoryCardRepository.add(card);

        // assert
        assertThrows(DuplicateCardException.class,()->inMemoryCardRepository.add(card));
    }
}