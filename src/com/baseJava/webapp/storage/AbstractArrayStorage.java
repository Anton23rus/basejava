package com.baseJava.webapp.storage;

import com.baseJava.webapp.exception.StorageException;
import com.baseJava.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void updateResume(Resume r, Object index) {
        storage[(Integer) index] = r;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void saveResume(Resume r, Object index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        }
        insertElement(r, (Integer) index);
        size++;
    }

    public void deleteResume(Object index) {
        fillDeletedElement((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }

    public Resume getResume(Object index) {
        return storage[(Integer) index];
    }

    @Override
    protected List<Resume> getResumeCollection() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0,size));
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);


}