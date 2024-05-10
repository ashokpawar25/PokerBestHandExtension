package com.amaap.pokerbesthandextension.repository.impl;

import com.amaap.pokerbesthandextension.repository.CardRepository;
import com.amaap.pokerbesthandextension.repository.db.InMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import jakarta.inject.Inject;

public class InMemoryCardRepository implements CardRepository {
    private final InMemoryDatabase inMemoryDatabase;

    @Inject
    public InMemoryCardRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public CardDto add(CardDto card) throws DuplicateCardException {
        return inMemoryDatabase.insertIntoCardTable(card);
    }

    @Override
    public CardDto findCard(String code) {
        return inMemoryDatabase.findCard(code);
    }
}
