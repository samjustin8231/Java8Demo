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

        List<String> lines = Arrays.asList("spring", "node", "mkyong");

        List<String> result = lines.stream()                // 转化为一个流
                .filter(line -> !"mkyong".equals(line))     // 排除 'mkyong'
                .collect(Collectors.toList());              // 吧输出流收集回List中

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
