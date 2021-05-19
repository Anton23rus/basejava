package com.baseJava.webapp.storage;

import com.baseJava.webapp.model.Resume;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapSorage extends AbstractStorage {
    private Map<String, Resume> map = new LinkedHashMap<>();

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    protected void updateData(Resume resume, Object index) {
        map.put((String) index, resume);
    }

    @Override
    protected void saveData(Resume resume, Object index) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getData(Object index) {
        return map.get((String) index);
    }

    @Override
    protected void deleteData(Object index) {
        map.remove((String) index);
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[map.size()]);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected Object getIndex(String uuid) {
        if (map.get(uuid) != null) {
            return uuid;
        }
        return null;
    }
}