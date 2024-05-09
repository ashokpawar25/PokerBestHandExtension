package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HighCardEvaluatorTest {

    @Test
    void shouldBeAbleToGetHighCard() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForHighCardRank();
        String expected = "high-card-ace";

        // act
        String actual = HighCardEvaluator.getHighCard(cards);

        // assert
        assertEquals(expected,actual);
    }
}