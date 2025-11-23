import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {

    @Test
    void testNullText() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            TextProcessor.reverseAndCapitalize(null);
        });
        assertEquals("El texto no puede ser nulo", ex.getMessage());
    }

    @Test
    void testEmptyText() {
        assertThrows(IllegalArgumentException.class, () -> TextProcessor.reverseAndCapitalize(""));
    }

    @Test
    void testOnlySpaces() {
        assertThrows(IllegalArgumentException.class, () -> TextProcessor.reverseAndCapitalize("   "));
    }

    @Test
    void testOverMaxLength() {
        String text = "a".repeat(1001);
        assertThrows(IllegalArgumentException.class, () -> TextProcessor.reverseAndCapitalize(text));
    }

    @Test
    void testBasicTransformation() {
        assertEquals("ALOH", TextProcessor.reverseAndCapitalize("hola"));
    }

    @Test
    void testTrimBeforeProcessing() {
        assertEquals("ALOH", TextProcessor.reverseAndCapitalize(" hola "));
    }

    @Test
    void testSpecialCharacters() {
        assertEquals("!DLROW", TextProcessor.reverseAndCapitalize("world!"));
    }

    @Test
    void testMixedCaseInput() {
        assertEquals("CBA", TextProcessor.reverseAndCapitalize("aBc"));
    }

    @Test
    void testLongValidText() {
        String text = "a".repeat(900);
        String expected = new StringBuilder(text).reverse().toString().toUpperCase();
        assertEquals(expected, TextProcessor.reverseAndCapitalize(text));
    }

    @Test
    void testOneChar() {
        assertEquals("A", TextProcessor.reverseAndCapitalize("a"));
    }
    @Test
    void testClassExistsTextProcessor() {
        assertDoesNotThrow(() -> Class.forName("TextProcessor"));
    }
    @Test
    void testTextProcessorConstructorCoverage() {
        new TextProcessor(); // Solo ejecuta el constructor
    }
}
