// Example solution to Practical 6
import javax.swing.*;  // Required for the Swing components
import java.awt.*;  // Required for GridLayout

public class GraphicalCalculator {

    GraphicalCalculator() {
        // Create frame with grid layout
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(7,1);
        panel.setLayout(layout);

        // Create and add text fiels
        JTextField input = new JTextField(20);
        panel.add(input); 

        // Create and add the buttons
        JButton clear = new JButton("Clear");
        panel.add(clear);    
        JButton add = new JButton("Add (+)");  
        panel.add(add);             
        JButton subtract = new JButton("Subtract (-)"); 
        panel.add(subtract); 
        JButton multiply = new JButton("Multiply (*)");  
        panel.add(multiply);       
        JButton divide = new JButton("Divide (/)"); 
        panel.add(divide);       
        JButton result = new JButton("Result (=)");  

        // Finalise GUI creation
        panel.add(result);        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true); 
    }
    public static void main(String[] args) {
        new GraphicalCalculator();  // Simple!
    }
}