import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ben on 02-02-16.
 */
public class InstructionParser {

    private String[] m_instructions;

    public boolean parse(String input) {
        if(input == null) {
            return false;
        }
        if(!input.matches("(\\s*(\\d{3})\\s*)*")) {
            System.out.println("faulty = " + input);
            return false;
        } else {
            System.out.println("good!! = " + input);
        }
        Pattern p = Pattern.compile("(\\s*(\\d{3})\\s*)*");
        Matcher m = p.matcher(input);
        m_instructions = new String[10];
        int i = 0;
        while (m.find()) {
            m_instructions[i++] = m.group();
            System.out.println("m.group() = " + m.group());
        }
        return true;

//        input = input.trim();
//        String[] splitInput = input.split(" ");
//        String[] instructions =  new String[splitInput.length];
////        for (int i = 0; i < splitInput.length; i++) {
////            try {
////                instructions[i] = Integer.parseInt(splitInput[i]);
////            } catch (NumberFormatException nfe) {
////                return false;
////            }
////        }
//        m_instructions = instructions;
//        return true;
    }


    public String[] getInstructions() {
        return m_instructions;
    }
}
