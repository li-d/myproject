package com.mycompany.common.demo.core;


import com.mycompany.common.demo.java8.stream.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * 创建对象的5种方式
 */
public class ObjectCreator {

    public static void main(String[] args) {
        String strClass = ObjectCreator.getByDeserialization().toString();

    }

    //通过new方法
    public static Student getByNew() {
        return new Student(1L, "肖战", 15, "浙江");
    }

    //通过class.forname 事实上Class的newInstance方法内部调用Constructor的newInstance方法。
    public static Student getByClass() {
        String className = "com.mycompany.common.demo.java8.stream.Student";
        try {
            return (Student) Class.forName(className).newInstance();
            //也可以使用如下
            //Student.class.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过Constructor类的newInstance方法
    public static Student getByConstructor() {
        try {
            return (Student) Student.class.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过clone
    public static Student getByClone() {
        Student studentClone = new Student(1L, "肖战", 15, "浙江");
        try {
            Student newStudent = (Student) studentClone.clone();
            System.out.println(newStudent.toString());
            return newStudent;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过I/O流(反序列化)返回对象
    public static Student getByDeserialization() {
        Student student = new Student(1L, "肖战", 15, "浙江");
        String fileName = "D:/deserialization.txt";
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(student);

            objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            Student newStudent = (Student) objectInputStream.readObject();

            System.out.println(newStudent.toString());
            return newStudent;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
