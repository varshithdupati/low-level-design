package Problems.StackOverflow.entities;

public class User {
    
    private String userId;
    private String name;
    private String email;
    private int reputation;

    public User(String name, String email) {
        this.userId = java.util.UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.reputation = 0;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getReputation() {
        return reputation;
    }

    public void updateReputation(int points) {
        this.reputation += points;
    }

}