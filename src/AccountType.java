public enum AccountType {
    savings ("Savings Account", 0.05),
    directbanking ("Direct Banking", 0.0),
    investment ("Investment Account", 0.15),
    chequing("chequing",0.0);
    

    private final String longname;
    private final double irate;

    AccountType(String name, double rate){
        this.longname = name;
        this.irate = rate;
    }
    public String longName(){
        return this.longname;
    }
    public double interestRate(){
        return this.irate;
    }
}