package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    public static final Comparator<Resume> NAME_COMPARATOR = (o1, o2) -> o1.getFullName().compareTo(o2.getFullName());
    public static final Comparator<Resume> UID_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    public void save(Resume r) {
        Object searchKey = ExistedSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    public void update(Resume r) {
        Object searchKey = NotExistedSearchKey(r.getUuid());
        doUpdate(searchKey, r);
    }

    public Resume get(String uuid) {
        Object searchKey = NotExistedSearchKey(uuid);
        return doGet(searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = NotExistedSearchKey(uuid);
        doDelete(uuid, searchKey);
    }

    private Object ExistedSearchKey(String uuid) {
        Object searchKey = findKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object NotExistedSearchKey(String uuid) {
        Object searchKey = findKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    public List<Resume> getAllSorted() {
        List<Resume> list = getAll();
        Collections.sort(list, NAME_COMPARATOR.thenComparing(UID_COMPARATOR));
        return list;
    }

    protected abstract List<Resume> getAll();

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doUpdate(Object searchKey, Resume r);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doDelete(String uuid, Object searchKey);

    protected abstract void doSave(Resume r, Object searchKey);

    protected abstract Object findKey(String uuid);
}



