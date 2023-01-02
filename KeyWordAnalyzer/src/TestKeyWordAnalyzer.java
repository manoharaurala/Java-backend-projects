public class TestKeyWordAnalyzer {
    public static void main(String[] args) {
        BasicKeywordAnalyzer keywordAnalyzer=new BasicKeywordAnalyzer();
        keywordAnalyzer.recordKeyword("Ruby");
        keywordAnalyzer.recordKeyword("Annaya");
        keywordAnalyzer.recordKeyword("Patti");
        keywordAnalyzer.recordKeyword("Kariya");
        keywordAnalyzer.recordKeyword("Gonde");
        keywordAnalyzer.recordKeyword("Ruby");
        keywordAnalyzer.recordKeyword("Annaya");
        keywordAnalyzer.recordKeyword("patti");


        System.out.println("All the keywords are added: "+keywordAnalyzer.getAllKeywords());
        System.out.println("Unique keywords are added: "+keywordAnalyzer.getUniqieKeywords());
        System.out.println("Keywords with frequency: "+keywordAnalyzer.getKeywordWithFrequency());
    }
}
