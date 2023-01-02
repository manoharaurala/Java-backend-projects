import java.util.Comparator;

public class KeywordComparator implements Comparator<KeywordFrequency> {


    @Override
    public int compare(KeywordFrequency o1, KeywordFrequency o2) {
        return o1.getFreq()-o2.getFreq();
    }

}
