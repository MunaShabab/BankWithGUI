import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.ChronoField;
import java.time.format.DateTimeFormatter;
public class Miscellaneous extends Transaction{
    //instance variables
    private double miscTransAmount;
    //class constructor
    public Miscellaneous (Account argAccount,String argDescription,double argAmount){
        super(argAccount,argDescription);
        this.SetMiscAmount(argAmount);
    }
    //set method for amount that throws an exception if the amount is negative
    public void SetMiscAmount(double argAmount){
       miscTransAmount=argAmount;
    }
    public double GetMiscAmount(){
        return miscTransAmount;
    }
    //class method CompleteMiscTrans throws an exception if the amount is greater than the account balance
    public void CompleteMiscTrans()throws Exception{
        if(this.GetMiscAmount()<0&&Math.abs(this.GetMiscAmount())>super.GetAccount().GetBalance()){
            throw new Exception("insufficient funds for this transaction, it cannot be completed");
        }
        //if it is not then it sets the account balnce to the correct amount
        else{
            super.GetAccount().SetBalance(super.GetAccount().GetBalance()+this.GetMiscAmount());
        }
        
        
    }
    public String ToString(){
        //format the date of the transaction with a DateTimeFormatter
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("ccc LLL dd HH:mm:ss zzz yyyy");
        //create a string with the withdrawal info
        String miscTransInfo=super.GetTime().format(formatter)+"     "+this.GetMiscAmount()+"     "+super.GetDescription();
        return miscTransInfo;
    }
}