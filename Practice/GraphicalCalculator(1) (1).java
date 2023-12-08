// Example solution to Practical 7
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicalCalculator {

    protected JTextField input;
    protected JButton clear, add, subtract, multiply, divide, result;
    protected int status;
    protected float storedValue;
    protected JFrame frame;

    float parseValue() {
        
        // Task 7.2: error handling
        try {
            return Float.parseFloat(input.getText());
        } catch(NumberFormatException ex) {        
            JOptionPane.showMessageDialog(frame, "Illegal input!");
            status = 0;
            storedValue = 0;
            input.setText("");
        }
        return 0F;    
    }
    GraphicalCalculator() {
        
        // Initialise
        status = 0;
        storedValue = 0;
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(7,1);
        panel.setLayout(layout);
        input = new JTextField(20);
        panel.add(input);   

        // Button clear
        clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input.setText("");
                input.requestFocusInWindow();
                status = 0;
                storedValue = 0;              
            }     
        }); 
        panel.add(clear);

        // Button add
        add = new JButton("Add (+)");  
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                storedValue = parseValue();
                input.setText("");
                input.requestFocusInWindow();
                status = 1;
            }     
        }); 
        panel.add(add);

        // Button subtract       
        subtract = new JButton("Subtract (-)"); 
        subtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                storedValue = parseValue();
                input.setText("");
                input.requestFocusInWindow();
                status = 2;
            }     
        });   
        panel.add(subtract); 

        // Button multiply
        multiply = new JButton("Multiply (*)");  
        multiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                storedValue = parseValue();
                input.setText("");
                input.requestFocusInWindow();
                status = 3;
            }     
        });        
        panel.add(multiply);     
    
        // Button divide
        divide = new JButton("Divide (/)"); 
        divide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                storedValue = parseValue();
                input.setText("");
                input.requestFocusInWindow();
                status = 4;
            }     
        }); 
        panel.add(divide);     

        // Button result
        result = new JButton("Result (=)");  
        result.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(status == 0)
                    return;
                else if(status == 1)  
                    storedValue += parseValue();
                else if(status == 2)  
                    storedValue -= parseValue();
                else if(status == 3)  
                    storedValue *= parseValue();
                else if(status == 4) {
                    float divider = parseValue();
                    if(divider == 0) {
                        storedValue = 0;
                        status = 0;
                        input.setText("Division by zero!");
                        return;
                    }
                    storedValue /= parseValue();
                } 
                input.setText(String.valueOf(storedValue));
                input.requestFocusInWindow();
                status = 0;
           }     
        }); 
        panel.add(result);     

        // Finalise
        frame.add(panel);
        frame.pack();
        frame.setVisible(true); 
    }
    public static void main(String[] args) {
        new GraphicalCalculator();
    }
}