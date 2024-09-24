import java.sql.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

import java.sql.*;
public  class Login extends JFrame implements ActionListener
{
				Connection con;
		ResultSet rs;
		Statement stmt;


		JLabel L1=new JLabel("Uco Bank",JLabel.RIGHT);
		JLabel L2=new JLabel("User Id");
		JLabel L3=new JLabel("Password");
		JLabel L4=new JLabel();

		JTextField T1=new JTextField(20);
		JTextField T2=new JTextField(20);
		
		JButton B1=new JButton("Submit");
		JButton B2=new JButton("Cancel");
		 
		
		Login()
		{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		setBounds(100,100,500,200);
		setLayout(new GridLayout(4,2,5,5));
		L1.setBounds(20,20,20,20);
			L1.setFont(new Font("Arial",Font.BOLD,30));
			L2.setFont(new Font("Arial",Font.BOLD,20));
			L3.setFont(new Font("Arial",Font.BOLD,20));

			T1.setFont(new Font("Arial",Font.BOLD,15));
			T2.setFont(new Font("Arial",Font.BOLD,15));
			

		add(L1);add(L4);		
		add(L2);add(T1);
		add(L3);add(T2);

		add(B1);add(B2);

				B1.addActionListener(this);
				B2.addActionListener(this);

		setLocationRelativeTo(null);
		setVisible(true);
			try
			{
			 con=DB.getConnection();
			stmt=con.createStatement();
		
			rs=stmt.executeQuery("select * from login1");
			
			rs.next();
			
			}
		
		
		catch(Exception e2)
			{
					e2.printStackTrace();
			}
		 
}

			public void actionPerformed(ActionEvent e)
			
			{
				String id=null,pass=null;
				if(e.getSource()==B1)
				{
			
			
				String name=T1.getText();
										
			String password=T2.getText();
			try
			{
			 id=rs.getString(1);
			 pass=rs.getString(2);

			}
		catch(SQLException e3)
		{}

			if(name.equals(id) && password.equals(pass))
			{
				MainMenu.main(new String[]{});
				
			}
			else
			{
				JOptionPane.showMessageDialog(Login.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				T1.setText("");
				T2.setText("");
			}
		}
			
			if(e.getSource()==B2)
			{
				System.exit(0);
			}
	}
	public static void main(String args[])
	{
		new Login();
	}
}