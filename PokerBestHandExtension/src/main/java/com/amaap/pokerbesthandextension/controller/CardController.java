package com.amaap.pokerbesthandextension.controller;

import com.amaap.pokerbesthandextension.repository.dto.CardDto;

public class CardController {
    public CardDto create(String code) {
        return CardDto.create(code);
    }
}
