import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class DataGUI extends JFrame {
    private JTextField input;
    private JButton analyzeBtn, avgBtn, saveScreen;
    private JTextArea output;
    private DataAnalyzer data;
    private static int counter;

    public DataGUI()  {
        super("Data Analysis");
        setSize(500, 400);
        setLayout(new FlowLayout());

        data = new DataAnalyzer("countries.txt", "populations.txt", 
                                 "incomes.txt", "unemployment.txt");

        input = new JTextField(20);
        analyzeBtn = new JButton("Analyze");
        avgBtn = new JButton("Avg Unemployment");
        output = new JTextArea(10, 40);
        saveScreen = new JButton("Save Search");
        output.setEditable(false);

        add(input);
        add(analyzeBtn);
        add(avgBtn);
        add(new JScrollPane(output));
        add(saveScreen);

        analyzeBtn.addActionListener(e -> analyze());
        avgBtn.addActionListener(e -> showAvg());

        saveScreen.addActionListener(e -> SaveScreens());

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

    public void SaveScreens(){
        
        counter++;
        try{
            int w = output.getWidth();
            int h = output.getHeight();
            int type = BufferedImage.TYPE_INT_ARGB;
            BufferedImage sshot = new BufferedImage(w,h,type);

            Graphics2D g2d = sshot.createGraphics();
            output.paint(g2d);

            File out = new File("Search" + counter + ".png");
            ImageIO.write(sshot, "png", out);
            g2d.dispose();

            System.out.println("Screenshot saved: ");

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DataGUI();
    }
}

