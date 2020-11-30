package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected Object findResume(String uuid) {
        return mapStorage.containsKey(uuid) ? uuid : null;
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
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateResume(Object searchKey, Resume resume) {
        saveResume(searchKey, resume);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumeList = new ArrayList<Resume>(mapStorage.values());
        resumeList.sort(RESUME_COMPARATOR);
        return resumeList;

    }

    @Override
    public int size() {
        return mapStorage.size();
    }
}
