import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageSize = 0;

    void clear() {
        Arrays.fill(storage, 0, storageSize - 1, null);
        storageSize = 0;
    }


    int elementExists(String guid) {
        int isExists = -1;
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(guid)) {
                isExists = i;
            }
        }
        return isExists;
    }

    void update(Resume r) {
        int index = elementExists(r.uuid);
        if (index >= 0) {
            storage[index] = r;
        } else {
            System.out.println("Невозможно обновить! Данного резюме нет в базе!");
        }
    }


    void save(Resume r) {
        if (storageSize < storage.length) {
            if (elementExists(r.uuid) < 0) {
                for (int i = storageSize; i >= 0; i--) {
                    if (i == 0) {
                        storage[i] = r;
                        storageSize++;
                    } else {
                        storage[i] = r;
                        storageSize++;
                        break;
                    }
                }
            } else {
                System.out.println("Данное резюме уже содержится в базе! Запись не требуется.");
            }
        } else {
            System.out.println("База резюме переполнена!");
        }
    }

    Resume get(String uuid) {
        int index = elementExists(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println("Резюме с указанным uuid нет в базе!");
            return null;
        }


    }

    void delete(String uuid) {
        int index = elementExists(uuid);
        if (index >= 0) {
            storage[index] = null;
            for (int x = index; x < storageSize; x++) {
                storage[x] = storage[x + 1];
                storage[x + 1] = null;
            }
            storageSize--;
        } else {
            System.out.println("Резюме с указанным uuid нет в базе!");
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, storageSize);
    }

    int size() {
        return storageSize;
    }
}
