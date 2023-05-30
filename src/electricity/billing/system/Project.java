package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
	
	String atype, meter;
	
	Project(String atype, String meter)
	{
		this.atype = atype;
		this.meter = meter;
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\elect1.jpg");
		Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		
		JMenu master = new JMenu("Master");
		master.setForeground(Color.BLUE);
		
		JMenuItem newcustomer = new JMenuItem("New Customer");
		newcustomer.setFont(new Font("monospaced", Font.PLAIN, 12));
		newcustomer.setBackground(Color.WHITE);
		ImageIcon icon1 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\icon1.png");
		Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		newcustomer.setIcon(new ImageIcon(image1));
		newcustomer.setMnemonic('D');
		newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		newcustomer.addActionListener(this);
		master.add(newcustomer);
		
		JMenuItem customerDetails = new JMenuItem("Customer Details");
		customerDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
		customerDetails.setBackground(Color.WHITE);
		ImageIcon icon2 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\icon2.png");
		Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		customerDetails.setIcon(new ImageIcon(image2));
		customerDetails.setMnemonic('M');
		customerDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		customerDetails.addActionListener(this);
		master.add(customerDetails);
		
		JMenuItem depositDetails = new JMenuItem("Deposit Details");
		depositDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
		depositDetails.setBackground(Color.WHITE);
		ImageIcon icon3 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\icon3.png");
		Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		depositDetails.setIcon(new ImageIcon(image3));
		depositDetails.setMnemonic('N');
		depositDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		depositDetails.addActionListener(this);
		master.add(depositDetails);
		
		JMenuItem calculateBill = new JMenuItem("Calculate Bill");
		calculateBill.setFont(new Font("monospaced", Font.PLAIN, 12));
		calculateBill.setBackground(Color.WHITE);
		ImageIcon icon4 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\icon5.png");
		Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		calculateBill.setIcon(new ImageIcon(image4));
		calculateBill.setMnemonic('B');
		calculateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		calculateBill.addActionListener(this);
		master.add(calculateBill);
		
		JMenu info = new JMenu("Information");
		info.setForeground(Color.RED);
		
		JMenuItem updateInfo = new JMenuItem("Update Information");
		updateInfo.setFont(new Font("monospaced", Font.PLAIN, 12));
		updateInfo.setBackground(Color.WHITE);
		ImageIcon icon5 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\icon4.png");
		Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		updateInfo.setIcon(new ImageIcon(image5));
		updateInfo.setMnemonic('P');
		updateInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		updateInfo.addActionListener(this);
		info.add(updateInfo);
		
		JMenuItem viewInfo = new JMenuItem("View Information");
		viewInfo.setFont(new Font("monospaced", Font.PLAIN, 12));
		viewInfo.setBackground(Color.WHITE);
		ImageIcon icon6 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\icon6.png");
		Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		viewInfo.setIcon(new ImageIcon(image6));
		viewInfo.setMnemonic('L');
		viewInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		viewInfo.addActionListener(this);
		info.add(viewInfo);
		
		JMenu user = new JMenu("User");
		user.setForeground(Color.BLUE);
		
		JMenuItem payBill = new JMenuItem("Pay Bill");
		payBill.setFont(new Font("monospaced", Font.PLAIN, 12));
		payBill.setBackground(Color.WHITE);
		ImageIcon icon7 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\icon4.png");
		Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		payBill.setIcon(new ImageIcon(image7));
		payBill.setMnemonic('R');
		payBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		payBill.addActionListener(this);
		user.add(payBill);
		
		JMenuItem billDetails = new JMenuItem("Bill Details");
		billDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
		billDetails.setBackground(Color.WHITE);
		ImageIcon icon8 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\icon6.png");
		Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		billDetails.setIcon(new ImageIcon(image8));
		billDetails.setMnemonic('B');
		billDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		billDetails.addActionListener(this);
		user.add(billDetails);
		
		JMenu report = new JMenu("Report");
		report.setForeground(Color.RED);
		
		JMenuItem generateBill = new JMenuItem("Generate Bill");
		generateBill.setFont(new Font("monospaced", Font.PLAIN, 12));
		generateBill.setBackground(Color.WHITE);
		ImageIcon icon9 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\icon7.png");
		Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		generateBill.setIcon(new ImageIcon(image9));
		generateBill.setMnemonic('G');
		generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		generateBill.addActionListener(this);
		report.add(generateBill);
		
		JMenu utility = new JMenu("Utility");
		utility.setForeground(Color.BLUE);
		
		JMenuItem notepad = new JMenuItem("Notepad");
		notepad.setFont(new Font("monospaced", Font.PLAIN, 12));
		notepad.setBackground(Color.WHITE);
		ImageIcon icon10 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\icon12.png");
		Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		notepad.setIcon(new ImageIcon(image10));
		notepad.setMnemonic('N');
		notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		notepad.addActionListener(this);
		utility.add(notepad);
		
		JMenuItem calculator = new JMenuItem("Calculator");
		calculator.setFont(new Font("monospaced", Font.PLAIN, 12));
		calculator.setBackground(Color.WHITE);
		ImageIcon icon11 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\icon9.png");
		Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		calculator.setIcon(new ImageIcon(image11));
		calculator.setMnemonic('C');
		calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		calculator.addActionListener(this);
		utility.add(calculator);
		
		JMenu mexit = new JMenu("Exit");
		mexit.setForeground(Color.RED);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.setFont(new Font("monospaced", Font.PLAIN, 12));
		exit.setBackground(Color.WHITE);
		ImageIcon icon12 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\icon11.png");
		Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		exit.setIcon(new ImageIcon(image12));
		exit.setMnemonic('W');
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		exit.addActionListener(this);
		mexit.add(exit);
		
		if (atype.equals("Admin"))
		{
			mb.add(master);
		}
		else
		{
			mb.add(info);
			mb.add(user);
			mb.add(report);
		}
		
		mb.add(utility);
		mb.add(mexit);
		
		
		setLayout(new FlowLayout());
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String msg = ae.getActionCommand();
		if (msg.equals("New Customer"))
		{
			new NewCustomer();
		}
		else if (msg.equals("Customer Details"))
		{
			new CustomerDetails();
		}
		else if (msg.equals("Deposit Details"))
		{
			new DepositDetails();
		}
		else if (msg.equals("Calculate Bill"))
		{
			new CalculateBill();
		}
		else if (msg.equals("View Information"))
		{
			new ViewInformation(meter);
		}
		else if (msg.equals("Update Information"))
		{
			new UpdateInformation(meter);
		}
		else if (msg.equals("Pay Bill"))
		{
			new PayBill(meter);
		}
		else if (msg.equals("Bill Details"))
		{
			new BillDetails(meter);
		}
		else if (msg.equals("Notepad"))
		{
			try
			{
				Runtime.getRuntime().exec("notepad.exe");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else if (msg.equals("Calculator"))
		{
			try
			{
				Runtime.getRuntime().exec("calc.exe");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else if (msg.equals("Exit"))
		{
			setVisible(false);
			new Login();
		}
		else if (msg.equals("Generate Bill"))
		{
			new GenerateBill(meter);
		}
	}

	public static void main(String[] args) {
		
		new Project("", "");
	}

}
