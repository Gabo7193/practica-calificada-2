public class TextProcessor {

    public TextProcessor() {
    }

    public static String reverseAndCapitalize(String input) {

        if (input == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }

        if (input.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        String trimmed = input.trim();
        String reversed = new StringBuilder(trimmed).reverse().toString();
        return reversed.toUpperCase();
    }
}
