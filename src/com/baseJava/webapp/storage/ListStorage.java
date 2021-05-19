package com.baseJava.webapp.storage;

import com.baseJava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> arrayList = new ArrayList<>();

    @Override
    public void clear() {
        arrayList.clear();
    }

    @Override
    protected void updateData(Resume resume, Object index) {
        arrayList.set((Integer) index, resume);
    }

    @Override
    protected void saveData(Resume resume, Object index) {
        arrayList.add(resume);
    }

    @Override
    protected Resume getData(Object index) {
        return arrayList.get((Integer) index);
    }

    @Override
    protected void deleteData(Object index) {
        arrayList.remove(((Integer) index).intValue());
    }

    @Override
    public Resume[] getAll() {
        return arrayList.toArray(new Resume[arrayList.size()]);
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    protected Object getIndex(String uuid) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }
}

