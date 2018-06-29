import Model.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/28 18:06
 */
public class ListDemo {
    public static void main(String[] agrs) {
//        method1();
//
//        method2();

//        method3();

//        method4();

//        method5();

//        method6();

//        method7();

        method8();
    }

    /**
     * map
     */
    private static void method8() {
        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        String name = persons.stream()
                .filter(x -> "jack".equals(x.getName()))
                .map(Person::getName)                        //把流转化为String
                .findAny()
                .orElse("");

        System.out.println("name : " + name);

        List<String> collect = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

    /**
     * filter多重条件指定.
     */
    private static void method7() {
        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        Person result1 = persons.stream()
                .filter((p) -> "jack".equals(p.getName()) && 20 == p.getAge())
                .findAny()
                .orElse(null);

        System.out.println("result 1 :" + result1);

        //or like this
        Person result2 = persons.stream()
                .filter(p -> {
                    if ("jack".equals(p.getName()) && 20 == p.getAge()) {
                        return true;
                    }
                    return false;
                }).findAny()
                .orElse(null);

        System.out.println("result 2 :" + result2);
    }

    /**
     * stream.filter()， .findAny().orElse (null) 来返回指定的对象
     */
    private static void method6() {
        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        Person result1 = persons.stream()                        // 转化为流
                .filter(x -> "jack".equals(x.getName()))        // 只过滤出"jack"
                .findAny()                                      // 如果找到了就返回
                .orElse(null);                                  // 如果找不到就返回null

        System.out.println(result1);

        Person result2 = persons.stream()
                .filter(x -> "ahmook".equals(x.getName()))
                .findAny()
                .orElse(null);

        System.out.println(result2);
    }

    /**
     * 传统的方式：通过name获取一个Person
     */
    private static void method5() {
        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        Person result = getStudentByName(persons, "jack");
        System.out.println(result);
    }

    private static Person getStudentByName(List<Person> persons, String name) {
        Person result = null;
        for (Person temp : persons) {
            if (name.equals(temp.getName())) {
                result = temp;
            }
        }
        return result;
    }

    /**
     * stream.filter()过滤list；
     */
    private static void method4() {
        List<String> lines = Arrays.asList("spring", "node", "mkyong");

        List<String> result = lines.stream()                // 转化为一个流
                .filter(line -> !"mkyong".equals(line))     // 排除 'mkyong'
                .collect(Collectors.toList());              // 把输出流收集回List中

        result.forEach((s) -> System.out.println(s));                //输出 : spring, node
    }

    /**
     * 传统的list过滤
     */
    private static void method3() {
        List<String> lines = Arrays.asList("spring", "node", "mkyong");
        List<String> result = getFilterOutput(lines, "mkyong");
        for (String temp : result) {
            System.out.println(temp);    //output : spring, node
        }
    }

    private static List<String> getFilterOutput(List<String> lines, String filter) {
        List<String> result = new ArrayList();
        for (String line : lines) {
            if (!"mkyong".equals(line)) { // we dont like mkyong
                result.add(line);
            }
        }
        return result;
    }

    /**
     * lambda表达式遍历map
     */
    private static void method2() {
        System.out.println();

        Map<String, Integer> items = new HashMap();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));
        System.out.println();

        items.forEach((k, v) -> {
            System.out.println("Item : " + k + " Count : " + v);
            if ("E".equals(k)) {
                System.out.println("Hello E");
            }
        });
    }

    /**
     * 传统的foreach遍历
     */
    private static void method1() {
        System.out.println();

        Map<String, Integer> items = new HashMap();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
    }
}
