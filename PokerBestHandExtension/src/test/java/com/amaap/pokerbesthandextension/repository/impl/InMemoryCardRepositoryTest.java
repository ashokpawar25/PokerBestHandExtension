package com.amaap.pokerbesthandextension.repository.impl;

import com.amaap.pokerbesthandextension.AppModule;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCardRepositoryTest {
    InMemoryCardRepository inMemoryCardRepository;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        inMemoryCardRepository = injector.getInstance(InMemoryCardRepository.class);
    }

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
        assertThrows(DuplicateCardException.class, () -> inMemoryCardRepository.add(card));
    }

    @Test
    void shouldBeAbleToGetCardByCode() throws DuplicateCardException {
        // arrange
        String code = "C8";
        CardDto expected = new CardDto(code);
        inMemoryCardRepository.add(expected);

        // act
        CardDto actual = inMemoryCardRepository.findCard(code);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetNullWhenCardNotFoundIntoDatabase() {
        // arrange
        String code = "C8";

        // act
        CardDto actual = inMemoryCardRepository.findCard(code);

        // assert
        assertNull(actual);
    }
}