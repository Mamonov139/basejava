package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Collection;

public class MapResumeStorage extends AbstractMapStorage {

    @Override
    protected Object findResume(String uuid) {
        return mapStorage.containsKey(uuid) ? mapStorage.get(uuid).getFullname() : null;
    }

    @Override
    protected Resume getResume(Object searchKey) {
        Collection<Resume> resumeCollection = mapStorage.values();
        for (Resume r : resumeCollection) {
            if (r.getFullname().equals(searchKey)) {
                return r;
            }
        }
        return null;
    }

    @Override
    protected void removeResume(Object searchKey) {
        mapStorage.remove(getResume(searchKey).getUuid());
    }


}
