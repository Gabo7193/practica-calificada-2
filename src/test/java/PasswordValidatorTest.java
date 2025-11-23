import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void testNullPassword() {
        assertThrows(IllegalArgumentException.class,
                () -> PasswordValidator.isValid(null));
    }

    @Test
    void testEmptyPassword() {
        assertThrows(IllegalArgumentException.class,
                () -> PasswordValidator.isValid(""));
    }

    @Test
    void testTooShortPassword() {
        assertFalse(PasswordValidator.isValid("Aa1!aa"));
    }

    @Test
    void testTooLongPassword() {
        String longPass = "A".repeat(70);
        assertFalse(PasswordValidator.isValid(longPass));
    }

    @Test
    void testInvalidCharacter() {
        assertFalse(PasswordValidator.isValid("Password123~"));
    }

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Password123!"));
    }
}
