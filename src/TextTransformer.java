import java.util.ArrayList;
import java.util.List;

public class TextTransformer {
    private String textToCompare;
    private int sentenceCount;
    String[] separatedWords;

    public TextTransformer(String textToCompare) {
        this.textToCompare = textToCompare;
        separateWords();
        countSentences();
        removeSignatures();
    }

    private void separateWords() {
        separatedWords = this.textToCompare.split(" ");
    }

    private void removeSignatures() {
        for (int i = 0; i < separatedWords.length; i++) {
            if (separatedWords[i].endsWith(".") || separatedWords[i].endsWith("!") || separatedWords[i].endsWith("?") || separatedWords[i].endsWith(",")) {
                separatedWords[i] = removeLastCharacter(separatedWords[i]);
            }
        }
    }

    private void countSentences() {
        for (int i = 0; i < separatedWords.length; i++) {
            if (separatedWords[i].endsWith(".") || separatedWords[i].endsWith("!") || separatedWords[i].endsWith("?")) {
                sentenceCount++;
            }
        }
    }

    private String removeLastCharacter(String str) {
        return str.substring(0, str.length() - 1);
    }

    public String[] getSeparatedWords() {
        return separatedWords;
    }

    public int getSentenceCount() {
        return sentenceCount;
    }
}

