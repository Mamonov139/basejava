package urise.webapp;

import urise.webapp.model.Resume;
import urise.webapp.storage.ArrayStorage;
import urise.webapp.storage.Storage;

/**
 * Interactive test for urise.webapp.storage.ArrayStorage implementation
 * (just run, no need to understand)
 */
public class MainArray {
    //public static final Storage ARRAY_STORAGE = new SortedArrayStorage();
    public static final Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");
        Resume r4 = new Resume("uuid4");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.update(r1);
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.update(r1);
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
