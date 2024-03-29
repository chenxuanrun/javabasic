package collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program: javabasic
 * @description: 实现comparetor排序
 * @author: cxr
 * @create: 2019-09-28 19:43
 **/
public class CustomerComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getName().compareTo(o2.getName())>0)
            return 1;
        if (o1.getName().compareTo(o2.getName())<0)
            return -1;
        return 0;
    }

    public static void main(String[] args) {
        Set<Customer> set = new TreeSet<>(new CustomerComparator());
        Customer customer1= new Customer("Tom",5);
        Customer customer2= new Customer("Tom",9);
        Customer customer3= new Customer("Tom",2);
        set.add(customer1);
        set.add(customer2);
        set.add(customer3);
        Iterator<Customer> it =set.iterator();
        while (it.hasNext()){
            Customer customer=it.next();
            System.out.println(customer.getName()+" "+customer.getAge());
        }
    }
}
