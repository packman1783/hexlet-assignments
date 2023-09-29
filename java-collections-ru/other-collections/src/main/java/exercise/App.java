package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());

        LinkedHashMap<String, String> result = keys.stream()
                .collect(LinkedHashMap::new, (text, key) -> {
                    Object value1 = map1.get(key);
                    Object value2 = map2.get(key);
                    if (value1 == null && value2 != null) {
                        text.put(key, "added");
                    } else if (value1 != null && value2 == null) {
                        text.put(key, "deleted");
                    } else if (value1 != null && value2 != null) {
                        if (!value1.equals(value2)) {
                            text.put(key, "changed");
                        } else {
                            text.put(key, "unchanged");
                        }
                    }
                }, LinkedHashMap::putAll);

        return result;
    }
}
//END
