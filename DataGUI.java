import java.awt.*;
import javax.swing.*;

public class DataGUI extends JFrame {
    private JTextField input;
    private JButton analyzeBtn, avgBtn;
    private JTextArea output;
    private DataAnalyzer data;

    public DataGUI() {
        super("Data Analysis");
        setSize(500, 400);
        setLayout(new FlowLayout());

        data = new DataAnalyzer("countries.txt", "populations.txt", 
                                 "incomes.txt", "unemployment.txt");

        input = new JTextField(20);
        analyzeBtn = new JButton("Analyze");
        avgBtn = new JButton("Avg Unemployment");
        output = new JTextArea(10, 40);
        output.setEditable(false);

        add(input);
        add(analyzeBtn);
        add(avgBtn);
        add(new JScrollPane(output));

        analyzeBtn.addActionListener(e -> analyze());
        avgBtn.addActionListener(e -> showAvg());

        setVisible(true);
    }

    private void analyze() {
        String status = input.getText();
        output.setText("Analyzing: " + status);
        data.identifyHighRiskCommunities(status, 10);
    }

    private void showAvg() {
        double avg = data.calculateAverageUnemployment();
        output.setText("Avg Unemployment: " + avg + "%");
    }

    public static void main(String[] args) {
        new DataGUI();
    }
}
