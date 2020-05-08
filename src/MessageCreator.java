import java.text.DecimalFormat;

public class MessageCreator {
    private String message = new String();

    public MessageCreator() {

    }

    public String returnFeaturesAndSimilarities(String textOne, String textTwo) {
        TextTransformer textTransformer1 = new TextTransformer(textOne);
        TextTransformer textTransformer2 = new TextTransformer(textTwo);
        Detector detector1 = new Detector(textTransformer1.getSeparatedWords(), textTransformer1.getSentenceCount());
        Detector detector2 = new Detector(textTransformer2.getSeparatedWords(), textTransformer2.getSentenceCount());
        message += "<html>Text 1 <br/>";
        message += "Avg. word length: " + detector1.calculateAverageWordLength() + "<br/>";
        message += "Type-Token Ratio: " + detector1.calculateAllDifferentWordsRatio() + "<br/>";
        message += "Hapax Legomena Ratio: " + detector1.calculateAverageUniqueWords() + "<br/>";
        message += "Average sentence length: " + detector1.calculateAverageSentenceLength() + "<br/><br/>";
        message += "Text 2<br/>";
        message += "Avg. word length: " + detector2.calculateAverageWordLength() + "<br/>";
        message += "Type-Token Ratio: " + detector2.calculateAllDifferentWordsRatio() + "<br/>";
        message += "Hapax Legomena Ratio: " + detector2.calculateAverageUniqueWords() + "<br/>";
        message += "Average sentence length: " + detector2.calculateAverageSentenceLength() + "<br/><br/>";
        message += "Similarity: " + calculateSimilarities(detector1, detector2) + "</html>";
        return message;
    }


    private float calculateSimilarities(Detector detector1, Detector detector2) {
        return (float) (Math.abs(detector1.calculateAverageWordLength() - detector2.calculateAverageWordLength()) * 11 +
                Math.abs(detector1.calculateAllDifferentWordsRatio() - detector2.calculateAllDifferentWordsRatio()) * 33 +
                Math.abs(detector1.calculateAverageUniqueWords() - detector2.calculateAverageUniqueWords()) * 50 +
                Math.abs(detector1.calculateAverageSentenceLength() - detector2.calculateAverageSentenceLength()) * 0.4);
    }


}
