package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
//        System.out.println(Arrays.binarySearch(storage,0, size, searchKey));
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insertStorage(Resume r, int index) {
        storage[-index - 1] = r;
    }

    @Override
    protected void deleteStorage(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        storage[size - 1] = null;
    }
}

//del b (index 1)
//0 1 2     3
//a b c     d