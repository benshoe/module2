import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ben on 02-02-16.
 */
public class SmallComputerTest {

    @Test
    public void testProcessInput1() throws Exception {
        SmallComputer smallComputer = new SmallComputer();
        smallComputer.processInput("123");
        assertEquals(SmallComputer.Result.STOPPED, smallComputer.getResult());
    }

    @Test
    public void testProcessInput2() throws Exception {
        SmallComputer smallComputer = new SmallComputer();
        smallComputer.processInput("275");
        assertEquals(SmallComputer.Result.SUCCESS, smallComputer.getResult());
        int[] result = new int[] {0, 0, 0, 0, 0, 0, 0, 5, 0, 0};
        int[] registers = smallComputer.getRegisters();
        assertArrayEquals(result, registers);

        smallComputer.processInput("226");
        assertEquals(SmallComputer.Result.SUCCESS, smallComputer.getResult());
        result = new int[] {0, 0, 6, 0, 0, 0, 0, 5, 0, 0};
        assertArrayEquals(result, registers);

        smallComputer.processInput("373");
        assertEquals(SmallComputer.Result.SUCCESS, smallComputer.getResult());
        result = new int[] {0, 0, 6, 0, 0, 0, 0, 8, 0, 0};
        assertArrayEquals(result, registers);

        smallComputer.processInput("426");
        assertEquals(SmallComputer.Result.SUCCESS, smallComputer.getResult());
        result = new int[] {0, 0, 36, 0, 0, 0, 0, 8, 0, 0};
        assertArrayEquals(result, registers);

        smallComputer.processInput("692");
        assertEquals(SmallComputer.Result.SUCCESS, smallComputer.getResult());
        result = new int[] {0, 0, 36, 0, 0, 0, 0, 8, 0, 36};
        assertArrayEquals(result, registers);

        smallComputer.processInput("672");
        assertEquals(SmallComputer.Result.SUCCESS, smallComputer.getResult());
        result = new int[] {0, 0, 36, 0, 0, 0, 0, 36, 0, 36};
        assertArrayEquals(result, registers);

        smallComputer.processInput("100");
        assertEquals(SmallComputer.Result.STOPPED, smallComputer.getResult());
        result = new int[] {0, 0, 36, 0, 0, 0, 0, 36, 0, 36};
        assertArrayEquals(result, registers);
    }

    @Test
    public void testProcessInput3() throws Exception {
        SmallComputer smallComputer = new SmallComputer();
        smallComputer.processInput("275");
        assertEquals(SmallComputer.Result.SUCCESS, smallComputer.getResult());
        int[] result = new int[] {0, 0, 0, 0, 0, 0, 0, 5, 0, 0};
        int[] registers = smallComputer.getRegisters();
        assertArrayEquals(result, registers);

        smallComputer.processInput("627");
        assertEquals(SmallComputer.Result.SUCCESS, smallComputer.getResult());
        result = new int[] {0, 0, 5, 0, 0, 0, 0, 5, 0, 0};
        assertArrayEquals(result, registers);

        smallComputer.processInput("575");
        assertEquals(SmallComputer.Result.SUCCESS, smallComputer.getResult());
        result = new int[] {0, 0, 5, 0, 0, 0, 0, 1, 0, 0};
        assertArrayEquals(result, registers);
    }

    @Test
    public void testGetResult() throws Exception {
        SmallComputer smallComputer = new SmallComputer();
        smallComputer.processInput("065");
        assertEquals("Instruction code '065' is not supported by the system", smallComputer.getMessage());
    }
}