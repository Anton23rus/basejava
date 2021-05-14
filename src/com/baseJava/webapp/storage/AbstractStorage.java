package com.baseJava.webapp.storage;

import com.baseJava.webapp.exception.ExistStorageException;
import com.baseJava.webapp.exception.NotExistStorageException;
import com.baseJava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void clear() {
        clearCollection();
    }

    public void update(Resume resume) {
        String uuid = resume.getUuid();
        Object index = getExistedElementIndex(uuid);
        updateCollection(resume, index);
    }

    public void save(Resume resume) {
        String uuid = resume.getUuid();
        Object index = getNotExistedElementIndex(uuid);
        saveCollection(resume, index);
    }

    public Resume get(String uuid) {
        Object index = getExistedElementIndex(uuid);
        Resume resume = getCollectionElement(index);
        return resume;
    }

    public void delete(String uuid) {
        Object index = getExistedElementIndex(uuid);
        deleteCollection(index);
    }

    public Resume[] getAll() {
        return getAllCollection();
    }

    public int size() {
        return sizeCollection();
    }

    private Object getExistedElementIndex(String uuid) {
        Object index = getIndex(uuid);
        if ((Integer) index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    private Object getNotExistedElementIndex(String uuid) {
        Object index = getIndex(uuid);
        if ((Integer) index >= 0) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }

    protected abstract void clearCollection();

    protected abstract void updateCollection(Resume resume, Object index);

    protected abstract void saveCollection(Resume resume, Object index);

    protected abstract Resume getCollectionElement(Object index);

    protected abstract void deleteCollection(Object index);

    protected abstract Resume[] getAllCollection();

    protected abstract int sizeCollection();

    protected abstract int getIndex(String uuid);
}
