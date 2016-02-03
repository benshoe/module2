/**
 * This parser verifies the string entered by the user
 *
 * It uses a regexp pattern to determine that each input consists of 3 digits.
 * When this succeeds the in
 *
 * @author Ben Schoen<ben.schoen@online.liverpool.ac.uk>
 * @since 3 February 2016
 */
class InstructionParser {

    public static final String PATTERN = "\\s*(\\d{3})\\s*"; // any number of leading or trailing spaces are ignored

    private String m_message; // the message containing the error

    public boolean parse(String input) {
        if(input == null || "".equals(input.trim())) {
            setMessage("The instruction is empty");
            return false;
        }
        if(!input.matches("(" + PATTERN + ")*")) { // when multiple 3-digit groups are sent to this parser, it will find them
            setMessage("Error processing " + input + ". The instruction does not consist of 3 digits");
            return false;
        }
        return true;
    }

    /*
    It is not necessary or wanted for other objects to set the message
     */
    private void setMessage(String message) {
        m_message = message;
    }

    /**
     * Returns the message if an error occurs
     */
    public String getMessage() {
        return m_message;
    }
}
