package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StraightFlushRankEvaluatorTest {
    StraightFlushRankEvaluator straightFlushRankEvaluator = new StraightFlushRankEvaluator();
    @Test
    void shouldBeAbleToEvaluateStraightFlushRank() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForStraightFlushRank();
        HandRank expected = HandRank.STRAIGHTFLUSH;

        // act
        HandRank actual = straightFlushRankEvaluator.getRank(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetNullWhenRankIsNotStraightFlush() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getFiveCards();

        // act
        HandRank rank = straightFlushRankEvaluator.getRank(cards);

        // assert
        assertNull(rank);
    }
}