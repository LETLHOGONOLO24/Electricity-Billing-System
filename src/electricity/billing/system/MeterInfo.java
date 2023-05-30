package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MeterInfo extends JFrame implements ActionListener {
	
	JButton submit;
	Choice meterLocation, meterType, phaseCode, billType;
	String meternumber;
	
	MeterInfo(String meternumber)
	{
		this.meternumber = meternumber;
		
		setSize(700, 500);
		setLocation(400, 200);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173, 216, 230));
		add(p);
		
		JLabel heading = new JLabel("Meter Information");
		heading.setBounds(180, 10, 200, 20);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
		p.add(heading);
		
		JLabel lblmeterNum = new JLabel("Meter Number");
		lblmeterNum.setBounds(100, 80, 100, 20);
		p.add(lblmeterNum);
		
		JLabel lblmeternumber = new JLabel(meternumber);
		lblmeternumber.setBounds(240, 80, 100, 20);
		p.add(lblmeternumber);
		
		JLabel lblmeterlo = new JLabel("Meter Location"); // meterlo for meter location
		lblmeterlo.setBounds(100, 120, 100, 20);
		p.add(lblmeterlo);
		
		meterLocation = new Choice();
		meterLocation.add("Outside");
		meterLocation.add("Inside");
		meterLocation.setBounds(240, 120, 200, 20);
		p.add(meterLocation);
		
		JLabel lblmeterType = new JLabel("Meter Type");
		lblmeterType.setBounds(100, 160, 100, 20);
		p.add(lblmeterType);
		
		meterType = new Choice();
		meterType.add("Electric Meter");
		meterType.add("Solar Meter");
		meterType.add("Smart Meter");
		meterType.setBounds(240, 160, 200, 20);
		p.add(meterType);
		
		JLabel lblphase = new JLabel("Phase Code");
		lblphase.setBounds(100, 200, 100, 20);
		p.add(lblphase);
		
		phaseCode = new Choice();
		phaseCode.add("011");
		phaseCode.add("022");
		phaseCode.add("033");
		phaseCode.add("044");
		phaseCode.add("055");
		phaseCode.add("066");
		phaseCode.add("077");
		phaseCode.add("088");
		phaseCode.add("099");
		phaseCode.setBounds(240, 200, 200, 20);
		p.add(phaseCode);
		
		JLabel lblbill = new JLabel("Bill Type");
		lblbill.setBounds(100, 240, 100, 20);
		p.add(lblbill);
		
		billType = new Choice();
		billType.add("Normal");
		billType.add("Industrial");
		billType.setBounds(240, 240, 200, 20);
		p.add(billType);
		
		JLabel lbldays = new JLabel("Days");
		lbldays.setBounds(100, 280, 100, 20);
		p.add(lbldays);
		
		JLabel lbltdays = new JLabel("30 Days"); // tdays for 30 days
		lbltdays.setBounds(240, 280, 100, 20);
		p.add(lbltdays);
		
		JLabel lblnote = new JLabel("Note");
		lblnote.setBounds(100, 320, 100, 20);
		p.add(lblnote);
		
		JLabel lblnotes = new JLabel("By Default Bill is calculated for 30 days only");
		lblnotes.setBounds(240, 320, 500, 20);
		p.add(lblnotes);
		
		submit = new JButton("Submit");
		submit.setBounds(220, 390, 100, 25);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		p.add(submit);
		
		setLayout(new BorderLayout());
		
		add(p, "Center");
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\USER\\Documents\\eclipse-workspace\\Electricity Billing System\\src\\icons\\hicon1.jpg");
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
			String meter = meternumber;
			String location = meterLocation.getSelectedItem();
			String type = meterType.getSelectedItem();
			String code = phaseCode.getSelectedItem();
			String typebill = billType.getSelectedItem();
			String days = "30";
			
			String query = "insert into meter_info(meter_no, meter_location, meter_type, phase_code, bill_type, days) values('"+meter+"', '"+location+"', '"+type+"', '"+code+"', '"+typebill+"', '"+days+"')";
			
			try
			{
				Conn c = new Conn();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Meter Information Added Successfully");
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
		
		new MeterInfo("");

	}

}
