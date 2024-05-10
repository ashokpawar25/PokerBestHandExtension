package com.amaap.pokerbesthandextension;

import com.amaap.pokerbesthandextension.repository.CardRepository;
import com.amaap.pokerbesthandextension.repository.HandRepository;
import com.amaap.pokerbesthandextension.repository.db.InMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.impl.InMemoryCardRepository;
import com.amaap.pokerbesthandextension.repository.impl.InMemoryHandRepository;
import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
    @Override
    protected void configure()
    {
        bind(CardRepository.class).to(InMemoryCardRepository.class);
        bind(HandRepository.class).to(InMemoryHandRepository.class);
        bind(InMemoryDatabase.class).to(FakeInMemoryDatabase.class).asEagerSingleton();
    }
}
