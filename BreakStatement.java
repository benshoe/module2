/**
 * Created by ben on 30-01-16.
 */
public class BreakStatement {

    public static void main(String[] args) {
        int y = 2;
        int x = 31;
        boolean prime;
        while (y < x) {
            if(x % y == 0) {
                break;
            }
            y++;
        }
        prime = y == x;
        System.out.println(y + " is prime = " + prime);

        x = 31;
        y = 2;
        prime = true;
        while(!prime && y < x) {
            if(x % y == 0) {
                prime = false;
            }
            y++;
        }
        System.out.println("prime = " + prime);
    }
}
