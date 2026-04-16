package Problems.StackOverflow.entities;

import java.time.LocalDate;

public abstract class Content {
    
    private String id;
    private String content;
    private User author;
    private LocalDate createdAt;

    public Content(String content, User author) {
        this.id = java.util.UUID.randomUUID().toString();
        this.content = content;
        this.author = author;
        this.createdAt = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public User getAuthor() {
        return author;
    }
    
}
