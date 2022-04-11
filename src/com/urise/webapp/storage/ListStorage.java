package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    protected void doSave(Resume r, Object index) {
        list.add(r);
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }

    @Override
    public void doUpdate(Object index, Resume r) {
        list.set((int) index, r);
    }

    @Override
    protected Resume doGet(Object index) {
        return list.get((int) index);
    }

    @Override
    protected void doDelete(String uuid, Object index) {
        list.remove((int) index);
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[size()]);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    protected Object findIndex(String uuid) {
        return list.indexOf(new Resume(uuid));
    }
}
