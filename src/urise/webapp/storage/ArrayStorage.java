package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {

    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void update(Resume resume) {
        int i = findResume(resume.getUuid());
        if (i == -1) {
            System.out.format("Error: %s not found in Storage!", resume.getUuid());
            return;
        }
        System.out.format("%s updated", resume.getUuid());
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.format("Error: for %s not enough place", resume.getUuid());
            return;
        }
        if (findResume(resume.getUuid()) != -1) {
            System.out.format("Error: %s already exist", resume.getUuid());
            return;
        }
        storage[size] = resume;
        size++;
    }

    public Resume get(String uuid) {
        int index = findResume(uuid);
        if (index == -1) {
            System.out.format("Error: %s not found in Storage!", uuid);
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = findResume(uuid);
        if (index == -1) {
            System.out.format("Error: %s not found in Storage!", uuid);
            return;
        }
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int findResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}
