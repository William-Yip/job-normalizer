package com.jobnormalizer;

import org.apache.commons.text.similarity.LevenshteinDistance;

public class LevenshteinScoreText implements ScoreTextCalculator {

    LevenshteinDistance levenshteinDistance = new LevenshteinDistance();

    @Override
    public int compare(String str1, String str2) throws IllegalArgumentException {
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("str1 and str2 args cannot be null or empty.");
        }
        return levenshteinDistance.apply(str1, str2);
    }

}
