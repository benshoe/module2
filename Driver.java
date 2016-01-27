/**
 * Created by ben on 26-01-16.
 */
public class Driver {
    public String name;
    public int number;

    public Driver(String name, int age) {
        this.name = name;
        this.number = age;
    }

    public boolean equals(Driver o) {
        return o.name == name && o.number == number;
    }
}
