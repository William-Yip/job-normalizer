package com.jobnormalizer;

public class JobNormalizer {

    public static void main(String[] args) {
        Normalizer normalizer = new Normalizer(new LevenshteinScoreText());

        String jt1 = "Java engineer";
        System.out.println("Normalized Title: " + normalizer.normalize(jt1));

        String jt2 = "C# engineer";
        System.out.println("Normalized Title: " + normalizer.normalize(jt2));

        String jt3 = "Chief Accountant";
        System.out.println("Normalized Title: " + normalizer.normalize(jt3));
    }

}

