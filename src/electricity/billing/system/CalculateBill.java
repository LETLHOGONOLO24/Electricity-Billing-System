package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class CalculateBill extends JFrame implements ActionListener {
	
	JTextField tfname, tfaddress, tfunits, tfProvince, tfemail, tfphone;
	JLabel lblname, labeladdress;
	JButton submit, cancel;
	Choice meternumber, cmonth;
	
	
	CalculateBill()
	{
		setSize(700, 500);
		setLocation(400, 150);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173, 216, 230));
		add(p);
		
		JLabel heading = new JLabel("Calculate Electricity Bill");
		heading.setBounds(100, 10, 400, 20);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
		p.add(heading);
		
		JLabel lblmeternum = new JLabel("Meter Number");
		lblmeternum.setBounds(100, 80, 100, 20);
		p.add(lblmeternum);
		
		meternumber = new Choice();
		meternumber.setBounds(240, 80, 200, 20);
		p.add(meternumber);
		
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			
			while (rs.next())
			{
				meternumber.add(rs.getString("meter_no"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(100, 120, 100, 20);
		p.add(lblName);
		
		lblname = new JLabel("");
		lblname.setBounds(240, 120, 100, 20);
		p.add(lblname);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(100, 160, 100, 20);
		p.add(lbladdress);
		
		labeladdress = new JLabel();
		labeladdress.setBounds(240, 160, 200, 20);
		p.add(labeladdress);
		
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meternumber.getSelectedItem()+"'");
			
			while (rs.next())
			{
				lblname.setText(rs.getString("name"));
				labeladdress.setText(rs.getString("address"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		meternumber.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent ie)
			{
				try
				{
					Conn c = new Conn();
					ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meternumber.getSelectedItem()+"'");
					
					while (rs.next())
					{
						lblname.setText(rs.getString("name"));
						labeladdress.setText(rs.getString("address"));
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblunitsConsumed = new JLabel("Units Consumed");
		lblunitsConsumed.setBounds(100, 200, 100, 20);
		p.add(lblunitsConsumed);
		
		tfunits = new JTextField();
		tfunits.setBounds(240, 200, 200, 20);
		p.add(tfunits);
		
		JLabel lblmonth = new JLabel("Month");
		lblmonth.setBounds(100, 240, 100, 20);
		p.add(lblmonth);
		
		cmonth = new Choice();
		cmonth.setBounds(240, 240, 200, 20);
		cmonth.add("January");
		cmonth.add("February");
		cmonth.add("March");
		cmonth.add("April");
		cmonth.add("May");
		cmonth.add("June");
		cmonth.add("July");
		cmonth.add("August");
		cmonth.add("September");
		cmonth.add("October");
		cmonth.add("November");
		cmonth.add("December");
		p.add(cmonth);
		
		submit = new JButton("Submit");
		submit.setBounds(120, 350, 100, 25);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		p.add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(250, 350, 100, 25);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		p.add(cancel);
		
		setLayout(new BorderLayout());
		
		add(p, "Center");
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\hicon2.jpg");
		Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image, "West");
		
		getContentPane().setBackground(Color.WHITE);
		
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource() == submit)
		{
			String meter = meternumber.getSelectedItem();
			String units = tfunits.getText();
			String month = cmonth.getSelectedItem();
			
			int totalbill = 0;
			int unit_consumed = Integer.parseInt(units);
			
			String query = "select * from tax";
			
			try
			{
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				
				while (rs.next())
				{
					totalbill += unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
					totalbill += Integer.parseInt(rs.getString("meter_rent"));
					totalbill += Integer.parseInt(rs.getString("service_charge"));
					totalbill += Integer.parseInt(rs.getString("service_tax"));
					totalbill += Integer.parseInt(rs.getString("nersa_tarrif"));
					totalbill += Integer.parseInt(rs.getString("fixed_tax"));
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			String query2 = "insert into bill(meter_no, month, units, totalbill, status) values('"+meter+"', '"+month+"', '"+units+"', '"+totalbill+"', 'Not Paid')";
			
			try
			{
				Conn c= new Conn();
				c.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
				setVisible(false);
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else
		{
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		
		new CalculateBill();

	}

}
