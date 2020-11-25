package urise.webapp.storage;

import urise.webapp.exception.StorageException;
import urise.webapp.model.Resume;

import java.util.Arrays;


public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract void doSave(int index, Resume resume);

    protected abstract void doRemove(int index);

    @Override
    protected boolean doCheckExist(Object searchKey) {
        return (int) searchKey >= 0;
    }

    @Override
    protected boolean doCheckNotExist(Object searchKey) {
        return (int) searchKey < 0;
    }
    @Override
    protected void updateResume(Object searchKey, Resume resume) {
        storage[(int) searchKey] = resume;
    }

    @Override
    protected void saveResume(Object searchKey, Resume resume) {
        checkOverflow(resume);
        doSave((int) searchKey, resume);
    }

    @Override
    protected void removeResume(Object searchKey) {
        doRemove((int) searchKey);
        updateResume(--size, null);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return storage[(int) searchKey];
    }

    protected void checkOverflow(Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        size++;
    }

    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }
}
