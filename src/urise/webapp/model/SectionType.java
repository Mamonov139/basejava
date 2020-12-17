package urise.webapp.model;

public enum SectionType {
    PERSONAL("Личные качества: \n"),
    OBJECTIVE("Позиция: \n"),
    ACHIEVEMENT("Достижения: \n"),
    QUALIFICATIONS("Квалификация: \n"),
    EXPERIENCE("Опыт работы: \n"),
    EDUCATION("Образование: \n");

    private String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
