import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.TitledBorder;

public class LogonFrame extends JFrame implements ActionListener, Activator{

    int maxUsers = 3;
    ArrayList userList = new ArrayList();
    User user = null;
    String userName;
    String password;

    JTextField userNameField;
    JPasswordField passwordField;
    JButton jbtAddUser, jbtChgPswd, jbtLogon;

    public LogonFrame(){

        super("Log on or Maintain User");
        int width = 330;
        int height = 170;
        JLabel label1 = new JLabel("User Name: ");
        userNameField = new JTextField(20);
        JLabel label2 = new JLabel("Password:   ");
        passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');
        jbtAddUser = new JButton("Add new user");
        jbtChgPswd = new JButton("Change user pswd");
        jbtLogon = new JButton("Log on");
        JPanel userPanel= new JPanel(new BorderLayout());
        userPanel.add(label1,BorderLayout.WEST);
        userPanel.add(userNameField,BorderLayout.CENTER);
        JPanel pswdPanel= new JPanel(new BorderLayout());
        pswdPanel.add(label2,BorderLayout.WEST);
        pswdPanel.add(passwordField,BorderLayout.CENTER);
        JPanel logonButtonPanel= new JPanel(new FlowLayout());
        logonButtonPanel.add(jbtLogon);
        JPanel maintButtonPanel= new JPanel(new FlowLayout());
        maintButtonPanel.add(jbtAddUser);
        maintButtonPanel.add(jbtChgPswd);
        JPanel contentPanel= new JPanel(new BorderLayout());
        contentPanel.add(userPanel, BorderLayout.NORTH);
        contentPanel.add(pswdPanel, BorderLayout.CENTER);
        contentPanel.add(logonButtonPanel, BorderLayout.SOUTH);
        contentPanel.setBorder(new TitledBorder("Enter User Info"));
        JPanel p2 = new JPanel(new BorderLayout());
        p2.add(contentPanel, BorderLayout.NORTH);
        p2.add(maintButtonPanel, BorderLayout.SOUTH);
        JPanel p3 = new JPanel(new BorderLayout(10,10));
        p3.add(p2, BorderLayout.WEST);
        JPanel p4 = new JPanel(new BorderLayout(10,10));
        p4.add(p3, BorderLayout.EAST);

        setContentPane(p4);

        jbtAddUser.addActionListener(this);
        jbtChgPswd.addActionListener(this);
        jbtLogon.addActionListener(this);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        InputMap map;

        map = jbtAddUser.getInputMap();

        if (map != null){
            map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false), "pressed");
            map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,true), "released");
        }

        map = jbtChgPswd.getInputMap();

        if (map != null){
            map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false), "pressed");
            map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,true), "released");
        }

        map = jbtLogon.getInputMap();

        if (map != null){
            map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false), "pressed");
            map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,true), "released");
        }



        pack();
        if( width < getWidth())
            width = getWidth();

        if(height < getHeight())
            height = getHeight();

        centerOnScreen(width, height);
    }

    public void centerOnScreen(int width, int height) {

        int top, left, x, y;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x = (screenSize.width - width)/2;
        y = (screenSize.height - height)/2;
        left = (x < 0) ? 0 : x;
        top = (y < 0) ? 0 : y;

        this.setBounds(left, top, width, height);
    }



    private boolean userExists(String userName) {

        boolean userInList = false;
        userName.trim();

        if(userList.size()>0){
            for(int i=0; i < userList.size() && !userInList; ++i){
                user = (User)userList.get(i);
                if(userName.equals(user.getName()))
                    userInList = true;
            }
        }
        return userInList;
    }

    private boolean addToList(User user) {
        boolean success = false;
        if(userList.size() < maxUsers)
            success = userList.add(user);
        return success;
    }

    private void doStockActivity() {

        StockFrame frame = new StockFrame(user,this);
        frame.pack();
        setVisible(false);
        frame.setVisible(true);
    }

    public void activate() {
        setVisible(true);
        userNameField.setText("");
        userNameField.requestFocus();
    }



    public void actionPerformed(ActionEvent e) {

        try{
            userName = userNameField.getText();
            if(userName.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a valid username.", "Missing user Name.", JOptionPane.ERROR_MESSAGE);
                userNameField.requestFocus();
            }
            else{
                password = new String(passwordField.getPassword());
                if(password.equals("")) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid password.", "Missing Password.", JOptionPane.ERROR_MESSAGE);
                    passwordField.requestFocus();
                }
                else {
                    if(e.getSource() == jbtAddUser) {
                        if(!userExists(userName)) {
                            user = new User(userName, password,4);
                            if(addToList(user))
                                JOptionPane.showMessageDialog(this, "Success! " + user.getName()+" has been added.");
                            else
                                JOptionPane.showMessageDialog(this, "Could not add new user " +user.getName());
                        }
                        else
                            JOptionPane.showMessageDialog(this, "user " +user.getName() + "Already exists!");
                    }
                    else if(e.getSource() == jbtLogon) {
                        if(userExists(userName)){
                            user.validate(password);
                            if(user.pswdIsExpiring())
                                JOptionPane.showMessageDialog(this, user.getName() + "logon successful: " +user.getPswdUses()+ "use(s) remaining.");
                            doStockActivity();
                        }
                        else
                            JOptionPane.showMessageDialog(this, "Invalid user.");
                    }
                    else if(e.getSource() == jbtChgPswd) {
                        if(userExists(userName)){
                            user.validate(password);
                            JLabel passwd=new JLabel("New Password");
                            JPasswordField pword=new JPasswordField(20);
                            Object[] ob={passwd, pword};
                            JOptionPane.showMessageDialog(this, ob);
                            String newPassword = new String(pword.getPassword());
                            user.changePassword(password,newPassword);
                            JOptionPane.showMessageDialog(this, "Success, " +user.getName() +"! You Password has been Changed");
                            doStockActivity();
                        }
                        else
                            JOptionPane.showMessageDialog(this, "Invalid User.");
                    }
                    else
                        JOptionPane.showMessageDialog(this, "Please choose a valid action");
                }
            }
            userNameField.setText("");
            passwordField.setText("");
            userNameField.requestFocus();
        }
        catch (PasswordUsedException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage() +'\n'+ex.usage(), "Invalid Password. Try again.", JOptionPane.ERROR_MESSAGE);
        }

        catch (PasswordSizeException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage()+'\n'+ex.usage(), "Invalid password. Try again.", JOptionPane.ERROR_MESSAGE);
        }

        catch (PasswordInvalidFormatException ex) {
            if(ex.getCount() > 2)
                System.exit(0);
            else
                JOptionPane.showMessageDialog(this,ex.getMessage() +'\n'+ex.usage() +"\nNumber of invalid attempts: "+ex.getCount(), "Invalid password format. try again.", JOptionPane.ERROR_MESSAGE);
        }

        catch (PasswordInvalidException ex) {
            if(ex.getCount() > 2)
                System.exit(0);
            else
                JOptionPane.showMessageDialog(this,ex.getMessage() +'\n'+ex.usage() +"\nNumber of invalid attempts: "+ex.getCount(), "Invalid password format. try again.", JOptionPane.ERROR_MESSAGE);
        }

        catch (PasswordException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage()+'\n'+ex.usage(), "Invalid Password. Try again.", JOptionPane.ERROR_MESSAGE);
        }

        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Unspecified Exception. ",JOptionPane.ERROR_MESSAGE);
        }

    }
}
