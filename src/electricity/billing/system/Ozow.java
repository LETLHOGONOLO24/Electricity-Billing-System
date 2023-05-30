package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ozow extends JFrame implements ActionListener {
	
	String meter;
	JButton back;
	
	Ozow(String meter)
	
	{
		this.meter = meter;
		
		JEditorPane j = new JEditorPane();
		j.setEditable(false);
		
		try
		{
			j.setPage("https://ozow.com");
		}
		catch (Exception e)
		{
			j.setContentType("text/html");
			j.setText("<html>Could not load<html>");
		}
		
		JScrollPane pane = new JScrollPane(j);
		add(pane);
		
		back = new JButton("Back");
		back.setBounds(640, 160, 80, 30);
		back.addActionListener(this);
		j.add(back);
		
		setSize(800, 600);
		setLocation(400, 150);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new PayBill(meter);
	}
	
	public static void main(String[] args)
	{
		new Ozow("");
	}

}
