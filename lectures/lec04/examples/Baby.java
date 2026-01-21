public class Baby {
    String name;
    boolean isMale;
    double weight;
    double decibels;

    public Baby(String name, boolean isMale, double weight) {
        this.name = name;
        this.isMale = isMale;
        this.weight = weight;
    }

    public void sayHi() {
        System.out.println("Hi, my name is " + name);
    }

    public void cry() {
        System.out.println(name + " cry at " + decibels + "db");
    }

    public void eat(double foodWeight) {
        if (foodWeight >= 0 && foodWeight < weight) {
            weight += foodWeight;
        }
    }

    public static void main(String[] args) {
        // instantiation
        Baby shiloh = new Baby("Shiloh Jolie-Pitt", true, 5.0);
        Baby knox = new Baby("Knox Jolie-Pitt", true, 3.0);

        // access fields
        System.out.println("shiloh.name = " + shiloh.name);
        System.out.println("knox.name = " + knox.name);

        // call methods
        shiloh.sayHi();
        knox.eat(1);
        shiloh.cry();
    }
}
