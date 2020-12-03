package urise.webapp.model;

import java.util.Objects;
import java.util.UUID;


public class Resume {

    private final String uuid;

    private String fullname;

    public Resume(String fullname) {
        this(UUID.randomUUID().toString(), fullname);
    }

    public Resume(String uuid, String fullname) {
        this.fullname = fullname;
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullnameWithUuid() {
        return getFullname() + " " + getUuid();
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
}

