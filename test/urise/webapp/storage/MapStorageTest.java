package urise.webapp.storage;

import org.junit.Assert;
import urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MapStorageTest extends AbstractStorageTest {

    public MapStorageTest() {
        super(new MapStorage());
    }

    @Override
    public void assertArrayEquals(Resume[] expectedResumes, Resume[] actualResumes) throws Exception {
        Set<Resume> expectedResumesSet = new HashSet<Resume>(Arrays.asList(expectedResumes));
        Set<Resume> actualResumesSet = new HashSet<Resume>(Arrays.asList(actualResumes));
        Assert.assertEquals(expectedResumesSet, actualResumesSet);
    }
}