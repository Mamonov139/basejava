package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {

    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void update(Resume r) {
        int i = findResume(r.toString());
        if (i == -1) {
            System.out.println("Error: uuid not found");
            return;
        }
        System.out.println("uuid updated");
    }

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Error: not enough place ");
            return;
        }
        if (findResume(r.toString()) != -1) {
            System.out.println("Error: uuid already exist ");
            return;
        }
        storage[size] = r;
        size++;
    }

    public Resume get(String uuid) {
        int i = findResume(uuid);
        if (i == -1) {
            System.out.println("Error: uuid not found ");
            return null;
        }
        return storage[i];
    }


    public void delete(String uuid) {
        int i = findResume(uuid);
        if (i == -1) {
            System.out.println("Error: uuid not found ");
            return;
        }
        storage[i] = storage[size - 1];
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
            if (storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}
