package com.baseJava.webapp.storage;

import com.baseJava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapStorageValue extends AbstractStorage {
    private Map<String, Resume> map = new LinkedHashMap<>();

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    protected void updateResume(Resume resume, Object searchKey) {
        map.put(((Resume) searchKey).getUuid(), resume);
    }

    @Override
    protected void saveResume(Resume resume, Object searchKey) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected void deleteResume(Object searchKey) {
        map.remove(((Resume) searchKey).getUuid());
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected List<Resume> getResumeCollection() {
        return new ArrayList<>(map.values());
    }
}