import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class W2Form extends JFrame implements ActionListener
{
    DataOutputStream output;

    JTextArea[] f = new JTextArea[41];
    JLabel[] l = new JLabel[33];
    PaintPanel paintP = new PaintPanel("W2.jpg");
    JLabel d = new JLabel("22222");
    JTextArea e = new JTextArea();
    JTextArea g = new JTextArea();
    JTextArea h = new JTextArea();
    JTextArea i = new JTextArea();
    JLabel ombLabel = new JLabel("OMB No. 1545-0008");
    JLabel irsLabel = new JLabel("Visit the IRS website at");
    JLabel webLabel = new JLabel("www.irs.gov/efile");

    Checkbox aBox = new Checkbox("",false);
    Checkbox bBox = new Checkbox("",false);
    Checkbox cBox = new Checkbox("",false);

    JLabel c1 = new JLabel("<html> C <br> o <br> d <br> e </html>");
    JLabel o2 = new JLabel("<html> C <br> o <br> d <br> e </html>");
    JLabel d3 = new JLabel("<html> C <br> o <br> d <br> e </html>");
    JLabel e4 = new JLabel("<html> C <br> o <br> d <br> e </html>");

    Font fon = new Font("cuckoo", Font.PLAIN, 15);
    Font fonI = new Font("cuckoo", Font.ITALIC, 15);
    Font fonM = new Font("cuckoo", Font.PLAIN, 20);
    Font fonS = new Font("cuckoo", Font.PLAIN, 12);
    Font fonSS = new Font("cuckoo", Font.PLAIN, 6);
    Font fonL = new Font("cuckoo", Font.BOLD, 36);

    Button bun = new Button("Submit Form");

	Date today = new Date();
	SimpleDateFormat myFormat = new SimpleDateFormat("MMddyyyy");
	String filename = "W2FormSubmit" + myFormat.format(today);

    public W2Form()
    {
        for (int i = 0; i < f.length; i++)
        {
            f[i] = new JTextArea();
            f[i].setOpaque(false);
            //f[i].setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        f[19].setOpaque(true);
        for (int i = 0; i < l.length; i++)
        {
            l[i] = new JLabel();
            l[i].setFont(fon);
        }
        c1.setFont(fonSS);
        o2.setFont(fonSS);
        d3.setFont(fonSS);
        e4.setFont(fonSS);
        l[18].setFont(fonS);
        l[19].setFont(fonS);
        l[20].setFont(fonS);
        d.setFont(fonL);
        this.setLayout(new BorderLayout());
        add(paintP, BorderLayout.CENTER);
        paintP.setLayout(null);
        paintP.setBackground(Color.white);
        paintP.add(d);
        d.setBounds(75, 15, 200, 30);
        paintP.add(h);
        h.setBackground(Color.gray);
        h.setBounds(700, 275, 266, 30);
        paintP.add(i);
        i.setBackground(Color.gray);
        i.setBounds(967, 546, 276, 22);
        paintP.add(f[0]);
        f[0].setBounds(280, 20, 293, 35);
        paintP.add(l[0]);
        l[0].setText("a Employee's social security number");
        l[0].setBounds(280, 0, 300, 20);
        paintP.add(f[1]);
        f[1].setBounds(20, 75, 668, 35);
        paintP.add(l[1]);
        l[1].setText("b Employer identification number (EIN)");
        l[1].setBounds(20, 55, 668, 20);
        paintP.add(f[2]);
        f[2].setBounds(20, 130, 668, 144);
        paintP.add(l[2]);
        l[2].setText("c Employer's name, address, and ZIP code");
        l[2].setBounds(20, 110, 668, 20);
        paintP.add(f[3]);
        f[3].setBounds(20, 294, 668, 35);
        paintP.add(l[3]);
        l[3].setText("d Control number");
        l[3].setBounds(20, 274, 668, 20);
        paintP.add(f[4]);
        f[4].setBounds(20, 349, 250, 200);
        paintP.add(e);
        e.setBounds(290, 349, 140, 200);
        paintP.add(g);
        g.setBounds(463, 349, 100, 200);
        paintP.add(l[4]);
        l[4].setText("e Employee's name and initials                 Last name                         Suff.");
        l[4].setBounds(20, 329, 668, 20);
        paintP.add(l[5]);
        l[5].setText("f Employee's address and ZIP code:");
        l[5].setBounds(20, 548, 668, 20);
        paintP.add(f[29]);
        f[29].setBounds(275, 549, 378, 20);
        paintP.add(l[6]);
        l[6].setText("15 State");
        l[6].setBounds(20, 571, 80, 20);
        paintP.add(f[28]);
        f[28].setBounds(30, 590, 40, 30);
        paintP.add(f[5]);
        f[5].setBounds(100, 590, 230, 30);
        paintP.add(l[7]);
        l[7].setText("Employer's state ID number");
        l[7].setBounds(100, 570, 360, 20);
        paintP.add(f[6]);
        f[6].setBounds(340, 590, 193, 30);
        paintP.add(l[8]);
        l[8].setText("16 State wages, tips, etc.");
        l[8].setBounds(340, 570, 193, 20);
        paintP.add(f[7]);
        f[7].setBounds(545, 590, 170, 30);
        paintP.add(l[9]);
        l[9].setText("17 State income tax");
        l[9].setBounds(545, 570, 280, 20);
        paintP.add(f[8]);
        f[8].setBounds(725, 590, 196, 30);
        paintP.add(l[10]);
        l[10].setText("18 Local wages, tips, etc.");
        l[10].setBounds(725, 570, 196, 20);
        paintP.add(f[9]);
        f[9].setBounds(930, 590, 170, 30);
        paintP.add(l[11]);
        l[11].setText("19 Local income tax");
        l[11].setBounds(930, 570, 180, 20);
        paintP.add(f[10]);
        f[10].setBounds(1110, 590, 130, 30);
        paintP.add(l[12]);
        l[12].setText("20 Locality name");
        l[12].setBounds(1110, 570, 130, 20);
        paintP.add(f[11]);
        f[11].setBounds(688, 75, 280, 35);
        paintP.add(l[13]);
        l[13].setText("1 Wages, tips, other compensations");
        l[13].setBounds(688, 55, 280, 20);
        paintP.add(f[12]);
        f[12].setBounds(968, 75, 273, 35);
        paintP.add(l[22]);
        l[22].setText("2 Fedral income tax withheld");
        l[22].setBounds(968, 55, 278, 20);
        paintP.add(f[13]);
        f[13].setBounds(688, 130, 280, 35);
        paintP.add(l[14]);
        l[14].setText("3 Social security wages");
        l[14].setBounds(688, 110, 280, 20);
        paintP.add(f[14]);
        f[14].setBounds(968, 130, 273, 35);
        paintP.add(l[23]);
        l[23].setText("4 Social security tax withheld");
        l[23].setBounds(968, 110, 280, 20);
        paintP.add(f[15]);
        f[15].setBounds(688, 185, 280, 35);
        paintP.add(l[15]);
        l[15].setText("5 Medicare wages and tips");
        l[15].setBounds(688, 165, 280, 20);
        paintP.add(f[16]);
        f[16].setBounds(968, 185, 273, 35);
        paintP.add(l[24]);
        l[24].setText("6 Medicare tax withheld");
        l[24].setBounds(968, 165, 280, 20);
        paintP.add(f[17]);
        f[17].setBounds(688, 240, 280, 35);
        paintP.add(l[16]);
        l[16].setText("7 Social security tips");
        l[16].setBounds(688, 220, 280, 20);
        paintP.add(f[18]);
        f[18].setBounds(968, 240, 273, 35);
        paintP.add(l[25]);
        l[25].setText("8 Allocated tips");
        l[25].setBounds(968, 220, 280, 20);
        paintP.add(f[19]);
        f[19].setBounds(688, 293, 278, 34);
        f[19].setEditable(false);
        f[19].setBackground(Color.gray);
        paintP.add(l[31]);
        l[31].setText("9");
        l[31].setBounds(688, 275, 280, 20);
        l[31].setBackground(Color.white);
        paintP.add(f[20]);
        f[20].setBounds(968, 295, 273, 34);
        paintP.add(l[26]);
        l[26].setText("10 Dependent care benefits");
        l[26].setBounds(968, 275, 280, 20);
        paintP.add(f[21]);
        f[21].setBounds(688, 350, 280, 35);
        paintP.add(l[17]);
        l[17].setText("11 Nonqualified plans");
        l[17].setBounds(688, 330, 280, 20);
        paintP.add(f[22]);
        f[22].setBounds(1050, 350, 193, 35);
        paintP.add(l[27]);
        l[27].setText("12a See Instructions for box 12");
        l[27].setBounds(968, 330, 280, 20);
        paintP.add(l[32]);
        l[32].setText("13");
        l[32].setBounds(688, 370, 50, 50);
        paintP.add(aBox);
        aBox.setBounds(738, 415, 20, 20);
        paintP.add(bBox);
        bBox.setBounds(815, 415, 20, 20);
        paintP.add(cBox);
        cBox.setBounds(895, 415, 20, 20);
        paintP.add(l[18]);
        l[18].setText("<html>Statuary <br> employee</html>");
        l[18].setBounds(725, 385, 90, 30);
        paintP.add(l[19]);
        l[19].setText("<html>Retirement <br>     plan</html>");
        l[19].setBounds(800, 385, 90, 30);
        paintP.add(l[20]);
        l[20].setText("<html>Third party <br> sick pay</html>");
        l[20].setBounds(885, 385, 90, 30);
        paintP.add(l[31]);
        l[31].setText("13");
        l[31].setBounds(690, 385, 20, 20);
        paintP.add(f[24]);
        f[24].setBounds(687, 460, 277, 108);
        paintP.add(l[21]);
        l[21].setText("14 Other");
        l[21].setBounds(690, 435, 90, 20);
        paintP.add(f[25]);
        f[25].setBounds(1050, 403, 193, 35);
        paintP.add(l[28]);
        l[28].setText("12b");
        l[28].setBounds(967, 360, 70, 70);
        paintP.add(f[26]);
        f[26].setBounds(1050, 458, 193, 35);
        paintP.add(f[27]);
        f[27].setBounds(1050, 514, 193, 35);
        paintP.add(l[29]);
        l[29].setText("12c");
        l[29].setBounds(967, 415, 70, 70);
        paintP.add(l[30]);
        l[30].setText("12d");
        l[30].setBounds(967, 469, 70, 70);
        paintP.add(l[31]);
        l[31].setText("9");
        l[31].setBounds(688, 275, 20, 20);
        paintP.add(f[30]);
        f[30].setBounds(989, 348, 55, 35);
        paintP.add(f[31]);
        f[31].setBounds(989, 403, 55, 35);
        paintP.add(f[32]);
        f[32].setBounds(989, 458, 55, 35);
        paintP.add(f[33]);
        f[33].setBounds(989, 514, 55, 35);
        paintP.add(f[34]);
        f[34].setBounds(21,627,60,48);
        paintP.add(f[35]);
        f[35].setBounds(89,627,250,48);
        paintP.add(f[36]);
        f[36].setBounds(343,627,200,48);
        paintP.add(f[37]);
        f[37].setBounds(548,627,175,48);
        paintP.add(f[38]);
        f[38].setBounds(728,627,200,48);
        paintP.add(f[39]);
        f[39].setBounds(932,627,175,48);
        paintP.add(f[40]);
        f[40].setBounds(1110,627,132,48);
        paintP.add(c1);
        c1.setBounds(973, 347, 10, 30);
        paintP.add(o2);
        o2.setBounds(973, 403, 10, 30);
        paintP.add(d3);
        d3.setBounds(973, 459, 10, 30);
        paintP.add(e4);
        e4.setBounds(973, 515, 10, 30);
        paintP.add(bun);
        bun.setBounds(530, 690, 120, 20);
        bun.setFont(fon);
        bun.addActionListener(this);
        paintP.add(ombLabel);
        ombLabel.setBounds(583, 30, 200, 20);
        ombLabel.setFont(fon);
        paintP.add(irsLabel);
        irsLabel.setBounds(1066,4,200,20);
        irsLabel.setFont(fon);
        paintP.add(webLabel);
        webLabel.setBounds(1066,26,200,20);
        webLabel.setFont(fonI);
    }
    public void actionPerformed(ActionEvent e)
    {
		String a = "false";
		String b = "false";
		String c = "false";

		if(aBox.getState() == true);
		{
			a = "true";
		}
		if(bBox.getState() == true);
		{
			b = "true";
		}
		if(cBox.getState() == true);
		{
			c = "true";
		}
        if (e.getSource() == bun)
        {
			try
			{
				output = new DataOutputStream(new FileOutputStream(filename));
				JOptionPane.showMessageDialog(null,"Your file has been saved.");
			}
			catch(Exception ex)
            {
				JOptionPane.showMessageDialog(null,"A storage space was not able to be created.");
			}
            try
            {
                for(int i = 0; i<f.length; i++)
                {
                    output.writeUTF(f[i].getText());
                }
                output.writeUTF(a);
				output.writeUTF(b);
				output.writeUTF(c);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"Your form was not able to be saved.");
            }
        }
    }

    public static void main(String[] args)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        W2Form w = new W2Form();
        w.setVisible(true);
        w.setBounds(0,0,width,height);
    }
}