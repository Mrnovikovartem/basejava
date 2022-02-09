package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[3];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (getArrayIndex(r.getUuid()) != -1) {
            System.out.println("Резюме существует");
        } else if (size == storage.length) {
            System.out.println("Массив переполнен");
        } else {
            for (int i = 0; i <= size; i++) {
                if (storage[i] == null) {
                    storage[i] = r;
                    size++;
                    break;
                }
            }
        }
    }

    public void update(Resume r) {
        if (getArrayIndex(r.getUuid()) == -1) {
            System.out.println("Резюме не найдено");
        } else {
            storage[getArrayIndex(r.getUuid())] = r;
        }
    }

    public Resume get(String uuid) {
        if (getArrayIndex(uuid) == -1) {
            System.out.println("Резюме не найдено");
            return null;
        }
        return storage[getArrayIndex(uuid)];
    }

    public void delete(String uuid) {
        if (getArrayIndex(uuid) == -1) {
            System.out.println("Резюме не найдено");
        }
        if (uuid.equals(storage[getArrayIndex(uuid)].getUuid())) {
            storage[getArrayIndex(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            return;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public int getArrayIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}