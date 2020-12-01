package urise.webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public abstract class AbstractStorageTest {

    protected final Storage storage;

    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final String UUID_4 = "uuid4";

    protected static final String FN_1 = "uuid1";
    protected static final String FN_2 = "uuid2";
    protected static final String FN_3 = "uuid3";
    protected static final String FN_4 = "uuid4";

    protected static final Resume resume1 = new Resume(UUID_1, FN_1);
    protected static final Resume resume2 = new Resume(UUID_2, FN_2);
    protected static final Resume resume3 = new Resume(UUID_3, FN_3);
    protected static final Resume resume4 = new Resume(UUID_4, FN_4);

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    public void save() throws Exception {
        storage.save(resume4);
        Assert.assertEquals(resume4, storage.get(UUID_4));
        Assert.assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(resume3);
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
    public void get() throws Exception {
        Assert.assertEquals(resume1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws RuntimeException {
        storage.get("dummy");
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();

        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> expectedResumes = Arrays.asList(resume1, resume2, resume3);
        List<Resume> actualResumes = storage.getAllSorted();
        Assert.assertArrayEquals(actualResumes.toArray(), expectedResumes.toArray());
    }


    @Test
    public void update() throws Exception {
        storage.update(resume3);
        Assert.assertSame(resume3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(resume4);
    }

}