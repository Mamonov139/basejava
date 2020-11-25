package urise.webapp.storage;

import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object findResume(String uuid);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void removeResume(Object searchKey);

    protected abstract void saveResume(Object searchKey, Resume resume);

    protected abstract void updateResume(Object searchKey, Resume resume);

    protected abstract boolean doCheckExist(Object searchKey);

    protected abstract boolean doCheckNotExist(Object searchKey);

    protected void checkExist(String uuid) {
        Object searchKey = findResume(uuid);
        if (doCheckExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
    }

    protected void checkNotExist(String uuid) {
        Object searchKey = findResume(uuid);
        if (doCheckNotExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
    }

    public void save(Resume resume) {
        checkExist(resume.getUuid());
        saveResume(findResume(resume.getUuid()), resume);
    }

    public void update(Resume resume) {
        checkNotExist(resume.getUuid());
        updateResume(findResume(resume.getUuid()), resume);
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
