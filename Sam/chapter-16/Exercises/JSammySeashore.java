/**
 * Created by bernard on 4/16/17.
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class JSammySeashore extends JFrame implements ActionListener{
    String[] rentals = {"Jet Ski", "Pontoon Boat", "Rowboat", "Canoe", "Kayak", "Beach Chair", "Umbrella"};
    int[] prices = {40, 40, 20, 20, 20, 7, 7};
    int hrs, price, index;
    boolean valid = false;

    JLabel timeLabel = new JLabel("Enter time of Rental");
    JLabel equipLabel = new JLabel("Select what you are renting");
    JLabel lessonLabel = new JLabel("Optional equipment rental");
    JLabel detailsLabel = new JLabel();
    JLabel priceLabel = new JLabel();

    JTextField timeField = new JTextField();
    JComboBox rentalBox = new JComboBox(rentals);
    JCheckBox lessonBox = new JCheckBox();
    JButton submit = new JButton("Submit");

    //Layout Panels
    JSammySeashoreLogo leftPanel = new JSammySeashoreLogo();
    JPanel rightPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    public JSammySeashore(){
        this.setLayout(new GridLayout(1, 2));
        this.add(leftPanel);
        this.add(rightPanel);
        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(3, 2));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(timeLabel);
        centerPanel.add(timeField);
        centerPanel.add(equipLabel);
        centerPanel.add(rentalBox);
        rentalBox.setBackground(Color.WHITE);
        centerPanel.add(lessonLabel);
        centerPanel.add(lessonBox);
        lessonBox.setBackground(Color.WHITE);
        rightPanel.add(southPanel, BorderLayout.SOUTH);
        southPanel.setLayout(new GridLayout(3, 1));
        southPanel.setBackground(Color.YELLOW);
        southPanel.add(buttonPanel);
        buttonPanel.setBackground(Color.BLUE);
        buttonPanel.add(submit);
        submit.addActionListener(this);
        southPanel.add(detailsLabel);
        southPanel.add(priceLabel);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit){
            try{
                hrs = Integer.valueOf(timeField.getText());
                valid = true;
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Not a valid input for hours field");
                valid = false;
            }
            if(valid){
                index = rentalBox.getSelectedIndex();
                price = prices[index] * hrs;
                if(lessonBox.isSelected()){
                    price += 5;
                }
            }
            detailsLabel.setText("The rental is one " + rentalBox.getSelectedItem() + " for " + timeField.getText() + " hours");
            priceLabel.setText("Final price: $" + price);
        }
    }

    public static void main(String[] args){
        JSammySeashore f = new JSammySeashore();
        f.setVisible(true);
        f.setSize(1000, 250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
