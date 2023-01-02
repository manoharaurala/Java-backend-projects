import java.util.List;
import java.util.Set;

public interface KeywordAnalyzerInterface {
    void recordKeyword(String keyword);
    List<String> getAllKeywords();

    default Set<String> getUniqieKeywords() {
        return null;
    }

    default List<KeywordFrequency> getKeywordWithFrequency(){
        return null;
    }


}
