package com.amaap.pokerbesthandextension.service;

import com.amaap.pokerbesthandextension.repository.HandRepository;
import com.amaap.pokerbesthandextension.repository.db.InMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import com.amaap.pokerbesthandextension.repository.impl.InMemoryCardRepository;
import com.amaap.pokerbesthandextension.repository.impl.InMemoryHandRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandServiceTest {

    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    CardService cardService = new CardService(new InMemoryCardRepository(inMemoryDatabase));
    HandRepository handRepository = new InMemoryHandRepository(inMemoryDatabase);
    HandService handService = new HandService(handRepository);

    @Test
    void shouldBeAbleToCreateHand() throws DuplicateCardException, InvalidCardCodeException {
        // arrange
        CardDto card1 = cardService.create("H4");
        CardDto card2 = cardService.create("C7");
        CardDto card3 = cardService.create("CT");
        CardDto card4 = cardService.create("SJ");
        CardDto card5 = cardService.create("DK");
        List<CardDto> cards = List.of(card1,card2,card3,card4,card5);
        Hand expected = new Hand(cards);

        // act
        Hand actual = handService.create(cards);

        // assert
        assertEquals(expected, actual);
    }
}