package urise.webapp.storage;

import urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void removeResume(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected void insertResume(int index, Resume resume) {
        storage[size] = resume;
    }

    @Override
    protected int findResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}
