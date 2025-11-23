import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void testNullPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.isValid(null);
        });
        assertEquals("La contraseña no puede ser nula o vacía", exception.getMessage());
    }
    @Test
    void testPasswordEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.isValid("");
        });
        assertEquals("La contraseña no puede ser nula o vacía", exception.getMessage());
    }
    @Test
    void testTooShortPassword() {
        assertFalse(PasswordValidator.isValid("Aa1!aa"));
    }
    @Test
    void testTooLongPassword() {
        String longPass = "A".repeat(65) + "a1!";
        assertFalse(PasswordValidator.isValid(longPass));
    }
    @Test
    void testMissingUppercase() {
        assertFalse(PasswordValidator.isValid("seguro123!"));
    }
    @Test
    void testMissingLowercase() {
        assertFalse(PasswordValidator.isValid("SEGURA123!"));
    }
    @Test
    void testMissingDigit() {
        assertFalse(PasswordValidator.isValid("Seguro!!!"));
    }
    @Test
    void testMissingSpecialChar() {
        assertFalse(PasswordValidator.isValid("Seguro123"));
    }
    @Test
    void testInvalidCharacter() {
        assertFalse(PasswordValidator.isValid("Seguro123~"));
    }
    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Secure123!"));
    }
    @Test
    void testClassExistsPasswordValidator() {
        assertDoesNotThrow(() -> Class.forName("PasswordValidator"));
    }
    @Test
    void testPasswordValidatorConstructorCoverage() {
        new PasswordValidator(); // Solo ejecuta el constructor
    }
}
