package exercise;

import java.util.Arrays;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] array) {
        return Arrays.stream(array)
                .flatMap(row -> Arrays.stream(row)
                        .flatMap(element -> Arrays.stream(new String[]{element, element})))
                .map(element -> new String[]{element, element})
                .toArray(String[][]::new);
    }
}
// END
