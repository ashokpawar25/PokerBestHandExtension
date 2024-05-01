package com.amaap.pokerbesthandextension.controller;

import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardControllerTest {

    CardController cardController = new CardController();

    @Test
    void shouldBeAbleToCreateCard()
    {
        // arrange
        String code = "H4";
        CardDto expected = new CardDto(code);

        // act
        CardDto actual = cardController.create(code);

        // assert
        assertEquals(expected,actual);
    }
}