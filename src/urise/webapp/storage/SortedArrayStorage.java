package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    protected static final Comparator<Resume> RESUME_UUID_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected Object findResume(String uuid) {
        Resume searchKey = new Resume(uuid,"");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_UUID_COMPARATOR);
    }

    @Override
    protected void doRemove(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    @Override
    protected void doSave(int index, Resume resume) {
        int insertIndex = -(index + 1);
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex - 1);
        storage[insertIndex] = resume;
    }
}
