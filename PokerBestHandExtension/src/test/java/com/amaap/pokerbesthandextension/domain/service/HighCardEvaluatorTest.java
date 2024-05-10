package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.builder.CardBuilder;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HighCardEvaluatorTest {

    @Test
    void shouldBeAbleToGetHighCard() throws InvalidCardCodeException {
        // arrange
        List<CardDto> cards = CardBuilder.getCardsForHighCardRank();
        String expected = "high-card-ace";

        // act
        String actual = HighCardEvaluator.getHighCard(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetKingAsHighCard() {
        // arrange
        List<CardDto> cards = List.of(new CardDto("CK"));
        String expected = "high-card-king";

        // act
        String actual = HighCardEvaluator.getHighCard(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetQueenAsHighCard() {
        // arrange
        List<CardDto> cards = List.of(new CardDto("CQ"));
        String expected = "high-card-queen";

        // act
        String actual = HighCardEvaluator.getHighCard(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetJackAsHighCard() {
        // arrange
        List<CardDto> cards = List.of(new CardDto("CJ"));
        String expected = "high-card-jack";

        // act
        String actual = HighCardEvaluator.getHighCard(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetTenAsHighCard() {
        // arrange
        List<CardDto> cards = List.of(new CardDto("CT"));
        String expected = "high-card-ten";

        // act
        String actual = HighCardEvaluator.getHighCard(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetNineAsHighCard() {
        // arrange
        List<CardDto> cards = List.of(new CardDto("C9"));
        String expected = "high-card-nine";

        // act
        String actual = HighCardEvaluator.getHighCard(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetEightAsHighCard() {
        // arrange
        List<CardDto> cards = List.of(new CardDto("C8"));
        String expected = "high-card-eight";

        // act
        String actual = HighCardEvaluator.getHighCard(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetSevenAsHighCard() {
        // arrange
        List<CardDto> cards = List.of(new CardDto("C7"));
        String expected = "high-card-seven";

        // act
        String actual = HighCardEvaluator.getHighCard(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetSixAsHighCard() {
        // arrange
        List<CardDto> cards = List.of(new CardDto("C6"));
        String expected = "high-card-six";

        // act
        String actual = HighCardEvaluator.getHighCard(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetFiveAsHighCard() {
        // arrange
        List<CardDto> cards = List.of(new CardDto("C5"));
        String expected = "high-card-five";

        // act
        String actual = HighCardEvaluator.getHighCard(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetFourAsHighCard() {
        // arrange
        List<CardDto> cards = List.of(new CardDto("C4"));
        String expected = "high-card-four";

        // act
        String actual = HighCardEvaluator.getHighCard(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetThreeAsHighCard() {
        // arrange
        List<CardDto> cards = List.of(new CardDto("C3"));
        String expected = "high-card-three";

        // act
        String actual = HighCardEvaluator.getHighCard(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetTwoAsHighCard() {
        // arrange
        List<CardDto> cards = List.of(new CardDto("C2"));
        String expected = "high-card-two";

        // act
        String actual = HighCardEvaluator.getHighCard(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetUnknownAsHighCard() {
        // arrange
        List<CardDto> cards = List.of(new CardDto("C10"));
        String expected = "high-card-unknown";

        // act
        String actual = HighCardEvaluator.getHighCard(cards);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToCreateInstanceOfClass()
    {
        // arrange & act
        HighCardEvaluator highCardEvaluator = new HighCardEvaluator();

        // assert
        assertNotNull(highCardEvaluator);
    }
}