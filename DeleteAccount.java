import java.sql.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public  class DeleteAccount extends JFrame implements ActionListener
{
		Connection con;
		ResultSet rs;
		Statement stmt;
int x=0;

		JLabel L1=new JLabel("Delete Account",JLabel.RIGHT);
		JLabel L2=new JLabel("Account No");
		JLabel L3=new JLabel();

		JTextField T1=new JTextField(20);
	
		JButton B1=new JButton("Delete Account");
		
		
		
		DeleteAccount()
		{
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		//setBounds(100,600,200,200);
		
		setLayout(new GridLayout(3,2,10,10));

			L1.setFont(new Font("Arial",Font.BOLD,30));
			L2.setFont(new Font("Arial",Font.BOLD,25));
			L3.setFont(new Font("Arial",Font.BOLD,25));
			
			T1.setFont(new Font("Arial",Font.BOLD,20));
			

		add(L1);add(L3);
		add(L2);add(T1);
		add(B1);
		
		B1.addActionListener(this);
		
		setSize(500,200);
		setLocationRelativeTo(null);
		setVisible(true);
		try
			{
			 con=DB.getConnection();
			stmt=con.createStatement();
					
			}
		
		catch(Exception e)
			{

				e.printStackTrace();
			}
	}
	public void actionPerformed(ActionEvent e)
	{
		int acn=0;
		
		if(e.getSource()==B1)
		{
			String s=T1.getText();
			if(s.equals(""))
				acn=0;
			else
			acn=Integer.parseInt(T1.getText());
			try
			{	 
			
			if(acn==0)
			{
			JOptionPane.showMessageDialog(null,"Fill the account no.. ");
			}
			else
			{
			x=stmt.executeUpdate("delete from account where AccountNo="+acn);
			
			if(x>0)
			{
				JOptionPane.showMessageDialog(null,"Account deleted Successfully...");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Unable to delete...");	
			}
			}	
		con.close();
		}
			catch(Exception e4)
			{

				e4.printStackTrace();
			}
			
		
		}
			
}				
	
}