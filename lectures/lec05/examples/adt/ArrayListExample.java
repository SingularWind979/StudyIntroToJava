package adt;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        
        nameList.add("Evan");
        nameList.add("Eugene");
        nameList.add("Adam");

        System.out.println("nameList.size() = " + nameList.size());
        
        System.out.println("nameList.get(0) = " + nameList.get(0));
        System.out.println("nameList.get(1) = " + nameList.get(1));

        nameList.set(0, "default");
        
        nameList.remove(1);

        for (String name : nameList) {
            System.out.println(name);
        }
    }
}
