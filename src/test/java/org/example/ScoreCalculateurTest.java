package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreCalculateurTest {

    private QuestionAChoixMultiple questionAchoixMultiple;
    private QuestionAChoixMultiple questionAchoixMultiple3Items;
    private ScoreCalculateur scoreCalculateur;

    @BeforeEach
    public void setUp() {
        // given: a multiple question with 5 items
        questionAchoixMultiple = new QuestionAChoixMultiple("q1", new ArrayList<>(Arrays.asList(2, 3, 5)),5);
        // and one with 3 items
        questionAchoixMultiple3Items = new QuestionAChoixMultiple("q2", new ArrayList<>(Arrays.asList(1,2)), 3);
        // and a score calulateur
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

    @Test
    public void testCalculeScore_ReponsesFaussesEtJustes() {
        // given : une liste contenant des réponses justes et fausses
        List<Integer> ltf = new ArrayList<>(Arrays.asList(1, 2, 3));
        // expected : le score vaut 1/6 du max
        assertEquals(16.66f, scoreCalculateur.calculeScore(ltf,questionAchoixMultiple),0.01f);
    }

    @Test
    public void testCalculeScore_ToutesLesResponsesSelectionnees5Items() {
        // given : une liste contenant toutes les réponses
        List<Integer> all = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        // expected : le score vaut zéro
        assertEquals(0f, scoreCalculateur.calculeScore(all,questionAchoixMultiple),0.01f);
    }

    @Test
    public void testCalculeScore_ToutesLesResponsesSelectionnees3Items() {
        // given : une liste contenant toutes les réponses
        List<Integer> all = new ArrayList<>(Arrays.asList(1, 2, 3));
        // expected : le score vaut zéro
        assertEquals(0f, scoreCalculateur.calculeScore(all,questionAchoixMultiple3Items),0.01f);
    }
}