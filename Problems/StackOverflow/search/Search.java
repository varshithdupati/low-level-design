package Problems.StackOverflow.search;

import java.util.List;

import Problems.StackOverflow.entities.Question;

public interface Search {
    
    List<Question> filter(List<Question> questions);
    
}
