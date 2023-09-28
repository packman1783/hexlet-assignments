package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {

    public static String getForwardedVariables(String configFileContent) {
        String forwardedVariables = Arrays.stream(configFileContent.split("\n"))
                .filter(line -> line.startsWith("environment"))
                .map(line -> line.replaceFirst("environment=\"", "").replaceAll("\"$", ""))
                .map(environmentLine -> environmentLine.split(","))
                .flatMap(Arrays::stream)
                .filter(variable -> variable.startsWith("X_FORWARDED_"))
                .map(variable -> variable.replaceFirst("X_FORWARDED_", ""))
                .map(variable -> {
                    String[] parts = variable.split("=");
                    return parts[0] + "=" + parts[1];
                })
                .collect(Collectors.joining(","));

        return forwardedVariables;
    }
}
//END
