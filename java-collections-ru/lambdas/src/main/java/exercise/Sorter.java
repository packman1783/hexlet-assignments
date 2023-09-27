package exercise;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter(user -> user.get("gender").equals("male"))
                .sorted(Comparator.comparing(user ->
                        LocalDate.parse(user.get("birthday"), DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                .map(user -> user.get("name"))
                .collect(Collectors.toList());
    }
}
// END
