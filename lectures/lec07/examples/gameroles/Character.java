package gameroles;

/**
 * Class to represent a character in the game.
 *
 * @author SingularWind
 */
public class Character {
    protected String name;
    protected int lv = 1;
    protected int hp = 100;
    protected int mp = 0;

    public Character(String name) {
        this.name = name;
    }

    protected int atk = 10;

    public void sayName() {
        System.out.println("I am " + name);
    }

    public void hit(Character target) {
        System.out.println(name + " hits " + target.name);
        if (target.hp > 0) {
            target.hp -= atk;
        } else {
            System.out.println(target.name + " is dead");
            lv++;
        }
    }

    public static void main(String[] args) {
        Character c1 = new Character("Jack");
        Character c2 = new Character("Jill");
        for (int i = 0; i < 10; i++) {
            c1.hit(c2);
        }
    }
}
