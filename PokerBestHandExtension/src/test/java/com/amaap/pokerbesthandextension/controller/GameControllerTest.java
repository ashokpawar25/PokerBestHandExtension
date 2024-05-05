package com.amaap.pokerbesthandextension.controller;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.domain.service.HandEvaluatorChain;
import com.amaap.pokerbesthandextension.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.HandNotFoundException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;
import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidHandSizeException;
import com.amaap.pokerbesthandextension.repository.impl.InMemoryHandRepository;
import com.amaap.pokerbesthandextension.service.GameService;
import com.amaap.pokerbesthandextension.service.HandService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameControllerTest {
    HandEvaluatorChain handEvaluatorChain = new HandEvaluatorChain();
    HandService handService = new HandService(new InMemoryHandRepository(new FakeInMemoryDatabase()));
    GameService gameService = new GameService(handEvaluatorChain,handService);
    GameController gameController = new GameController(gameService);

    @Test
    void shouldBeAbleToCheckFlushRankForHand() throws InvalidHandSizeException, HandNotFoundException, InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForFlushRank();
        HandRank expected = HandRank.FLUSH;

        // act
        Hand hand = handService.create(cards);
        HandRank actual = gameController.checkRankFor(hand);

        // assert
        assertEquals(expected,actual);
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
        assertEquals(expected,actual);
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
        assertEquals(expected,actual);
    }
}
