package adt;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<String> nameSet = new TreeSet<>();
        nameSet.add("Evan");
        nameSet.add("Eugene");
        nameSet.add("Adam");

        System.out.println("nameSet.size() = " + nameSet.size());
        System.out.println("nameSet.contains(\"Evan\") = " + nameSet.contains("Evan"));

        nameSet.remove("Eugene");

        for (String name : nameSet) {
            System.out.println(name);
        }
    }
}
