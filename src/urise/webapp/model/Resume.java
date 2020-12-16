package urise.webapp.model;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;


public class Resume {

    private final String uuid;

    private String fullName;

    private HashMap<ContactsType, String> contacts = new HashMap<>();

    private HashMap<SectionType, Section> sections = new HashMap<>();

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.fullName = fullName;
        this.uuid = uuid;
    }

    public Resume(String fullName, HashMap<ContactsType, String> contacts, HashMap<SectionType, Section> sections) {
        this(fullName);
        this.contacts.putAll(contacts);
        this.sections.putAll(sections);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullName) {
        this.fullName = fullName;
    }

    public String getFullnameWithUuid() {
        return getFullname() + " " + getUuid();
    }

    public String getContact(ContactsType contactsType) {
        return contacts.get(contactsType);
    }

    public void setContact(ContactsType contactsType, String value) {

    }

    public String getSectionValue(SectionType sectionType) {
        return sections.get(sectionType).getSectionValue();
    }

    public void setSectionValue(ContactsType contactsType, String value) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);

    }

    @Override
    public String toString() {
        return uuid;
    }

    protected interface Boo {

    }

    protected abstract class Foo {

    }

    protected class Foo1 extends Foo {

    }
}

