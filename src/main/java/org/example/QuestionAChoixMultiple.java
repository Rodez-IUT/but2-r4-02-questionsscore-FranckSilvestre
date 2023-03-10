package org.example;

import java.util.List;

/**
 * Classe représentant une question à choix multiple
 */
public class QuestionAChoixMultiple implements QuestionAChoix {

    private String enonce;
    private List<Integer> indicesBonnesReponses;
    private int nombreChoix;

    /**
     * Une question à choix multiple est complètement caractérisé par son énoncé et la liste des indices qui forment
     * la bonne réponse
     * @param enonce l'énoncé de la question
     * @param indicesBonnesReponses la liste des indices formant la bonne réponse.
     * @param nombreChoix le nombre de choix possible
     */
    public QuestionAChoixMultiple(String enonce,
                                  List<Integer> indicesBonnesReponses,
                                  int nombreChoix) {
        this.enonce = enonce;
        this.indicesBonnesReponses = indicesBonnesReponses;
        this.nombreChoix = nombreChoix;
    }

    /**
     * Récupère l'énoncé de la question
     * @return l'énoncé de la question
     */
    public String getEnonce() {
        return enonce;
    }

    /**
     * Opération permettant de récupérer le score donné par un choix.
     * @param indiceChoix l'indice du choix
     * @return 100/n si indiceChoix appartient à la liste des indices formant la bonne réponse, 0 sinon
     */
    public float getScoreForIndice(int indiceChoix) {
        int nombreBonnesReponses = indicesBonnesReponses.size();
        int nombreMauvaisesReponses = nombreChoix - nombreBonnesReponses;
        float res;
        if (indicesBonnesReponses.contains(indiceChoix)) {
            res = 100f/((float)(nombreBonnesReponses));
        } else {
            res = -100f/((float)(nombreMauvaisesReponses));
        }
        return res;
    }
}
