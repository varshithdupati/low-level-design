package Problems.StackOverflow.reputation;

import Problems.StackOverflow.entities.ReputationDelta;
import Problems.StackOverflow.entities.VoteType;

public class ReputationService {
    
    public ReputationDelta calculateReputationForQuestion(VoteType voteType) {
        switch (voteType) {
            case UPVOTE:
                return new ReputationDelta(10, 0);
            case DOWNVOTE:
                return new ReputationDelta(-2, 0);
            default:
                return new ReputationDelta(0, 0);
        }
    }

    public ReputationDelta calculateReputationForAnswer(VoteType voteType) {
        switch (voteType) {
            case UPVOTE:
                return new ReputationDelta(10, 0);
            case DOWNVOTE:
                return new ReputationDelta(-2, -1);
            default:
                return new ReputationDelta(0, 0);
        }
    }

    public ReputationDelta calculateReputationForAcceptingAnswer() {
        return new ReputationDelta(15, 2);
    }

}
