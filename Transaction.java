import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.ChronoField;
import java.time.format.DateTimeFormatter;
public class Transaction{
    //class instance variables
    private Account account;
    private ZonedDateTime time;
    private String description;
    
    //class constructor
    public Transaction(Account argAccount,String argDescription){
        this.SetAccount(argAccount);
        this.SetTime();
        this.SetDescription(argDescription);
    }

    //set and get methods
    public void SetAccount(Account argAccount){
        account=argAccount;
    }
  
    public void SetTime(){
        time=ZonedDateTime.now();
    }
    public void SetDescription(String argDescription){
        description=argDescription;
    }

    public Account GetAccount(){
        return account;
    }
    
    public ZonedDateTime GetTime(){
        return time;
    }
    public String GetDescription(){
        return description;
    }
    //class methods
    public String ToString(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("ccc LLL dd HH:mm:ss zzz yyyy");
        String transactionInfo=this.GetTime().format(formatter)+"     "+this.GetDescription();
        return transactionInfo;
    }


}