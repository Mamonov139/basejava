package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private final List<Resume> listStorage = new ArrayList<>();

    @Override
    protected int findResume(String uuid) {
        int index = 0;
        for (Resume r : listStorage) {
            if (uuid.equals(r.getUuid())) return index;
            index++;
        }
        return -1;
    }

    @Override
    protected void addByIndex(int index, Resume resume) {
        listStorage.set(index, resume);
    }

    @Override
    protected Resume getByIndex(int index) {
        return listStorage.get(index);
    }

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    protected void insertResume(int index, Resume resume) {
        listStorage.add(resume);
    }

    @Override
    public void removeResume(int index) {
        listStorage.remove(index);
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

