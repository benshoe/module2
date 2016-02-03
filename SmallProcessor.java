/**
 * This processor processes the instructions one by one
 *
 * It uses the InstructionParser to parse and verify the input
 *
 * @author Ben Schoen<ben.schoen@online.liverpool.ac.uk>
 * @since 3 February 2016
 */
class SmallProcessor {

    private InstructionParser m_parser = new InstructionParser(); // Created once and reused by each call to verifyInput

    public static final int THOUSAND = 1000; // this is the modulus used to convert values
    private final int[] m_registers = new int[10]; // this holds the 10 registers
    private String m_message; // here we can store a message with the result

    /**
     * Call this method to verify the instruction
     */
    public boolean verifyInput(String input) {
        if(m_parser.parse(input)) {
            return true;
        }
        m_result = Result.ERROR;
        m_message = m_parser.getMessage();
        return false;
    }

    /**
     * Call this when the result must be reset after an error
     */
    void resetResult() {
        m_result = Result.SUCCESS;
    }

    /**
     * The possible results of the processor are stored in this enum
     */
    public enum Result {
        /** Successfully processed the input */
        SUCCESS,
        /** The input contained or produced an error */
        ERROR,
        /** The input contained an instruction that caused it to stop */
        STOPPED
    }

    private Result m_result = Result.SUCCESS; // the default result is SUCCESS

    public void processInput(String input) {
        int firstChar = Integer.parseInt(input.substring(0, 1)); // The input has been verified and is split into three separate int values
        int secondChar = Integer.parseInt(input.substring(1, 2));
        int thirdChar = Integer.parseInt(input.substring(2, 3));

        switch (firstChar) { // the first character is used to determine the instruction to perform
            case 0: // this leads to an error
                m_result = Result.ERROR;
                m_message = "Instruction code '" + input + "' is not supported by the system";
                break;
            case 1: // this causes the processor to stop
                m_result = Result.STOPPED; // the result is changed here and possibly in case 5
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
            case 5: // We must check for 0 here, otherwise we would divide by zero
                if(thirdChar == 0) {
                    m_result = Result.ERROR;
                    m_message = "We cannot divide by 0";
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

    /*
    I have created separate methods for each instruction. This makes it easier to determine what each instruction does.
    Even though they are only one liners I believe it is better readable and therefore better for maintenance purposes.

    Each method (except the assign methods) contains the modulus 1000 calculation
     */
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

    /**
     * The message with an error can be retrieved here
     */
    public String getMessage() {
        return m_message;
    }

    /**
     * The result of processing the instruction
     */
    public Result getResult() {
        return m_result;
    }

    /**
     * The registers are kept in an array of int
     */
    public int[] getRegisters() {
        return m_registers;
    }
}
