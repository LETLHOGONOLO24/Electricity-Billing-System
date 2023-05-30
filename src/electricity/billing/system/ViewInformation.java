package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewInformation extends JFrame implements ActionListener {
	
	JButton cancel;
	
	ViewInformation(String meter)
	{
		setBounds(350, 150, 850, 650);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
		heading.setBounds(250, 0, 500, 40);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(heading);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(70, 80, 100, 20);
		add(lblname);
		
		JLabel name = new JLabel("");
		name.setBounds(250, 80, 100, 20);
		add(name);
		
		JLabel lblmeternumber = new JLabel("Meter Number");
		lblmeternumber.setBounds(70, 140, 100, 20);
		add(lblmeternumber);
		
		JLabel meternumber = new JLabel("");
		meternumber.setBounds(250, 140, 100, 20);
		add(meternumber);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(70, 200, 100, 20);
		add(lbladdress);
		
		JLabel address = new JLabel("");
		address.setBounds(250, 200, 100, 20);
		add(address);
		
		JLabel lblcity = new JLabel("City");
		lblcity.setBounds(70, 260, 100, 20);
		add(lblcity);
		
		JLabel city = new JLabel("");
		city.setBounds(250, 260, 100, 20);
		add(city);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setBounds(470, 80, 100, 20);
		add(lblProvince);
		
		JLabel province = new JLabel("");
		province.setBounds(610, 80, 100, 20);
		add(province);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(470, 140, 130, 20);
		add(lblemail);
		
		JLabel email = new JLabel("");
		email.setBounds(610, 140, 130, 20);
		add(email);
		
		JLabel lblphone = new JLabel("Phone Number");
		lblphone.setBounds(470, 200, 100, 20);
		add(lblphone);
		
		JLabel phone = new JLabel("");
		phone.setBounds(610, 200, 100, 20);
		add(phone);
		
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
			
			while (rs.next())
			{
				name.setText(rs.getString("name"));
				address.setText(rs.getString("address"));
				city.setText(rs.getString("city"));
				province.setText(rs.getString("province"));
				
				email.setText(rs.getString("email"));
				phone.setText(rs.getString("phone"));
				meternumber.setText(rs.getString("meter_no"));
				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(350, 340, 100, 25);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\viewcustomer.jpg");
		Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(20, 350, 600, 300);
		add(image);
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
	}
	
	public static void main(String[] args)
	{
		new ViewInformation("");
	}

}
