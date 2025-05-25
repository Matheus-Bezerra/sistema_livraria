package utils;

public class SenhaValidator {
    public static boolean isValid(String senha) {
        if (senha == null) return false;
        return senha.length() >= 6;
    }
}