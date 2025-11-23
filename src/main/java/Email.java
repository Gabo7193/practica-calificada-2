public class Email {
    public boolean isValidEmail(String email) {

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        if (!email.contains("@")) {
            return false;
        }

        String[] parts = email.split("@");
        if (parts.length != 2) return false;

        String local = parts[0];
        String domain = parts[1];

        if (local.isEmpty() || local.startsWith(".") || local.endsWith(".")) return false;
        if (local.contains("..")) return false;
        if (!domain.contains(".")) return false;

        return true;
    }
}
