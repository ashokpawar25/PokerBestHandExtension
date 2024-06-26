package com.amaap.pokerbesthandextension.controller;

import com.amaap.pokerbesthandextension.AppModule;
import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.HandNotFoundException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;
import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidHandSizeException;
import com.amaap.pokerbesthandextension.service.HandService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameControllerTest {
    HandService handService;
    GameController gameController;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        gameController = injector.getInstance(GameController.class);
        handService = injector.getInstance(HandService.class);
    }

    @Test
    void shouldBeAbleToCheckFlushRankForHand() throws InvalidHandSizeException, HandNotFoundException, InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForFlushRank();
        HandRank expected = HandRank.FLUSH;

        // act
        Hand hand = handService.create(cards);
        HandRank actual = gameController.checkRankFor(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToCheckPairRankForHand() throws InvalidHandSizeException, HandNotFoundException, InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForPairRank();
        HandRank expected = HandRank.PAIR;

        // act
        Hand hand = handService.create(cards);
        HandRank actual = gameController.checkRankFor(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToCheckThreeOfAKindRankForHand() throws InvalidHandSizeException, HandNotFoundException, InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForThreeOfAKindRank();
        HandRank expected = HandRank.THREEOFAKIND;

        // act
        Hand hand = handService.create(cards);
        HandRank actual = gameController.checkRankFor(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToCheckFourOfAKindRankForHand() throws InvalidHandSizeException, HandNotFoundException, InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForFourOfAKindRank();
        HandRank expected = HandRank.FOUROFAKIND;

        // act
        Hand hand = handService.create(cards);
        HandRank actual = gameController.checkRankFor(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToCheckStraightRankForHand() throws InvalidHandSizeException, HandNotFoundException, InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForStraightRank();
        HandRank expected = HandRank.STRAIGHT;

        // act
        Hand hand = handService.create(cards);
        HandRank actual = gameController.checkRankFor(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToCheckStraightFlushRankForHand() throws InvalidHandSizeException, HandNotFoundException, InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForStraightFlushRank();
        HandRank expected = HandRank.STRAIGHTFLUSH;

        // act
        Hand hand = handService.create(cards);
        HandRank actual = gameController.checkRankFor(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToCheckTwoPairRankForHand() throws InvalidHandSizeException, HandNotFoundException, InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForTwoPairRank();
        HandRank expected = HandRank.TWOPAIR;

        // act
        Hand hand = handService.create(cards);
        HandRank actual = gameController.checkRankFor(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToCheckFullHouseRankForHand() throws InvalidHandSizeException, HandNotFoundException, InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForFullHouseRank();
        HandRank expected = HandRank.FULLHOUSE;

        // act
        Hand hand = handService.create(cards);
        HandRank actual = gameController.checkRankFor(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToCheckHighCardRankForHand() throws InvalidHandSizeException, HandNotFoundException, InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForHighCardRank();
        HandRank expected = HandRank.HIGHCARD;

        // act
        Hand hand = handService.create(cards);
        HandRank actual = gameController.checkRankFor(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetHighCardForHand() throws InvalidHandSizeException, HandNotFoundException, InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForHighCardRank();
        String expected = "high-card-ace";

        // act
        Hand hand = handService.create(cards);
        String actual = gameController.getHighCard(hand);

        // assert
        assertEquals(expected, actual);
    }
}
