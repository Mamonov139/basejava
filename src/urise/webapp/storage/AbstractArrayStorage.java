package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public abstract class AbstractArrayStorage implements  Storage{
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    protected abstract int findResume(String uuid);

    public Resume get(String uuid) {
        int index = findResume(uuid);
        if (index == -1) {
            System.out.format("Error: %s not found in Storage!\n", uuid);
            return null;
        }
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }
    public void update(Resume resume) {
        int index = findResume(resume.getUuid());
        if (index == -1) {
            System.out.format("Error: %s not found in Storage!\n", resume.getUuid());
            return;
        }
        System.out.format("%s updated\n", resume.getUuid());
    }
}
