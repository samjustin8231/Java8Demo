import java.util.HashMap;
import java.util.Map;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/28 18:06
 */
public class ListDemo {
    public static void main(String[] agrs) {
        method1();

        method2();
    }

    /**
     * lambda表达式遍历map
     */
    private static void method2() {
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
