package com.baseJava.webapp.storage;

import com.baseJava.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }

    @Override
    protected void insertElement(Resume r, int index) {
//      http://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array#answer-36239
        int insertIdx = -index - 1;
        System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
        storage[insertIdx] = r;
    }

    private static final Comparator<Resume> COMPARATOR_RESUME = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    @Override
    protected Object getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "some_fullName");
        return Arrays.binarySearch(storage, 0, size, searchKey, COMPARATOR_RESUME);
    }
}

