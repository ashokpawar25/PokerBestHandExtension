package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FullHouseRankEvaluatorTest {
    FullHouseRankEvaluator fullHouseRankEvaluator = new FullHouseRankEvaluator();
    @Test
    void shouldBeAbleToEvaluateFullHouseRank() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForFullHouseRank();
        HandRank expected = HandRank.FULLHOUSE;

        // act
        HandRank actual = fullHouseRankEvaluator.getRank(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetNullWhenRankIsNotFullHouse() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getFiveCards();

        // act
        HandRank rank = fullHouseRankEvaluator.getRank(cards);

        // assert
        assertNull(rank);
    }
}