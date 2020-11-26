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
}