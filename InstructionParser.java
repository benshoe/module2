import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ben on 02-02-16.
 */
public class InstructionParser {

    public static final String PATTERN = "\\s*(\\d{3})\\s*";
    private String[] m_instructions;

    public boolean parse(String input) {
        if(input == null || "".equals(input)) {
            return false;
        }
        if(!input.matches("(" + PATTERN + ")*")) {
            return false;
        }
        extractInstructions(input);
        return true;
    }

    private void extractInstructions(String input) {
        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(input);
        List<String> instructions = new ArrayList<>();
        while (m.find()) {
            instructions.add(m.group().trim());
        }
        m_instructions = instructions.toArray(new String[instructions.size()]);
    }

    public String[] getInstructions() {
        return m_instructions;
    }
}
