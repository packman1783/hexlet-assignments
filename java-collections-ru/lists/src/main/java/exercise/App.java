package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {

    public static boolean scrabble(String letters, String word) {
        String lettersLowCase = letters.toLowerCase();
        String wordLowCase = word.toLowerCase();

        List<Character> lettersList = new ArrayList<>();
        for (char c : lettersLowCase.toCharArray()) {
            lettersList.add(c);
        }

        for (char i : wordLowCase.toCharArray()) {
            if (lettersList.contains(i)) {
                lettersList.remove(Character.valueOf(i));
            } else {
                return false;
            }
        }

        return true;
    }
}
//END
