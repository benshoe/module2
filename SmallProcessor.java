/**
 * Created by ben on 02-02-16.
 */
public class SmallProcessor {

    private InstructionParser m_parser = new InstructionParser();

    public static final int THOUSAND = 1000; // this is the modulus used to convert values
    private final int[] m_registers = new int[10]; // this holds the 10 registers
    private String m_message; // here we can store a message with the result

    public boolean verifyInput(String input) {
        if(m_parser.parse(input)) {
            return true;
        }
        m_result = Result.ERROR;
        m_message = m_parser.getMessage();
        return false;
    }

    public void setResult(Result result) {
        m_result = result;
    }

    public enum Result {
        SUCCESS, ERROR, STOPPED
    }

    private Result m_result = Result.SUCCESS;

    public void processInput(String input) {
        int firstChar = Integer.parseInt(input.substring(0, 1));
        int secondChar = Integer.parseInt(input.substring(1, 2));
        int thirdChar = Integer.parseInt(input.substring(2, 3));

        switch (firstChar) {
            case 0:
                m_result = Result.ERROR;
                m_message = "Instruction code '" + input + "' is not supported by the system";
                break;
            case 1:
                m_result = Result.STOPPED;
                break;
            case 2:
                assignValue(secondChar, thirdChar);
                break;
            case 3:
                plus(secondChar, thirdChar);
                break;
            case 4:
                multiply(secondChar, thirdChar);
                break;
            case 5:
                if(thirdChar == 0) {
                    m_result = Result.ERROR;
                } else {
                    divide(secondChar, thirdChar);
                }
                break;
            case 6:
                assignRegisterValue(secondChar, thirdChar);
                break;
            case 7:
                addRegisterValue(secondChar, thirdChar);
                break;
            case 8:
                sqrt(secondChar);
                break;
            case 9:
                power(secondChar, thirdChar);
                break;
            default:
                throw new IllegalArgumentException("This input string cannot be processed: " + input);
        }
    }

    private void sqrt(int secondChar) {
        m_registers[secondChar] = ((int) Math.sqrt(m_registers[secondChar])) % THOUSAND;
    }

    private void addRegisterValue(int secondChar, int thirdChar) {
        m_registers[secondChar] = (m_registers[secondChar] + m_registers[thirdChar]) % THOUSAND;
    }

    private void power(int secondChar, int thirdChar) {
        m_registers[secondChar] = (int) Math.pow(m_registers[secondChar], thirdChar) % THOUSAND;
    }

    private void divide(int secondChar, int thirdChar) {
        m_registers[secondChar] = (m_registers[secondChar] / thirdChar) % THOUSAND;
    }

    private void assignRegisterValue(int secondChar, int thirdChar) {
        m_registers[secondChar] = m_registers[thirdChar];
    }

    private void multiply(int secondChar, int thirdChar) {
        m_registers[secondChar] = (m_registers[secondChar] * thirdChar) % THOUSAND;
    }

    private void plus(int secondChar, int thirdChar) {
        m_registers[secondChar] = (m_registers[secondChar] + thirdChar) % THOUSAND;
    }

    private void assignValue(int secondChar, int thirdChar) {
        m_registers[secondChar] = thirdChar;
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
