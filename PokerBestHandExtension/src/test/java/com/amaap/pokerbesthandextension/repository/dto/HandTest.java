package com.amaap.pokerbesthandextension.repository.dto;

import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidHandSizeException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void shouldBeAbleToCreateHand() throws InvalidHandSizeException, InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getFiveCards();
        Hand expected = new Hand(cards);

        // act
        Hand actual = Hand.create(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenTryToCreateHandWithNumberOfCardOtherThanFive() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getFourCards();

        // act & assert
        assertThrows(InvalidHandSizeException.class,()->Hand.create(cards));
    }

    @Test
    void shouldBeAbleToCheckEqualityOfInstanceOfClass() throws InvalidCardCodeException {
        // arrange
        List<CardDto> list1 = CardBuilder.getFiveCards();
        List<CardDto> list2 = CardBuilder.getCardsForFlushRank();
        Hand hand1 = new Hand(list1);
        Hand hand2 = new Hand(list1);
        Hand hand3 = new Hand(list2);
        Object object = new Object();

        // act & assert
        assertTrue(hand1.equals(hand1));
        assertTrue(hand1.equals(hand2));
        assertFalse(hand1.equals(hand3));
        assertFalse(hand1.equals(object));
        assertFalse(hand1.equals(null));
    }
}