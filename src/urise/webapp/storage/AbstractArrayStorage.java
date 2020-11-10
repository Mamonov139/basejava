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
        if (index == size) {
            storage[size] = resume;
            size++;
            return;
        }
        // System.arraycopy(storage, -(index + 1), storage, -(index + 1)+1, size + index+1);
        for (int i = size - 1; i >= -(index + 1); i--) {
            storage[i + 1] = storage[i];
        }
        storage[-(index + 1)] = resume;
        size++;
    }

    public void delete(String uuid) {
        int index = findResume(uuid);
        if (index < 0 || index == size) {
            System.out.format("Error: %s not found in Storage!\n", uuid);
            return;
        }
        removeResume(index);
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
