import java.sql.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public  class Deposit extends JFrame implements ActionListener
{
		
		Connection con;
		ResultSet rs;
		Statement stmt;
		int y;

		JLabel L1=new JLabel("Deposit Form");
		JLabel L2=new JLabel("A/c No:");
		JLabel L3=new JLabel("Date:");
		JLabel L4=new JLabel("Amount:");
		


		JTextField T1=new JTextField(20);
		JTextField T2=new JTextField(20);
		JTextField T3=new JTextField(20);
		JTextField T4=new JTextField(20);
		JTextField T5=new JTextField(20);

			JButton B1=new JButton("OK");
		JButton B2=new JButton("Reset");

		Deposit()
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
		
		add(L1);add(L2);add(L3);add(L4);
		add(T1);add(T2);add(T3);add(T4);add(T5);add(B1);add(B2);
			
			L1.setFont(new Font("Arial",Font.BOLD,30));
			L2.setFont(new Font("Arial",Font.BOLD,25));
			L3.setFont(new Font("Arial",Font.BOLD,25));
			L4.setFont(new Font("Arial",Font.BOLD,25));
		


			T1.setFont(new Font("Arial",Font.BOLD,20));
			T2.setFont(new Font("Arial",Font.BOLD,20));
			T3.setFont(new Font("Arial",Font.BOLD,20));
			T4.setFont(new Font("Arial",Font.BOLD,20));
			T5.setFont(new Font("Arial",Font.BOLD,20));
			

			L1.setBounds(300,10,400,100);
			L2.setBounds(100,80,400,100);
			T1.setBounds(290,115,250,30);
			L3.setBounds(100,120,400,100);
			T2.setBounds(290,155,80,30);
			T5.setBounds(373,155,80,30);
			T4.setBounds(456,155,80,30);
			L4.setBounds(100,165,400,100);
			T3.setBounds(290,200,250,30);
			

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
		
		if(e.getSource()==B2)
		{
			T1.setText("");
			T2.setText("");
			T3.setText("");
			T4.setText("");
			T5.setText("");
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
	
					}
					else{
		
		if(e.getSource()==B1)
		{
		//int accno=Integer.parseInt(T1.getText());
		String day=T2.getText();
		 String month=T5.getText();
		String year=T4.getText();
		int amt=Integer.parseInt(T3.getText());
		
		try
		{
			
			int x=stmt.executeUpdate("insert into deposit values("+acn+ ",'"+day+"','"+month+"','"+year+"',"+amt+")");
				rs=stmt.executeQuery("select * from balance where Accountno ="+acn);
				rs.next();
				int a=rs.getRow();
				
				if(a>0)
				{
					int b=stmt.executeUpdate("update balance set  Total=Total+"+amt+" Where Accountno="+acn);
					if(b>0)
					{
						JOptionPane.showMessageDialog(null,"Deposited Successfully...");
					}		
					else
	  				{
							JOptionPane.showMessageDialog(null,"Operation Failed...");
					}
				}
					else
				{
					
						int z=stmt.executeUpdate("insert into balance(Accountno,Total) values("+acn+","+amt+")");
				
					if(z>0)
					{
						JOptionPane.showMessageDialog(null,"Deposited Successfully...");
					}
							
					else
					{
						JOptionPane.showMessageDialog(null,"Operation failed...");	
					}
		}		}
		catch(SQLException e7)
		{

		}

		}}
		

		
	}	
		}
