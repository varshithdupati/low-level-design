package Problems.StackOverflow.entities;

import java.util.ArrayList;
import java.util.List;

public class Question extends Post {

    private String title;
    private List<Answer> answers;
    Answer acceptedAnswer;
    private List<Tag> tags;
    
    public Question(String title, String content, User author) {
        super(content, author);
        this.title = title;
        this.answers = new ArrayList<>();
        acceptedAnswer = null;
        this.tags = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void acceptAnswer(Answer answer) {
        if (answers.contains(answer) && acceptedAnswer == null) {
            acceptedAnswer = answer;
        }
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }
    
}
