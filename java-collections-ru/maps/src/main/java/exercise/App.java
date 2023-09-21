package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordCount = new HashMap<>();

        if (sentence.isEmpty()) {
            return wordCount;
        }

        String[] sentences = sentence.split(" ");

        for (String word : sentences) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        return wordCount;
    }

    public static String toString(Map<String, Integer> words) {
        StringBuilder result = new StringBuilder();

        result.append("{\n");

        for (Map.Entry<String, Integer> word : words.entrySet()) {
            result.append("  ")
                    .append(word.getKey())
                    .append(":  ")
                    .append(word.getValue())
                    .append("\n");
        }

        result.append("}");

        return result.toString();
    }
}
//END
