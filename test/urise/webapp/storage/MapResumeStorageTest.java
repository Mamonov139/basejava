package urise.webapp.storage;

import org.junit.Before;
import urise.webapp.model.Resume;

import static org.junit.Assert.*;

public class MapResumeStorageTest extends AbstractStorageTest {
    public MapResumeStorageTest() { super(new MapResumeStorage());}
}