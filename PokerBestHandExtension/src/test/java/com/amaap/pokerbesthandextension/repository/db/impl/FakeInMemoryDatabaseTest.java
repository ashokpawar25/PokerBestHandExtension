package com.amaap.pokerbesthandextension.repository.db.impl;

import com.amaap.pokerbesthandextension.repository.db.InMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import com.amaap.pokerbesthandextension.repository.impl.InMemoryCardRepository;
import org.junit.jupiter.api.Test;

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
        assertThrows(DuplicateCardException.class,()->fakeInMemoryDatabase.insertIntoCardTable(card));
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
        assertEquals(expected,actual);
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
}