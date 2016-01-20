/**
 * Created by ben on 18-01-16.
 */
public class NumberTester {

    public static void main(String[] args) {
        byte myByte = 10;
        myByte--;
        myByte += 1;
        --myByte;
        myByte = (byte) (myByte + 10);
        System.out.println("myByte = " + myByte);

        long freeMemoryBefore = Runtime.getRuntime().totalMemory();
        System.out.println("freeMemoryBefore = " + freeMemoryBefore);
        String s = "Hello World";
        long freeMemoryAfter = Runtime.getRuntime().totalMemory();
        System.out.println("freeMemoryAfter = " + freeMemoryAfter);

        int i = 1234567890;
        long l = i;
        float f = l;
        double d = f;
        System.out.println("f = " + f);
        System.out.println("i = " + i);
        System.out.println("l = " + l);
        System.out.println("d = " + d);

        System.out.println("(f - l) = " + (f - l));

        System.out.println(3/2);
        System.out.println(3/2.0);
        System.out.println(3.0/2.0);

        int x = 1111111111;
        int y = 10000;
        f = (float) x / y;
        d = (double) x / y;
        System.out.println("f= "+f);
        System.out.println("d= "+d);
    }
}
