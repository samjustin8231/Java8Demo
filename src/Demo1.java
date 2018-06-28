import Model.Developer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/28 17:52
 */
public class Demo1 {
    public static void main(String[] args) {

        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

        System.out.println("After Sort");

        //lambda 表达式!
        listDevs.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());

        //java 8 , lambda也可以打印List
        listDevs.forEach((Developer) -> System.out.println(Developer));
    }

    private static List<Developer> getDevelopers() {
        List<Developer> result = new ArrayList<Developer>();
        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));
        return result;
    }
}
