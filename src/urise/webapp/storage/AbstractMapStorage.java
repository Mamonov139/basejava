package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapStorage extends AbstractStorage {

    protected final Map<String, Resume> mapStorage = new HashMap<>();

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
        List<Resume> resumeList = new ArrayList<>(mapStorage.values());
        resumeList.sort(RESUME_COMPARATOR);
        return resumeList;
    }

    @Override
    public int size() {
        return mapStorage.size();
    }
}