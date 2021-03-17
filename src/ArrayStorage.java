import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = storage.length-1; i >= 0; i--) {
            if (storage[i] == null && i == 0) {
                storage[i] = r;
            }
            else if (storage[i] == null && i != 0){
                continue;
            }
             else if(storage[i] != null) {
                storage[i + 1] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume x : storage) {
            if (x.uuid.equals(uuid)) {
                return x;
            }
        }
      //  return storage[Arrays.asList(storage).indexOf(uuid)];
return null;
    }

    void delete(String uuid) {
        boolean done = false;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                done = true;
                for (int x = i; x < storage.length - 1; x++) {

                        if (storage[x + 1] != null) {
                            storage[x] = storage[x + 1];
                            storage[x + 1] = null;
                        }
                        else break;

                }
            }
            if (done) break;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        int storageSize = size();
        Resume[] storageWithoutNull = Arrays.copyOf(storage, storageSize);
        return storageWithoutNull;
    }

    int size() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return i;
            }
        }
        return storage.length;
    }
}
