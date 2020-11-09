package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected int findResume(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
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

    @Override
    public void delete(String uuid) {
        int index = findResume(uuid);
        if (index < 0 || index == size) {
            System.out.format("Error: %s not found in Storage!\n", uuid);
            return;
        }
        //System.arraycopy(storage, index + 1, storage, index, size - index-1);
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage[size - 1] = null;
        size--;
    }
}
