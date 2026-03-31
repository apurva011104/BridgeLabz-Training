import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class User {
    private final String userId;
    private String name;
    private int age;
    private ArrayList<String> friendIds;

    public User(String userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
    }

    public String getUserId() { 
        return userId; 
    }

    public String getName() { 
        return name; 
    }

    public int getAge() { 
        return age; 
    }

    public ArrayList<String> getFriendIds() { 
        return friendIds; 
    }

    public void addFriend(String friendId) {
        if (!friendIds.contains(friendId)) {
            friendIds.add(friendId);
        }
    }

    public void removeFriend(String friendId) {
        friendIds.remove(friendId);
    }

    public int countFriends() {
        return friendIds.size();
    }

    public void displayUser() {
        System.out.printf("User ID: %s, Name: %s, Age: %d, Friends: %s%n",userId, name, age, friendIds);
    }

}

class UserNode {

    private User user;
    private UserNode next;

    public UserNode(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public UserNode getNext() {
        return next;
    }

    public void setNext(UserNode next) {
        this.next = next;
    }

}

// Social Media Friend System
public class SocialMediaFriendConnections {

    private UserNode head;
    private Set<String> allUserIDs;

    public SocialMediaFriendConnections() {
        allUserIDs = new HashSet<>();
    }

    //Method to check if user id already exists
    private boolean userExists(String userId) {
        return allUserIDs.contains(userId);
    }

    //Method to add users
    public void addUser(String userId, String name, int age) {

        if (userExists(userId)) {
            System.out.println("User ID already exists");
            return;
        }

        User user = new User(userId, name, age);
        UserNode newNode = new UserNode(user);

        if (head == null) {
            head = newNode;
        } else {
            UserNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }

        allUserIDs.add(userId);
        System.out.println("User added successfully");
    }


    //Method to create friendship
    public void addFriend(String userId1, String userId2) {

        if (userId1.equals(userId2)) {
            System.out.println("Cannot add yourself as a friend");
            return;
        }

        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found");
            return;
        }

        user1.addFriend(userId2);
        user2.addFriend(userId1);

        System.out.println("Friend connection added between " + userId1 + " and " + userId2);
    }

    //Method to remove friend
    public void removeFriend(String userId1, String userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found");
            return;
        }

        user1.removeFriend(userId2);
        user2.removeFriend(userId1);

        System.out.println("Friend connection removed between " + userId1 + " and " + userId2);
    }

    //Method to find mutual friends
    public void findMutualFriends(String userId1, String userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found");
            return;
        }

        ArrayList<String> mutual = new ArrayList<>();
        for (String friendId : user1.getFriendIds()) {
            if (user2.getFriendIds().contains(friendId)) {
                mutual.add(friendId);
            }
        }

        System.out.println("Mutual friends between " + userId1 + " and " + userId2 + ": " + mutual);
    }

    //Method to display all friends of a user
    public void displayFriends(String userId) {
        User user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Friends of " + user.getName() + ": " + user.getFriendIds());
    }

    //Method to find user
    private User findUserById(String userId) {
        UserNode current = head;
        while (current != null) {
            if (current.getUser().getUserId().equals(userId)) {
                return current.getUser();
            }
            current = current.getNext();
        }
        return null;
    }

    //Method to search user by od
    public void searchUserById(String userId) {

        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found");
        } 
        else {
            user.displayUser();
        }
    }

    //Method to search user by name
    public void searchUserByName(String name) {
        UserNode current = head;
        ArrayList<User> foundUsers = new ArrayList<>();

        while (current != null) {
            if (current.getUser().getName().equalsIgnoreCase(name)) {
                foundUsers.add(current.getUser());
            }
            current = current.getNext();
        }

        if (foundUsers.isEmpty()) {
            System.out.println("No users found with name: " + name);
        } 
        else {
            System.out.println("Users found:");
            for (User u : foundUsers) {
                u.displayUser();
            }
        }
    }

    

    //Method to count friends
    public void countFriends() {
        UserNode current = head;
        while (current != null) {
            User u = current.getUser();
            System.out.println(u.getName() + " has " + u.countFriends() + " friends");
            current = current.getNext();
        }
    }

    //Method to display all users
    public void displayAllUsers() {
        UserNode current = head;
        while (current != null) {
            current.getUser().displayUser();
            current = current.getNext();
        }
    }

    //main method for testing
    public static void main(String[] args) {
        SocialMediaFriendConnections socialMedia= new SocialMediaFriendConnections();

        socialMedia.addUser("User1", "Ava", 21);
        socialMedia.addUser("User2", "Ruby", 30);
        socialMedia.addUser("User3", "Rose", 28);

        socialMedia.addFriend("User1", "User2");
        socialMedia.addFriend("User1", "User3");

        socialMedia.displayAllUsers();

        socialMedia.findMutualFriends("User2", "User3");

        socialMedia.displayFriends("User1");

        socialMedia.countFriends();

        socialMedia.removeFriend("User1", "User2");

        socialMedia.displayFriends("User1");
    }
}
