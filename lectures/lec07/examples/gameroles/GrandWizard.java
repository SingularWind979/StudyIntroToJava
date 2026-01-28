package gameroles;

/**
 * Class to represent a grand wizard in the game.
 *
 * @author SingularWind
 */
public class GrandWizard extends Wizard {
    public GrandWizard(String name) {
        super(name);
    }

    @Override
    public void sayName() {
        System.out.println("I am Grand Wizard, " + name);
    }
}
