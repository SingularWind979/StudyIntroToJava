package counter;

public class Counter {
    int myCount = 0;
    static int ourCount = 0;

    public void increment() {
        myCount++;
        ourCount++;
    }

    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        
        counter1.increment();
        counter1.increment();
        counter2.increment();
        
        System.out.println("counter1.myCount = " + counter1.myCount);
        System.out.println("counter1.ourCount = " + Counter.ourCount);
        System.out.println("counter2.myCount = " + counter2.myCount);
        System.out.println("counter2.ourCount = " + Counter.ourCount);
    }
}
