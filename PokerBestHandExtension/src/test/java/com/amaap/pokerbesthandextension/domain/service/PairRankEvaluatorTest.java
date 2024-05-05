package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PairRankEvaluatorTest {
    PairRankEvaluator pairRankEvaluator = new PairRankEvaluator();
    @Test
    void shouldBeAbleToEvaluatePairRank() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForPairRank();
        HandRank expected = HandRank.PAIR;

        // act
        HandRank actual = pairRankEvaluator.getRank(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetNullWhenRankIsNotPair() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForFlushRank();

        // act
        HandRank rank = pairRankEvaluator.getRank(cards);

        // assert
        assertNull(rank);
    }
}