import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Detector {

    private int sentenceCount;
    private String[] words;


    public Detector(String[] words, int sentenceCount) {
        this.words = words;
        this.sentenceCount = sentenceCount;
    }

    public float calculateAverageWordLength() {
        float sum = 0;
        for (int i = 0; i < words.length; i++) {
            sum += words[i].length();
        }
        return sum / words.length;
    }

    public float calculateAllDifferentWordsRatio() {
        List<String> differentWords = new ArrayList<>();
        differentWords.add(words[0]);
        for (int i = 0; i < words.length; i++) {
            int sameWordCounter = 0;
            for (int j = 0; j < differentWords.size(); j++) {
                if (differentWords.get(j).equalsIgnoreCase(words[i])) {
                    sameWordCounter++;
                    break;
                }
            }
            if (sameWordCounter == 0) {
                differentWords.add(words[i]);
            }
        }
        return (float) differentWords.size()/words.length;
    }

    public float calculateAverageUniqueWords() {
        int uniqueWordCount = 0;
        for (int i = 0; i < words.length; i++) {
            int wordCount = 0;
            for (int j = 0; j < words.length; j++) {
                if (words[j].equalsIgnoreCase(words[i]))
                    wordCount++;
                if (wordCount > 1)
                    break;
            }
            if (wordCount == 1) {
                uniqueWordCount++;
            }
        }
        return (float) uniqueWordCount / words.length;
    }

    public float calculateAverageSentenceLength() {
        return (float) words.length / sentenceCount;
    }


}
