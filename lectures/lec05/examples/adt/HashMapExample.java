package adt;

import java.util.Map;
import java.util.TreeMap;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, String> nameEmailMap =  new TreeMap<>();

        nameEmailMap.put("Evan", "email1@mit.edu");
        nameEmailMap.put("Eugene", "email2@mit.edu");
        nameEmailMap.put("Adam", "email3@mit.edu");

        System.out.println("nameEmailMap.size() = " + nameEmailMap.size());
        
        System.out.println("nameEmailMap.get(\"Eugene\") = " + nameEmailMap.get("Eugene"));

        nameEmailMap.remove("Evan");

        for (String name : nameEmailMap.keySet()) {
            System.out.println(name);
        }
        for (String email : nameEmailMap.values()) {
            System.out.println(email);
        }
        for (Map.Entry<String, String> nameEmail : nameEmailMap.entrySet()) {
            System.out.println(nameEmail.getKey() + "'s email = " + nameEmail.getValue());
        }
    }
}
