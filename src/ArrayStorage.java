import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {

    Resume[] storage = new Resume[10000];
    private int size = 0;

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    void clear() {
        while (this.getSize() != 0) {
            storage[this.getSize() - 1] = null;
            this.setSize(this.getSize() - 1);
        }
    }

    void save(Resume r) {
        storage[this.getSize()] = r;
        this.setSize(this.getSize() + 1);
    }

    Resume get(String uuid) {
        for (int i = 0; i < this.getSize(); i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int i = 0;
        while (i <= this.getSize()) {
            if (storage[i].toString().equals(uuid)) {
                while (storage[i] != null && i != storage.length - 1) {
                    storage[i] = storage[i + 1];
                    i++;
                }
                storage[i] = null;
                this.setSize(this.getSize() - 1);
                break;
            }
            i++;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, this.getSize());
    }

    int size() {
        return this.getSize();
    }

}
