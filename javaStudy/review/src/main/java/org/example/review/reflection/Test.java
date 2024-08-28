package org.example.review.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
//        try {
//            Class cls = Class.forName("org.example.review.reflection.Student");
//            Method[] methods = cls.getDeclaredMethods();
//            for(Method m : methods) {
//                System.out.println(m.getName());
//            }
//            System.out.println();
//            Object o = cls.getConstructor().newInstance();
//
//            Method setId = cls.getMethod("setId", int.class);
//            setId.invoke(o, 12);
//            Student s = (Student) o;
//            System.out.println(s.getId());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            Class cls = Class.forName("org.example.review.reflection.Student");
            //获取所有公有的属性
            Field[] fields = cls.getFields();
            for(Field f : fields) {
                System.out.println(f);
            }
            System.out.println();

            //获取所有属性
            Field[] fieldArray = cls.getDeclaredFields();
            for(Field f : fieldArray) {
                System.out.println(f);
            }

            System.out.println();

            //获取指定公有属性
            Field field = cls.getDeclaredField("grade");
            System.out.println(field);
            Object o = cls.getConstructor().newInstance();
            field.set(o, 100);
            Student s = (Student) o;
            System.out.println(s.getGrade());

            System.out.println();

            //获取指定私有属性
            Field f = cls.getDeclaredField("name");
            System.out.println(f);
            f.setAccessible(true);
            f.set(o, "zhangsan");
            System.out.println(s.getName());


        } catch (Exception e) {
            e.printStackTrace();
        }


//        try {
//            Class cls = Class.forName("org.example.review.reflection.Student");
//            //获取所有共有的构造方法
//            Constructor[] constructors = cls.getConstructors();
//            for(Constructor c : constructors) {
//                System.out.println(c);
//            }
//            System.out.println();
//
//            //获得所有的构造方法，包括共有的，私有的，受保护的，默认的
//            constructors = cls.getDeclaredConstructors();
//            for(Constructor c : constructors) {
//                System.out.println(c);
//            }
//            System.out.println();
//
//            //获取无参构造
//            Constructor constructor = cls.getConstructor(null);
//            System.out.println(constructor);
//
//            //获取单参构造
//            Constructor con = cls.getConstructor(int.class);
////            Constructor constructor = cls.getDeclaredConstructor(int.class);
//
//            Object o = con.newInstance(12);
//            Student s = (Student) o;
//            System.out.println(s.getId());
//
//            System.out.println();
//            //获取私有构造函数，并调用
//            Constructor c = cls.getDeclaredConstructor(String.class);
//            System.out.println(c);
//            c.setAccessible(true);//允许在类外也可修改或访类内属性和方法
//            Object obj = c.newInstance("abc");
//            Student s1 = (Student) obj;
//            System.out.println(s1.getName());
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        Class cls = null;
//        try {
//            cls = Class.forName("org.example.review.reflection.Student");
//            System.out.println("1: " + cls.getName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Student stu = new Student();
//        Class stuCls = stu.getClass();
//        System.out.println("2: " + stuCls.getName());
//        System.out.println(cls == stuCls);
//
//        Class stuClass = Student.class;
//        System.out.println("3: " + stuClass.getName());
//        System.out.println(stuCls == stuClass);
    }
}
