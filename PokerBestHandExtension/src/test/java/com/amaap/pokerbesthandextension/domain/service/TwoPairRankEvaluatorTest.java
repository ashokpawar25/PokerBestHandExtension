package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwoPairRankEvaluatorTest {
    TwoPairRankEvaluator twoPairRankEvaluator = new TwoPairRankEvaluator();
    @Test
    void shouldBeAbleToEvaluateTwoPairRank() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForTwoPairRank();
        HandRank expected = HandRank.TWOPAIR;

        // act
        HandRank actual = twoPairRankEvaluator.getRank(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetNullWhenRankIsNotTwoPair() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getFiveCards();

        // act
        HandRank rank = twoPairRankEvaluator.getRank(cards);

        // assert
        assertNull(rank);
    }
}