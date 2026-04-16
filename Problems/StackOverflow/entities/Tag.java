package Problems.StackOverflow.entities;

public class Tag {
    
    private String tagId;
    private String name;

    public Tag(String name) {
        this.tagId = java.util.UUID.randomUUID().toString();
        this.name = name;
    }

    public String getTagId() {
        return tagId;
    }

    public String getName() {
        return name;
    }
    
}