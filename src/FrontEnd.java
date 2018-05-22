import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;




public class FrontEnd extends JPanel {
	
	private JButton but1,but2,but3,but4,but5,but6,but7,but8,but9,but10,cancel,back,en;
	private JPanel pan1,cen,window;
	private JTextField cardNum;
	private JFrame frame;
	private FrontEnd obj1;
	private JPasswordField pinNum;
	private ButtonListener addText = new ButtonListener();
	private int withAmt;
	private PersonalClient pick;
	private BusinessClient pick1;
	private BusinessClient pick2;
	private Client truePick;
	private HashMap<String,Client> choice = new HashMap<String,Client>();
	private Lab5Main obj = new Lab5Main();
	private JTextField rem,withText ;
	private remListener a =new remListener();
	private withdrawListener b =new withdrawListener();
	private ArrayList<Client> DepositData = new ArrayList<Client>();
	private int track = 0;
	private JLabel title2;
	
	
	public FrontEnd(){
		setLayout(new BorderLayout());
		
		ButtonListener addText = new ButtonListener();
		numpadAlt keyAlt = new numpadAlt();
		//left side
		but1 = new JButton("1");
		but1.addActionListener(addText);
		
		
		but2 = new JButton("2");
		but2.addActionListener(addText);
		
		but3 = new JButton("3");
		but3.addActionListener(addText);
		
		but4 = new JButton("4");
		but4.addActionListener(addText);
		
		but5 = new JButton("5");
		but5.addActionListener(addText);
		
		but6 = new JButton("6");
		but6.addActionListener(addText);
		
		but7 = new JButton("7");
		but7.addActionListener(addText);
		
		but8 = new JButton("8");
		but8.addActionListener(addText);
		
		but9 = new JButton("9");
		but9.addActionListener(addText);
		but9.setMnemonic(KeyEvent.VK_W);
		
		but10 = new JButton("0");
		but10.addActionListener(addText);
		
		en = new JButton("ENTER");
		en.addActionListener(new test());
		
		 pan1 = new JPanel();
		
		
		pan1.setLayout(new GridLayout(2,2));
		
		pan1.add(but1);
		pan1.add(but2);
		pan1.add(but3);
		pan1.add(but4);
		
		JPanel pan2 = new JPanel();
		//pan2.setBackground(Color.red);
		pan2.setPreferredSize(new Dimension(250,10));
		pan2.setLayout(new BoxLayout(pan2,BoxLayout.Y_AXIS));
		
		JPanel cancelBackSpace = new JPanel();
		cancelBackSpace.setLayout(new GridLayout(2,2));
		back = new JButton("BACKSPACE");
		back.addActionListener(addText);
		cancel = new JButton("CANCEL");
		cancel.addActionListener(new cancelAction());
		cancelBackSpace.add(back);
		cancelBackSpace.add(cancel);
		
		pan2.add(new JPanel());
		//pan2.add(Box.createRigidArea(new Dimension(0,50)));
		pan2.add(pan1);
		pan2.add(Box.createRigidArea(new Dimension(0,10)));
		pan2.add(cancelBackSpace);
		pan2.add(Box.createRigidArea(new Dimension(0,50)));
		
		
		// center window
		 window = new JPanel();
		window.setPreferredSize(new Dimension(300,200));
		
		
		//centre centre 
		cen = new JPanel();
		window.add(cen);
		cen.setPreferredSize(new Dimension(800,500));//470,500
		cen.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		//right side of window
		JPanel leftButtons = new JPanel();
		
		
		leftButtons.setLayout(new GridLayout(3,2));
		
		
		leftButtons.add(but5);
		leftButtons.add(but6);
		leftButtons.add(but7);
		leftButtons.add(but8);
		leftButtons.add(but9);
		leftButtons.add(but10);
		
		JPanel left = new JPanel();
		
		left.setPreferredSize(new Dimension(250,10));
		left.setLayout(new BoxLayout(left,BoxLayout.Y_AXIS));
		
		JPanel enter = new JPanel();
		enter.setLayout(new GridLayout(2,1));
		
		enter.add(en);
		enter.add(new JPanel());
		
		
		
		left.add(new JPanel());
		left.add(leftButtons);
		left.add(Box.createRigidArea(new Dimension(0,10)));
		left.add(enter);
		
		
		//title
		JLabel title = new JLabel("JLCB Automated Banking Machine ",JLabel.CENTER);
		title.setFont(new Font("Arial",Font.BOLD,30));
		
		title2 = new JLabel("                         "+Functions.today(), SwingConstants.CENTER);
		title2.setFont(new Font("Arial",Font.PLAIN,20));
		clock();
		
		Box top = Box.createVerticalBox();
		top.setPreferredSize(new Dimension(0,100));
		top.add(Box.createRigidArea(new Dimension(0,30)));
		top.add(title);
		top.add(Box.createVerticalGlue());
		top.add(title2);
		
		Box box = Box.createHorizontalBox();
		
		box.add(Box.createRigidArea(new Dimension(430,0)));
		box.add(top);
		//buttom
		CardNumScreen();
		
		JPanel buttom = new JPanel();
		buttom.setPreferredSize(new Dimension(0,50));
		
		add(BorderLayout.WEST,pan2);
		add(BorderLayout.CENTER,window);
		add(BorderLayout.EAST,left);
		add(BorderLayout.NORTH,box);
		add(BorderLayout.SOUTH,buttom);
		
		
		
		
		
		
		
	}
	
	public void hardKey(){
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		
		keyPressQ q = new keyPressQ();
		keyPressW w = new keyPressW();
		keyPressS s = new keyPressS();
		keyPressX x = new keyPressX();
		keyPressP p = new keyPressP();
		keyPressO o = new keyPressO();
		keyPressK k = new keyPressK();
		keyPressM m = new keyPressM();
		
		but10.getInputMap(map).put(KeyStroke.getKeyStroke("Q"), "pressed");
		but1.getInputMap(map).put(KeyStroke.getKeyStroke("W"), "pressed");
		but2.getInputMap(map).put(KeyStroke.getKeyStroke("S"), "pressed");
		but3.getInputMap(map).put(KeyStroke.getKeyStroke("X"), "pressed");
		but4.getInputMap(map).put(KeyStroke.getKeyStroke("P"), "pressed");
		but5.getInputMap(map).put(KeyStroke.getKeyStroke("O"), "pressed");
		but6.getInputMap(map).put(KeyStroke.getKeyStroke("K"), "pressed");
		but7.getInputMap(map).put(KeyStroke.getKeyStroke("M"), "pressed");
		
		but1.getActionMap().put("pressed", w);
		but2.getActionMap().put("pressed", s);
		but3.getActionMap().put("pressed", x);
		but4.getActionMap().put("pressed", p);
		but5.getActionMap().put("pressed", o);
		but6.getActionMap().put("pressed", k);
		but7.getActionMap().put("pressed", m);
		but10.getActionMap().put("pressed", q);
		
		cardNum.addKeyListener(new KeyAdapter() {
			   public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			         e.consume();  // ignore event
			      }
			   }
			});
		
	}
	
	
	
	public void clock(){
		Thread clock = new Thread(){
			public void run(){
				while (true){
				try {
				
				title2.setText("                         "+Functions.today());
				
				
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}
		};
		clock.start();
	}
	
	public void BalanceQuery(){
		JLabel label = new JLabel("Your Balance");
		label.setFont(new Font("Serif", Font.BOLD, 30));
		
		for (Object i: obj.getClient()){
			if (((Client)i).getCard().equals(cardNum.getText()) && ((Client)i).getPin().equals(pinNum.getText())){
				choice.put(((Client)i).getClientType(), ((Client)i));
			}
		}
		for (Object i: obj.getClient()){
			if (((Client)i).getCard().equals(cardNum.getText()) && ((Client)i).getPin().equals(pinNum.getText())){
				choice.put(((Client)i).getClientType(), ((Client)i));
			}
		}
		
		Client picker = (Client)choice.values().toArray()[0];
		JLabel label2 = new JLabel("Balance: " +String.format("%.2f", picker.getAccount(0).currentBalance())+"");
		label2.setFont(new Font("Serif", Font.BOLD, 16));
		
		cen.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weighty = 0.1;
		gc.weightx = 0.1;
		gc.anchor = GridBagConstraints.NORTH;
		
		cen.add(label,gc);
		gc.anchor = GridBagConstraints.CENTER;
		
		//gc.insets = new Insets(30,0,0,0);
		cen.add(label2,gc);
	}
	
	
	public void Deposit(){
		int tracker = 1;
		Font font = new Font("Serif", Font.BOLD, 14);
		JLabel label = new JLabel("Select account to deposit to",JLabel.CENTER);
		label.setFont(font);
		cen.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		gc.insets = new Insets(0,0,20,0);
		
		
		
		cen.add(label,gc);
		for (Object i: obj.getClient()){
			if (((Client)i).getCard().equals(cardNum.getText()) && ((Client)i).getPin().equals(pinNum.getText())){
				choice.put(((Client)i).getClientType(), ((Client)i));
			}
		}
		


		
		for (PersonalClient i:obj.getPersonal()){
		
				
				label = new JLabel(tracker + ". " +i.showDeposit());
				label.setFont(font);
				gc.gridy++;
				cen.add(label,gc);
				tracker++;
				DepositData.add(i);
			
		}
		
		for (BusinessClient j: obj.getBusiness()){
			
			
				
				
				
				label = new JLabel(tracker + ". " +j.showDeposit());
				label.setFont(font);
				gc.gridy++;
				cen.add(label,gc);
				tracker++;
				DepositData.add(j);
			
		}
		
		
		
		gc.gridy++;
		gc.insets = new Insets(10,0,30,10);
		withText = new JTextField(15);
		withText.addKeyListener(new DepositAction());
		
		rem = new JTextField("Press Enter Here",15);
		
		
		withText.setMinimumSize(new Dimension(200,20));
		rem.setMinimumSize(new Dimension(200,20));
		 
		JLabel prompt = new JLabel("Enter Number corresponding to the client you want to Deposit to");
		
		prompt.setFont(font);
		
		cen.add(prompt,gc);
		gc.gridx = 1;
		
		cen.add(withText,gc);
		
	}
	
	public void withdrawDisplay(){
		
		int tracker =1;
		
		Font font = new Font("Serif", Font.BOLD, 16);
		JLabel label = new JLabel("ID number                    Amount",JLabel.CENTER);
		label.setFont(font);
		cen.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		//gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,20,0);
		//gc.weightx=1;
		//gc.weighty=1;
		
		//cen.add(label,gc);
		
		cen.add(label,gc);
		
		ArrayList<Client> data = new ArrayList<Client>();
		
		
		for (PersonalClient i: obj.getPersonal()){
		
			if (i.getCard().equals(cardNum.getText()) && i.getPin().equals(pinNum.getText())){
				pick =i;
				
				label = new JLabel(tracker + ". " +i.show());
				label.setFont(font);
				gc.gridy++;
				cen.add(label,gc);
				tracker++;
				data.add(i);
			}
		}
		
		for (BusinessClient j: obj.getBusiness()){
			
			if (j.getSig().contains(pick)){
				pick1 =j;
				
				
				label = new JLabel(tracker + ". " +j.show());
				label.setFont(font);
				gc.gridy++;
			//	cen.add(label,gc);
				tracker++;
				data.add(j);
			}
		}
		
		for (BusinessClient i: obj.getBusiness()){
			
			if (i.getCard().equals(cardNum.getText()) && i.getPin().equals(pinNum.getText())){
				pick1 =i;
				
				label = new JLabel(tracker + ". " +i.show());
				label.setFont(font);
				gc.gridy++;
			    cen.add(label,gc);
				tracker++;
				data.add(i);
			}
		}
		
		
		but1.setText("1");
		but2.setText("2");
		but3.setText("3");
		but4.setText("4");
		but5.setText("5");
		but6.setText("6");
		but7.setText("7");
		back.setText("8");
		en.setText("9");
		
		gc.gridy++;
		gc.insets = new Insets(20,0,50,10);
		 withText = new JTextField(15);
		 rem = new JTextField("Press Enter here",15);
		JLabel prompt = new JLabel("Enter Amount of money you want to withdraw");
		prompt.setToolTipText("Press Enter here to continue");
		JLabel delPrompt = new JLabel("Enter Number of the account you want to withdraw from");
		prompt.setFont(font);
		delPrompt.setFont(font);
		cen.add(prompt,gc);
		gc.gridx = 1;
		cen.add(withText,gc);
		gc.gridx--;
		gc.gridy++;
		cen.add(delPrompt,gc);
		gc.gridx++;
		
		cen.add(rem, gc);
		
		ChooseWhich j = new ChooseWhich();
		
		withText.addMouseListener(j);
		rem.addMouseListener(j);
		
		withText.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		rem.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER && Integer.parseInt(withText.getText()) > 100){
					withAmt = Integer.parseInt(withText.getText());
					truePick = data.get(Integer.parseInt(rem.getText()) - 1);
					pick.withdraw(withAmt);
					JOptionPane.showMessageDialog(null, "new Balance: "+String.format("%s", Functions.bills(truePick.getTotalAccountAmt())),"Balance Amount",JOptionPane.PLAIN_MESSAGE);
					
					Functions.makelog("Withdraw",""+ withAmt, String.format("%.2f", truePick.getTotalAccountAmt()), truePick.getAccount(0).getType(),truePick.getCard());
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}
	
	public void options(){
		JLabel label = new JLabel("Please select from the buttons on the right");
		label.setFont(new Font("Serif", Font.BOLD, 16));
		cen.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		cen.add(label,gc);
		but1.setText("");
		but2.setText("");
		but3.setText("");
		but4.setText("");
		but5.setText("");
		but6.setText("");
		but7.setText("");
		but8.setText("Balance Query");
		but8.addActionListener(new atmAction());
		but9.setText("Withdraw");
		but9.addActionListener(new atmAction());
		but10.setText("Deposit");
		but10.addActionListener(new atmAction());
		back.setText("");
		en.setText("");
	}
	
	public void pinNumScreen(){
		
		JLabel label = new JLabel("Enter Pin");
		label.setFont(new Font("Serif", Font.BOLD, 16));
		pinNum = new JPasswordField(15);
		
		cen.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		cen.add(label,gc);
		
		gc.gridx=0;
		gc.gridy = 3;
		gc.insets = new Insets(30,0,0,0);
		cen.add(pinNum,gc);
		
		
		
	}
	
	public void camesha(){
		JLabel label = new JLabel("Unknown Card or Invalid Pin");
		label.setFont(new Font("Serif", Font.BOLD, 16));
		
		
		cen.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		cen.add(label,gc);
		
		
	}
	
	public void CardNumScreen(){
		JLabel label = new JLabel("Enter Card Number");
		label.setFont(new Font("Serif", Font.BOLD, 16));
		cardNum = new JTextField("",15);
		
		
		cen.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		hardKey();
		cen.add(label,gc);
		
		gc.gridx=0;
		gc.gridy = 3;
		gc.insets = new Insets(30,0,0,0);
		cen.add(cardNum,gc);
		
		
	}
	
	public void appendText(ActionEvent event,JPasswordField pass){
		if (event.getSource() == but1){
			pass.setText(pass.getText() + "1");
		}
		if (event.getSource() == but2){
			pass.setText(pass.getText() + "2");
		}
		if (event.getSource() == but3){
			pass.setText(pass.getText() + "3");
		}
		if (event.getSource() == but4){
			pass.setText(pass.getText() + "4");
		}
		if (event.getSource() == but5){
			pass.setText(pass.getText() + "5");
		}
		if (event.getSource() == but6){
			pass.setText(pass.getText() + "6");
		}
		if (event.getSource() == but7){
			pass.setText(pass.getText() + "7");
		}
		if (event.getSource() == but8){
			pass.setText(pass.getText() + "8");
		}
		if (event.getSource() == but9){
			pass.setText(pass.getText() + "9");
		}
		if (event.getSource() == but10){
			pass.setText(pass.getText() + "0");
		}
		
		if (event.getSource() == back){
			pass.setText(pass.getText().substring(0,pass.getText().length()-1));
		}
		}
	
	
	
	public void runJFrame(){
		Lab5Main.PclientData.removeAll(Lab5Main.PclientData);
		Lab5Main.BclientData.removeAll(Lab5Main.BclientData);
		obj1 = new FrontEnd();
		frame = new JFrame("Atm");
	//	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.addWindowListener(new closeAction());
		
		numpadAlt keyAlt = new numpadAlt();
		frame.addKeyListener(keyAlt);
		frame.getContentPane().add(obj1);
		frame.setPreferredSize(new Dimension(920,740));
		frame.pack();
		frame.setVisible(true);
	}
	
	private class ButtonListener  implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if (track ==0){
			if (event.getSource() == but1){
				cardNum.setText(cardNum.getText() + "1");
			}
			if (event.getSource() == but2){
				cardNum.setText(cardNum.getText() + "2");
			}
			if (event.getSource() == but3){
				cardNum.setText(cardNum.getText() + "3");
			}
			if (event.getSource() == but4){
				cardNum.setText(cardNum.getText() + "4");
			}
			if (event.getSource() == but5){
				cardNum.setText(cardNum.getText() + "5");
			}
			if (event.getSource() == but6){
				cardNum.setText(cardNum.getText() + "6");
			}
			if (event.getSource() == but7){
				cardNum.setText(cardNum.getText() + "7");
			}
			if (event.getSource() == but8){
				cardNum.setText(cardNum.getText() + "8");
			}
			if (event.getSource() == but9){
				cardNum.setText(cardNum.getText() + "9");
			}
			if (event.getSource() == but10){
				cardNum.setText(cardNum.getText() + "0");
			}
			
			if (event.getSource() == back){
				cardNum.setText(cardNum.getText().substring(0,cardNum.getText().length()-1));
			}
			}
			if (track == 1){
				appendText(event,pinNum);
			}
			
			
		}
		}
	private class test implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Boolean invalidScreen = false;
			if (track == 0){
				
				cen.removeAll();
				cen.updateUI();
				pinNumScreen();
				
			}
		  
			else if (track == 1){
				Boolean card = false;
				Boolean pin = false;
				
				
				for (Object i: obj.getClient()){
					if (cardNum.getText().equals(((Client)i).getCard())){
						card = true;
					}
				}
				for (Object i: obj.getClient()){
					if (pinNum.getText().equals(((Client)i).getPin())){
						pin = true;
					}
				}
				if (cardNum.getText().equals("444555") && pinNum.getText().equals("4321")){
					System.exit(0);
				}
				if (card == true && pin == true){
					cen.removeAll();
					cen.updateUI();
					options();
				}
				else{
					cen.removeAll();
					cen.updateUI();
					camesha();
					
					invalidScreen = true;
				
				}	
		}
			if (invalidScreen == false){
			track++;
			
			}
		
	}
	
	
}
	
	
	private class atmAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == but9){
				if (track == 2){
					cen.removeAll();
					cen.updateUI();
					withdrawDisplay();
				}
			}
			if (e.getSource() == but10){
				if (track == 2){
					cen.removeAll();
					cen.updateUI();
					Deposit();
					
				}
			}
			if (e.getSource() == but8){
				if (track == 2){
					cen.removeAll();
					cen.updateUI();
					BalanceQuery();
					
				}
			}
		}
		
	}
	private class withdrawListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			if (event.getSource() == but1){
				withText.setText(withText.getText() + "1");
			}
			if (event.getSource() == but2){
				withText.setText(withText.getText() + "2");
			}
			if (event.getSource() == but3){
				withText.setText(withText.getText() + "3");
			}
			if (event.getSource() == but4){
				withText.setText(withText.getText() + "4");
			}
			if (event.getSource() == but5){
				withText.setText(withText.getText() + "5");
			}
			if (event.getSource() == but6){
				withText.setText(withText.getText() + "6");
			}
			if (event.getSource() == but7){
				withText.setText(withText.getText() + "7");
			}
			if (event.getSource() == back){
				withText.setText(withText.getText() + "8");
			}
			if (event.getSource() == en){
				withText.setText(withText.getText() + "9");
			}
			/*if (event.getSource() == but10){
				cardNum.setText(cardNum.getText() + "0");
			}*/
			
			
			
		}
		
	}
	
	private class remListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
			if (event.getSource() == but1){
				rem.setText(rem.getText() + "1");
			}
			if (event.getSource() == but2){
				rem.setText(rem.getText() + "2");
			}
			if (event.getSource() == but3){
				rem.setText(rem.getText() + "3");
			}
			if (event.getSource() == but4){
				rem.setText(rem.getText() + "4");
			}
			if (event.getSource() == but5){
				rem.setText(rem.getText() + "5");
			}
			if (event.getSource() == but6){
				rem.setText(rem.getText() + "6");
			}
			if (event.getSource() == but7){
				rem.setText(rem.getText() + "7");
			}
			if (event.getSource() == back){
				rem.setText(rem.getText() + "8");
			}
			if (event.getSource() == en){
				rem.setText(rem.getText() + "9");
			}
			/*if (event.getSource() == but10){
				cardNum.setText(cardNum.getText() + "0");
			}*/
			
			
			
		}
		
	}
	
	private class ChooseWhich implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		/*	if (e.getSource() == withText){
				but1.removeActionListener(a);
				but2.removeActionListener(a);
				but3.removeActionListener(a);
				but4.removeActionListener(a);
				but5.removeActionListener(a);
				but6.removeActionListener(a);
				but7.removeActionListener(a);
				back.removeActionListener(a);
				en.removeActionListener(a);	
			but1.addActionListener(b);
			but2.addActionListener(b);
			but3.addActionListener(b);
			but4.addActionListener(b);
			but5.addActionListener(b);
			but6.addActionListener(b);
			but7.addActionListener(b);
			back.addActionListener(b);
			en.addActionListener(b);
			}
			
			if (e.getSource() == rem){
				but1.removeActionListener(b);
				but2.removeActionListener(b);
				but3.removeActionListener(b);
				but4.removeActionListener(b);
				but5.removeActionListener(b);
				but6.removeActionListener(b);
				but7.removeActionListener(b);
				back.removeActionListener(b);
				en.removeActionListener(b);
				but1.addActionListener(a);
				but2.addActionListener(a);
				but3.addActionListener(a);
				but4.addActionListener(a);
				but5.addActionListener(a);
				but6.addActionListener(a);
				but7.addActionListener(a);
				back.addActionListener(a);
				en.addActionListener(a);}*/
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == withText){
				but1.removeActionListener(a);
				but2.removeActionListener(a);
				but3.removeActionListener(a);
				but4.removeActionListener(a);
				but5.removeActionListener(a);
				but6.removeActionListener(a);
				but7.removeActionListener(a);
				back.removeActionListener(a);
				en.removeActionListener(a);	
			but1.addActionListener(b);
			but2.addActionListener(b);
			but3.addActionListener(b);
			but4.addActionListener(b);
			but5.addActionListener(b);
			but6.addActionListener(b);
			but7.addActionListener(b);
			back.addActionListener(b);
			en.addActionListener(b);
			}
			
			if (e.getSource() == rem){
				but1.removeActionListener(b);
				but2.removeActionListener(b);
				but3.removeActionListener(b);
				but4.removeActionListener(b);
				but5.removeActionListener(b);
				but6.removeActionListener(b);
				but7.removeActionListener(b);
				back.removeActionListener(b);
				en.removeActionListener(b);
				but1.addActionListener(a);
				but2.addActionListener(a);
				but3.addActionListener(a);
				but4.addActionListener(a);
				but5.addActionListener(a);
				but6.addActionListener(a);
				but7.addActionListener(a);
				back.addActionListener(a);
				en.addActionListener(a);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class cancelAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getSource() == cancel){
				//track--;
				
				if (track == 1){
					cen.removeAll();
					cen.updateUI();
					CardNumScreen();
					track--;
				}
				else if (track == 2){
					cen.removeAll();
					cen.updateUI();
					pinNumScreen();
					track--;
					
					but1.setText("1");	
					but2.setText("2");
					but3.setText("3");
					but4.setText("4");
					but5.setText("5");
					but6.setText("6");
					
					
					but7.setText("7");
					
					
					but8.setText("8");
					
					
					but9.setText("9");
					
					
					but10.setText("0");
					
					back.setText("BACKSPACE");
					en.setText("ENTER");
					
					
				}
			}
		}
		
	}
	
	private class closeAction implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
		
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			Lab5Main.PclientData.removeAll(Lab5Main.PclientData);
			Lab5Main.BclientData.removeAll(Lab5Main.BclientData);
			obj1 = new FrontEnd();
			
			frame = new JFrame("Atm");
		//	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			frame.addWindowListener(new closeAction());
			
			
			frame.getContentPane().add(obj1);
			frame.setPreferredSize(new Dimension(920,740));
			frame.pack();
			frame.setVisible(true);
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	private class DepositAction implements KeyListener{
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER ){
				Client pick = DepositData.get(Integer.parseInt(withText.getText())-1);
				Client picker = (Client)choice.values().toArray()[0];
				if (/*cardNum.getText().equals(pick.getCard())*/ picker.getAccount(0).getAccountNum().equals(pick.getAccount(0).getAccountNum()) ){
					//int a = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount you want to Deposit"));
					int a = depositBreak();
					pick.Deposit(a);
					picker.with2(a);
					Functions.makelog("Depsoit", a+"", String.format("%.2f", picker.getTotalAccountAmt()), picker.getClientType(),picker.getCard());
					JOptionPane.showMessageDialog(null, "You Succcessfully Despoited $"+ a);
				}
				else{
					String a = JOptionPane.showInputDialog("Enter the Account number of the Account");
					
					if (a.equals(pick.getAccount(0).getAccountNum()) ){
						//int b = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount you want to Deposit"));
						int b  = depositBreak();
						pick.Deposit(b);
						picker.with2(b);
						Functions.makelog("Depsoit", a+"", String.format("%.2f", picker.getTotalAccountAmt()), picker.getClientType(),picker.getCard());
						JOptionPane.showMessageDialog(null, "You Succcessfully Despoited $"+ b);
					}
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		private  int depositBreak(){
			
			JTextField m500 = new JTextField();
			JTextField m5000 = new JTextField();
			JTextField m1000 = new JTextField();
			JTextField m100 = new JTextField();
			Object[] message = {
			    "Number of 5000:", m5000,
			    "Number of 1000:", m1000,
			    "Number of 500:", m500,
			    "Number of 100:", m100
			};
			int option = JOptionPane.showConfirmDialog(null, message, "Bill break down", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
				int a = m5000.getText().equals("")? 0: (Integer.parseInt(m5000.getText()) * 5000);
				int b = m1000.getText().equals("")? 0: (Integer.parseInt(m1000.getText()) * 1000);
				int c = m500.getText().equals("")? 0: (Integer.parseInt(m500.getText()) * 500);
				int d = m100.getText().equals("")? 0: (Integer.parseInt(m100.getText()) * 100);
				//int val = (Integer.parseInt(m5000.getText()) * 5000) + (Integer.parseInt(m1000.getText()) * 1000) + (Integer.parseInt(m500.getText()) * 500) + (Integer.parseInt(m100.getText()) * 100);
				int val = a + b + c + d;
				return val;
			}
			else{
				return 0;
			}
		}
		
	}
	
	private class numpadAlt implements KeyListener{

		@Override
		public void keyPressed(KeyEvent event) {
			// TODO Auto-generated method stub
			if (event.getKeyCode() == KeyEvent.VK_W){
				cardNum.setText(cardNum.getText() + "1");
			}
			if (event.getKeyCode() == KeyEvent.VK_S){
				cardNum.setText(cardNum.getText() + "2");
			}
			if (event.getKeyCode() == KeyEvent.VK_K){
				cardNum.setText(cardNum.getText() + "3");
			}
			if (event.getKeyCode() == KeyEvent.VK_4){
				cardNum.setText(cardNum.getText() + "4");
			}
			if (event.getKeyCode() == KeyEvent.VK_5){
				cardNum.setText(cardNum.getText() + "5");
			}
			if (event.getKeyCode() == KeyEvent.VK_6){
				cardNum.setText(cardNum.getText() + "6");
			}
			if (event.getKeyCode() == KeyEvent.VK_7){
				cardNum.setText(cardNum.getText() + "7");
			}
			if (event.getKeyCode() == KeyEvent.VK_8){
				cardNum.setText(cardNum.getText() + "8");
			}
			if (event.getKeyCode() == KeyEvent.VK_9){
				cardNum.setText(cardNum.getText() + "9");
			}
			if (event.getKeyCode() == KeyEvent.VK_0){
				cardNum.setText(cardNum.getText() + "0");
			}
			
			if (event.getKeyCode() == KeyEvent.VK_BACK_SPACE){
				cardNum.setText(cardNum.getText().substring(0,cardNum.getText().length()-1));
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		
	}
	private class keyPressW extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			cardNum.setText(cardNum.getText() + "1");
				
			
		}}
	private class keyPressS extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			cardNum.setText(cardNum.getText() + "2");
				
			
		}}
	private class keyPressX extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			cardNum.setText(cardNum.getText() + "3");
				
			
		}}
	private class keyPressP extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			cardNum.setText(cardNum.getText() + "4");
				
			
		}}
	private class keyPressO extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			cardNum.setText(cardNum.getText() + "5");
				
			
		}}
	private class keyPressK extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			cardNum.setText(cardNum.getText() + "6");
				
			
		}}
	private class keyPressM extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			cardNum.setText(cardNum.getText() + "7");
				
			
		}}
	private class keyPressQ extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			cardNum.setText(cardNum.getText() + "0");
				
			
		}}
	
	}
