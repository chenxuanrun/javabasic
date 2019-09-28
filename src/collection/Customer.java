package collection;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program: javabasic
 * @description: 实现comparable排序
 * @author: cxr
 * @create: 2019-09-28 19:25
 **/
public class Customer implements Comparable<Customer>{
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age &&
                Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Customer o) {
        //先按照name属性进行排序
        if (this.name.compareTo(o.name)>0)
            return 1;
        if (this.name.compareTo(o.name)<0)
            return -1;
        //再按照age属性进行排序
        if (this.age>o.age)
            return 1;
        if (this.age<o.age)
            return -1;
        return 0;
    }

    public static void main(String[] args) {
        Set<Customer> set= new TreeSet<>();
        Customer customer1 = new Customer("Tom",16);
        Customer customer2 = new Customer("Tom",15);
        set.add(customer1);
        set.add(customer2);
        for (Customer customer:set) {
            System.out.println(customer.name+" "+customer.age);
        }
    }
}
