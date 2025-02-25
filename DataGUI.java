import java.awt.*;
import javax.swing.*;

public class DataGUI extends JFrame {
    private JTextField inputField;
    private JButton analyzeColorButton, analyzeDietButton, analyzeStatusButton, analyzeNameButton;
    private JButton commonColorButton, commonDietButton, commonStatusButton;
    private JButton leastCommonColorButton, statusPercentageButton;
    private JTextArea resultsArea;
    private DataAnalyzer dataAnalyzer;
    
    public DataGUI() {
        setTitle("Data Analysis GUI");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        dataAnalyzer = new DataAnalyzer("countries.txt", "populations.txt", "incomes.txt", "unemployment.txt");
        
        inputField = new JTextField(20);
        analyzeStatusButton = new JButton("Analyze by Status");
        statusPercentageButton = new JButton("Status Percentage");
        resultsArea = new JTextArea(10, 40);
        resultsArea.setEditable(false);
        
        add(inputField);
        add(analyzeStatusButton);
        add(statusPercentageButton);
        add(new JScrollPane(resultsArea));
        
        analyzeStatusButton.addActionListener(e -> analyzeByStatus());
        statusPercentageButton.addActionListener(e -> getStatusPercentage());
        
        setVisible(true);
    }

    private void analyzeByStatus() {
        String status = inputField.getText();
        resultsArea.setText("Analyzing status: " + status);
        dataAnalyzer.identifyHighRiskCommunities(status, 10);
    }

    private void getStatusPercentage() {
        double avgUnemployment = dataAnalyzer.calculateAverageUnemployment();
        resultsArea.setText("Average unemployment rate: " + avgUnemployment + "%");
    }

    public static void main(String[] args) {
        new DataGUI();
    }
}
