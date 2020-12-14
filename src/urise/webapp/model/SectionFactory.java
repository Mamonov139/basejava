package urise.webapp.model;

public class SectionFactory {
    protected static Section newSectionObject(SectionType section, String value) {
        switch (section) {
            case PERSONAL:
            case OBJECTIVE:
                return new SingleLineSection(value);
            default:
                return new BulletedLineSection(value);
        }
    }
}
