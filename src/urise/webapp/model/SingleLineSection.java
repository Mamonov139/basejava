package urise.webapp.model;

public class SingleLineSection implements Section {
    private final String singleLineValue;

    public SingleLineSection(String value) {
        singleLineValue = null;
    }

    @Override
    public void setSectionValue(String value, SectionType section) {

    }

    @Override
    public String getSectionValue(SectionType section) {
        return null;
    }
}
