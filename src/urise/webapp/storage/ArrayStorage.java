package urise.webapp.storage;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage extends AbstractArrayStorage {

    protected void removeResume(int index) {
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
    }

    protected int findResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return size;
    }

}
