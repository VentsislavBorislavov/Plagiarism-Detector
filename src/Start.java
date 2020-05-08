import java.text.DecimalFormat;

public class Start {
    private String message = new String() ;

    public Start() {
        String text1 = "This is some real famous quote that you haven't heard";
        String text2 = "That is real famous quote. You should have heard it!";
        TextTransformer textTransformer1 = new TextTransformer(text1);
        TextTransformer textTransformer2 = new TextTransformer(text2);
        Detector detector1 = new Detector(textTransformer1.getSeparatedWords(), textTransformer1.getSentenceCount());
        Detector detector2 = new Detector(textTransformer2.getSeparatedWords(), textTransformer2.getSentenceCount());
        message += "Text1: \n";
        message += "Avg. word length: " + detector1.calculateAverageWordLength() + "\n";
        message += "Type-Token Ratio: " + detector1.calculateAllDifferentWordsRatio() + "\n";
        message += "Hapax Legomena Ratio: " + detector1.calculateAverageUniqueWords() + "\n";
        message += "Average sentence length: " + detector1.calculateAverageSentenceLength() + "\n\n";
        message += "Text 2\n";
        message += "Avg. word length: " + detector2.calculateAverageWordLength() + "\n";
        message += "Type-Token Ratio: " + detector2.calculateAllDifferentWordsRatio() + "\n";
        message += "Hapax Legomena Ratio: " + detector2.calculateAverageUniqueWords() + "\n";
        message += "Average sentence length: " + detector2.calculateAverageSentenceLength() + "\n\n";
        message += "Similarity: " + calculateSimilarities(detector1, detector2);
        System.out.println(message);
    }

    private float calculateSimilarities(Detector detector1, Detector detector2) {
        return (float) (Math.abs(detector1.calculateAverageWordLength() - detector2.calculateAverageWordLength()) * 11 +
                        Math.abs(detector1.calculateAllDifferentWordsRatio() - detector2.calculateAllDifferentWordsRatio()) * 33 +
                        Math.abs(detector1.calculateAverageUniqueWords() - detector2.calculateAverageUniqueWords()) * 50 +
                        Math.abs(detector1.calculateAverageSentenceLength() - detector2.calculateAverageSentenceLength()) * 0.4);
    }


}
