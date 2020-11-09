package urise.webapp.storage;

import urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume resume) {
        if (size == STORAGE_LIMIT) {
            System.out.format("Error: for %s not enough place\n", resume.getUuid());
            return;
        }
        if (findResume(resume.getUuid()) != -1) {
            System.out.format("Error: %s already exist\n", resume.getUuid());
            return;
        }
        storage[size] = resume;
        size++;
    }

    public void delete(String uuid) {
        int index = findResume(uuid);
        if (index == -1) {
            System.out.format("Error: %s not found in Storage\n!", uuid);
            return;
        }
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    protected int findResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}
