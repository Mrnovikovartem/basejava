package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void save(Resume r) {
        Object searchKey = isExistedSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    public void update(Resume r) {
        Object searchKey = isNotExistedSearchKey(r.getUuid());
        doUpdate(searchKey, r);
    }

    public Resume get(String uuid) {
        Object searchKey = isNotExistedSearchKey(uuid);
        return doGet(searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = isNotExistedSearchKey(uuid);
        doDelete(uuid, searchKey);
    }

    public Object isExistedSearchKey(String uuid) {
        Object searchKey = findIndex(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    public Object isNotExistedSearchKey(String uuid) {
        Object searchKey = findIndex(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doUpdate(Object searchKey, Resume r);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doDelete(String uuid, Object searchKey);

    protected abstract void doSave(Resume r, Object searchKey);

    protected abstract Object findIndex(String uuid);
}



