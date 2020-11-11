package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    protected abstract int findResume(String uuid);

    protected abstract void removeResume(int index);

    protected abstract void insertResume(int index, Resume resume);

    public Resume get(String uuid) {
        int index = findResume(uuid);
        if (index < 0 || index == size) {
            System.out.format("Error: %s not found in Storage!\n", uuid);
            return null;
        }
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public void save(Resume resume) {
        if (size == STORAGE_LIMIT) {
            System.out.format("Error: for %s not enough place\n", resume.getUuid());
            return;
        }
        int index = findResume(resume.getUuid());
        if (index >= 0 && index < size) {
            System.out.format("Error: %s already exist\n", resume.getUuid());
            return;
        }
        if (index < 0) {
            index = -(index + 1);
        }
        insertResume(index, resume);
        size++;
    }

    public void delete(String uuid) {
        int index = findResume(uuid);
        if (index < 0 || index == size) {
            System.out.format("Error: %s not found in Storage!\n", uuid);
            return;
        }
        removeResume(index);
        storage[size - 1] = null;
        size--;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = findResume(resume.getUuid());
        if (index < 0 || index == size) {
            System.out.format("Error: %s not found in Storage!\n", resume.getUuid());
            return;
        }
        System.out.format("%s updated\n", resume.getUuid());
    }
}
