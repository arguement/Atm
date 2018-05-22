import java.util.ArrayList;

import javax.swing.JOptionPane;

public abstract class Client {

    protected String clientid, telephone, name;
    protected ArrayList<Address> addresses;
    protected ArrayList<Account> accounts;
    protected int cardNum;
    protected int pin;
    protected Card card;
	protected String clientType;
    

    public Client(String clid, String name_, String address_, String parish_,
                  String tel_,String clientType){
        accounts = new ArrayList<Account>();
        addresses = new ArrayList<Address>();
        // Parish pa = Parish.KingstonStAndrew;  // default parish
        Parish pa = Parish.findByName(parish_);

        addresses.add(new Address(address_, pa));
        telephone = tel_;
        name = name_;
        clientid = clid;
        this.clientType = clientType;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }
    public void addAccount(String type, double balance,String accNum){
        type = String.join("", type.split(" "));
        AccountType act = AccountType.valueOf(type);
        addAccount(new Account(act, balance,accNum));
    }
    public void addAddress(Address addr_){
        addresses.add(addr_);
    }

    public Account getAccount(int seq){
        if (seq < accounts.size())
            return accounts.get(seq);
        else
            return null;
    }
    public ArrayList<Account> getAccounts(){
        return this.accounts;
    }
    
    public abstract String getFullName();
    public abstract String getName();

    public Parish getPrimaryParish(){
        Address p;
        try{
            p = this.addresses.get(0);
        }
        catch(Exception e){
            p = null;
        }
        return p.getParish();
    }
    public double getTotalAccountAmt(){
    	return accounts.get(0).currentBalance();
    }
    public void withdraw(double amt){
    	 if(this.accounts.get(0).getAccountType() != AccountType.investment){
		
    		 this.accounts.get(0).setBalance(this.accounts.get(0).currentBalance()-amt);
		}
    	 else{
    		 JOptionPane.showMessageDialog(null, "you cannot withdraw from an investment account","Withdraw error",JOptionPane.PLAIN_MESSAGE);
    		 
    	 }
	}
    
    public void with2(double amt){
    	if(this.accounts.get(0).getAccountType() != AccountType.investment){
    		
   		 this.accounts.get(0).setBalance(this.accounts.get(0).currentBalance()-amt);
		}
   	
    }
    
    public void Deposit(double amt){
		this.accounts.get(0).setBalance(this.accounts.get(0).currentBalance()+amt);
	}
    public String showName(){
    	return this.name;
    }
    public static String space(int amt){
    	String o = "";
    	for (int i = 0; i < amt; i++){
    		o+=" ";
    	}
    	return o;
    }
    public String show(){
    	//return this.clientid + "                       " + getTotalAccountAmt();
    	return String.format("%s "+space(15) +" %.2f",this.clientid,getTotalAccountAmt());
    }
    
    public void setCardPin(int card,int pin){
    	this.cardNum = card;
    	this.pin = pin;
    }
    public void setCard(String card,String pin){
    	this.card = new Card(card,pin);
    }
    public String getCard(){
    	return this.card.getSerialNum();
    }
    public String getPin(){
    	return this.card.getPin();
    }
    public String getClientId(){
    	return this.clientid;
    }
    public String getClientType() {
  		return clientType;
  	}

    
    public String toString(){
        String f = "\n  Client: %s (%s)\n  Tel: %s%s%s \n%s";
        String aa, ac,ll = "";
        ac = "\n  Accounts:";
        for (Account a : accounts){
            ac += String.format("\n    %-20s:    $%,12.2f", a.getType(), a.currentBalance());
        }
        aa = "\n  Address:";
        for (Address b: addresses){
            aa += String.format("\n    %s", b.toString());
        }
        for (int i = 0; i < 70;i++){
        	ll+="_"; 
        }
        return String.format(f, name, clientid, telephone, ac, aa,ll);

    }
}
