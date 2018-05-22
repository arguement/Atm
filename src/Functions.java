import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;




public class Functions {
	
	private static int transNum = 1;
	
	
	
	
	public static String bills(double amt){
		int  r5000=0, r1000=0, r500=0, r100=0,count=0; 
	    String mon="";
	    double val = amt;

	while(amt >= 5000) 
	{ 
	r5000 = (int) (amt / 5000) ; 
	amt = amt % 5000;
	
	mon+= r5000 + "x" + "$5000 + ";
	break ; 
	}
	while(amt >= 1000) 
	{ 
	r1000 = (int) (amt / 1000) ; 
	amt = amt % 1000;
	
	mon+= r1000 + "x" + "$1000 + ";
	break ; 
	} 
	while(amt >= 500) 
	{ 
	r500 = (int) (amt / 500) ; 
	amt = amt % 500;
	
	mon+= r500 + "x" + "$500 + ";
	break ; 
	} 
	while(amt >= 100) 
	{ 
	r100 = (int) (amt / 100) ;
	amt = amt % 100; 

	mon+= r100 + "x" + "$100 + ";
	break ; 
	}  

	count = r5000 + r1000 + r500 + r100 ;   
	
	return mon.substring(0,mon.length()-2) +"= "+String.format("%.2f",val);
	}
	
	
	
	
	public static String today(){
        Calendar today  = Calendar.getInstance();
        today.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
                  today.get(Calendar.DAY_OF_MONTH), today.get(Calendar.HOUR), today.get(Calendar.MINUTE),today.get(Calendar.SECOND));

        String dateStr = new SimpleDateFormat(
                "yyyy-dd-MM  hh:mm ss", Locale.ENGLISH).format(
                    Calendar.getInstance().getTime());
        return dateStr;
    }
	
	
	public static void makelog(String action,String amt,String bal,String type,String masker){
File file = new File("log.txt");
		
		FileWriter wr = null;
		try {
			wr = new FileWriter(file,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter br = new BufferedWriter(wr);
		try {
			br.newLine();
			br.write(spacer(3)+"Transaction Information  ");
			br.newLine();
			br.newLine();
			br.write( spacer(3)+action+" \t\t\t "+type);
			br.newLine();
			br.write(spacer(3)+"AMOUNT :"+ spacer(8)+amt);
			br.newLine();
			br.write(spacer(3)+"CURRENT BAL :"+ spacer(8)+bal);
			br.newLine();
			br.write("AVAILABLE BAL :"+ spacer(7)+"$0.00");
			br.newLine();
			br.newLine();
			br.write("ATM NO:\t "+String.format("%03d", transNum));
			br.newLine();
			br.write("CARD NO:\t "+Functions.mask(masker));
			
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static String spacer(int size){
		String a = "";
		for (int i = 0; i < size; i++){
			a+=" ";
		}
		return a;
	}
	public static String mask(String mask){
		String[] ar = mask.split("");
		String adder = "";
		
		for (int i=0; i< ar.length; i++){
			if (i <= ar.length - 5){
				adder += "X";
			}
			else{
				adder += ar[i];
			}
		}
		return adder;
	}
}
