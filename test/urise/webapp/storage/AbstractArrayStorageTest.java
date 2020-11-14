package urise.webapp.storage;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.model.Resume;

import java.lang.reflect.Field;

public abstract class AbstractArrayStorageTest {

    private final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void storageOverflow() throws Exception{
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredField();
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(new Resume(UUID_1), storage.get(UUID_1));
    }

    @Test
    public void getAll() throws Exception {
        Resume[] testArray = storage.getAll();
        Assert.assertEquals(3, testArray.length);
        for (Resume resume : testArray) {
            Assert.assertNotEquals(null, resume);
        }
    }

    @Test
    public void save() throws Exception {
        Resume r4 = new Resume(UUID_4);
        storage.save(r4);
        Assert.assertEquals(r4, storage.get(UUID_4));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        Resume r4 = new Resume(UUID_4);
        storage.save(r4);
        storage.delete(UUID_4);
        storage.get(UUID_4);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.getAll().length);
    }

    @Test
    public void update() throws Exception {
        Resume r3 = new Resume(UUID_3);
        storage.update(r3);
        Assert.assertSame(storage.get(UUID_3), r3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws RuntimeException {
        storage.get("dummy");
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(new Resume(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete(UUID_4);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        Resume r4 = new Resume(UUID_4);
        storage.update(r4);
    }

}