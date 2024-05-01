package com.amaap.pokerbesthandextension.controller;

import com.amaap.pokerbesthandextension.controller.dto.HttpStatus;
import com.amaap.pokerbesthandextension.controller.dto.Response;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import com.amaap.pokerbesthandextension.service.CardService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardControllerTest {
    CardService cardService = new CardService();

    CardController cardController = new CardController(cardService);

    @Test
    void shouldBeAbleToCreateCard() throws InvalidCardCodeException {
        // arrange
        String code = "H4";
        Response expected = new Response(HttpStatus.OK,"Card Created Successfully");

        // act
        Response actual = cardController.create(code);

        // assert
        assertEquals(expected,actual);
    }
}