package urise.webapp.storage;

import org.junit.Assert;
import org.junit.Test;
import urise.webapp.exception.StorageException;
import urise.webapp.model.Resume;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Override
    public void assertArrayEquals(Resume[] expectedResumes, Resume[] actualResumes) throws Exception {
        Assert.assertEquals(3, actualResumes.length);
        Assert.assertArrayEquals(expectedResumes, actualResumes);
    }

    @Test(expected = StorageException.class)
    public void storageOverflow() throws Exception {
        for (int i = 3; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
            try {
                storage.save(new Resume());
            } catch (StorageException e) {
                Assert.fail("Переполнение раньше времени!");
            }
        }
        storage.save(new Resume());
    }

}