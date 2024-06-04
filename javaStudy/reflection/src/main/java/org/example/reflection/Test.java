package org.example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void showConstructor() throws Exception{
        Class cls = Student.class;
//        Constructor con = cls.getDeclaredConstructor();
//        Object o = con.newInstance();

        Constructor con = cls.getDeclaredConstructor(Integer.class);
        Object o = con.newInstance(3000);
        Student s = (Student) o;
        System.out.println(s.getId());

    }

    public static void main(String[] args) {

        try {
            Class<?> cls = Class.forName("org.example.reflection.Student");
            System.out.println(cls.getName());
            //实例化
            Object o = cls.newInstance();

            Field[] fields = o.getClass().getDeclaredFields();
            for(Field field : fields) {
                field.setAccessible(true);
                System.out.print(field.getName() + " ");
                System.out.println(field.get(o));
            }

            Field idField = cls.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(o, 2);
            System.out.println("id " + idField.get(o));


            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.getName());
            }
            Method setId = cls.getDeclaredMethod("setId", Integer.class);
            setId.invoke(o, 200);//调用方法
            System.out.println(idField.get(o));

            showConstructor();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
