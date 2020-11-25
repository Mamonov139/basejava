package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected Object findResume(String uuid) {
        return mapStorage.containsKey(uuid) ? uuid : "null";
    }

    @Override
    protected boolean doCheckExist(Object searchKey) {
        return !((String) searchKey).equals("null");
    }

    @Override
    protected boolean doCheckNotExist(Object searchKey) {
        return ((String) searchKey).equals("null");
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return mapStorage.get((String) searchKey);
    }

    @Override
    protected void removeResume(Object searchKey) {
        mapStorage.remove((String) searchKey);
    }

    @Override
    protected void saveResume(Object searchKey, Resume resume) {
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateResume(Object searchKey, Resume resume) {
        saveResume(searchKey, resume);
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
