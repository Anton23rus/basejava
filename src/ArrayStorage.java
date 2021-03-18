import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageSize = 0;

    void clear() {
        for (int i = 0; i < storageSize; i++) {
            storage[i] = null;
        }
        storageSize = 0;
    }

    void save(Resume r) {
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
    }

    Resume get(String uuid) {
        for (Resume r : storage) {
            if (r.uuid.equals(uuid)) {
                return r;
            }
        }
        return null;
    }

    void delete(String uuid) {
        boolean done = false;
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                done = true;
                for (int x = i; x < storageSize; x++) {
                    storage[x] = storage[x + 1];
                    storage[x + 1] = null;
                    break;
                }
                storageSize--;
            }
            if (done) break;
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
