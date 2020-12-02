package urise.webapp.storage;

import urise.webapp.model.Resume;

public class MapResumeStorage extends AbstractMapStorage {

    @Override
    protected Object findResume(String uuid) {
        return mapStorage.getOrDefault(uuid, null);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return mapStorage.get(((Resume) searchKey).getUuid());
    }

    @Override
    protected void removeResume(Object searchKey) {
        mapStorage.remove(((Resume) searchKey).getUuid());
    }
}
