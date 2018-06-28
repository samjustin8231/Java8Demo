package Model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/28 17:53
 */
public class Developer {
    private String name;
    private BigDecimal salary;
    private int age;

    public Developer(String name, BigDecimal salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return age == developer.age &&
                Objects.equals(name, developer.name) &&
                Objects.equals(salary, developer.salary);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, salary);
    }

    @Override
    public String toString() {
        return "Model.Developer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
