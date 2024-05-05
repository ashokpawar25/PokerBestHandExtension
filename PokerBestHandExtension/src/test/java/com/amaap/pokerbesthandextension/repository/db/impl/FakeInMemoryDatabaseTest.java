package com.amaap.pokerbesthandextension.repository.db.impl;

import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import com.amaap.pokerbesthandextension.repository.impl.InMemoryCardRepository;
import com.amaap.pokerbesthandextension.service.CardService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FakeInMemoryDatabaseTest {
    FakeInMemoryDatabase fakeInMemoryDatabase = new FakeInMemoryDatabase();
    CardService cardService = new CardService(new InMemoryCardRepository(fakeInMemoryDatabase));

    @Test
    void shouldBeAbleToAddCardIntoDatabase() throws DuplicateCardException {
        // arrange
        String code = "H4";
        CardDto expected = new CardDto(code);

        // act
        CardDto actual = fakeInMemoryDatabase.insertIntoCardTable(expected);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenTryToAddDuplicateCardIntoDatabase() throws DuplicateCardException {
        // arrange
        String code = "H4";
        CardDto card = new CardDto(code);

        // act
        fakeInMemoryDatabase.insertIntoCardTable(card);

        // assert
        assertThrows(DuplicateCardException.class, () -> fakeInMemoryDatabase.insertIntoCardTable(card));
    }

    @Test
    void shouldBeAbleToGetCardByCode() throws DuplicateCardException {
        // arrange
        String code = "C8";
        CardDto expected = new CardDto(code);
        fakeInMemoryDatabase.insertIntoCardTable(expected);

        // act
        CardDto actual = fakeInMemoryDatabase.findCard(code);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetNullWhenCardNotFoundIntoDatabase() {
        // arrange
        String code = "C8";

        // act
        CardDto actual = fakeInMemoryDatabase.findCard(code);

        // assert
        assertNull(actual);
    }

    @Test
    void shouldBeAbleToAddHandInDatabase() throws DuplicateCardException, InvalidCardCodeException {
        // arrange
        CardDto card1 = cardService.create("H4");
        CardDto card2 = cardService.create("C7");
        CardDto card3 = cardService.create("CT");
        CardDto card4 = cardService.create("SJ");
        CardDto card5 = cardService.create("DK");
        List<CardDto> cards = List.of(card1,card2,card3,card4,card5);
        Hand expected = new Hand(cards);

        // act
        Hand actual = fakeInMemoryDatabase.insertIntoHandTable(expected);

        // assert
        assertEquals(expected, actual);
    }
}