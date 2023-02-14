package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionAChoixExclusifTest {

    private QuestionAChoixExclusif qce;

    @BeforeEach
    void setUp() {
        // given: une question à choix exclusif
        qce = new QuestionAChoixExclusif("Q1", 2);
    }

    @Test
    void getEnonce() {
        // expected: l'énoncé fourni par la question est celui tilisé à la construction
        assertEquals("Q1", qce.getEnonce());
    }

    @Test
    void getScoreForIndiceBonneReponse() {
        // expected: score = 100 si indice correspond à la bonne réponse
        assertEquals(100, qce.getScoreForIndice(2));
    }

    @Test
    void getScoreForIndiceMauvaiseReponse() {
        // expected: score = 0 si indice correspond à une mauvaise réponse
        assertEquals(0, qce.getScoreForIndice(1));
        assertEquals(0, qce.getScoreForIndice(3));
    }
}