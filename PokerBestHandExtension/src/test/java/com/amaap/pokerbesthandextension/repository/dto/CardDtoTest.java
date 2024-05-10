package com.amaap.pokerbesthandextension.repository.dto;

import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardDtoTest {

    @Test
    void shouldBeAbleToCreateCard() throws InvalidCardCodeException {
        // arrange
        String code = "H4";
        CardDto expected = new CardDto(code);

        // act
        CardDto actual = CardDto.create(code);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidCardCodeIsPassed() {
        assertThrows(InvalidCardCodeException.class, () -> CardDto.create("G2"));
        assertThrows(InvalidCardCodeException.class, () -> CardDto.create("SD"));
        assertThrows(InvalidCardCodeException.class, () -> CardDto.create(""));
    }

    @Test
    void shouldBeAbleToCheckEqualityOfInstanceOfClass()
    {
        // arrange
        CardDto card1 = new CardDto("H4");
        CardDto card2 = new CardDto("H4");
        CardDto card3 = new CardDto("H6");
        Object object = new Object();

        // act & assert
        assertTrue(card1.equals(card1));
        assertTrue(card1.equals(card2));
        assertFalse(card1.equals(card3));
        assertFalse(card1.equals(object));
        assertFalse(card1.equals(null));
    }
}