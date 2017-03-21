import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JFonts extends JFrame implements ActionListener
{
    JTextField nameLabel = new JTextField();
    JComboBox fontBox = new JComboBox();
    JComboBox sizeBox = new JComboBox();
    int size;
    String fonty;
    int o;
    Font font = new Font("Arial", Font.PLAIN, 100);
    String[] textFonts = {"Font","Arial","Baskerville Old Face","Bodoni MT","Calibri","Century","Century Gothic","Chiller","Comic Sans MS","Impact","Jokerman","Lucida Bright","Lucida Calligraphy","Magneto","Microsoft Sans Serif","Papyrus","Rage Italic","SansSerif","Times New Roman","Trebuchet MS","Verdana","Webdings"};
    String[] textSize = {"Size","Custom","5","10                        ","15","20","25","30","35","40","45","50","55","60","65","70","75","80","85","90","95","100"};

    JPanel top = new JPanel();
   //JPanel bottom = new JPanel();

    public JFonts()
    {
        this.setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        top.add(fontBox);
        fontBox.addActionListener(this);
        top.add(sizeBox);
        sizeBox.addActionListener(this);
        add(nameLabel, BorderLayout.CENTER);
        nameLabel.setEditable(false);
        nameLabel.setText("Helena High School");
        nameLabel.setFont(font);
        for(int i=0; i<textFonts.length; i++)
        {
            fontBox.addItem(textFonts[i]);
        }
        for(int i=0; i<textSize.length; i++)
        {
            sizeBox.addItem(textSize[i]);
        }

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == fontBox)
        {
            o = fontBox.getSelectedIndex();
            fonty = textFonts[o];
            Font fon = new Font(fonty, Font.PLAIN, size);
            nameLabel.setFont(fon);
        }
        else
        {
            o = sizeBox.getSelectedIndex();
            try
            {
                size = Integer.valueOf(textSize[o]);
            }
            catch (NumberFormatException a)
            {
                if(o == 1)
                {
                    size = Integer.valueOf(JOptionPane.showInputDialog(null, "Enter size"));
                }
                else
                {

                }
            }
            Font fon = new Font(fonty, Font.PLAIN, size);
            nameLabel.setFont(fon);
        }

    }
    public static void main(String[] args)
    {
        JFonts f = new JFonts();
        f.setVisible(true);
        f.setBounds(0,0,1200,900);
    }
}