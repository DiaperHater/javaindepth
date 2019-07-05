import java.util.Arrays;

public class SentimentAnalyzer {
    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
                                          String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length]; // output

        // your code ~ you will be invoking getOpinionOnFeature
        for (int featureIndex = 0; featureIndex < featureSet.length; featureIndex++) {

            String[] oneFeatureSynonims = featureSet[featureIndex];

            for (String synonim : oneFeatureSynonims) {
                int opinion = getOpinionOnFeature(review, synonim, posOpinionWords, negOpinionWords);
                boolean opinionIsFound = opinion != 0 ? true : false;
                if (opinionIsFound) {
                    featureOpinions[featureIndex] = opinion;
                    break;
                }
            }
        }

        return featureOpinions;
    }

    // First invoke checkForWasPhrasePattern and
    // if it cannot find an opinion only then invoke checkForOpinionFirstPattern
    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {

        // your code
        int opinion = 0;

        opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        if (opinion != 0) {
            return opinion;
        }
        opinion = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);

        return opinion;

    }

    // Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
    // Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
    // You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";

        String patternInLower = pattern.toLowerCase();
        String reviewInLower = review.toLowerCase();

        // Check for positive opinions
        for (String posWord : posOpinionWords) {
            if (reviewInLower.contains(patternInLower + posWord)) {
                return 1;
            }
        }

        // Check for negative opinions
        for (String negWord : negOpinionWords) {
            if (reviewInLower.contains(patternInLower + negWord)) {
                return -1;
            }
        }

        return 0;
    }

    // You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
                                                   String[] negOpinionWords) {
        // Extract sentences as feature might appear multiple times.
        // split() takes a regular expression and "." is a special character
        // for regular expression. So, escape it to make it work!!
        String reviewInLower = review.toLowerCase();
        String[] sentences = reviewInLower.split("\\.");

        //Check all sentences for positive and negative opinions
        for (String sentence : sentences) {

            // Check for positive opinions
            for (String posWord : posOpinionWords) {
                String searchPhrase = posWord + " " + feature;
                if (sentence.contains(searchPhrase)) {
                    return 1;
                }
            }

            // Check for negative opinions
            for (String negWord : negOpinionWords) {
                String searchPhrase = negWord + " " + feature;
                if (sentence.contains(searchPhrase)) {
                    return -1;
                }
            }
        }

        // your code for processing each sentence. You can return if opinion is found in a sentence (no need to process subsequent ones)

        return 0;
    }

    public static void main(String[] args) {
//        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";

        String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";

        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
                "delicious" };
        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}