import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;



public class Lab5Main{

    private  ArrayList<String[]> accountData = new ArrayList<String[]>();
    // ToDo: Create a private ArrayList to hold a single type that can
    // be used to access client and account information.
    // e.g.
     private ArrayList<Object> clientData = new ArrayList<Object>() ;
    // change YOUR_CLASS to reflect the actual class whose instances
    // will be in the clientData ArrayList;
    static ArrayList<PersonalClient> PclientData = new ArrayList<PersonalClient>() ;
    static ArrayList<BusinessClient> BclientData = new ArrayList<BusinessClient>() ;
    static ArrayList<String[]> logList = new ArrayList<String[]>();
    
    private void createObjects(){
        String[] accountInfo;
        PersonalClient PS;
        BusinessClient BS;
        ArrayList<String> white = new ArrayList<String>();
        String[] ar = {"HWA12","DIG01","WUU88","SHA47","KPK24"};
        white.addAll(Arrays.asList(ar));
        
        for (int i=0; i< 10 /*accountData.size()*/; i++ ) {
        	// columns: 0-id, 1-name, 2-accType, 3-balance, 4-address, 5-parish, 6-phone
            accountInfo = accountData.get(i);
            if (!white.contains(accountInfo[0])){
            
            PS = new PersonalClient(accountInfo[0],accountInfo[1]+","+accountInfo[2],accountInfo[5],accountInfo[6],accountInfo[7],accountInfo[1],accountInfo[2],accountInfo[7],accountInfo[8],accountInfo[9],accountInfo[10]);
            PS.addAccount(accountInfo[3], Double.parseDouble(accountInfo[4]),accountInfo[13]);
          PS.setCard(accountInfo[11], accountInfo[12]);
            
            clientData.add(PS);
           PclientData.add(PS);
            }
            
            else if (white.contains(accountInfo[0])){
            	BS = new BusinessClient(accountInfo[0],accountInfo[1]+ ","+accountInfo[2],accountInfo[5],accountInfo[6],accountInfo[4],accountInfo[9],accountInfo[10]);
            	BS.addAccount(accountInfo[3], Double.parseDouble(accountInfo[4]),accountInfo[13]);
            	BS.setCard(accountInfo[11], accountInfo[12]);
            	BS.addSig(accountInfo[8]);
            	clientData.add(BS);
                BclientData.add(BS);
            }
           
            
            // ToDo: using the data contained in the accountInfo array,
            // create instances of the classes you specified in Part 1
            // Then, find a way to compose the instances so you can
            // add an entry to clientData;
            // clientData.add(accountInfo);
        }
    }

    public double totalFunds(){

        double mgmtTotal = 0;
        // ToDo:
        // complete this method that will loop through clientData to 
        // extract the balance for accounts contained within to 
        // general a total that is then returned.
        for (Object j: clientData){
        	mgmtTotal += ((Client)j).getTotalAccountAmt();
        }
        
        return mgmtTotal;
    }
    public ArrayList<BusinessClient> getBusiness(){
    	return this.BclientData;
    }
    public ArrayList<PersonalClient> getPersonal(){
    	return this.PclientData;
    }
    
    public ArrayList<Object> getClient(){
    	return this.clientData;
    }

    private void initialize(){
        // This method just adds some test data to the accountData arraylist
        // You will write code in the method: createObjects to loop through
        // the array initialized here to create instances of your classes
        // You probably shouldn't modify this method - unless:
        // you're adding some new sample data
    	
    	try {
    		accountData =SimpleData.ReadCSV("clientList.csv","\t");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
    }
    public void transaction(){
    	Scanner scan = new Scanner(System.in);
    	int i =1;
    	 for (Object c: clientData ){
         	System.out.println( i+"  "  + ((Client)c).showName()+"\t"+((Client)c).getTotalAccountAmt());
         	i++;
         }
    	 System.out.println("\n" + "Enter the number of the account you want to have a transaction with");
    	 int mod = Integer.parseInt(scan.nextLine());
    	 
    	 System.out.println("Deposit or Withdraw?");
    	 String choice = scan.nextLine();
    	 
    	 if (choice.equalsIgnoreCase("Deposit")){
    		 System.out.println("how much do you want to Deposit");
    		 double amt = Double.parseDouble(scan.nextLine());
    		 ((Client)clientData.get(mod-1)).Deposit(amt);
    		 System.out.println("you have successfully deposited "+ amt);
    		 
    		 if (((Client)clientData.get(mod-1)).getAccount(0).getAccountType()== AccountType.investment){
    			 System.out.println("you have an investment account...");
    			 System.out.println("it attracted a charge of $120.0");
    			 ((Client)clientData.get(mod-1)).withdraw(100);
    		 }
    		 System.out.print("your current balance: ");
    		 System.out.println(((Client)clientData.get(mod-1)).getTotalAccountAmt());
    	 }
    	 else if (choice.equalsIgnoreCase("Withdraw")){
    		 System.out.println("how much do you want to withdraw");
    		 double amt = Double.parseDouble(scan.nextLine());
    		 ((Client)clientData.get(mod-1)).withdraw(amt);
    		 System.out.println("you have successfully withdrawed "+ amt);
    		 
    		 if (((Client)clientData.get(mod-1)).getAccount(0).getAccountType()== AccountType.chequing){
    			 System.out.println("you have an chequing account...");
    			 System.out.println("it attracted a charge of $15.0");
    			 ((Client)clientData.get(mod-1)).withdraw(15);
    		 }
    		 
    		 System.out.print("your current balance: ");
    		 System.out.println(((Client)clientData.get(mod-1)).getTotalAccountAmt());
    	 }
    	 
    }
    

    public Lab5Main(){
        // instantiate accountData, the arraylist with string arrays
        accountData = new ArrayList<String[]>();
        initialize();
        createObjects();
        String[] log = {"Client id","Name","Account Type","Prior Balance","Transaction type","New Balance","Account Deposited to"};
        logList.add(log);
        
        try {
			SimpleData.writeCSV("C:\\Users\\Douglas\\Desktop\\log.txt", logList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        logList.removeAll(logList);
    }

    public static void main(String[] args){
    	String[] log = {"Client id",""};
    	FrontEnd obj = new FrontEnd();
		obj.runJFrame();
    	/*Scanner scan = new Scanner(System.in);
        Lab5Main m = new Lab5Main();
        double fundsUnderManagement = m.totalFunds();
        System.out.printf("The total sum under management is %,.2f",
                          fundsUnderManagement);
        for (Object c: clientData ){
        	System.out.println(c);}*/
        /*
        
        System.out.println("\n"+"Do you want to place a transaction (Deposit or Withdraw)?" +"\n");
        System.out.print("yes or no: ");
        String choice = scan.nextLine();
        
        if (choice.equalsIgnoreCase("yes")){
        	m.transaction();
        }*/

        // ToDo: print out some of the values in clientData
        // no more than 6 entries.
    }
}
