import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame implements ActionListener {
    private JLabel labelProgramFunction;
    JLabel labelFeatures;
    private JLabel labelTextOne;
    private JLabel labelTextTwo;
    private JLabel results;
    private JTextArea textAreaOne;
    private JTextArea textAreaTwo;
    private JButton click;
    MessageCreator messageCreator = new MessageCreator();


    public Display() {
        setLayout(null);
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelProgramFunction = new JLabel("This program calculates the similarity between two texts by using the following text features: ");
        labelFeatures = new JLabel("1) Average Word Length  2) Type-Token Ratio  3) Hapax Legomena Ratio  4) Average Sentence Length.");
        labelTextOne = new JLabel("Text One");
        labelTextTwo = new JLabel("Text Two");
        click = new JButton("Calculate Similarity!");
        textAreaOne = new JTextArea();
        textAreaTwo = new JTextArea();
        results = new JLabel();
        labelProgramFunction.setBounds(100, 10,600, 30);
        labelFeatures.setBounds(100,30,700, 40);
        labelTextOne.setBounds(160, 70, 120, 30);
        labelTextTwo.setBounds(500, 70, 120, 30);
        textAreaOne.setBounds(50, 100, 300, 300);
        textAreaTwo.setBounds(400, 100, 300, 300);
        click.setBounds(300, 420, 150, 40);
        results.setBounds(300, 430, 300, 300);
        click.addActionListener(this);
        textAreaOne.setLineWrap(true);
        textAreaTwo.setLineWrap(true);
        add(click);
        add(results);
        add(textAreaTwo);
        add(textAreaOne);
        add(labelTextTwo);
        add(labelTextOne);
        add(labelProgramFunction);
        add(labelFeatures);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == click) {
            String tempTextOne = textAreaOne.getText();
            String tempTextTwo = textAreaTwo.getText();
            results.setText(messageCreator.returnFeaturesAndSimilarities(tempTextOne, tempTextTwo));
        }
    }
}
