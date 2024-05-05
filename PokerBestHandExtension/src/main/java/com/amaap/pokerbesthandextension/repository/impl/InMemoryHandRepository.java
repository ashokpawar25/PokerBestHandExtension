package com.amaap.pokerbesthandextension.repository.impl;

import com.amaap.pokerbesthandextension.repository.HandRepository;
import com.amaap.pokerbesthandextension.repository.db.InMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.HandNotFoundException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;

import java.util.List;

public class InMemoryHandRepository implements HandRepository {
    InMemoryDatabase inMemoryDatabase;
    public InMemoryHandRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public Hand add(Hand hand) {
        return inMemoryDatabase.insertIntoHandTable(hand);
    }

    @Override
    public List<CardDto> getCardsForHand(Hand hand) throws HandNotFoundException {
        return inMemoryDatabase.getCardsForHand(hand);
    }
}
