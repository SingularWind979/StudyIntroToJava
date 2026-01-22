package parenting.roles;

import parenting.tools.BabyFood;

public class Parent {
    public static void main(String[] args) {
        Baby baby = new Baby("Mike", 1, 'm');
        baby.eat(new BabyFood("milk", 12, 1));
    }
}
