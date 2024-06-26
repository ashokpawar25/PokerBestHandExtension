package com.amaap.pokerbesthandextension.controller;

import com.amaap.pokerbesthandextension.controller.dto.HttpStatus;
import com.amaap.pokerbesthandextension.controller.dto.Response;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import com.amaap.pokerbesthandextension.service.CardService;
import jakarta.inject.Inject;

public class CardController {
    private final CardService cardService;
    @Inject
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    public Response create(String code){
        try {
            cardService.create(code);
            return new Response(HttpStatus.OK,"Card Created Successfully");
        } catch (InvalidCardCodeException | DuplicateCardException e) {
            return new Response(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    public CardDto get(String code) {
        return cardService.get(code);
    }
}
