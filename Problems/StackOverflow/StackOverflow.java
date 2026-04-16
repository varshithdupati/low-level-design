package Problems.StackOverflow;

import java.util.ArrayList;
import java.util.List;

import Problems.StackOverflow.entities.Answer;
import Problems.StackOverflow.entities.Comment;
import Problems.StackOverflow.entities.Post;
import Problems.StackOverflow.entities.Question;
import Problems.StackOverflow.entities.ReputationDelta;
import Problems.StackOverflow.entities.Tag;
import Problems.StackOverflow.entities.User;
import Problems.StackOverflow.entities.Vote;
import Problems.StackOverflow.entities.VoteType;
import Problems.StackOverflow.reputation.ReputationService;
import Problems.StackOverflow.search.Search;

public class StackOverflow {
    
    private static volatile StackOverflow INSTANCE;

    List<Question> questions;
    private ReputationService reputationService;

    private StackOverflow() {
        questions = new ArrayList<>();
        reputationService = new ReputationService();
    }

    public static StackOverflow getInstance() {
        if (INSTANCE == null) {
            synchronized(StackOverflow.class) {
                if (INSTANCE == null) {
                    INSTANCE = new StackOverflow();
                }
            }
        }
        return INSTANCE;
    }

    public User createUser(String name, String email) {
        User user = new User(name, email);
        return user;
    }

    public Question postQuestion(String title, String content, User author) {
        Question question = new Question(title, content, author);
        questions.add(question);
        return question;
    }

    public Answer postAnswer(Question question, String content, User author) {
        Answer answer = new Answer(content, author);
        question.addAnswer(answer);
        return answer;
    }

    public Comment postComment(Post post, String content, User author) {
        Comment comment = new Comment(content, author);
        post.addComment(comment);
        return comment;
    }

    public Vote vote(Post post, User voter, VoteType voteType) {
        Vote vote = new Vote(post, voter, voteType);
        post.addVote(vote);
        ReputationDelta delta = reputationService.calculateReputationForQuestion(voteType);
        post.getAuthor().updateReputation(delta.getAuthorDelta());
        voter.updateReputation(delta.getActorDelta());
        return vote;
    }

    public void acceptAnswer(Question question, Answer answer, User actor) {
        if(question.getAuthor() == actor) {
            question.acceptAnswer(answer);
            ReputationDelta delta = reputationService.calculateReputationForAcceptingAnswer();
            answer.getAuthor().updateReputation(delta.getAuthorDelta());
            actor.updateReputation(delta.getActorDelta());
        }
    }

    public Tag addTag(Question question, String tagName) {
        Tag tag = new Tag(tagName);
        question.addTag(tag);
        return tag;
    }

    public List<Question> search(Search search) {
        return search.filter(questions);
    }

}
