package urise.webapp.storage;

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
    protected boolean doCheckExist(Object searchKey) {
        return (int) searchKey >= 0;
    }

    @Override
    protected boolean doCheckNotExist(Object searchKey) {
        return (int) searchKey < 0;
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
    protected void updateResume(Object searchKey, Resume resume) {
        listStorage.add((int) searchKey, resume);
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

