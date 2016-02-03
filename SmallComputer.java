/**
 * Created by ben on 02-02-16.
 */
public class SmallComputer {

    public static final int CHAR_TO_INT = 48;
    private final int[] m_registers;
    private String m_message;

    public enum Result {
        SUCCESS, ERROR, STOPPED
    }

    private Result m_result = Result.SUCCESS;

    public SmallComputer() {
        m_registers = new int[10];
    }

    public void processInput(String input) {
        int firstChar = input.charAt(0) - CHAR_TO_INT;
        int secondChar = input.charAt(1) - CHAR_TO_INT;
        int thirdChar = input.charAt(2) - CHAR_TO_INT;

        switch (firstChar) {
            case 0:
                m_result = Result.ERROR;
                m_message = "Instruction code '" + input + "' is not supported by the system";
                break;
            case 1:
                m_result = Result.STOPPED;
                stopProgram();
                break;
            case 2:
                assign(secondChar, thirdChar);
                break;
            case 3:
                plus(secondChar, thirdChar);
                break;
            case 4:
                multiply(secondChar, thirdChar);
                break;
            case 5:
                divide(secondChar, thirdChar);
                break;
            case 6:
                assignRegister(secondChar, thirdChar);
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            default:
                throw new IllegalArgumentException("This input string cannot be processed: " + input);


        }
    }

    private void divide(int secondChar, int thirdChar) {
        m_registers[secondChar] = m_registers[secondChar] / thirdChar;
    }

    private void assignRegister(int secondChar, int thirdChar) {
        m_registers[secondChar] = m_registers[thirdChar];
    }

    private void multiply(int secondChar, int thirdChar) {
        m_registers[secondChar] = m_registers[secondChar] * thirdChar;
    }

    private void plus(int secondChar, int thirdChar) {
        m_registers[secondChar] = m_registers[secondChar] + thirdChar;
    }

    private void assign(int secondChar, int thirdChar) {
        m_registers[secondChar] = thirdChar;
    }

    private void stopProgram() {
    }

    public void processInput(String[] input) {
        for (int i = 0; i < input.length; i++) {
            processInput(input[i]);
        }
    }

    public String getMessage() {
        return m_message;
    }

    public Result getResult() {
        return m_result;
    }

    public int[] getRegisters() {
        return m_registers;
    }
}
