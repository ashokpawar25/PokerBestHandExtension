package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FourOfAKindRankEvaluatorTest {
    FourOfAKindRankEvaluator fourOfAKindRankEvaluator = new FourOfAKindRankEvaluator();
    @Test
    void shouldBeAbleToEvaluateFourOfAKindRank() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForFourOfAKindRank();
        HandRank expected = HandRank.FOUROFAKIND;

        // act
        HandRank actual = fourOfAKindRankEvaluator.getRank(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetNullWhenRankIsNotFourOfAKind() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getFiveCards();

        // act
        HandRank rank = fourOfAKindRankEvaluator.getRank(cards);

        // assert
        assertNull(rank);
    }
}