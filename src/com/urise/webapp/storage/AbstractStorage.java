package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void save(Resume r) {
        Object index = findIndex(r.getUuid());
        if (isExist(index)) {
            throw new ExistStorageException(r.getUuid());
        }
        doSave(r, index);
    }

    public void update(Resume r) {
        Object index = findIndex(r.getUuid());
        if (!isExist(index)) {
            throw new NotExistStorageException(r.getUuid());
        }
        doUpdate(index, r);
    }

    public Resume get(String uuid) {
        Object index = findIndex(uuid);
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        }
        return doGet(index);
    }

    public void delete(String uuid) {
        Object index = findIndex(uuid);
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        }
        doDelete(uuid, index);
    }

    protected abstract boolean isExist(Object index);

    protected abstract void doUpdate(Object index, Resume r);

    protected abstract Resume doGet(Object index);

    protected abstract void doDelete(String uuid, Object index);

    protected abstract void doSave(Resume r, Object index);

    protected abstract Object findIndex(String uuid);
}



