import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
public class UnitTest{
    public static void main(String[] args){
        
        //create few Account objects and add them to the accountList ArrayList
        ArrayList<Account> accountList= new ArrayList<Account>();
        ArrayList<Transaction> transactionList1= new ArrayList<Transaction>();
        ArrayList<Transaction> transactionList2= new ArrayList<Transaction>();
        ArrayList<Transaction> transactionList3= new ArrayList<Transaction>();
        Account account1= new Account(220345,"John","Doe","234 Rangler St.","Detroit","MI",42896,"6307772091",1200,transactionList1);
        accountList.add(account1);
        System.out.println("account1 balance befor deposit: $"+ String.format("%.2f",account1.GetBalance()));
        Transaction transaction1=new Transaction(account1,"Chipotle");
        System.out.println(transaction1.ToString());
        account1.AddTransaction(transaction1);
        try{
            Deposit deposit1= new Deposit(account1,"Pay Check",400);
            deposit1.CompleteDeposit();
            System.out.println("account1 balance after deposit: $"+ String.format("%.2f",account1.GetBalance()));
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        Account account2= new Account(190567,"Lisa","Darrow","54 Grove Lane","Saltre","OH",45973,"7408221086",4600,transactionList2);
        accountList.add(account2);
        System.out.println("account2 balance befor deposit: $"+ String.format("%.2f",account2.GetBalance()));
        try{
            Withdrawal withdrawal1= new Withdrawal(account2,"auto shop",500);
            withdrawal1.CompleteWithdrawal();
            System.out.println("account2 balance after withdrawal: $"+ String.format("%.2f",account2.GetBalance()));
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        Account account3= new Account(234652,"Mark","Cross","7653 Summer Drive","Lima","OH",46745,"4603891002",9000,transactionList3);
        accountList.add(account3);
        System.out.println("account3 balance befor deposit: $"+ String.format("%.2f",account3.GetBalance()));
        try{
            Miscellaneous misc1= new Miscellaneous(account3,"service",-50);
            misc1.CompleteMiscTrans();
            System.out.println("account3 balance after Miscellaneous transaction: $"+ String.format("%.2f",account3.GetBalance()));
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
        for(Account a:accountList){
            System.out.println(a.ToString());
        }
        


    }
}