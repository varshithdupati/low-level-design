package Problems.StackOverflow.search;

import java.util.List;
import java.util.stream.Collectors;

import Problems.StackOverflow.entities.Question;

public class TextSearch implements Search {
    
    private String query;

    public TextSearch(String query) {
        this.query = query;
    }
    
    @Override
    public List<Question> filter(List<Question> questions) {
        return questions.stream()
            .filter(q -> q.getContent().contains(query) || q.getTitle().contains(query))
            .collect(Collectors.toList());
    }
    
}
