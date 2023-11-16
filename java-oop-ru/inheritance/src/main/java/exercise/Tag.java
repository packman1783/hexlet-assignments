package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
class Tag {
    String tagName;
    Map<String, String> attributes;

    Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public String toString() {
        String attributeString = attributes.entrySet().stream()
                .map(entry -> entry.getKey() + "=\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(" "));

        return "<" + tagName + (attributeString.isEmpty() ? "" : " " + attributeString) + ">";
    }
}
// END
