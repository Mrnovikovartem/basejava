package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
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

    @Override
    protected void doSave(Resume r, int index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Массив переполнен", r.getUuid());
        }
        addElement(r, index);
        size++;
    }

    @Override
    public void doUpdate(int index, Resume r) {
        storage[index] = r;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    protected Resume doGet(int index) {
        return storage[index];
    }

    @Override
    protected void doDelete(String uuid, int index) {
        if (uuid.equals(storage[index].getUuid())) {
            deleteFromArray(index);
            storage[size - 1] = null;
            size--;
        }
    }

    protected abstract void addElement(Resume r, int index);

    protected abstract void deleteFromArray(int index);

}