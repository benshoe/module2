/**
 * This class creates an instance of the NumberSwitcher class
 * and invokes the run() method.
 *
 * How NumberSwitcher is implemented is not known, its implementation is
 * hidden from us. If I had exposed the methods then the user could invoke
 * them in a different order leading to errors and a non-logical flow.
 *
 * @author Ben Schoen<ben.schoen@online.liverpool.ac.uk>
 * @since 8 January 2016
 */
public class NumberSwitcherTest {
    public static void main(String[] args) {
        NumberSwitcher switcher = new NumberSwitcher();
        switcher.run();
    }
}
