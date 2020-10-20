import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int i = 0;
        while (storage[i] != null && i != storage.length) {
            storage[i] = null;
            i++;

        }

    }

    void save(Resume r) {
        int i = 0;
        while (storage[i] != null && i != storage.length) {
            i++;
        }

        storage[i] = r;


    }

    Resume get(String uuid) {
        int i = 0;
        while (storage[i] != null && i != storage.length) {
            if (storage[i].toString() == uuid) {
                return storage[i];
            }
            i++;
        }


        return null;
    }

    void delete(String uuid) {

        int i = 0;
        while (storage[i] != null && i != storage.length) {
            if (storage[i].toString().equals(uuid)) {
                while (storage[i] != null && i != storage.length - 1) {
                    storage[i] = storage[i + 1];
                    i++;

                }
                storage[i] = null;
                break;
            }
            i++;
        }


    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int l;
        l = this.size();

        return Arrays.copyOf(storage, l);
    }

    int size() {
        int i = 0;
        while (storage[i] != null && i != storage.length) {
            i++;
        }
        return i;
    }
}
