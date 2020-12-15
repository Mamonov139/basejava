package urise.webapp.model;

public class SingleLineSection implements Section {
    private String singleLineValue;

    public SingleLineSection(String value) {
        singleLineValue = value;
    }

    public void setSectionValue(String value) {
        singleLineValue = value;
    }

    @Override
    public String getSectionValue() {
        return singleLineValue;
    }
}
