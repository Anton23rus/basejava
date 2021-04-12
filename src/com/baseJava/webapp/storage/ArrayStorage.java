package com.baseJava.webapp.storage;

import com.baseJava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int storageSize = 0;

    public void clear() {
        Arrays.fill(storage, 0, storageSize, null);
        storageSize = 0;
    }

    public void update(Resume resume) {
        String uuid = resume.getUuid();
        int index = findIndex(uuid);
        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("Невозможно обновить! Резюме с uuid: " + uuid + " нет в базе!");
        }
    }

    public void save(Resume resume) {
        if (storageSize < storage.length) {
            String uuid = resume.getUuid();
            if (findIndex(uuid) < 0) {
                storage[storageSize] = resume;
                storageSize++;
            } else {
                System.out.println("Резюме с uuid: " + uuid + " уже содержится в базе! Запись не требуется.");
            }
        } else {
            System.out.println("База резюме переполнена!");
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        System.out.println("Резюме с uuid: " + uuid + " нет в базе!");
        return null;
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index >= 0) {
            storage[index] = storage[storageSize - 1];
            storage[storageSize - 1] = null;
            storageSize--;
        } else {
            System.out.println("Резюме uuid: " + uuid + " нет в базе!");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, storageSize);
    }

    public int size() {
        return storageSize;
    }

    private int findIndex(String guid) {
        int index = -1;
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].getUuid().equals(guid)) {
                index = i;
            }
        }
        return index;
    }
}
