package com.baseJava.webapp;

import com.baseJava.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Resume r = new Resume("some_name");
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        // TODO : invoke r.toString via reflection
        Class classResume = r.getClass();
        String methodName = "toString";
        Method method = classResume.getMethod(methodName);
        System.out.println(method.invoke(r));
        System.out.println(r);
    }
}
