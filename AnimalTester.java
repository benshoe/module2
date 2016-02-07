import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 07-02-16.
 */
public class AnimalTester {
    public static void main(String[] args) {

        Reptile crocodile = new Reptile();
        Animal animal = crocodile;
        Moveable moveable = crocodile;
        Object o = crocodile;

        List<Moveable> animals = new ArrayList<>();
        animals.add(crocodile);
        animals.add(moveable);

        List<Moveable> moveableObjects = new ArrayList<>();
        moveableObjects.add(new Car());
        moveableObjects.add(new Bike());
        moveableObjects.add(new Reptile());
        moveableObjects.add(new Bird());

        for(Moveable m : moveableObjects) {
            m.move();
        }

    }

}
