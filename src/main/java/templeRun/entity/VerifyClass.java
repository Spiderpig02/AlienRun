package templeRun.entity;

public class VerifyClass {

    public static void verifyUsername(String username) throws IllegalArgumentException {
        if (username == null || username == "" || username == " " || !username.matches("[A-Za-z0-9]+")
                || username.isBlank() || username.isEmpty()) {
            throw new IllegalArgumentException("There must be an username before you can start the game.");
        }
    }

    public static int tryUsername(String username) {
        try {
            verifyUsername(username);
        } catch (IllegalArgumentException e) {
            return 0;
        }
        return 1;
    }

}
