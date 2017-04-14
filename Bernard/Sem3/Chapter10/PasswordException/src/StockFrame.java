import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;

public class StockFrame extends JFrame implements ActionListener, WindowListener{
    String stockSymbol;

    JTextField jtfStockSymbol;
    JButton jbtAddStock, jbtLogout;
    JComboBox jcbStockList;
    Activator caller;

    public StockFrame(User user, Activator callerObj) {
        super("Add Stock Symbols");

        int width = 330;
        int height = 170;
        caller = callerObj;

        JLabel label1 = new JLabel("Symbol:");
        jtfStockSymbol = new JTextField(4);
        jbtAddStock = new JButton("Add Symbol");

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 3));
        p1.add(label1);
        p1.add(jtfStockSymbol);
        p1.add(jbtAddStock);
        p1.setBorder(new TitledBorder("Add Stock Symbol"));

        JLabel label2 = new JLabel();
        jcbStockList = new JComboBox();

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 2));
        p2.add(label2);
        p2.add(jcbStockList);
        p2.setBorder(new TitledBorder("View Stock Symbols"));

        JLabel label3 = new JLabel();
        jbtLogout = new JButton("Log Out");

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 2));
        p3.add(label3);
        p3.add(jbtLogout);
        p3.setBorder(new TitledBorder("Current User"));

        JPanel p4 = new JPanel();
        p4.setLayout(new GridLayout(3, 1, 10, 5));
        p4.add(p1);
        p4.add(p2);
        p4.add(p3);

        JPanel p5 = new JPanel(new BorderLayout(10, 10));
        p5.add(p4, BorderLayout.WEST);
        JPanel p6 = new JPanel((new BorderLayout(10, 10)));
        p6.add(p5, BorderLayout.EAST);

        setContentPane(p6);

        addWindowListener(this);
        jbtAddStock.addActionListener(this);
        jbtLogout.addActionListener(this);
        jcbStockList.addActionListener(this);

        pack();
        if (width < getWidth())
            width = getWidth();
        if (height < getHeight())
            height = getHeight();
        centerOnScreen(width, height);
        jtfStockSymbol.setText("");
        jtfStockSymbol.requestFocus();
    }

    public void centerOnScreen(int width, int height){
        int top , left, x, y;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        x = (screenSize.width - width)/2;
        y = (screenSize.height - height)/2;
        left = (x < 0) ? 0: x;
        top = (y < 0) ? 0: y;

        this.setBounds(left, top, width, height);
    }

    public boolean stockInList(String stock){
        boolean inList = false;
        int numItems;

        numItems = jcbStockList.getItemCount();
        stock.trim();
        if(numItems > 0){
            for(int i = 0; i < numItems && !inList; i++){
                if(stock.equals((String)jcbStockList.getItemAt(i)))
                inList = true;
            }
        }
        return inList;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == jbtLogout){
            logoutUser();
        }
        else
        if(e.getSource() == jbtAddStock){
            stockSymbol = jtfStockSymbol.getText();
            if(stockSymbol.equals(""))
                JOptionPane.showMessageDialog(null,"Please enter a stock symbol to add");
            else{
                if(!stockInList(stockSymbol))
                    jcbStockList.addItem(stockSymbol);
            }
            jtfStockSymbol.setText("");
            jtfStockSymbol.requestFocus();
        }
        else
        if(e.getSource() == jcbStockList){
            stockSymbol = (String)jcbStockList.getSelectedItem();
            if(stockSymbol == null)
                JOptionPane.showMessageDialog(null, "Please add the stock to the list");
            else
                jtfStockSymbol.setText(stockSymbol);
        }
        else {
            JOptionPane.showMessageDialog(this, "Please choose a valid action");
        }
    }

    private void logoutUser(){
        this.setVisible(false);
        dispose();
        caller.activate();
    }

    public void windowOpened(WindowEvent event){
        jtfStockSymbol.setText("");
        jtfStockSymbol.requestFocus();
    }

    public void windowClosing(WindowEvent event){
        logoutUser();
    }

    public void windowClosed(WindowEvent event){}
    public void windowIconified(WindowEvent event){}
    public void windowDeiconified(WindowEvent event){}
    public void windowActivated(WindowEvent event){}
    public void windowDeactivated(WindowEvent event){}
}
