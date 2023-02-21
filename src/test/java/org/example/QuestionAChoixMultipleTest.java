package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple questionAchoixMultiple;

    @BeforeEach
    public void setup() {
        // given: a multiple choice question with correct indices : [2,3,5]
        questionAchoixMultiple = new QuestionAChoixMultiple("q1", new ArrayList<>(Arrays.asList(2, 3, 5)));
    }

    @Test
    public void testGetEnonce() {
        // when: getEnonce invoquée, then: la valeur obtenue est la valeur initiale
        assertEquals("q1", questionAchoixMultiple.getEnonce());
    }

    @Test
    public void testGetScore_CorrectIndice() {
        // expected: getScoreForIndice return a non null value when a correct indice is provided
        assertEquals(33.33f, questionAchoixMultiple.getScoreForIndice(2), 0.01f);
    }

    @Test
    public void testGetScore_NotCorrectIndice() {
        // expected: getScoreForIndice return 0 as score when a non correct index is provided
        assertEquals(0f, questionAchoixMultiple.getScoreForIndice(1), 0.001f);
    }

}