import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ben on 02-02-16.
 */
public class InstructionParserTest {

    @Test
    public void testParse() {
        InstructionParser parser = new InstructionParser();
        assertFalse(parser.parse(null));
        assertFalse(parser.parse(""));
        assertFalse(parser.parse("1"));
        assertFalse(parser.parse("12"));
        assertTrue(parser.parse("123"));
        assertTrue(parser.parse(" 123"));
        assertTrue(parser.parse(" 123 "));
        assertFalse(parser.parse("1234"));
        assertFalse(parser.parse("123 4"));
        assertFalse(parser.parse("123 45"));
        assertTrue(parser.parse("123 456"));
        assertFalse(parser.parse("123 1 456"));
    }
}