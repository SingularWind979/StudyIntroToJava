package gameroles;

import java.util.ArrayList;

/**
 * Class to represent a wizard in the game.
 *
 * @author SingularWind
 */
public class Wizard extends Character {
    ArrayList<Spell> spells = new ArrayList<>();

    public Wizard(String name) {
        super(name);
        mp = 100;
    }

     @Override
    public void sayName() {
        System.out.println("I am a wizard " + name);
    }

    public void cast(Spell spell) {
        System.out.println(name);
        if (mp >= spell.mpCost) {
            mp -= spell.mpCost;
            System.out.println("casts " + spell.name + " dealing " + spell.damage + " damage");
        } else {
            System.out.println("does not have enough mp to cast " + spell.name);
        }
    }

    public static class Spell {
        String name;
        int mpCost;
        int damage;

        public Spell(String name, int mpCost, int damage) {
            this.name = name;
            this.mpCost = mpCost;
            this.damage = damage;
        }
    }


    public static void main(String[] args) {
        Wizard wizard = new Wizard("Gandalf");
        wizard.spells.add(new Spell("Fireball", 10, 20));
        wizard.spells.add(new Spell("IceLance", 15, 15));
        wizard.cast(wizard.spells.get(0));
        wizard.cast(wizard.spells.get(1));
    }
}
