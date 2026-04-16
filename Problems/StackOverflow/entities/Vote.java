package Problems.StackOverflow.entities;

public class Vote {
    
    private String voteId;
    private Post post;
    private User voter;
    private VoteType type;

    public Vote(Post post, User voter, VoteType type) {
        this.voteId = java.util.UUID.randomUUID().toString();
        this.post = post;
        this.voter = voter;
        this.type = type;
    }

    public String getVoteId() {
        return voteId;
    }

    public Post getPost() {
        return post;
    }

    public User getVoter() {
        return voter;
    }

    public VoteType getType() {
        return type;
    }

}
