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
        int index = existsElement(uuid);
        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("Невозможно обновить! Резюме с uuid: " + uuid + " нет в базе!");
        }
    }

    public void save(Resume resume) {
        if (storageSize < storage.length) {
            String uuid = resume.getUuid();
            if (existsElement(uuid) < 0) {
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
        int index = existsElement(uuid);
        if (index >= 0) {
            return storage[index];
        }
        System.out.println("Резюме с uuid: " + uuid + " нет в базе!");
        return null;
    }

    public void delete(String uuid) {
        int index = existsElement(uuid);
        if (index >= 0) {
            storage[index] = null;
            for (int i = index; i < storageSize; i++) {
                storage[i] = storage[i + 1];
            }
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

    private int existsElement(String guid) {
        int isExists = -1;
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].getUuid().equals(guid)) {
                isExists = i;
            }
        }
        return isExists;
    }
}
