package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreCalculateurTest {

    private QuestionAChoixMultiple questionAchoixMultiple;
    private ScoreCalculateur scoreCalculateur;

    @BeforeEach
    public void setUp() {
        questionAchoixMultiple = new QuestionAChoixMultiple("q1", new ArrayList<>(Arrays.asList(2, 3, 5)));
        scoreCalculateur = new ScoreCalculateur();
    }

    @Test
    public void testCalculeScore_BadAnswers() {
        // given: a list of bad answers
        List<Integer> lf = new ArrayList<>(Arrays.asList(1, 4));
        // expected: score is 0
        assertEquals(0f, scoreCalculateur.calculeScore(lf, questionAchoixMultiple), 0.01f);
    }

    @Test
    public void testCalculeScore_BadAnswersWith3Clauses() {
        // given: a list of bad answers
        List<Integer> lf = new ArrayList<>(Arrays.asList(1, 4));
        // When: we calculate the score
        float actualScore = scoreCalculateur.calculeScore(lf, questionAchoixMultiple);
        // then: score is 0
        assertEquals(0f, actualScore , 0.01f);
    }

    @Test
    public void testCalculeScore_OnlyGoodAnswers() {
        // given : a list of good answers only
        List<Integer> lt = new ArrayList<>(Arrays.asList(2, 3, 5));
        // expected : the score equals to 100
        assertEquals(100f, scoreCalculateur.calculeScore(lt, questionAchoixMultiple), 0.01f);

    }

    @Test
    public void testCalculeScore_HalfGoodAnswers() {
        // given : a list of half good answers
        List<Integer> ltf = new ArrayList<>(Arrays.asList(2, 3));
        // expected : score equals 2/3 of the max score
        assertEquals(66.66f, scoreCalculateur.calculeScore(ltf, questionAchoixMultiple), 0.01f);
    }



}