import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.ChronoField;
import java.time.format.DateTimeFormatter;
public class Deposit extends Transaction{
    //instance variables
    private double depositAmount;
    //class constructor
    public Deposit (Account argAccount,String argDescription,double argAmount)throws Exception{
        super(argAccount,argDescription);
        this.SetDepositAmount(argAmount);
    }
    //set method for amount that throws an exception if the amount is negative
    public void SetDepositAmount(double argAmount)throws Exception{
        if(argAmount<=0){
            throw new Exception("The amount entered must be positive");
        }
        else{
            depositAmount=argAmount;
        } 
       
    }
    public double GetDepositAmount(){
        return depositAmount;
    }
    //class method 
    public void CompleteDeposit(){
        super.GetAccount().SetBalance(super.GetAccount().GetBalance()+this.GetDepositAmount());
        
    }
    public String ToString(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("ccc LLL dd HH:mm:ss zzz yyyy");
        String depositInfo=super.GetTime().format(formatter)+"     "+this.GetDepositAmount()+"     "+super.GetDescription();
        return depositInfo;
    }
}