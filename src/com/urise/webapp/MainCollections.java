package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ListStorage;

import java.util.*;

public class MainCollections {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume RESUME1 = new Resume(UUID_1);
    private static final Resume RESUME2 = new Resume(UUID_2);
    private static final Resume RESUME3 = new Resume(UUID_3);
    private static final Resume RESUME4 = new Resume(UUID_4);

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(RESUME1);
        collection.add(RESUME2);
        collection.add(RESUME3);
        collection.add(RESUME4);

//        for (Resume r : collection) {
//            System.out.println(r);
//            if (Objects.equals(r.getUuid(), UUID_1)) {
//               collection.remove(r);
//            }
//        }
        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume r = iterator.next();
            System.out.println(r);
            if (Objects.equals(r.getUuid(), UUID_2)) {
                iterator.remove();
            }
        }
        System.out.println(collection.toString());

        Map<String, Resume> map = new HashMap<>();
        map.put(UUID_1, RESUME1);
        map.put(UUID_2, RESUME2);
        map.put(UUID_3, RESUME3);
        map.put(UUID_4, RESUME4);

        for (String uuid : map.keySet()) {
            System.out.println(map.get(uuid));
        }

        for (Map.Entry<String,Resume> entry : map.entrySet()){
            System.out.println(entry.getValue());
        }

//        ListStorage list = new ListStorage();
//
//        list.save(RESUME1);
//        list.save(RESUME2);
//        list.save(RESUME3);
//        System.out.println(list.getAll());
//
//        list.delete(UUID_3);
//        list.update(RESUME2);
//
//        System.out.println(Arrays.toString(list.getAll()));
//
//        System.out.println(list.get(UUID_2));
//        list.clear();
//
//        System.out.println(Arrays.toString(list.getAll()));
//
//        System.out.println(Arrays.toString(list.getAll()));
//
//        System.out.println(list.size());
    }
}
