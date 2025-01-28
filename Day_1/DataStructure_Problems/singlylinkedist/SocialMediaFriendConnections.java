package singlylinkedist;
// Class representing a user in the social media system
import java.util.*;

class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds; // List to store Friend IDs
    UserNode next;

    // Constructor to initialize a user node
    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

// Class implementing the social media friend connection system
class SocialMedia {
    private UserNode head;

    // Add a new user to the system
    public void addUser(int userId, String name, int age) {
        UserNode newNode = new UserNode(userId, name, age);
        if (head == null) {
            head = newNode;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("User added: " + name);
    }

    // Search for a user by User ID
    private UserNode findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
        }
        if (!user2.friendIds.contains(userId1)) {
            user2.friendIds.add(userId1);
        }

        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    // Remove a friend connection between two users
    public void removeFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));

        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        List<Integer> mutualFriends = new ArrayList<>(user1.friendIds);
        mutualFriends.retainAll(user2.friendIds);

        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
        for (int id : mutualFriends) {
            UserNode mutualFriend = findUserById(id);
            if (mutualFriend != null) {
                System.out.println(mutualFriend.name);
            }
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        for (int id : user.friendIds) {
            UserNode friend = findUserById(id);
            if (friend != null) {
                System.out.println(friend.name);
            }
        }
    }

    // Search for a user by Name or User ID
    public void searchUser(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User found: " + temp.name + ", ID: " + temp.userId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User with name " + name + " not found.");
    }

    public void searchUserById(int userId) {
        UserNode user = findUserById(userId);
        if (user != null) {
            System.out.println("User found: " + user.name + ", Age: " + user.age);
        } else {
            System.out.println("User with ID " + userId + " not found.");
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        UserNode temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }
}

// Main class to demonstrate the Social Media Friend Connections system
 class SocialMediaFriendConnections {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        // Add users
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 28);

        // Add friend connections
        sm.addFriend(1, 2);
        sm.addFriend(1, 3);

        // Display friends
        sm.displayFriends(1);

        // Find mutual friends
        sm.findMutualFriends(1, 2);

        // Count friends
        sm.countFriends();

        // Search for a user
        sm.searchUser("Alice");
        sm.searchUserById(3);

        // Remove a friend connection
        sm.removeFriend(1, 2);
        sm.displayFriends(1);
    }
}
