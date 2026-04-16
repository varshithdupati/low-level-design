package Problems.StackOverflow.search;

import java.util.List;
import java.util.stream.Collectors;

import Problems.StackOverflow.entities.User;
import Problems.StackOverflow.entities.Question;

public class UserSearch implements Search {
    
    private User user;
    
    public UserSearch(User user) {
        this.user = user;
    }
    
    @Override
    public List<Question> filter(List<Question> questions) {
        return questions.stream()
            .filter(q -> q.getAuthor().equals(user))
            .collect(Collectors.toList());
    }
    
}
