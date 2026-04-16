package Problems.StackOverflow.entities;

public class ReputationDelta {
    
    private int authorDelta;
    private int actorDelta;

    public ReputationDelta(int authorDelta, int actorDelta) {
        this.authorDelta = authorDelta;
        this.actorDelta = actorDelta;
    }

    public int getAuthorDelta() {
        return authorDelta;
    }

    public int getActorDelta() {
        return actorDelta;
    }
}
