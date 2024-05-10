package com.amaap.pokerbesthandextension.service;

import com.amaap.pokerbesthandextension.AppModule;
import com.amaap.pokerbesthandextension.controller.CardController;
import com.amaap.pokerbesthandextension.repository.HandRepository;
import com.amaap.pokerbesthandextension.repository.db.InMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.HandNotFoundException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;
import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidHandSizeException;
import com.amaap.pokerbesthandextension.repository.impl.InMemoryCardRepository;
import com.amaap.pokerbesthandextension.repository.impl.InMemoryHandRepository;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HandServiceTest {

    HandService handService ;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        handService = injector.getInstance(HandService.class);
    }

    @Test
    void shouldBeAbleToCreateHand() throws InvalidHandSizeException, InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getFiveCards();
        Hand expected = new Hand(cards);

        // act
        Hand actual = handService.create(cards);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetListOfCardsForHand() throws HandNotFoundException, InvalidHandSizeException, InvalidCardCodeException {
        // arrange
        List<CardDto> expected = CardBuilder.getFiveCards();
        Hand hand = new Hand(expected);

        // act
        handService.create(expected);
        List<CardDto> actual = handService.getCardsForHand(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenHandNotFound() throws InvalidHandSizeException, InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getFiveCards();
        Hand hand = Hand.create(cards);

        // act & assert
        assertThrows(HandNotFoundException.class,()->handService.getCardsForHand(hand));
    }
}