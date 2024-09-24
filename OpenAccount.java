import java.sql.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public  class OpenAccount extends JFrame implements ActionListener
{
		Connection con;
		ResultSet rs;
		Statement stmt;

int a;
		JLabel L1=new JLabel("Open Account",JLabel.RIGHT);
		JLabel L2=new JLabel("Customer Name");
		JLabel L3=new JLabel("Address");
		JLabel L4=new JLabel("City");
		JLabel L5=new JLabel("State");
		JLabel L6=new JLabel("Country");
		JLabel L7=new JLabel("Pin");
		JLabel L8=new JLabel("Mobile No");
		JLabel L9=new JLabel("Adhar No");
		JLabel L10=new JLabel("Account No");
		JLabel L11=new JLabel();

		JTextField T1=new JTextField(20);
		JTextField T2=new JTextField(20);
		JTextField T3=new JTextField(20);
		JTextField T4=new JTextField(20);
		JTextField T5=new JTextField(20);
		JTextField T6=new JTextField(20);
		JTextField T7=new JTextField(20);
		JTextField T8=new JTextField(20);
		JTextField T9=new JTextField(20);

		JButton B1=new JButton("Open Account");
		JButton B2=new JButton("Cancel");
		
		
		OpenAccount()
		{
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		//setBounds(100,600,200,200);
		
		setLayout(new GridLayout(11,2,10,10));

			L1.setFont(new Font("Arial",Font.BOLD,30));
			L2.setFont(new Font("Arial",Font.BOLD,25));
			L3.setFont(new Font("Arial",Font.BOLD,25));
			L4.setFont(new Font("Arial",Font.BOLD,25));
			L5.setFont(new Font("Arial",Font.BOLD,25));
			L6.setFont(new Font("Arial",Font.BOLD,25));
			L7.setFont(new Font("Arial",Font.BOLD,25));
			L8.setFont(new Font("Arial",Font.BOLD,25));
			L9.setFont(new Font("Arial",Font.BOLD,25));
			L10.setFont(new Font("Arial",Font.BOLD,25));

			T1.setFont(new Font("Arial",Font.BOLD,20));
			T2.setFont(new Font("Arial",Font.BOLD,20));
			T3.setFont(new Font("Arial",Font.BOLD,20));
			T4.setFont(new Font("Arial",Font.BOLD,20));
			T5.setFont(new Font("Arial",Font.BOLD,20));
			T6.setFont(new Font("Arial",Font.BOLD,20));
			T7.setFont(new Font("Arial",Font.BOLD,20));
			T8.setFont(new Font("Arial",Font.BOLD,20));
			T9.setFont(new Font("Arial",Font.BOLD,20));
			

		add(L1);add(L11);
		add(L2);add(T1);
		add(L3);add(T2);
		add(L4);add(T3);
		add(L5);add(T4);
		add(L6);add(T5);
		add(L7);add(T6);
		add(L8);add(T7);
		add(L9);add(T8);
		add(L10);add(T9);

		add(B1);add(B2);
		

		B1.addActionListener(this);
		B2.addActionListener(this);
		

		setSize(750,500);
		setLocationRelativeTo(null);
		setVisible(true);
		try
			{
			 con=DB.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from account_no");

			rs.next();
			a=rs.getInt(1);
			
			 T9.setText(String.valueOf(a));
			T9.setEditable(false);
		
			}
		
		catch(Exception e)
			{

				e.printStackTrace();
			}
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==B1)
		{
			
							

		String cname=T1.getText();
		String add=T2.getText();
		 String city=T3.getText();
		String state=T4.getText();
		String country=T5.getText();
		 int pin=Integer.parseInt(T6.getText());
		 long mobile=Long.parseLong(T7.getText());
		long adhar=Long.parseLong(T8.getText());
		int accountno=Integer.parseInt(T9.getText());
		
		try
		{
			
			int x=stmt.executeUpdate("insert into account values('"+cname+ "','"+add+"','"+city+"','"+state+"','"+country+"',"+pin+","+mobile+","+adhar+","+accountno+")");
		
		//con.close();
			if(x>0)
			{
			JOptionPane.showMessageDialog(null,"Account Opened Successfully...");
			stmt.executeUpdate("Update account_no set srno="+(a+1));
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Insertion failed...");	
			}
		}
		catch(SQLException e6)
		{}

		}
			
		

		
		if(e.getSource()==B2)
		{
		
			clr();
		}
}
		
		public void clr()
		{
			try
			{
				T1.setText("");
				T2.setText("");
				T3.setText("");
				T4.setText("");
				T5.setText("");
				T6.setText("");
				T7.setText("");
				T8.setText("");
				

				T1.requestFocus();
			}
			catch(Exception e5)
			{}
		}


		
	
}