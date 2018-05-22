public class Account{

    private final AccountType type;
    private double balance;
    private String accNum;

    public Account(AccountType accType, double accBalance,String accNum){
        type = accType;
        balance = accBalance;
        this.accNum = accNum;
    }

    public String getType(){
        return type.longName();
    }
    public String getAccountNum(){
    	return this.accNum;
    }

    public AccountType getAccountType(){
        return type;
    }

    public double currentBalance(){
        return balance;
    }
    public void setBalance(double setter){
    	this.balance = setter;
    }

    public double calcInterest(int days){
        double totalInterest, daysInterest;
        totalInterest = balance * type.interestRate();
        daysInterest = totalInterest * ((double)days/365.25);
        return daysInterest;
    }
}