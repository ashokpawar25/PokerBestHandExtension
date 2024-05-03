package com.amaap.pokerbesthandextension.service;

import com.amaap.pokerbesthandextension.repository.CardRepository;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;

public class CardService {
    private final CardRepository cardRepository;
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public CardDto create(String code) throws InvalidCardCodeException, DuplicateCardException {
        CardDto card = CardDto.create(code);
        return cardRepository.add(card);
    }

    public CardDto get(String code) {
        return cardRepository.findCard(code);
    }
}
