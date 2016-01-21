import java.math.BigInteger;

/**
 * Created by ben on 21-01-16.
 */
public class ObjectEqualityTester {

    private boolean b;

    public static void main(String[] args) {
        ObjectEqualityTester tester = new ObjectEqualityTester();
        ObjectEqualityTester tester2 = tester;

        System.out.println("tester == tester2 = " + (tester == tester2));
        ObjectEqualityTester tester3 = tester2;
        System.out.println("tester == tester3 = " + (tester == tester3));


        Human johnA = new Human(25, "John");
        Human johnB = new Human(25, "John");
        System.out.println("JohnA and JohnB are equal? " + (johnA == johnB));
        System.out.println("JohnA and JohnB are equal? " + (johnA.equals(johnB)));
        System.out.println("JohnB and JohnA are equal? " + (johnB.equals(johnA)));
        System.out.println("JohnB and null are equal? " + (johnB.equals(null)));
        Human johnC = new Human(25, "John");
        System.out.println("JohnB and JohnC are equal?" + (johnB.equals(johnC)));
        System.out.println("JohnA and JohnC are equal?" + (johnA.equals(johnC)));

        boolean adult = false;
        if(adult = true) {
            System.out.println("You are an adult. " + adult);
        }

        BigInteger bi1 = BigInteger.ONE;
        BigInteger bi2 = BigInteger.ONE;
        System.out.println("bi1 == bi2: " + (bi1 == bi2));

        boolean equal = tester == tester2;
        System.out.println("The objects are equal? " + equal);
    }
}

class Human {
    private int age;
    private String name;

    Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o1) {
        if(o1 == null)
            return false;
        if(!(o1 instanceof Human))
            return false;

        if(((Human) o1).age != this.age)
            return false;
        if(!((Human) o1).name.equals(this.name))
            return false;
        return true;
    }
}
