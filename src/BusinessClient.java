import java.util.ArrayList;
import java.util.Arrays;

public class BusinessClient extends Client {
	private String tradingName;
	private String OfficialName;
	private String telephone;
	private String telephone2;
	private ArrayList<PersonalClient> signatories= new ArrayList<PersonalClient>();
	private String trn;
	
	public BusinessClient(String clid, String name_, String address_, String parish_, String tel_,String trn,String clientType) {
		super(clid, name_, address_, parish_, tel_,clientType);
		
		this.trn = trn;
		this.tradingName = name.split(",")[0];
		this.OfficialName = name.split(",")[1];
		this.telephone = tel_;
		
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
		return this.tradingName;
	}
	
	public void addSigg(PersonalClient ar){
		signatories.add(ar);
	}
	public void addSig(String sig){
		
		String[] ar = sig.split(",");
		ArrayList<String> ha = new ArrayList<String>();
		ha.addAll(Arrays.asList(ar));
		
		for (PersonalClient i:Lab5Main.PclientData){
			if (ha.contains(i.getClientId())){
				addSigg(i);
			}
		}
	}
	
	public ArrayList<PersonalClient> getSig(){
		return this.signatories;
	}
	public String showDeposit(){
    	return this.trn + " " +  this.accounts.get(0).getType() ;
    }
	
	
	

}
