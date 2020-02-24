package com.mycompany.common.demo.reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //通过反射获取对象
        Class<?> BookClass = Class.forName("com.mycompany.common.demo.reflection.Book");
        Object object = BookClass.newInstance();
        Book book = (Book) object;
        book.setAuthor("simaguang");
        book.setName("zagang");
        System.out.println(book.toString());

        //获取私有构造方法
        Constructor BookConstructor = BookClass.getDeclaredConstructor(String.class, String.class);
        BookConstructor.setAccessible(true);
        Book book2 = (Book) BookConstructor.newInstance("name2", "author2");
        System.out.println(book2.toString());

        //反射私有属性
        Field field = BookClass.getDeclaredField("TAG");
        field.setAccessible(true);
        String str = (String) field.get(object);
        System.out.println(str);

        //反射共有属性
        Field field2 = BookClass.getField("TAG");
        field2.setAccessible(true);
        String str2 = (String) field2.get(object);
        System.out.println(str2);

        //反射获取类的私有方法
        Method bookMethod = BookClass.getDeclaredMethod("declaredMethod", int.class);
        bookMethod.setAccessible(true);
        String value = (String) bookMethod.invoke(object, 2);
        System.out.println(value);
    }
}
