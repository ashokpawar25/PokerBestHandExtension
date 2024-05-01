package com.amaap.pokerbesthandextension.service;

import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;

public class CardService {
    public CardDto create(String code) throws InvalidCardCodeException {
        return CardDto.create(code);
    }
}
