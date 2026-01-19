/**
 * GravityCalculator that computes the distance an object will fall in Earth's gravity.
 */
public class GravityCalculator {
    public static void main(String[] args) {
        double gravity = -9.81; // Earth's gravity in m/s^2
        double initialVelocity = 0.0;
        double fallingTime = 10.0;
        double initialPosition = 0.0;
        double finalPosition;
        finalPosition = initialPosition
                + initialVelocity * fallingTime
                + 0.5 * gravity * fallingTime * fallingTime;
        System.out.println("The object's position after " + fallingTime
                + " seconds is " + finalPosition + " m.");
    }
}
