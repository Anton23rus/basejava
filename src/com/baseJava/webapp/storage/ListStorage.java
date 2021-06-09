package com.baseJava.webapp.storage;

import com.baseJava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> arrayList = new ArrayList<>();

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    public void clear() {
        arrayList.clear();
    }

    @Override
    protected void updateResume(Resume resume, Object index) {
        arrayList.set((Integer) index, resume);
    }

    @Override
    protected void saveResume(Resume resume, Object index) {
        arrayList.add(resume);
    }

    @Override
    protected Resume getResume(Object index) {
        return arrayList.get((Integer) index);
    }

    @Override
    protected void deleteResume(Object index) {
        arrayList.remove(((Integer) index).intValue());
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected List<Resume> getResumeCollection() {
        return new ArrayList<>(arrayList);
    }
}

