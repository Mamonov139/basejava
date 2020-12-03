package urise.webapp.storage;

import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected static final Comparator<Resume> RESUME_FULLNAME_COMPARATOR = (o1, o2) -> {
        return o1.getFullname().equals(o2.getFullname()) ? o1.getUuid().compareTo(o2.getUuid()) : o1.getFullname().compareTo(o2.getFullname());
    };

    protected abstract Object findResume(String uuid);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void removeResume(Object searchKey);

    protected abstract void saveResume(Object searchKey, Resume resume);

    protected abstract void updateResume(Object searchKey, Resume resume);

    protected abstract boolean isExist(Object searchKey);

    protected abstract List<Resume> getResumeList();

    public void save(Resume resume) {
        Object searchKey = checkNotExist(resume.getUuid());
        saveResume(searchKey, resume);
    }

    public void update(Resume resume) {
        Object searchKey = checkExist(resume.getUuid());
        updateResume(searchKey, resume);
        System.out.format("%s updated\n", resume.getUuid());
    }

    public void delete(String uuid) {
        Object searchKey = checkExist(uuid);
        removeResume(searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = checkExist(uuid);
        return getResume(searchKey);
    }

    private Object checkNotExist(String uuid) {
        Object searchKey = findResume(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object checkExist(String uuid) {
        Object searchKey = findResume(uuid);
        if (!(isExist(searchKey))) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumeList = getResumeList();
        resumeList.sort(RESUME_FULLNAME_COMPARATOR);
        return resumeList;
    }

}
