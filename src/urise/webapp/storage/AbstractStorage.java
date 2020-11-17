package urise.webapp.storage;

import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract int findResume(String uuid);

    protected abstract void addByIndex(int index, Resume resume);

    protected abstract Resume getByIndex(int index);

    protected abstract void insertResume(int index, Resume resume);

    protected abstract void removeResume(int index);

    public void save(Resume resume) {
        int index = findResume(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        }
        insertResume(index, resume);
            }

    public void update(Resume resume) {
        int index = findResume(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        }
        addByIndex(index, resume);
        System.out.format("%s updated\n", resume.getUuid());
    }

    public void delete(String uuid) {
        int index = findResume(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        removeResume(index);
            }

    public Resume get(String uuid) {
        int index = findResume(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return getByIndex(index);
    }
}
