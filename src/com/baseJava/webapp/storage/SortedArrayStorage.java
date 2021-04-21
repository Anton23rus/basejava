package com.baseJava.webapp.storage;

import com.baseJava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void createElement(Resume resume, int index) {
        storage[countIndex(index)] = resume;
    }

    @Override
    protected void moveElements(int index) {
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
    }

    private int countIndex(int index) {
        return (index + 1) * (-1);
    }
}
