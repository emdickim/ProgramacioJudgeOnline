package a30_04_passwordValidation;

import java.util.Scanner;

public class PasswordValidation {

    public boolean validatePassword(String password) {

        if (password == null) {
            throw new NullPointerException("Password can't be null.");
        }
        if (password.isEmpty()) {
            throw new IllegalArgumentException("Password can't be empty.");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must have at least 8 characters.");
        }
        if (password.contains(" ")) {
            throw new IllegalStateException("Password can't contain spaces.");
        }

        if (!password.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("Password must contain at least one number.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter.");
        }

        if (password.matches(".*[!%&?].*")) {
            throw new UnsupportedOperationException("Characters !, %, &, ? are not allowed.");
        }

        if (password.toLowerCase().contains("password") ||
                password.contains("12345678")) {
            throw new SecurityException("Weak password is not allowed.");
        }

        return true;
    }
    /*
    * null -> Password can't be null.
"" -> Password can't be empty.
"Ab1" -> Password must have at least 8 characters.
"Abc 1234" -> Password can't contain spaces.
"Abcdefgh" -> Password must contain at least one number.
"abcdefg1" -> Password must contain at least one uppercase letter.
"Abcdef1!" -> Characters !, %, &, ? are not allowed.
"Abcdef1%" -> Characters !, %, &, ? are not allowed.
"Abcdef1&" -> Characters !, %, &, ? are not allowed.
"Abcdef1?" -> Characters !, %, &, ? are not allowed.
"password123A" -> Weak password is not allowed.
"PASSWORD123" -> Weak password is not allowed.
"12345678Abc" -> Weak password is not allowed.
"Abcdefg1" -> Valid*/
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PasswordValidation p = new PasswordValidation();
        boolean valida = false;
        String password = sc.nextLine();
        try {
            valida = p.validatePassword(password);
            System.out.println(password + " -> Valid");
        } catch (Exception e) {
            String input = (password == null) ? "null" : password;
            System.out.println(input + " -> " + e.getMessage());
        }
        //if (valida) System.out.println(password + " -> Valid");
    }
}
