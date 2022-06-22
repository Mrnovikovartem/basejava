package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MainCollections {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final  Resume RESUME1 = new Resume(UUID_1, "Name1" );
    private static final Resume RESUME2 = new Resume(UUID_2, "Name2");
    private static final Resume RESUME3 = new Resume(UUID_3,"Name3" );
    private static final Resume RESUME4 = new Resume(UUID_4,"Name4" );



    public static void main(String[] args) {
//        Collection<Resume> collection = new ArrayList<>();
//        collection.add(RESUME1);
//        collection.add(RESUME2);
//        collection.add(RESUME3);
//        collection.add(RESUME4);
//        collection.add(RESUME6);

        List<Resume> list = new ArrayList<>();
        list.add(0,RESUME1);
        list.add(1,RESUME2);
        System.out.println(list.indexOf(new Resume("uuid2","Name2")));



//        for (Resume r : collection) {
//            System.out.println(r);
//            if (Objects.equals(r.getUuid(), UUID_1)) {
//               collection.remove(r);
//            }
//        }
//        Iterator<Resume> iterator = collection.iterator();
//        while (iterator.hasNext()) {
//            Resume r = iterator.next();
//            System.out.println(r);
//            if (Objects.equals(r.getUuid(), UUID_2)) {
//                iterator.remove();
//            }
//        }

//        System.out.println(collection.toString());
//
//        Map<String, Resume> map = new LinkedHashMap<>();
//        map.put(UUID_1, RESUME1);
//        map.put(UUID_2, RESUME2);
//        map.put(UUID_3, RESUME3);
//        map.put(UUID_4, RESUME4);

//        for (String uuid : map.keySet()) {
//            System.out.println(map.get(uuid));
//        }
//
//        for (Map.Entry<String,Resume> entry : map.entrySet()){
//            System.out.println(entry.getValue());
//        }

//        System.out.println((Resume[])map.values().toArray(new Resume[4]));
//        System.out.println(map.toString());
//        System.out.println(map.get("uuid1"));
//        System.out.println(map.containsKey("uuid1"));
//
//
////        System.out.println(Arrays.toString(map.values()));
//
//
//        System.out.println(Arrays.toString(map.values().toArray(new Resume[4])));


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
//        System.out.println(list.size());

//        List<Resume> resumes = Arrays.asList(RESUME1, RESUME2, RESUME3);
//        resumes.remove(1);
//        System.out.println(resumes);

    }

}
