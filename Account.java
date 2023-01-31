import java.util.ArrayList;

//class Account that represents a bank account
public class Account{
    //Instance Variables
    private int accountNo;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phoneNumber;
    private double balance;
    private ArrayList<Transaction> transactionList;

    //class constructor
    public Account(int argAccountNo,String argFirstName,String argLastName,String argAddress,String argCity,String argState,int argZip,String argPhoneNumber,double argBalance,ArrayList<Transaction> argTransactionList){
        this.SetAccountNo(argAccountNo);
        this.SetFirstName(argFirstName);
        this.SetLastName(argLastName);
        this.SetAddress(argAddress);
        this.SetCity(argCity);
        this.SetState(argState);
        this.SetZip(argZip);
        this.SetPhoneNumber(argPhoneNumber);
        this.SetBalance(argBalance);
        this.SetTransactionList(argTransactionList);
    }

    //set and get methods
    public void SetAccountNo(int argAccountNo){
        accountNo=argAccountNo;
    }
    public void SetFirstName(String argFirstName){
        firstName=argFirstName;
    }
    public void SetLastName(String argLastName){
        lastName=argLastName;
    }
    public void SetAddress(String argAddress){
        address=argAddress;
    }
    public void SetCity(String argCity){
        city=argCity;
    }
    public void SetState(String argState){
        state= argState;
    }
    public void SetZip(int argZip){
        zip=argZip;
    }
    public void SetPhoneNumber(String argPhoneNumber){
        phoneNumber=argPhoneNumber;
    }
    
    public void SetBalance(double argBalance){
        
        balance=argBalance;
        
    }
    public void SetTransactionList(ArrayList<Transaction> argTransactionList){
        transactionList=argTransactionList;
    }
    public int GetAccountNo(){
        return accountNo;
    }
    public String GetFirstName(){
        return firstName;
    }
    public String GetLastName(){
        return lastName;
    }
    public String GetAddress(){
        return address;
    }
    public String GetCity(){
        return city;
    }
    public String GetState(){
        return state;
    }
    public int GetZip(){
        return zip;
    }
    public String GetPhoneNumber(){
        return phoneNumber;
    }
    public double GetBalance(){
        return balance;
    }
    public ArrayList<Transaction> GetTransactionList(){
        return transactionList;
    }


    //class method
    public void AddTransaction(Transaction argTransaction){
        this.GetTransactionList().add(argTransaction);
    }
    public String ToString(){
        String accountInfo=this.GetFirstName()+" "+this.GetLastName()+", Account Number: "+this.GetAccountNo()+", Balance: $"
        +String.format("%.2f",this.GetBalance());
        return accountInfo;
    }



}