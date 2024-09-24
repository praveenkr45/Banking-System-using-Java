import java.sql.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public  class User extends JFrame implements ActionListener
{
		
		Connection con;
		ResultSet rs;
		Statement stmt;

		JLabel L1=new JLabel("Create User Id");
		JLabel L2=new JLabel("Name:");
		JLabel L3=new JLabel("Email:");
		JLabel L4=new JLabel("User Name:");
		JLabel L5=new JLabel("Password:");


		JTextField T1=new JTextField(20);
		JTextField T2=new JTextField(20);
		JTextField T3=new JTextField(20);
		JTextField T4=new JTextField(20);

			JButton B1=new JButton("Add User");
		JButton B2=new JButton("Cancel");

		User()
		{
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		Container cont=getContentPane();
		cont.setBackground(Color.cyan);
		L1.setForeground(Color.red);
		B1.setBackground(Color.blue);
		B1.setForeground(Color.white);
		B2.setBackground(Color.blue);
		B2.setForeground(Color.white);
		
		add(L1);add(L2);add(L3);add(L4);add(L5);
		add(T1);add(T2);add(T3);add(T4);add(B1);add(B2);
			
			L1.setFont(new Font("Arial",Font.BOLD,30));
			L2.setFont(new Font("Arial",Font.BOLD,25));
			L3.setFont(new Font("Arial",Font.BOLD,25));
			L4.setFont(new Font("Arial",Font.BOLD,25));
			L5.setFont(new Font("Arial",Font.BOLD,25));


			T1.setFont(new Font("Arial",Font.BOLD,20));
			T2.setFont(new Font("Arial",Font.BOLD,20));
			T3.setFont(new Font("Arial",Font.BOLD,20));
			T4.setFont(new Font("Arial",Font.BOLD,20));
			

			L1.setBounds(300,10,400,100);
			L2.setBounds(100,80,400,100);
			T1.setBounds(290,115,250,30);
			L3.setBounds(100,120,400,100);
			T2.setBounds(290,155,250,30);
			L4.setBounds(100,165,400,100);
			T3.setBounds(290,200,250,30);
			L5.setBounds(100,210,400,100);
			T4.setBounds(290,245,250,30);

			B1.setBounds(300,300,100,50);
			B2.setBounds(430,300,100,50);

			B1.addActionListener(this);
			B2.addActionListener(this);

		setSize(800,500);
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
		
		if(e.getSource()==B1)
		{
		String name=T1.getText();
		String email=T2.getText();
		 String username=T3.getText();
		String pass=T4.getText();
		
		try
		{
			
			int x=stmt.executeUpdate("insert into user1 values('"+name+ "','"+email+"','"+username+"','"+pass+"')");
		
		//con.close();
			if(x>0)
			{
			JOptionPane.showMessageDialog(null,"Inserted Successfully...");
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
			T1.setText("");
			T2.setText("");
			T3.setText("");
			T4.setText("");
		}
	}	
	
		}
