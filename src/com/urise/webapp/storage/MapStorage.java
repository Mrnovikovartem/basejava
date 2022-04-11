package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new LinkedHashMap<>();

    @Override
    protected boolean isExist(Object index) {
        return index != null;
    }

    @Override
    protected void doUpdate(Object index, Resume r) {
        map.replace(r.getUuid(), r, r);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return (Resume) uuid;
    }

    @Override
    protected void doDelete(String uuid, Object index) {
        map.remove(uuid);
    }

    @Override
    protected void doSave(Resume r, Object index) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Object findIndex(String uuid) {
        return map.get(uuid);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) map.values().toArray(new Resume[size()]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
