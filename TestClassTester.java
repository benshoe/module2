/**
 * Created by ben on 24-01-16.
 */
public class TestClassTester {

    public static void main(String[] args) {
        TestClass obj1 = new TestClass();
        obj1.setFieldInt(5);
        obj1.setFieldDouble(10.0);
        obj1.setFieldString("test");

        TestClass obj2 = new TestClass();
        obj2.setFieldInt(5);
        obj2.setFieldDouble(10.0);
        obj2.setFieldString("test");

        boolean equal = obj1.equals(obj2);

        System.out.println("equal = " + equal);

        equal = obj1.equals(null);
        System.out.println("equal = " + equal);
    }
}
