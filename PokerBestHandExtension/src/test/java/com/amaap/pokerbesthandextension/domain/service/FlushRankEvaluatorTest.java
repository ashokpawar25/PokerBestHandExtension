package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlushRankEvaluatorTest {
    FlushRankEvaluator flushRankEvaluator = new FlushRankEvaluator();

    @Test
    void shouldBeAbleToEvaluateFlushRank() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForFlushRank();
        HandRank expected = HandRank.FLUSH;

        // act
        HandRank actual = flushRankEvaluator.getRank(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetNullWhenRankIsNotFlush() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForPairRank();

        // act
        HandRank rank = flushRankEvaluator.getRank(cards);

        // assert
        assertNull(rank);
    }
}