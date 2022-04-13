package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new LinkedHashMap<>();

    @Override
    protected boolean isExist(Object key) {
        return key != null;
    }

    @Override
    protected void doUpdate(Object key, Resume r) {
        map.replace(r.getUuid(), r, r);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return (Resume) map.get(uuid);
    }

    @Override
    protected void doDelete(String uuid, Object key) {
        map.remove(uuid);
    }

    @Override
    protected void doSave(Resume r, Object key) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Object findIndex(String uuid) {
        if (map.get(uuid) == null) {
            return null;
        } else {
            return map.get(uuid).getUuid();
        }
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[size()]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
