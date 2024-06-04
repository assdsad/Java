package org.example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectBase {

    public static void showConstructor() throws Exception{
        Class cls = Student.class;
//        Constructor con = cls.getDeclaredConstructor();//拿到无参构造方法
//        Object o = con.newInstance();//实例化对象
//        Student s = (Student) o;
//        s.setId(1);
//        System.out.println(s.getId());

        Constructor con = cls.getDeclaredConstructor(Integer.class);//得到单参构造方法
        Object o = con.newInstance(100);//实例化对象时也要传入单参构造的参数
        Student s = (Student) o;
        System.out.println(s.getId());
    }
    public static void showMethods(Object obj) throws Exception {
        Class<?> cls = obj.getClass();
//        Method[] methods = cls.getMethods();//得到所有 方法 的集合 （包括继承父类的方法）
        Method[] methods = cls.getDeclaredMethods();//得到当前类中的所有实现了的方法
        for(Method method : methods) {
            System.out.println(method.getName());
        }

        Method setId = cls.getMethod("setId", Integer.class);//有重载方法时，调用单参的方法并且参数类型为Integer
//        cls.getMethod("setId", Integer.class, String.class);
        //调用方法
        setId.invoke(obj, 100);//把100传入obj对象的setId()方法中  s.setId(100);  id变为100

    }
     public static void showField(Object obj) throws Exception {
         //得到类
         Class<?> cls = obj.getClass();
         //得到 属性 的集合
         Field[] fields = cls.getDeclaredFields();
         for(Field field : fields) {
             //打印属性的名字
             System.out.print(field.getName() + " ");
             field.setAccessible(true);//设置类内属性在类外也可以访问  例如private属性在类外也可访问
             Object value = field.get(obj);//得到obj对象的当前field对应的属性的值  s.id   s.name
             System.out.println(value);
         }

         Field id = cls.getDeclaredField("id");//得到id属性
         id.setAccessible(true);
         id.set(obj, 2);//把obj对象的id属性值改为2   s.id = 2
         System.out.println("id = " + id.get(obj));
     }

    public static void main(String[] args) {
        Student s = new Student();
        s.setId(1);
        s.setName("张三");
        try {
            showField(s);

//            showMethods(s);
//            System.out.println(s.getId());

//            showConstructor();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            //加载类
//            //获得到一个类
//            Class<?> cls = Class.forName("org.example.reflection.Student");
//            System.out.println(cls.getName());
//            Object object = cls.newInstance();//用于实例化对象
////            cls.getClassLoader();//获得加载这个类的 类加载器
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
