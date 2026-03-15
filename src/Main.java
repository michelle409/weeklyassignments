import java.util.*;

public class Main {

    // stores username -> userId
    static HashMap<String, Integer> usernameMap = new HashMap<>();

    // stores username -> attempt count
    static HashMap<String, Integer> attemptCount = new HashMap<>();

    // check availability in O(1)
    public static boolean checkAvailability(String username) {

        attemptCount.put(username, attemptCount.getOrDefault(username, 0) + 1);

        return !usernameMap.containsKey(username);
    }

    // register a new user
    public static void registerUser(String username, int userId) {
        usernameMap.put(username, userId);
    }

    // suggest alternative usernames
    public static List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        suggestions.add(username + "1");
        suggestions.add(username + "2");
        suggestions.add(username.replace("_", "."));

        return suggestions;
    }

    // find most attempted username
    public static String getMostAttempted() {

        String most = "";
        int max = 0;

        for (String user : attemptCount.keySet()) {

            if (attemptCount.get(user) > max) {
                max = attemptCount.get(user);
                most = user;
            }

        }

        return most + " (" + max + " attempts)";
    }

    public static void main(String[] args) {

        // existing users
        registerUser("john_doe", 1);
        registerUser("alice", 2);

        System.out.println("Check john_doe: " + checkAvailability("john_doe"));
        System.out.println("Check jane_smith: " + checkAvailability("jane_smith"));

        System.out.println("Suggestions for john_doe: " + suggestAlternatives("john_doe"));

        checkAvailability("admin");
        checkAvailability("admin");
        checkAvailability("admin");

        System.out.println("Most attempted username: " + getMostAttempted());
    }
}