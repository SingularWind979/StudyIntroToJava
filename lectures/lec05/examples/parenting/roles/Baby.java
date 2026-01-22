package parenting.roles;

import parenting.tools.BabyFood;

public class Baby {
    private final String name;
    private final char gender;
    private int month;

    public Baby() {
        this("default", 0, '?');
    }

    public Baby(String name, int month, char gender) {
        this.name = name;
        this.month = month;
        this.gender = gender;
    }

    public void eat(BabyFood food) {
        System.out.println("Baby" + name + "is eating" + food.getName());
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return "Baby{name=%s, month=%d, gender=%s}".formatted(name, month, gender);
    }
}
