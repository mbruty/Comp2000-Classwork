package net.bruty.session_one.Encapsulation;

public class Encapsulation {
    public static void Login(String userName, String pass) {

        System.out.println("Authenticating...");

        if (authenticate(userName, pass)) {
            System.out.println("Logged in " + userName);
            return;
        }
        System.out.println("Incorrect Password or Username");
    }

    private static Boolean authenticate(String userName, String password) {
        return userName.equals("Bob") && password.equals("pass");
    }

    public static void post(String message, String photo, String tags) {
        System.out.println(" ** Post to Social Media App **");
        if (checkString(message, "Message") && checkString(photo, "Photo") && checkString(tags, "Tags"))
            System.out.println("Posting to Social Media");
    }

    private static Boolean checkString(String stringToCheck, String type) {
        if (stringToCheck.isBlank()) {
            System.out.println(type + "is required!");
            return false;
        }
        System.out.println(type + ": \t" + stringToCheck);
        return true;
    }
}
