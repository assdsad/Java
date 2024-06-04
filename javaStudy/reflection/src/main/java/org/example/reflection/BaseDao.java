package org.example.reflection;

import java.lang.reflect.Field;

public class BaseDao {

    public static void save(Object obj) throws Exception {
        Class<?> cls = obj.getClass();//类名与表明相同
        String sql = "insert into ";
        sql += cls.getSimpleName() + "(";

        Field[] fields = cls.getDeclaredFields();
        for(Field field : fields) {
            sql += field.getName() + ",";
        }
        sql = sql.substring(0, sql.length() - 1);//去掉最后一个,
        sql += ") values(";
        for(Field field : fields) {
            field.setAccessible(true);
//            if(field.get(obj) instanceof String)
            if(field.get(obj).getClass().getSimpleName().equals("String")) {//如果是字符串类型则在其左右加上''
                sql += "'" + field.get(obj) + "',";
            }else {
                sql += field.get(obj) + ",";
            }
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += ")";

        System.out.println(sql);

    }

    public static void main(String[] args) {

        Student s = new Student();
        s.setId(200);
        s.setName("张三");

        try {
            save(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
