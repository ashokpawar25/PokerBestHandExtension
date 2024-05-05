package com.amaap.pokerbesthandextension.controller;

import com.amaap.pokerbesthandextension.controller.dto.HttpStatus;
import com.amaap.pokerbesthandextension.controller.dto.Response;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.HandNotFoundException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidHandSizeException;
import com.amaap.pokerbesthandextension.service.HandService;

import java.util.List;

public class HandController {
    HandService handService;
    public HandController(HandService handService) {
        this.handService = handService;
    }

    public Response create(List<CardDto> cards){
        try {
            handService.create(cards);
            return new Response(HttpStatus.OK,"Hand Created successfully");
        } catch (InvalidHandSizeException e) {
            return new Response(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public List<CardDto> getCardsForHand(Hand hand) throws HandNotFoundException {
        return handService.getCardsForHand(hand);
    }
}
