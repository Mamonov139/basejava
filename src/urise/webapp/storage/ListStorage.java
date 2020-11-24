package urise.webapp.storage;

import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private final List<Resume> listStorage = new ArrayList<>();

    @Override
    protected Object findResume(String uuid) {
        for (int index = 0; index < size(); index++) {
            if (uuid.equals(getResume(index).getUuid())) return index;
        }
        return -1;
    }

    @Override
    protected void checkExist(String uuid) {
        Object searchKey = findResume(uuid);
        if ((int) searchKey >= 0) {
            throw new ExistStorageException(uuid);
        }
    }

    @Override
    protected void checkNotExist(String uuid) {
        Object searchKey = findResume(uuid);
        if ((int) searchKey < 0) {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return listStorage.get((int) searchKey);
    }

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    public void removeResume(Object searchKey) {
        listStorage.remove((int) searchKey);
    }

    @Override
    protected void saveResume(Object searchKey, Resume resume) {
        listStorage.add(resume);
    }

    @Override
    public Resume[] getAll() {
        Resume[] r = new Resume[listStorage.size()];
        return listStorage.toArray(r);
    }

    @Override
    public int size() {
        return listStorage.size();
    }
}

