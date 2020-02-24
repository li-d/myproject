package com.mycompany.common.demo.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DemoTest {

    public static void main(String[] args) {
        Student s1 = new Student(1L, "肖战", 15, "浙江");
        Student s2 = new Student(2L, "王一博", 16, "湖北");
        Student s6 = new Student(2L, "王一博", 16, "湖北");
        Student s3 = new Student(3L, "杨紫", 17, "北京");
        Student s4 = new Student(4L, "李现", 18, "浙江");
        Student s5 = new Student(4L, "李现1", 19, "浙江");
        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);
        /*String[] str = new String[]{"1","2"};
        List<String> strings = new ArrayList<>(Arrays.asList(str));
        strings.forEach(a-> System.out.println(a));



        DemoTest.testFilter(studentList);
        testMap(studentList);*/
        //testGroup(studentList);
        //testSort2(studentList);
        studentList.sort(Comparator.comparing((Student e)->e.getId()).reversed());
        studentList.forEach(a-> System.out.println(a));
    }

    /**
     * 集合的筛选
     *
     * @param students
     * @return
     */
    private static void testFilter(List<Student> students) {
        List<Student> listFilter = students.stream().filter(e -> e.getAge() > 15).collect(Collectors.toList());
        //listFilter.forEach(System.out::println);
        listFilter.forEach(a -> System.out.println(a));
    }

    /**
     * 集合转换
     *
     * @param students
     * @return
     */
    private static void testMap(List<Student> students) {
        List<Long> list = students.stream().map(e -> e.getId()).collect(Collectors.toList());
        list.forEach(aLong -> System.out.println(aLong));
        Map<Long, String> map1 = students.stream().collect(Collectors.toMap(Student::getId, Student::getName));
        map1.forEach((aLong, s) -> System.out.println(aLong + ":" + s));
        Map<Long, Student> map2 = students.stream().collect(Collectors.toMap(Student::getId, Student -> Student));
        map2.forEach((aLong, student) -> System.out.println(aLong + ":" + student));
    }

    /**
     * 集合去重（基本类型）
     */
    private static void testDistinct1() {
        List<String> strs = Arrays.asList("111", "222", "222", "111");
        strs.stream().distinct().forEach(e -> {
            //System.out.println(e);
        });
        Long count = strs.stream().distinct().count();
        System.out.println(count);
        System.out.println(strs.size());
    }

    /**
     * 集合去重（对象 重写equals和hashcode方法）
     */
    private static void testDistinct2(List<Student> students) {
        students.stream().distinct().forEach(e -> {
            System.out.println(e);
        });
    }

    /**
     * 集合排序（默认排序  正序）
     */
    private static void testSort1() {
        List<String> strs = Arrays.asList("111", "222", "2333", "111");
        strs.stream().sorted().forEach(a -> System.out.println(a));
    }

    /**
     * 对象排序
     */
    private static void testSort2(List<Student> students) {
        students.stream().sorted(Comparator.comparingLong(Student::getId)).forEach(a-> System.out.println(a));
        //students.stream().sorted(Comparator.comparingLong(Student::getId)).sorted(Comparator.comparingInt(Student::getAge)).forEach(a -> System.out.println(a));
    }

    /**
     * 集合limit，返回前几个元素
     */
    private static void testLimit() {
        List<String> list = Arrays.asList("333", "222", "111");
        list.stream().limit(2).forEach(System.out::println);
    }

    /**
     * 集合skip，删除前n个元素
     */
    private static void testSkip() {
        List<String> list = Arrays.asList("333", "222", "111");
        list.stream().skip(1).forEach(System.out::println);
    }

    /**
     * 集合reduce,将集合中每个元素聚合成一条数据
     */
    private static void testReduce() {
        List<String> list = Arrays.asList("欢", "迎", "你");
        System.out.println(list.stream().reduce((a1, a2) -> a1 + a2));
        System.out.println(list.stream().reduce("beijing", (a1, a2) -> a1 + a2));
    }

    /**
     * 求最小值
     */
    private static void testMin(List<Student> students) {
        Student student = students.stream().min(Comparator.comparingInt(Student::getAge)).get();
        System.out.println(student);
    }

    /**
     * 求最大值
     */
    private static void testMax(List<Student> students) {
        Student student = students.stream().max(Comparator.comparingInt(Student::getAge)).get();
        System.out.println(student);
    }

    /**
     * anyMatch：Stream 中任意一个元素符合传入的 predicate，返回 true
     * <p>
     * allMatch：Stream 中全部元素符合传入的 predicate，返回 true
     * <p>
     * noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true
     */
    private static void testMatch(List<Student> students) {
        Boolean anyMatch = students.stream().anyMatch(e -> e.getName().equals("肖战"));
        if (anyMatch) {
            System.out.println("存在肖战");
        }
        Boolean allMatch = students.stream().allMatch(e -> e.getAge() > 10);
        if (allMatch) {
            System.out.println("都大于10");
        }
        Boolean noneMatch = students.stream().noneMatch(e -> e.getAddress().equals("上海"));
        if (noneMatch) {
            System.out.println("没有一个上海人");
        }
    }

    /**
     * 将集合中相同的key组装成map
     */
    public static Map<Long, List<String>> testMap2(List<Student> students) {
        Map<Long, List<String>> map = students.stream().collect(Collectors.toMap(e -> e.getId(), e -> new ArrayList<>(Arrays.asList(e.getName())), (olist, nlist) -> {
                    olist.addAll(nlist);
                    return olist;
                }
        ));
        for (Map.Entry<Long, List<String>> entrySet : map.entrySet()) {
            System.out.println(entrySet.getKey() + ":" + entrySet.getValue().toString());
        }
        return map;
    }

    public static Map<Long, List<String>> testGroup(List<Student> students) {
        Map<Long, List<String>> map = students.stream().collect(Collectors.groupingBy(e -> e.getId(), Collectors.mapping(e -> e.getName(), Collectors.toList())));
        for (Map.Entry<Long, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
        return map;
    }


}
