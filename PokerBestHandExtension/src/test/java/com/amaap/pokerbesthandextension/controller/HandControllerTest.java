package com.amaap.pokerbesthandextension.controller;
import com.amaap.pokerbesthandextension.controller.dto.HttpStatus;
import com.amaap.pokerbesthandextension.controller.dto.Response;
import com.amaap.pokerbesthandextension.repository.HandRepository;
import com.amaap.pokerbesthandextension.repository.db.InMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.HandNotFoundException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;
import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidHandSizeException;
import com.amaap.pokerbesthandextension.repository.impl.InMemoryCardRepository;
import com.amaap.pokerbesthandextension.repository.impl.InMemoryHandRepository;
import com.amaap.pokerbesthandextension.service.CardService;
import com.amaap.pokerbesthandextension.service.HandService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HandControllerTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    HandRepository handRepository = new InMemoryHandRepository(inMemoryDatabase);
    HandService handService = new HandService(handRepository);
    HandController handController = new HandController(handService);

    @Test
    void shouldBeAbleToGetOkResponseWhenCreateHand(){
        // arrange
        List<CardDto> cards = CardBuilder.getFiveCards();
        Response expected = new Response(HttpStatus.OK,"Hand Created successfully");

        // act
        Response actual = handController.create(cards);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetBadRequestAsResponseWhenHandSizeIsInvalid()
    {
        // arrange
        List<CardDto> cards = CardBuilder.getFourCards();
        Response expected = new Response(HttpStatus.BAD_REQUEST,"Invalid hand size "+cards.size());

        // act
        Response actual = handController.create(cards);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetListOfCardsForHand() throws HandNotFoundException{
        // arrange
        List<CardDto> expected = CardBuilder.getFiveCards();
        Hand hand = new Hand(expected);

        // act
        handController.create(expected);
        List<CardDto> actual = handController.getCardsForHand(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenHandNotFound() throws InvalidHandSizeException {
        // arrange
        List<CardDto> cards = CardBuilder.getFiveCards();
        Hand hand = Hand.create(cards);

        // act & assert
        assertThrows(HandNotFoundException.class,()->handController.getCardsForHand(hand));
    }
}