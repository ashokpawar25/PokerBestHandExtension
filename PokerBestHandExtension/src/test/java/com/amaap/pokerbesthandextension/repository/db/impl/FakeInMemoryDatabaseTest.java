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
    void shouldBeAbleToGetOkResponseWhenCardCreatedSuccessfully() throws DuplicateCardException {
        // arrange
        String code = "H4";
        CardDto expected = new CardDto(code);

        // act
        CardDto actual = fakeInMemoryDatabase.insertIntoCardTable(expected);

        // assert
        assertEquals(expected, actual);
    }
}