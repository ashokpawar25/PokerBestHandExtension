package com.amaap.pokerbesthandextension.controller;

import com.amaap.pokerbesthandextension.AppModule;
import com.amaap.pokerbesthandextension.controller.dto.HttpStatus;
import com.amaap.pokerbesthandextension.controller.dto.Response;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CardControllerTest {
    CardController cardController;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        cardController = injector.getInstance(CardController.class);
    }

    @Test
    void shouldBeAbleToGetOkResponseWhenCardCreatedSuccessfully() throws InvalidCardCodeException {
        // arrange
        String code = "H4";
        Response expected = new Response(HttpStatus.OK, "Card Created Successfully");

        // act
        Response actual = cardController.create(code);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetBadRequestAsResponseWhenTryToCreateDuplicateCard() {
        // arrange
        String code = "H4";
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Card:H4 is already present in database");

        // act
        cardController.create(code);
        Response actual = cardController.create(code);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetCardByCode() {
        // arrange
        String code = "C8";
        CardDto expected = new CardDto(code);
        cardController.create(code);

        // act
        CardDto actual = cardController.get(code);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetNullWhenCardNotFound() {
        // arrange
        String code = "C8";

        // act
        CardDto actual = cardController.get(code);

        // assert
        assertNull(actual);
    }
}