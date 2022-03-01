package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Резюме " + uuid + " не найдено");
            return null;
        }
        return storage[index];
    }

    public void save(Resume r) {
        int index = findIndex(r.getUuid());
        if (index >= 0) {
            System.out.println("Резюме " + r.getUuid() + " существует");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("Массив переполнен");
        } else {
            saveToArray(r, index);
            size++;
        }
    }

    public void update(Resume r) {
        int index = findIndex(r.getUuid());
        if (index < 0) {
            System.out.println("Резюме " + r.getUuid() + " не найдено");
        } else {
            storage[index] = r;
        }
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Резюме " + uuid + " не найдено");
        } else if (uuid.equals(storage[index].getUuid())) {
            deleteFromArray(index);
            storage[size - 1] = null;
            size--;
        }
    }

    protected abstract int findIndex(String uuid);

    protected abstract void saveToArray(Resume r, int index);

    protected abstract void deleteFromArray(int index);
}