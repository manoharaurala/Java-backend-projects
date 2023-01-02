import java.util.*;

public class BasicKeywordAnalyzer implements KeywordAnalyzerInterface{
    private List<String> keywords;
    private Set<String> keywordSet;
    private Map<String,Integer> keywordFreqMap;
    public BasicKeywordAnalyzer(){
        keywords=new ArrayList<>();
        keywordSet=new LinkedHashSet<>();
        keywordFreqMap=new LinkedHashMap<>();
    }
    @Override
    public void recordKeyword(String keyword) {
        keywords.add(keyword);
        keywordSet.add(keyword);
        if(keywordFreqMap.containsKey(keyword)){
            keywordFreqMap.put(keyword,keywordFreqMap.get(keyword)+1);
        }
        else {
            keywordFreqMap.put(keyword,1);
        }
        System.out.println("Recorder keyword: "+keyword);

    }

    @Override
    public List<String> getAllKeywords() {
        return keywords;
    }

    @Override
    public Set<String> getUniqieKeywords() {
        return keywordSet;
    }

    @Override
    public List<KeywordFrequency> getKeywordWithFrequency() {
        List<KeywordFrequency> keywordFrequencyList=new ArrayList<>();
        for(String keyword:keywordFreqMap.keySet()){
            keywordFrequencyList.add(new KeywordFrequency(keyword,keywordFreqMap.get(keyword)));
        }

        Collections.sort(keywordFrequencyList,new KeywordComparator().reversed());
        return keywordFrequencyList;
    }
}
