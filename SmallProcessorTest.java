import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ben on 02-02-16.
 */
public class SmallProcessorTest {

    @Test
    public void testProcessInput1() throws Exception {
        SmallProcessor smallProcessor = new SmallProcessor();
        smallProcessor.processInput("123");
        assertEquals(SmallProcessor.Result.STOPPED, smallProcessor.getResult());
    }

    @Test
    public void testProcessInput2() throws Exception {
        SmallProcessor smallProcessor = new SmallProcessor();
        smallProcessor.processInput("275");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        int[] result = new int[] {0, 0, 0, 0, 0, 0, 0, 5, 0, 0};
        int[] registers = smallProcessor.getRegisters();
        assertArrayEquals(result, registers);

        smallProcessor.processInput("226");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 6, 0, 0, 0, 0, 5, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("373");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 6, 0, 0, 0, 0, 8, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("426");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 36, 0, 0, 0, 0, 8, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("692");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 36, 0, 0, 0, 0, 8, 0, 36};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("672");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 36, 0, 0, 0, 0, 36, 0, 36};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("100");
        assertEquals(SmallProcessor.Result.STOPPED, smallProcessor.getResult());
        result = new int[] {0, 0, 36, 0, 0, 0, 0, 36, 0, 36};
        assertArrayEquals(result, registers);
    }

    @Test
    public void testProcessInput3() throws Exception {
        SmallProcessor smallProcessor = new SmallProcessor();
        smallProcessor.processInput("275");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        int[] result = new int[] {0, 0, 0, 0, 0, 0, 0, 5, 0, 0};
        int[] registers = smallProcessor.getRegisters();
        assertArrayEquals(result, registers);

        smallProcessor.processInput("627");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 5, 0, 0, 0, 0, 5, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("575");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 5, 0, 0, 0, 0, 1, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("429");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 45, 0, 0, 0, 0, 1, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("602");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {45, 0, 45, 0, 0, 0, 0, 1, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("503");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {15, 0, 45, 0, 0, 0, 0, 1, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("402");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {30, 0, 45, 0, 0, 0, 0, 1, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("902");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {900, 0, 45, 0, 0, 0, 0, 1, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("296");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {900, 0, 45, 0, 0, 0, 0, 1, 0, 6};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("495");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {900, 0, 45, 0, 0, 0, 0, 1, 0, 30};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("797");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {900, 0, 45, 0, 0, 0, 0, 1, 0, 31};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("525");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {900, 0, 9, 0, 0, 0, 0, 1, 0, 31};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("424");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {900, 0, 36, 0, 0, 0, 0, 1, 0, 31};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("820");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {900, 0, 6, 0, 0, 0, 0, 1, 0, 31};
        assertArrayEquals(result, registers);
    }

    @Test
    public void testProcessInputBinary() throws Exception {
        SmallProcessor smallProcessor = new SmallProcessor();
        smallProcessor.processInput("271");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        int[] result = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        int[] registers = smallProcessor.getRegisters();
        assertArrayEquals(result, registers);

        smallProcessor.processInput("472");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 0, 0, 0, 0, 0, 2, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("472");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 0, 0, 0, 0, 0, 4, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("472");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 0, 0, 0, 0, 0, 8, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("472");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 0, 0, 0, 0, 0, 16, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("472");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 0, 0, 0, 0, 0, 32, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("472");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 0, 0, 0, 0, 0, 64, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("472");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 0, 0, 0, 0, 0, 128, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("472");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 0, 0, 0, 0, 0, 256, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("472");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 0, 0, 0, 0, 0, 512, 0, 0};
        assertArrayEquals(result, registers);

        smallProcessor.processInput("472");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        result = new int[] {0, 0, 0, 0, 0, 0, 0, 24, 0, 0};
        assertArrayEquals(result, registers);
    }

    @Test
    public void testDivideByZero() throws Exception {
        SmallProcessor smallProcessor = new SmallProcessor();
        smallProcessor.processInput("271");
        assertEquals(SmallProcessor.Result.SUCCESS, smallProcessor.getResult());
        int[] result = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        int[] registers = smallProcessor.getRegisters();
        assertArrayEquals(result, registers);

        smallProcessor.processInput("570");
        assertEquals(SmallProcessor.Result.ERROR, smallProcessor.getResult());
        result = new int[] {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        assertArrayEquals(result, registers);
        assertEquals("We cannot divide by 0", smallProcessor.getMessage());
    }

    @Test
    public void testGetResult() throws Exception {
        SmallProcessor smallProcessor = new SmallProcessor();
        smallProcessor.processInput("065");
        assertEquals("Instruction code '065' is not supported by the system", smallProcessor.getMessage());
    }

}