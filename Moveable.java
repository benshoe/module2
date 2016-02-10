/**
 * Created by ben on 07-02-16.
 */
public interface Moveable {
    default void move() {
        System.out.println("This is a default implementation");
    }

    static void fly() {
        System.out.println("And I can fly!");
    }
}
