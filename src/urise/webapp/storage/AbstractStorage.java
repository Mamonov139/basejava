package urise.webapp.storage;

import urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object findResume(String uuid);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void removeResume(Object searchKey);

    protected abstract void saveResume(Object searchKey, Resume resume);

    protected abstract void checkExist(String uuid);

    protected abstract void checkNotExist(String uuid);

    public void save(Resume resume) {
        checkExist(resume.getUuid());
        saveResume(findResume(resume.getUuid()), resume);
    }

    public void update(Resume resume) {
        checkNotExist(resume.getUuid());
        saveResume(findResume(resume.getUuid()), resume);
        System.out.format("%s updated\n", resume.getUuid());
    }

    public void delete(String uuid) {
        checkNotExist(uuid);
        removeResume(findResume(uuid));
    }

    public Resume get(String uuid) {
        checkNotExist(uuid);
        return getResume(findResume(uuid));
    }
}
