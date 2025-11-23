import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    Email email = new Email();

    @Test
    void testNullEmail() {
        assertThrows(IllegalArgumentException.class, () -> email.isValidEmail(null));
    }

    @Test
    void testEmptyEmail() {
        assertThrows(IllegalArgumentException.class, () -> email.isValidEmail(""));
    }

    @Test
    void testMissingAt() {
        assertFalse(email.isValidEmail("usuario.gmail.com"));
    }

    @Test
    void testMissingDomain() {
        assertFalse(email.isValidEmail("usuario@com"));
    }

    @Test
    void testStartsWithDot() {
        assertFalse(email.isValidEmail(".user@gmail.com"));
    }

    @Test
    void testEndsWithDot() {
        assertFalse(email.isValidEmail("user.@gmail.com"));
    }

    @Test
    void testDoubleDot() {
        assertFalse(email.isValidEmail("user..test@gmail.com"));
    }

    @Test
    void testDomainNoDot() {
        assertFalse(email.isValidEmail("user@gmail"));
    }

    @Test
    void testValidEmail() {
        assertTrue(email.isValidEmail("cliente123@tienda.com"));
    }

    @Test
    void testVeryLongEmail() {
        String longEmail = "a".repeat(250) + "@gmail.com";
        assertTrue(email.isValidEmail(longEmail)); // sigue válido
    }
    @Test
    void testLocalPartEmpty() {
        Email e = new Email();
        assertFalse(e.isValidEmail("@gmail.com"));
    }
    @Test
    void testMultipleAtSymbols() {
        Email e = new Email();
        assertFalse(e.isValidEmail("user@@gmail.com"));
    }


}

