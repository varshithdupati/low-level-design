package Problems.StackOverflow;

import Problems.StackOverflow.entities.Answer;
import Problems.StackOverflow.entities.Question;
import Problems.StackOverflow.entities.User;
import Problems.StackOverflow.entities.VoteType;

public class StackOverflowDemo {
    public static void main(String[] args) {

        StackOverflow stackOverflow = StackOverflow.getInstance();   

        User user1 = stackOverflow.createUser("Alice", "alice@example.com");
        User user2 = stackOverflow.createUser("Bob", "bob@example.com");

        Question question = stackOverflow.postQuestion("How to implement a linked list in Java?", "I am new to data structures and want to learn how to implement a linked list in Java. Can someone provide an example?", user1);
        Answer answer = stackOverflow.postAnswer(question, "Here is an example of a linked list implementation in Java...", user2);
        stackOverflow.postComment(question, "This is a great question!", user2);
        stackOverflow.addTag(question, "java");
        stackOverflow.vote(question, user2, VoteType.UPVOTE);
        stackOverflow.acceptAnswer(question, answer, user1);

        System.out.println("Alice's Reputation: " + user1.getReputation());
        System.out.println("Bob's Reputation: " + user2.getReputation());

    }
}
