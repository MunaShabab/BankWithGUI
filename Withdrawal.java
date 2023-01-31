import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.ChronoField;
import java.time.format.DateTimeFormatter;
public class Withdrawal extends Transaction{
    //instance variables
    private double withdrawalAmount;
    //class constructor
    public Withdrawal (Account argAccount,String argDescription,double argAmount)throws Exception{
        super(argAccount,argDescription);
        this.SetWithdrawalAmount(argAmount);
    }
    //set method for amount that throws an exception if the amount is negative
    public void SetWithdrawalAmount(double argAmount)throws Exception{
        if(argAmount<=0){
            throw new Exception("The amount entered must be positive");
        }
        else{
            withdrawalAmount=argAmount;
        } 
       
    }
    public double GetWithdrawalAmount(){
        return withdrawalAmount;
    }
    //class method CompleteWithdrawal throws an exception if the amount is greater than the account balance
    public void CompleteWithdrawal()throws Exception{
        if(super.GetAccount().GetBalance()<this.GetWithdrawalAmount()){
            throw new Exception("insufficient funds for this transaction, it cannot be completed");
        }
        //if it is not then it sets the account balnce to the correct amount
        else{
            super.GetAccount().SetBalance(super.GetAccount().GetBalance()-this.GetWithdrawalAmount());
        }
        
        
    }
    public String ToString(){
        //format the date of the transaction with a DateTimeFormatter
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("ccc LLL dd HH:mm:ss zzz yyyy");
        //create a string with the withdrawal info
        String withdrawalInfo=super.GetTime().format(formatter)+"     -"+this.GetWithdrawalAmount()+"     "+super.GetDescription();
        return withdrawalInfo;
    }
}