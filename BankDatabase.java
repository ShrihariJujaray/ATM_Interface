import java.util.HashMap;

public class BankDatabase {
    private static HashMap<String, User> users = new HashMap<>();

    // new users
    public static void addUser(User user) {
        users.put(user.getAccountNumber(), user);
    }

    // account numbers of users
    public static User getUser(String accountNumber) {
        return users.get(accountNumber);
    }
}
