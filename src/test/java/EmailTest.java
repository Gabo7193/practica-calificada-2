import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    Email emailValidator = new Email();

    @Test
    void testNullEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> emailValidator.isValidEmail(null));
    }

    @Test
    void testEmptyEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> emailValidator.isValidEmail(""));
    }

    @Test
    void testEmailWithoutAt() {
        assertFalse(emailValidator.isValidEmail("usuario.gmail.com"));
    }

    @Test
    void testEmailDoubleAt() {
        assertFalse(emailValidator.isValidEmail("a@@b.com"));
    }

    @Test
    void testLocalPartInvalid() {
        assertFalse(emailValidator.isValidEmail(".abc@gmail.com"));
    }

    @Test
    void testBasicValidEmail() {
        assertTrue(emailValidator.isValidEmail("user@mail.com"));
    }
}
