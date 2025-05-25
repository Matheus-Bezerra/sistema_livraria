package utils;

import java.util.regex.Pattern;

/**
 * Utilitário para validação de emails.
 */
public class EmailValidator {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    /**
     * Valida se o email fornecido é válido.
     *
     * @param email Email a ser validado.
     * @return {@code true} se válido, {@code false} caso contrário.
     */
    public static boolean isValid(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
}