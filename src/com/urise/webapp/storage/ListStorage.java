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
    protected void doSave(Resume r, int index) {
        list.add(r);
    }

    @Override
    public void doUpdate(int index, Resume r) {
        list.set(index, r);
    }

    @Override
    protected Resume doGet(int index) {
        return list.get(index);
    }

    @Override
    protected void doDelete(String uuid, int index) {
        Resume r = new Resume(uuid);
        list.remove(r);
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
    protected int findIndex(String uuid) {
        return list.indexOf(new Resume(uuid));
    }
}
