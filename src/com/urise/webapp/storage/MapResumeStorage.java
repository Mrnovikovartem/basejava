package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {
    private Map<String, Resume> map = new LinkedHashMap<>();

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
    }

    @Override
    protected void doUpdate(Object resume, Resume r) {
        map.replace(r.getUuid(), r, r);
    }

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    @Override
    protected void doDelete(String uuid, Object resume) {
        map.remove(uuid);
    }

    @Override
    protected void doSave(Resume r, Object resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume findKey(String uuid) {
        if(map.containsKey(uuid)){
            return  map.get(uuid);
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
