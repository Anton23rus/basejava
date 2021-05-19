package com.baseJava.webapp.storage;

import com.baseJava.webapp.exception.ExistStorageException;
import com.baseJava.webapp.exception.NotExistStorageException;
import com.baseJava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        String uuid = resume.getUuid();
        Object index = getExistedElementIndex(uuid);
        updateData(resume, index);
    }

    public void save(Resume resume) {
        String uuid = resume.getUuid();
        Object index = getNotExistedElementIndex(uuid);
        saveData(resume, index);
    }

    public Resume get(String uuid) {
        Object index = getExistedElementIndex(uuid);
        Resume resume = getData(index);
        return resume;
    }

    public void delete(String uuid) {
        Object index = getExistedElementIndex(uuid);
        deleteData(index);
    }

    private Object getExistedElementIndex(String uuid) {
        Object index = getIndex(uuid);
        if (index instanceof String) {
            return index;
        } else if ((Integer) index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    private Object getNotExistedElementIndex(String uuid) {
        Object index = getIndex(uuid);
        if (index instanceof String) {
            throw new ExistStorageException(uuid);
        } else if ((Integer) index >= 0) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }

    protected abstract void updateData(Resume resume, Object index);

    protected abstract void saveData(Resume resume, Object index);

    protected abstract Resume getData(Object index);

    protected abstract void deleteData(Object index);

    protected abstract Object getIndex(String uuid);
}
