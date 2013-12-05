package com.airhacks.airject;

import java.lang.reflect.Field;

/**
 * Hello world!
 *
 */
public class AppServer {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> client = Class.forName("com.airhacks.airject.Client");
        Field[] declaredFields = client.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(AirJect.class)) {
                Class<?> type = field.getType();
                System.out.println("Found: " + type);
                Object serverSide = type.newInstance();
                Object clientSide = client.newInstance();
                field.setAccessible(true);
                field.set(clientSide, serverSide);
                System.out.println(" " + clientSide.toString());
            } else {
                System.out.println("Not annotated: " + field);
            }

        }
    }
}
