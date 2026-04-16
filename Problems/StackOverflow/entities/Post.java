package Problems.StackOverflow.entities;

import java.util.ArrayList;
import java.util.List;

public class Post extends Content {

    List<Comment> comments;
    List<Vote> votes;
    
    public Post(String content, User author) {
        super(content, author);
        comments = new ArrayList<>();
        votes = new ArrayList<>();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addVote(Vote vote) {
        votes.add(vote);
    }

}
