package urise.webapp.model;

public enum ContactsType {
    PHONE("Телефон"),
    EMAIL("@mail");

    private String title;

    ContactsType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
