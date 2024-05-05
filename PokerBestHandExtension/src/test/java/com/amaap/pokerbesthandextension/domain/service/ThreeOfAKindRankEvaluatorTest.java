package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeOfAKindRankEvaluatorTest {
    ThreeOfAKindRankEvaluator threeOfAKindRankEvaluator = new ThreeOfAKindRankEvaluator();
    @Test
    void shouldBeAbleToEvaluateThreeOfAKindRank() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForThreeOfAKindRank();
        HandRank expected = HandRank.THREEOFAKIND;

        // act
        HandRank actual = threeOfAKindRankEvaluator.getRank(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetNullWhenRankIsNotThreeOfAKind() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getFiveCards();

        // act
        HandRank rank = threeOfAKindRankEvaluator.getRank(cards);

        // assert
        assertNull(rank);
    }
}