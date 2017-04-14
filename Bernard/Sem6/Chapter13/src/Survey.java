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
import java.util.concurrent.ThreadLocalRandom;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

public class Survey extends JFrame implements ActionListener{
    JLabel title = new JLabel("Survey Mrs.Smith");
    JLabel description = new JLabel("Answer the quesiton on a scale of 1-10");
    JLabel[] questions = new JLabel[10];
    JTextField[] answers = new JTextField[10];
    JButton save = new JButton("Save");
    JButton view = new JButton("View");
    JButton back = new JButton("Back");
    JTextArea centerTextField = new JTextArea();
    Font fon = new Font("Verdana", Font.BOLD, 24);
    String[] arrayL;
    String delimiter = ",";
    String s = "";
    FileChannel fcIn = null;
    Path results = Paths.get("results.txt");
    String[] array;

    JPanel centerPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel eastPanel = new JPanel();

    public Survey(){
        this.setLayout(new BorderLayout());
        for(int i = 0; i < questions.length; i++){
            questions[i] = new JLabel();
            answers[i] = new JTextField();
        }
        this.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(10,2));
        for(int i = 0; i < questions.length; i++){
            centerPanel.add(questions[i]);
            centerPanel.add(answers[i]);
        }
        this.add(southPanel, BorderLayout.SOUTH);
        southPanel.setLayout(new GridLayout(1,2));
        southPanel.add(save);
        southPanel.add(view);
        questions[0].setText("What is your name");
        questions[1].setText("What is your grade");
        questions[2].setText("How do you feel about Smith(1 = bad)");
        questions[3].setText("How mean is Smith(1 = mean)");
        questions[4].setText("How Crazy is the duck obsession(1 = ridiculous)");
        questions[5].setText("Does Smith bully Sem 1 students(1 = yes)");
        questions[6].setText("Does Smith have a fair grading system (1 = no)");
        questions[7].setText("How would you grade Smith's overall performance(1 = bad)");
        questions[8].setText("Can Smith actually program(1 = no)");
        questions[9].setText("Any additional comments?");
        save.addActionListener(this);
        view.addActionListener(this);
        back.addActionListener(this);
        try {
            InputStream iStream = new BufferedInputStream(Files.newInputStream(results));
            BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
            s = reader.readLine();
            reader.close();
        }
        catch(Exception a){
            System.out.println("Message: "+ a);
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Save")){
            try {
                fcIn = (FileChannel) Files.newByteChannel(results, CREATE, WRITE);
                for(int i = 0; i < answers.length; i++) {
                    if(i == answers.length - 1) {
                        s = s + answers[i].getText() + delimiter + System.getProperty("line.separator");
                    }else{
                        s = s + answers[i].getText() + delimiter;
                    }
                }
                OutputStream outputStr = new BufferedOutputStream(Files.newOutputStream(results,CREATE));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStr));
                System.out.println(s);
                writer.write(s, 0, s.length());
                writer.close();
            }catch(Exception a){
                a.printStackTrace();
            }
        }
        else  if(e.getActionCommand().equals("View")){
            createView();
        }
        else if(e.getActionCommand().equals("Back")){
            createSurvey();
        }
    }

    public void createSurvey(){
        this.remove(centerTextField);
        this.remove(back);
        this.remove(eastPanel);
        for(int i = 0; i < questions.length; i++){
            questions[i] = new JLabel();
            answers[i] = new JTextField();
        }
        this.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(10,2));
        for(int i = 0; i < questions.length; i++){
            centerPanel.add(questions[i]);
            centerPanel.add(answers[i]);
        }
        questions[0].setText("What is your name");
        questions[1].setText("What is your grade");
        questions[2].setText("How do you feel about Smith(1 = bad)");
        questions[3].setText("How mean is Smith(1 = mean)");
        questions[4].setText("How Crazy is the duck obsession(1 = ridiculous)");
        questions[5].setText("Does Smith bully Sem 1 students(1 = yes)");
        questions[6].setText("Does Smith have a fair grading system (1 = no)");
        questions[7].setText("How would you grade Smith's overall performance(1 = bad)");
        questions[8].setText("Can Smith actually program(1 = no)");
        questions[9].setText("Any additional comments?");
        this.add(southPanel, BorderLayout.SOUTH);
        southPanel.setLayout(new GridLayout(1,2));
        southPanel.add(save);
        southPanel.add(view);
        this.repaint();
        this.revalidate();
    }
    public void createView(){
        for(int i = 0; i < questions.length; i++){
            centerPanel.remove(questions[i]);
            centerPanel.remove(answers[i]);
        }
        this.remove(centerPanel);
        this.add(centerTextField, BorderLayout.CENTER);
        arrayL = s.split(delimiter);
        for(int i = 1; i < arrayL.length + 1; i++) {
            if (i != 0) {
                if (i % 10 == 0) {
                    centerTextField.setText(centerTextField.getText() + arrayL[i -1] + System.getProperty("line" +
                            ".separator"));
                } else {
                    centerTextField.setText(centerTextField.getText() + arrayL[i -1 ] + " ");
                }
            } else {
                centerTextField.setText(centerTextField.getText() + arrayL[i - 1]);
            }
        }
        centerTextField.setFont(fon);
        centerTextField.setEditable(false);
        this.remove(southPanel);
        this.add(back, BorderLayout.SOUTH);
        this.add(eastPanel, BorderLayout.EAST);
        eastPanel.setBackground(Color.white);
        JTextArea fields = new JTextArea();
        double count = 0;
        for(int i = 0; i < arrayL.length; i ++){
            if(arrayL[i].length() > 1){
                if((i + 1) % 10 == 0) {
                    fields.setEditable(false);
                    fields.setFont(fon);
                    fields.setText(fields.getText() + "Grade: " + ((count/8) * 10) + "%" +System.getProperty(("line" +
                            ".separator")));
                    count = 0;
                }
                else{
                    count = 0;
                }
            }
            else{
                count = count + Double.parseDouble(arrayL[i]);
            }
        }
        eastPanel.add(fields);
        this.repaint();
        this.revalidate();
    }

    public static void main(String args[]){
        Survey s = new Survey();
        s.setVisible(true);
        s.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        s.setSize(800, 500);

    }
}
