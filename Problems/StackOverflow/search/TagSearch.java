package Problems.StackOverflow.search;

import java.util.List;
import java.util.stream.Collectors;

import Problems.StackOverflow.entities.Question;
import Problems.StackOverflow.entities.Tag;

public class TagSearch implements Search {
    
    private Tag tag;

    public TagSearch(Tag tag) {
        this.tag = tag;
    }

    @Override
    public List<Question> filter(List<Question> questions) {
        return questions.stream()
            .filter(q -> q.getTags().stream().anyMatch(t -> t.equals(tag)))
            .collect(Collectors.toList());
    }
    
}
