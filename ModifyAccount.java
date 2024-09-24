import java.sql.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public  class ModifyAccount extends JFrame implements ActionListener
{
		Connection con;
		ResultSet rs;
		Statement stmt;
int acn;

		JLabel L1=new JLabel("Modify Account",JLabel.RIGHT);
		JLabel L2=new JLabel("Account No");
		JLabel L3=new JLabel("Customer Name");
		JLabel L4=new JLabel("Address");
		JLabel L5=new JLabel("City");
		JLabel L6=new JLabel("State");
		JLabel L7=new JLabel("Country");
		JLabel L8=new JLabel("Pin");
		JLabel L9=new JLabel("Mobile No");
		JLabel L10=new JLabel("Adhar No");
		JLabel L11=new JLabel("Account No");
		JLabel L12=new JLabel();
		


		JTextField T1=new JTextField(20);
		JTextField T2=new JTextField(20);
		JTextField T3=new JTextField(20);
		JTextField T4=new JTextField(20);
		JTextField T5=new JTextField(20);
		JTextField T6=new JTextField(20);
		JTextField T7=new JTextField(20);
		JTextField T8=new JTextField(20);
		JTextField T9=new JTextField(20);
		JTextField T10=new JTextField(20);
		

		JButton B1=new JButton("Search");
		JButton B2=new JButton("Update");
		JButton B3=new JButton("Cancel");
		JButton B4=new JButton("Close");
		
		
		ModifyAccount()
		{
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(13,2,10,10));

			
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
			L11.setFont(new Font("Arial",Font.BOLD,25));

			T1.setFont(new Font("Arial",Font.BOLD,20));
			T2.setFont(new Font("Arial",Font.BOLD,20));
			T3.setFont(new Font("Arial",Font.BOLD,20));
			T4.setFont(new Font("Arial",Font.BOLD,20));
			T5.setFont(new Font("Arial",Font.BOLD,20));
			T6.setFont(new Font("Arial",Font.BOLD,20));
			T7.setFont(new Font("Arial",Font.BOLD,20));
			T8.setFont(new Font("Arial",Font.BOLD,20));
			T9.setFont(new Font("Arial",Font.BOLD,20));
			T10.setFont(new Font("Arial",Font.BOLD,20));
			

		add(L1);add(L12);
		add(L2);add(T1);
		add(B1);add(B3);
		add(L3);add(T2);
		add(L4);add(T3);
		add(L5);add(T4);
		add(L6);add(T5);
		add(L7);add(T6);
		add(L8);add(T7);
		add(L9);add(T8);
		add(L10);add(T9);
		add(L11);add(T10);
		add(B2);add(B4);
		

		B1.addActionListener(this);
		B2.addActionListener(this);
		B3.addActionListener(this);
		B4.addActionListener(this);

		L3.setVisible(false);
		L4.setVisible(false);
		L5.setVisible(false);
		L6.setVisible(false);
		L7.setVisible(false);
		L8.setVisible(false);
		L9.setVisible(false);
		L10.setVisible(false);
		L11.setVisible(false);

		T2.setVisible(false);
		T3.setVisible(false);
		T4.setVisible(false);
		T5.setVisible(false);
		T6.setVisible(false);
		T7.setVisible(false);
		T8.setVisible(false);
		T9.setVisible(false);
		T10.setVisible(false);
		B2.setVisible(false);
		B4.setVisible(false);

		setSize(1000,600);
		setLocationRelativeTo(null);
		setVisible(true);
		try
			{
			 con=DB.getConnection();
			 stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			}
		
		catch(Exception e)
			{}
	}
		public void actionPerformed(ActionEvent e)
		{		
						
		//	System.out.println("Hello");
				try
				{
					acn=Integer.parseInt(T1.getText());
					//System.out.println(acn);
				rs=stmt.executeQuery("select * from account where AccountNo="+acn);
				
						rs.next();

					int x=rs.getRow();
					
					if(x<=0)
					{
						JOptionPane.showMessageDialog(null,"Record not found...");
					}
					else{
				String name=rs.getString(1);
				 String add=rs.getString(2);
				 String city=rs.getString(3);
				 String state=rs.getString(4);
				 String country=rs.getString(5);
				int  pin=rs.getInt(6);
				 long mob=rs.getLong(7);
				 long aadhar=rs.getLong(8);
					int accn=rs.getInt(9);				
				
			if(e.getSource()==B1)
			{
									
						T2.setText(name);
						T3.setText(add);
						T4.setText(city);
						T5.setText(state);
						T6.setText(country);
						T7.setText(String.valueOf(pin));
						T8.setText(String.valueOf(mob));
						T9.setText(String.valueOf(aadhar));
						T10.setText(String.valueOf(accn));
						T10.setEditable(false);


						L3.setVisible(true);
						L4.setVisible(true);
						L5.setVisible(true);
						L6.setVisible(true);
						L7.setVisible(true);
						L8.setVisible(true);
						L9.setVisible(true);
						L10.setVisible(true);
						L11.setVisible(true);

						T2.setVisible(true);
						T3.setVisible(true);
						T4.setVisible(true);
						T5.setVisible(true);
						T6.setVisible(true);
						T7.setVisible(true);
						T8.setVisible(true);
						T9.setVisible(true);
						T10.setVisible(true);
						B2.setVisible(true);
						B4.setVisible(true);
				
			}
		}}
		catch(Exception e1)
		{

			e1.printStackTrace();
		}


			if(e.getSource()==B2)
				{
			
				int pin,acc;
				long mob,adhar;
		//char name,date,course;

		String n=T2.getText();
		String ad=T3.getText();
		 String city=T4.getText();
		String state=T5.getText();
		String country=T6.getText();
		 pin=Integer.parseInt(T7.getText());
		 mob=Long.parseLong(T8.getText());
		adhar=Long.parseLong(T9.getText());
		acc=Integer.parseInt(T10.getText());
		
		try
		{
			
			int y=stmt.executeUpdate("Update account set Customername='"+n+"', Address='"+ad+"',City='"+city+"',State='"+state+"',Country='"+country+"',Pin="+pin+",Mobile="+mob+",Adharno="+adhar+" Where Accountno="+acc);
			if(y>0)
			{
			JOptionPane.showMessageDialog(null,"Updated Successfully...");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Can't be updated...");
			}
		}
		catch(SQLException e6)
		{}

		}

			if(e.getSource()==B3)
			{
				T1.setText("");
			}

			if(e.getSource()==B4)
			{
				System.exit(0);
			}
		}
	
}