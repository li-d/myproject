package com.mycompany.common.demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestClass {

    public static void main(String[] args)  {


        //获取对象Class的三种方式
        try {
            //1 Class.forName
            Book book = (Book) Class.forName("com.mycompany.common.demo.reflection.Book").newInstance();
            //2 .class
            Class bookClass = Book.class;
            // 3 getClass
            Book bean = new Book();
            bean.getClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


        //通过反射创建对象


        try {
            // 1 通过无参数构造器
            Constructor constructor = Book.class.getDeclaredConstructor();
            constructor.newInstance();

            //2 通过无参数构造方法
            Constructor constructor1 = Book.class.getConstructor(String.class,String.class);
            Book b = (Book) constructor1.newInstance("name","age");
            System.out.println(b.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
