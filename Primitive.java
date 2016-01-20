import static java.lang.System.nanoTime;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/13/16.
 */
public class Primitive {
	public static void main(String[] args) {
		long sum = 0;
		long ts = nanoTime();
		for(long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println("it took: " + (nanoTime() - ts)/1_000_000 + " ms");
	}
}
