package com.amaap.pokerbesthandextension.repository.impl;

import com.amaap.pokerbesthandextension.AppModule;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.HandNotFoundException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;
import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidHandSizeException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InMemoryHandRepositoryTest {
    InMemoryHandRepository inMemoryHandRepository;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        inMemoryHandRepository = injector.getInstance(InMemoryHandRepository.class);
    }

    @Test
    void shouldBeAbleToAddHandInRepository() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getFiveCards();
        Hand expected = new Hand(cards);

        // act
        Hand actual = inMemoryHandRepository.add(expected);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetListOfCardsForHand() throws HandNotFoundException, InvalidCardCodeException {
        // arrange
        List<CardDto> expected = CardBuilder.getFiveCards();
        Hand hand = new Hand(expected);

        // act
        inMemoryHandRepository.add(hand);
        List<CardDto> actual = inMemoryHandRepository.getCardsForHand(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenHandNotFoundInDatabase() throws InvalidHandSizeException, InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getFiveCards();
        Hand hand = Hand.create(cards);

        // act & assert
        assertThrows(HandNotFoundException.class, () -> inMemoryHandRepository.getCardsForHand(hand));
    }
}