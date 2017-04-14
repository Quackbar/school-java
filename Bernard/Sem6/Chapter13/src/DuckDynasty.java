import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;


public class DuckDynasty extends JFrame implements ActionListener{

    JLabel idL = new JLabel("Enter ducky ID(XXX): ");
    JLabel nameL = new JLabel("Enter ducky name: ");
    JLabel colorL = new JLabel("Enter ducky color: ");
    JLabel smackL = new JLabel("Enter smack of: ");

    JTextField idF = new JTextField();
    JTextField nameF = new JTextField();
    JTextField colorF = new JTextField();
    JTextField smackF = new JTextField();

    JPanel centerP = new JPanel();
    JPanel southP = new JPanel();

    JButton submit = new JButton("Submit");
    JButton view = new JButton("View Duckies");

    static Path path = Paths.get("ducky.txt");

    String ID_FORMAT = "XXX";
    String NAME_FORMAT = "          ";
    int nameLength = NAME_FORMAT.length();
    String COLOR_FORMAT = "          ";
    int colorLength = COLOR_FORMAT.length();
    String SMACK_FORMAT = "          ";
    int smackLength = SMACK_FORMAT.length();
    String delimiter = ",";

    StringBuilder sbName;
    StringBuilder sbColor;
    StringBuilder sbSmack;

    String s = ID_FORMAT + delimiter + NAME_FORMAT + delimiter + COLOR_FORMAT + delimiter + SMACK_FORMAT + System.getProperty("line.separator");
    int RESIZE = s.length();

    String name, color, smack, idS;
    int id;
    String EMPTY_ACCT = "XXX";
    String[] array;

    InputStream iStream;

    public DuckDynasty(){
        this.setLayout(new BorderLayout());
        this.add(centerP, BorderLayout.CENTER);
        centerP.setLayout(new GridLayout(4,2));
        centerP.add(idL);
        centerP.add(idF);
        centerP.add(nameL);
        centerP.add(nameF);
        centerP.add(colorL);
        centerP.add(colorF);
        centerP.add(smackL);
        centerP.add(smackF);
        this.add(southP, BorderLayout.SOUTH);
        southP.add(submit);
        submit.addActionListener(this);
        southP.add(view);
        view.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Submit")){
            boolean thing = false;
            try {
                id = Integer.parseInt(idF.getText());
            }catch (NumberFormatException a){
                thing = true;
            }
            idS = idF.getText();
            name = nameF.getText();
            sbName = new StringBuilder(name);
            sbName.setLength(nameLength);
            color = colorF.getText();
            sbColor = new StringBuilder(color);
            sbColor.setLength(colorLength);
            smack = smackF.getText();
            sbSmack = new StringBuilder(smack);
            sbSmack.setLength(smackLength);

            try{
                iStream = new BufferedInputStream(Files.newInputStream(path));
            }catch(Exception a){
                createEmptyFile(path, s);
            }
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
                s = reader.readLine();
                while(s != null){
                    array = s.split(delimiter);
                    System.out.println(array[0] + idS);
                    if(array[0].equals(idS)){
                        thing = true;
                    }
                    s = reader.readLine();
                }
                reader.close();
            }catch(Exception a){
                a.printStackTrace();
            }
            if(thing){
                JOptionPane.showMessageDialog(null, "Not a valid ID");
            }
            else{
                idF.setText("");
                idF.requestFocus();
                nameF.setText("");
                colorF.setText("");
                smackF.setText("");
                s = idS + delimiter + sbName + delimiter + sbColor + delimiter + sbSmack + System.getProperty("line.separator");
                System.out.println(s);
                byte data[] = s.getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(data);
                try {
                    FileChannel fc = (FileChannel)Files.newByteChannel(path, WRITE);
                    fc.position(id * RESIZE);
                    fc.write(buffer);
                    fc.close();
                }catch(Exception a) {
                    a.printStackTrace();
                }
            }
        }
        else if(e.getActionCommand().equals("View Duckies")){
            try{
                InputStream iStream = new BufferedInputStream(Files.newInputStream(path));
                BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
                s = reader.readLine();
                while(s != null){
                    array = s.split(delimiter);
                    if(!array[0].equals(EMPTY_ACCT)){
                        JOptionPane.showMessageDialog(null, "ID# " + array[0] + "\nName: " + array[1] + "\nColor: " + array[2] + "\nSmack Of: " + array[3]);
                    }
                    s = reader.readLine();
                }
                reader.close();
            }catch(Exception a){
                a.printStackTrace();
            }
        }
    }

    public static void createEmptyFile(Path file, String s) {
        final int NUMRECS = 1000;
        try{
            OutputStream outputStr = new BufferedOutputStream(Files.newOutputStream(file,CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStr));
            for(int count = 0; count < NUMRECS; ++count)
                writer.write(s, 0, s.length());
            writer.close();
        }
        catch (Exception e){
            System.out.println("Error message: " + e);
        }
    }

    public static void main(String[] args){
        DuckDynasty d = new DuckDynasty();
        d.setVisible(true);
        d.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        d.setTitle("Input Duckies");
        d.setSize(400,150);
    }
}
