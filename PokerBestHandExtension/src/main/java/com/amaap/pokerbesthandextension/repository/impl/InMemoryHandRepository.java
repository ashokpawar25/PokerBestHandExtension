package com.amaap.pokerbesthandextension.repository.impl;

import com.amaap.pokerbesthandextension.repository.HandRepository;
import com.amaap.pokerbesthandextension.repository.db.InMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.dto.Hand;

public class InMemoryHandRepository implements HandRepository {
    InMemoryDatabase inMemoryDatabase;
    public InMemoryHandRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public Hand add(Hand hand) {
        return inMemoryDatabase.insertIntoHandTable(hand);
    }
}
