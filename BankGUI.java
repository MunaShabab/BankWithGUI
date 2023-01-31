import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
 
public class BankGUI extends JFrame implements ActionListener{
    public JLabel infoLable=new JLabel("                  Please select one of the following transactions                  ");
    public JLabel typeLbl= new JLabel(     "Type: ");
    public JRadioButton depositBtn= new JRadioButton("Deposit",true);
    public JRadioButton withdrawBtn= new JRadioButton("Withdrawal");
    public JRadioButton miscBtn= new JRadioButton("Miscellaneous");
    public ButtonGroup transTypeGroup= new ButtonGroup();
    public JLabel amtLbl= new JLabel("         Amount: ");
    public JTextField amtText=new JTextField(8);
    public JLabel descLbl= new JLabel("                         Description:                       ");
    public JTextField descText= new JTextField(25);
    public JButton completeBtn= new JButton("Complete Transaction");
    public JLabel transAmtLbl=new JLabel(" ");
    public JLabel statusLbl= new JLabel("");
    public JLabel transLbl1= new JLabel("_______________________________________________________________");
    public JPanel transPanel= new JPanel();
    private Account account1=null;
    private Deposit deposit1=null;
    private Withdrawal withdrawal1=null;
    private Miscellaneous miscTrans1=null;
     

    public static void main(String[] args){
        
        
        new BankGUI("Transaction");
        
    }
    BankGUI(String title){
        ArrayList<Transaction> transactionList1= new ArrayList<Transaction>();
        account1= new Account(220345,"John","Doe","234 Rangler St.","Detroit","MI",42896,"6307772091",0,transactionList1);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p=new JPanel(new FlowLayout(FlowLayout.CENTER,10,30));
        transPanel.setLayout(new BoxLayout(transPanel, BoxLayout.Y_AXIS));
        completeBtn.addActionListener(this);
        transTypeGroup.add(depositBtn);
        transTypeGroup.add(withdrawBtn);
        transTypeGroup.add(miscBtn);
        p.add(infoLable);
        p.add(typeLbl);
        p.add(depositBtn);
        p.add(withdrawBtn);
        p.add(miscBtn);
        p.add(amtLbl);
        p.add(amtText);
        p.add(descLbl);
        p.add(descText);
        p.add(completeBtn);
        p.add(transAmtLbl);
        p.add(statusLbl);
        transPanel.add(transLbl1);
        p.add(transPanel);
        this.getContentPane().add(p);
        this.setSize(450,500);

    }
    public void actionPerformed(ActionEvent e){
        double amount= Double.parseDouble(amtText.getText());
        String description=descText.getText();
        
        JLabel transLbl=new JLabel("");
        transPanel.add(transLbl,1);
        
        if(depositBtn.isSelected()){
            try{
                deposit1=new Deposit(account1,description,amount);
                deposit1.CompleteDeposit();
                account1.AddTransaction(deposit1);
                transAmtLbl.setText("$"+String.valueOf(amount));
                statusLbl.setText("OK! and the account balance is: "+ account1.GetBalance());
                transLbl.setText(deposit1.ToString());
               
            }
            catch(Exception exception){
                statusLbl.setText(exception.toString());
            }
            

        }
        if(withdrawBtn.isSelected()){
            try{
                withdrawal1=new Withdrawal(account1, description,amount);
                withdrawal1.CompleteWithdrawal();
                account1.AddTransaction(withdrawal1);
                transAmtLbl.setText("$"+String.valueOf(amount));
                statusLbl.setText("OK! and the account balance is: "+ account1.GetBalance());
                transLbl.setText(withdrawal1.ToString());
                transPanel.add(transLbl);
            }
            catch(Exception exception){
                statusLbl.setText(exception.toString());
            }
        }
        if(miscBtn.isSelected()){
            miscTrans1=new Miscellaneous(account1, description,amount);
            try{
                miscTrans1.CompleteMiscTrans();
                account1.AddTransaction(miscTrans1);
                transAmtLbl.setText("$"+String.valueOf(amount));
                statusLbl.setText("OK! and the account balance is: "+ account1.GetBalance());
                transLbl.setText(miscTrans1.ToString());
                transPanel.add(transLbl);

            }
            catch(Exception exception){
                statusLbl.setText(exception.toString());
            }

        }
        
    }

}