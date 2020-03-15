package com.automation.tests.OfficeHours;

import java.lang.reflect.Array;
import java.util.*;

public class List_Set {

    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        LinkedHashSet<String > linkedHashSet = new LinkedHashSet<>();

        for(String each : Arrays.asList("Value5", "Value1", "Value3")){
            hashSet.add(each);
            treeSet.add(each);
            linkedHashSet.add(each);
        }
        System.out.println("hashset" + hashSet);//karmasik order
        System.out.println("treeset" + treeSet); //ascending order
        System.out.println("linkedHashSet" + linkedHashSet); //keep the order

        //how to iterate through the set
        System.out.println("hash set");
        Iterator<String> iteratorSet = hashSet.iterator();
        while(iteratorSet.hasNext()){
            System.out.println(iteratorSet.next());
        }
        System.out.println("tree set");
        Iterator<String> iteratorSet2 = treeSet.iterator();
        while (iteratorSet2.hasNext()){
            System.out.println(iteratorSet2.next());
        }
        System.out.println("linked hash set");
        Iterator<String> iteratorSet3= linkedHashSet.iterator();
        while (iteratorSet3.hasNext()){
            System.out.println(iteratorSet3.next());
        }

        ArrayList<Integer> dropdown = new ArrayList<>();
        dropdown.add(1);
        dropdown.add(2);
        dropdown.add(3);
        dropdown.add(4);
        dropdown.add(5);
        dropdown.add(1);

        System.out.println("list:" + dropdown);
        HashSet<Integer> optionSet = new HashSet<>(dropdown);
        System.out.println("OptionSet:" + optionSet);
        if(dropdown.size() == optionSet.size()){
            System.out.println("expected is the same as actual");
        }else {
            System.out.println("options contains duplicates");
        }
        System.out.println("Queue example");
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("John");
        priorityQueue.add("Kate");
        priorityQueue.add("Tom");
       // priorityQueue.add("Queue");
        System.out.println("priorityQueue.peek() = " + priorityQueue.peek());
        System.out.println("priorityQueue.poll() = " + priorityQueue.poll());
        System.out.println("priorityQueue = " + priorityQueue);

        ArrayDeque <String> deque = new ArrayDeque<>();

        Deque<Integer> numbers= new ArrayDeque<>();
        numbers.add(20);
        numbers.add(30);
        numbers.add(50);
        System.out.println("numbers = " + numbers);
        numbers.add(90);
        System.out.println("numbers = " + numbers);
        System.out.println("numbers.pollFirst() = " + numbers.pollFirst());


    }
}
