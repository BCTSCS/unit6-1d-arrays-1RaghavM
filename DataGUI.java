import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
 
public class DataGUI extends JFrame {
    private JTextField inputField;
    private JButton statusButton, percentageButton, saveScreenButton;
    private JTextArea resultsArea;
    private CountryAnalyzer analyzer;
    private int counter;
 
    public DataGUI() {
        super("Data Analysis Tool");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        counter = 0;
 
        // Initialize data analyzer with data files
        analyzer = new CountryAnalyzer("countries.txt", "populations.txt",
                                  "incomes.txt", "unemployment.txt");
 
        // Create components
        inputField = new JTextField(20);
        statusButton = new JButton("Analyze by Status");
        percentageButton = new JButton("Status Percentage");
        saveScreenButton = new JButton("Save Screen");
        resultsArea = new JTextArea(10, 40);
        resultsArea.setEditable(false);
 
        // Add components to window
        add(inputField);
        add(statusButton);
        add(percentageButton);
        add(saveScreenButton);
        add(new JScrollPane(resultsArea));
 
        // Setup button actions
        statusButton.addActionListener(e -> analyzeStatus());
        percentageButton.addActionListener(e -> showPercentage());
        saveScreenButton.addActionListener(e -> saveScreen());
 
        setVisible(true);
    }
 
    private void analyzeStatus() {
        String status = inputField.getText();
        resultsArea.setText("Analyzing status: " + status);
        analyzer.identifyHighRiskCommunities(status, 10);
    }
 
    private void showPercentage() {
        double average = analyzer.calculateAverageUnemployment();
        resultsArea.setText("Average unemployment: " + average + "%");
    }
    
    public void saveScreen() {
        counter++;
        try {
            // Create a BufferedImage to store content
            int w = resultsArea.getWidth();
            int h = resultsArea.getHeight();
            int type = BufferedImage.TYPE_INT_ARGB;
            BufferedImage sshot = new BufferedImage(w, h, type);

            // Grab the canvas of the image
            Graphics2D g2d = sshot.createGraphics();
            // Like a virtual brush, paint the canvas with resultArea
            resultsArea.paint(g2d);

            // Make a file
            File out = new File("Search" + counter + ".png");
            // Save the content of the image to this file
            ImageIO.write(sshot, "png", out);

            // Remove the canvas
            g2d.dispose();

            System.out.println("Screenshot saved: " + out.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
 
    public static void main(String[] args) {
        new DataGUI();
    }
}