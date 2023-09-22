package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();

        for (Map<String, String> book : books) {
            boolean check = true;

            for (Map.Entry<String, String> entry : where.entrySet()) {
                String entryKey = entry.getKey();
                String entryValue = entry.getValue();

                if (!book.containsKey(entryKey) || !book.get(entryKey).equals(entryValue)) {
                    check = false;
                    break;
                }
            }

            if (check) {
                result.add(book);
            }
        }

        return result;
    }
}
//END
