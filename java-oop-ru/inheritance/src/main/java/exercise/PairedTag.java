package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    String body;
    List<Tag> children;

    PairedTag(String tagName, Map<String, String> attributes, String body, List<Tag> children) {
        super(tagName, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String attributeString = attributes.entrySet().stream()
                .map(entry -> entry.getKey() + "=\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(" "));

        sb.append("<" + tagName + (attributeString.isEmpty() ? "" : " " + attributeString) + ">");

        if (!body.isEmpty()) {
            sb.append(body);
        } else {
            for (Tag child : children) {
                sb.append(child.toString());
            }
        }
        sb.append("</").append(tagName).append(">");
        return sb.toString();
    }
}
// END
