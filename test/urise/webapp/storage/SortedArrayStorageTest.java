package urise.webapp.storage;

import static org.junit.Assert.*;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    private static final Storage SORTED_ARRAY_STORAGE = new SortedArrayStorage();

    public SortedArrayStorageTest() {
        super(SORTED_ARRAY_STORAGE);
    }
}