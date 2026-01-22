package parenting.tools;

public class BabyFood {
    private String name;
    private double price;
    private double weight;

    public BabyFood() {
        this("default", 0.0, 0.0);
    }

    public BabyFood(String name) {
        this(name, 0.0, 0.0);
    }

    public BabyFood(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "BabyFood{name=%s, price=$%s, weight=%s(kg)}".formatted(name, price, weight);
    }

}
