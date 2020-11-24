package urise.webapp.storage;


import org.junit.Assert;
import urise.webapp.model.Resume;

public class ListStorageTest extends AbstractStorageTest {

    public ListStorageTest() {
        super(new ListStorage());
    }

    @Override
    protected void assertArrayEquals(Resume[] expectedResumes, Resume[] actualResumes) throws Exception {
        Assert.assertEquals(3, actualResumes.length);
        Assert.assertArrayEquals(expectedResumes, actualResumes);
    }
}