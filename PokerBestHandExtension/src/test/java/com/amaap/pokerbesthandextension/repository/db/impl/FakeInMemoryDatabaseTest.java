package com.amaap.pokerbesthandextension.repository.db.impl;

import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.HandNotFoundException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;
import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FakeInMemoryDatabaseTest {
    FakeInMemoryDatabase fakeInMemoryDatabase = new FakeInMemoryDatabase();

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
    void shouldBeAbleToAddHandInDatabase() {
        // arrange
        List<CardDto> cards = CardBuilder.getFiveCards();
        Hand expected = new Hand(cards);

        // act
        Hand actual = fakeInMemoryDatabase.insertIntoHandTable(expected);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetListOfCardsForHand() throws HandNotFoundException {
        // arrange
        List<CardDto> expected = CardBuilder.getFiveCards();
        Hand hand = new Hand(expected);

        // act
        fakeInMemoryDatabase.insertIntoHandTable(hand);
        List<CardDto> actual = fakeInMemoryDatabase.getCardsForHand(hand);

        // assert
        assertEquals(expected, actual);
    }
}