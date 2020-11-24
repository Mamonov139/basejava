package urise.webapp.storage;

import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected Object findResume(String uuid) {
        return mapStorage.containsKey(uuid) ? uuid : null;
    }

    @Override
    protected void checkExist(String uuid) {
        String searchKey = (String) findResume(uuid);
        if (!searchKey.equals("null")) {
            throw new ExistStorageException(uuid);
        }
    }

    @Override
    protected void checkNotExist(String uuid) {
        String searchKey = (String) findResume(uuid);
        if (searchKey.equals("null")) {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return mapStorage.get(searchKey);
    }

    @Override
    protected void removeResume(Object searchKey) {
        mapStorage.remove(searchKey);
    }

    @Override
    protected void saveResume(Object searchKey, Resume resume) {
        mapStorage.put((String) searchKey, resume);
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] r = new Resume[size()];
        return mapStorage.values().toArray(r);

    }

    @Override
    public int size() {
        return mapStorage.size();
    }
}
