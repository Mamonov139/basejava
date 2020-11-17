package urise.webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.exception.StorageException;
import urise.webapp.model.Resume;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {



    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
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

    @Test
    public void get() throws Exception {
        Assert.assertEquals(new Resume(UUID_1), storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws RuntimeException {
        storage.get("dummy");
    }

    @Test
    public void getAll() throws Exception {
        Resume[] expectedResumes = {new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)};
        Resume[] actualResumes = storage.getAll();
        Assert.assertEquals(3, actualResumes.length);
        Assert.assertArrayEquals(expectedResumes, actualResumes);
    }

    @Test
    public void save() throws Exception {
        Resume r4 = new Resume(UUID_4);
        storage.save(r4);
        Assert.assertEquals(r4, storage.get(UUID_4));
        Assert.assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(new Resume(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_3);
        Assert.assertEquals(2, storage.size());
        storage.get(UUID_3);

    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete(UUID_4);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();

        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume r3 = new Resume(UUID_3);
        storage.update(r3);
        Assert.assertSame(r3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        Resume r4 = new Resume(UUID_4);
        storage.update(r4);
    }

}