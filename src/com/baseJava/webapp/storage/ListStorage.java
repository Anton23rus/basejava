package com.baseJava.webapp.storage;

import com.baseJava.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {
    private ArrayList<Resume> arrayList = new ArrayList<>();

    @Override
    protected void clearCollection() {
        arrayList.clear();
    }

    @Override
    protected void updateCollection(Resume resume, Object index) {
        arrayList.set((Integer) index, resume);
    }

    @Override
    protected void saveCollection(Resume resume, Object index) {
        arrayList.add(resume);
    }

    @Override
    protected Resume getCollectionElement(Object index) {
        return arrayList.get((Integer) index);
    }

    @Override
    protected void deleteCollection(Object index) {
        arrayList.remove(((Integer) index).intValue());
    }

    @Override
    protected Resume[] getAllCollection() {
        return arrayList.toArray(new Resume[arrayList.size()]);
    }

    @Override
    protected int sizeCollection() {
        return arrayList.size();
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}

