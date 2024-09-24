import java.sql.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public  class CheckBalance extends JFrame implements ActionListener
{
		
		Connection con;
		ResultSet rs;
		Statement stmt;
		int y;

		JLabel L1=new JLabel("Check Account Balance");
		JLabel L2=new JLabel("A/c No:");
		JLabel L3=new JLabel();
		JLabel L4=new JLabel("");


		JTextField T1=new JTextField(20);
		
			JButton B1=new JButton("OK");
		JButton B2=new JButton("Reset");

		CheckBalance()
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
		
		add(L1);add(L2);add(L3);
		add(T1);add(B1);add(B2);add(L4);
			
			L1.setFont(new Font("Arial",Font.BOLD,30));
			L2.setFont(new Font("Arial",Font.BOLD,25));
			L3.setFont(new Font("Arial",Font.BOLD,25));
			


			T1.setFont(new Font("Arial",Font.BOLD,20));
			

			L1.setBounds(250,10,400,100);
			L2.setBounds(100,80,400,100);
			T1.setBounds(290,115,250,30);
			L3.setBounds(180,160,600,100);
				
			//L4.setBounds(130,120,500,100);
			

			B1.setBounds(300,300,100,50);
			B2.setBounds(430,300,100,50);

			B1.addActionListener(this);
			B2.addActionListener(this);

			L3.setVisible(false);
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
		
		if(e.getSource()==B2)
		{
			T1.setText("");
			L3.setText("");
		
			T1.requestFocus();
			return;
		}
		int	acn=Integer.parseInt(T1.getText());
					//System.out.println(acn);
				try
				{
				rs=stmt.executeQuery("select * from account where AccountNo="+acn);
				
						rs.next();

					 y=rs.getRow();
				}
				catch(Exception e7)
				{}	
					if(y<=0)
					{
						JOptionPane.showMessageDialog(null,"Invalid AccountNo...");
						T1.requestFocus();
					}
					else{
		
		if(e.getSource()==B1)
		{
			
		try
		{
			
			rs=stmt.executeQuery("select * from balance where Accountno ="+acn);
			rs.next();
			int bal=rs.getInt(2);
			//System.out.println(bal);
			L3.setText("Total Amount = Rs. "+String.valueOf(bal));
			L3.setVisible(true);
		}
		catch(Exception e8)
		{
			e8.printStackTrace();
		}
	}
}
		

		
	}	
		}
