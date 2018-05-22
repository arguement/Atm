import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonalClient extends Client {
	
	private String surname;
	private String givenName;
	public String telephone;
	public Date dob;
	private String trn;
	
	
	public PersonalClient(String clid, String name_, String address_, String parish_, String tel_,String surname,String givenName,String telelphone,String dob,String trn,String clientType) {
		super(clid, name_, address_, parish_, tel_,clientType);
		
		this.trn = trn;
		this.surname = surname;
		this.givenName = givenName;
		try {
			this.dob = new SimpleDateFormat("yyyy/MM/dd").parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.givenName;
	}
	public String showDeposit(){
    	return this.trn + " "+  this.accounts.get(0).getType() ;
    }
    
	
	

}
