package com.jobnormalizer;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Normalizer {

    private static final List<String> NORMALIZED_TITLES = Arrays.asList(
            "Architect",
            "Software engineer",
            "Quantity surveyor",
            "Accountant"
    );

    private final ScoreTextCalculator scoreTextCalculator;

    public Normalizer(ScoreTextCalculator scoreTextCalculator) {
        if (Objects.isNull(scoreTextCalculator)) {
            // default score text calculator
            this.scoreTextCalculator = new LevenshteinScoreText();
        }
        else {
            this.scoreTextCalculator = scoreTextCalculator;
        }
    }

    public String normalize(String jobTitle) {
        if (jobTitle == null || jobTitle.isEmpty()) {
            throw new IllegalArgumentException("Job title cannot be null or empty");
        }

        String bestMatch = null;
        int bestScore = Integer.MAX_VALUE;

        for (String normalizedTitle : NORMALIZED_TITLES) {
            int score = scoreTextCalculator.compare(jobTitle.toLowerCase(), normalizedTitle.toLowerCase());
            if (score < bestScore) {
                bestScore = score;
                bestMatch = normalizedTitle;
            }
        }

        return bestMatch;
    }

}
