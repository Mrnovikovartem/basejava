package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
        return map.get((String) uuid);
    }

    @Override
    protected void doDelete(Object key) {
        map.remove(key);
    }

    @Override
    protected void doSave(Resume r, Object key) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Object findKey(String uuid) {
        if(map.containsKey(uuid)){
            return  map.get(uuid).getUuid();
        } else {
            return null;
        }
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAll() {
        List<Resume> list = new ArrayList<Resume>(map.values());
        return list;
    }

    @Override
    public int size() {
        return map.size();
    }
}
