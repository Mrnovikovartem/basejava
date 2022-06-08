package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, RuntimeException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        Field field1 = r.getClass().getDeclaredFields()[1];
        field.setAccessible(true);
        field1.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field1.getName());
        System.out.println(field.get(r));
        System.out.println(field1.get(r));
        field.set(r, "new_uuid");
        System.out.println(r);

        Method method = r.getClass().getMethod("toString");
        System.out.println(method);
        System.out.println(method.invoke(r));
    }
}
