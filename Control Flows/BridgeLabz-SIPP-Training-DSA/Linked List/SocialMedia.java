import java.util.ArrayList;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;  // List of friend IDs
    User next;  // for singly linked list

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

public class SocialMedia {
    User head = null;

    // Add a new user (helper for testing)
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newUser;
        }
    }

    // Find user by ID
    public User findUserById(int userId) {
        User curr = head;
        while (curr != null) {
            if (curr.userId == userId) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    // Find user by Name
    public User findUserByName(String name) {
        User curr = head;
        while (curr != null) {
            if (curr.name.equalsIgnoreCase(name)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    // Add friend connection (mutual)
    public boolean addFriendConnection(int userId1, int userId2) {
        if (userId1 == userId2) return false;  // can't friend self

        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) return false;

        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
        }
        if (!user2.friendIds.contains(userId1)) {
            user2.friendIds.add(userId1);
        }
        return true;
    }

    // Remove friend connection (mutual)
    public boolean removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) return false;

        boolean removed1 = user1.friendIds.remove(Integer.valueOf(userId2));
        boolean removed2 = user2.friendIds.remove(Integer.valueOf(userId1));
        return removed1 && removed2;
    }

    // Find mutual friends between two users
    public ArrayList<Integer> findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        ArrayList<Integer> mutualFriends = new ArrayList<>();

        if (user1 == null || user2 == null) return mutualFriends;

        for (int friendId : user1.friendIds) {
            if (user2.friendIds.contains(friendId)) {
                mutualFriends.add(friendId);
            }
        }
        return mutualFriends;
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User with ID " + userId + " not found.");
            return;
        }
        System.out.print("Friends of " + user.name + " (ID " + user.userId + "): ");
        if (user.friendIds.isEmpty()) {
            System.out.println("No friends.");
            return;
        }
        for (int friendId : user.friendIds) {
            User friend = findUserById(friendId);
            if (friend != null) {
                System.out.print(friend.name + " (ID " + friend.userId + "), ");
            }
        }
        System.out.println();
    }

    // Count the number of friends for each user
    public void countFriendsForAllUsers() {
        User curr = head;
        while (curr != null) {
            System.out.println(curr.name + " (ID " + curr.userId + ") has " + curr.friendIds.size() + " friend(s).");
            curr = curr.next;
        }
    }

  
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        // Add some users
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 22);
        sm.addUser(4, "Diana", 27);
        sm.addUser(5, "Eve", 29);

        // Add friend connections
        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);
        sm.addFriendConnection(2, 4);
        sm.addFriendConnection(3, 5);

        // Display friends
        sm.displayFriends(1);
        sm.displayFriends(2);
        sm.displayFriends(3);

        // Find mutual friends between Alice and Bob
        System.out.println("Mutual friends between Alice and Bob:");
        ArrayList<Integer> mutual = sm.findMutualFriends(1, 2);
        for (int id : mutual) {
            User u = sm.findUserById(id);
            if (u != null) System.out.println(u.name + " (ID " + u.userId + ")");
        }

        // Remove friend connection
        System.out.println("\nRemoving friend connection between Alice and Bob...");
        sm.removeFriendConnection(1, 2);
        sm.displayFriends(1);
        sm.displayFriends(2);

        // Count friends for all users
        System.out.println("\nNumber of friends for each user:");
        sm.countFriendsForAllUsers();

        // Search user by name
        System.out.println("\nSearching for user named 'Diana':");
        User found = sm.findUserByName("Diana");
        if (found != null) {
            System.out.println("Found user: " + found.name + " (ID " + found.userId + ")");
        }
    }
}
