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
    protected void saveToStorage(Resume resume, int index) {
        storage[-index - 1] = resume;
    }

    @Override
    protected void deleteFromStorage(int index) {
        int countMove = size - index - 1;
        if (countMove > 0 ) {
            System.arraycopy(storage, index + 1, storage, index, countMove);
        }
    }


}
