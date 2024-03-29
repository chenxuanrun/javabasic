package collection;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @program: javabasic
 * @description: list和set重复和顺序对比
 * @author: cxr
 * @create: 2019-09-28 19:22
 **/
public class DuplicateAndOrderTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("111");
        linkedList.add("222");
        linkedList.add("333");
        linkedList.add("444");
        linkedList.add("555");
        linkedList.add("111");
        linkedList.get(1);
        System.out.println(linkedList);
        TreeSet treeSet = new TreeSet();
        treeSet.add("111");
        treeSet.add("222");
        treeSet.add("333");
        treeSet.add("444");
        treeSet.add("555");
        treeSet.add("111");
        System.out.println(treeSet);
    }
}
