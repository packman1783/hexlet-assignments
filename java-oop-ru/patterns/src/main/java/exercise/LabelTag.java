package exercise;

// BEGIN
class LabelTag implements TagInterface {
    private String tag;
    private TagInterface inputTag;

    LabelTag(String tag, TagInterface inputTag) {
        this.tag = tag;
        this.inputTag = inputTag;
    }

    @Override
    public String render() {
        return String.format("<label>%s%s</label>", tag, inputTag.render());
    }
}
// END
