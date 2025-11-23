import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {

    @Test
    void testNullText() {
        assertThrows(IllegalArgumentException.class,
                () -> TextProcessor.reverseAndCapitalize(null));
    }

    @Test
    void testEmptyText() {
        assertThrows(IllegalArgumentException.class,
                () -> TextProcessor.reverseAndCapitalize("   "));
    }

    @Test
    void testTooLongText() {
        String longText = "a".repeat(1200);
        assertThrows(IllegalArgumentException.class,
                () -> TextProcessor.reverseAndCapitalize(longText));
    }

    @Test
    void testReverseSimpleWord() {
        assertEquals("CBA", TextProcessor.reverseAndCapitalize("abc"));
    }

    @Test
    void testReverseTrimEffect() {
        assertEquals("DCBA", TextProcessor.reverseAndCapitalize("  abcd  "));
    }

    @Test
    void testUpperCaseResult() {
        assertEquals("HOLA", TextProcessor.reverseAndCapitalize("aloh"));
    }
}
