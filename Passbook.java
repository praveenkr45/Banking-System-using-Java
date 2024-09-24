import java.sql.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public  class Passbook extends JFrame implements ActionListener
{	
		
		Connection con;
		ResultSet rs;
		Statement stmt;
		String column[]={"DATE","DEPOSIT"};
		String column1[]={"DATE","WITHDRAWAL"};
		
		int y;


		JLabel L1=new JLabel("Passbook");
		JLabel L2=new JLabel("A/c No:");
		JLabel L3=new JLabel();
		JLabel L4=new JLabel();
		JLabel L5=new JLabel();


		JTextField T1=new JTextField(20);
		
			JButton B1=new JButton("OK");
		

		Passbook()
		{
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		Container cont=getContentPane();
		cont.setBackground(Color.cyan);
		L1.setForeground(Color.red);
		B1.setBackground(Color.blue);
		B1.setForeground(Color.white);
		
		
		
		add(L1);add(L2);add(L3);
		add(T1);add(B1);add(L4);add(L5);
		

			L1.setFont(new Font("Arial",Font.BOLD,40));
			L2.setFont(new Font("Arial",Font.BOLD,25));
			L3.setFont(new Font("Arial",Font.BOLD,25));
			L4.setFont(new Font("Arial",Font.BOLD,25));
			L5.setFont(new Font("Arial",Font.BOLD,25));


			T1.setFont(new Font("Arial",Font.BOLD,20));
			

			L1.setBounds(340,10,400,100);
			L2.setBounds(160,80,400,100);
			T1.setBounds(290,115,250,30);
			L3.setBounds(130,400,600,100);
			L4.setBounds(500,400,600,100);
			L5.setBounds(300,500,600,100);
						
			B1.setBounds(550,115,70,30);
			

			B1.addActionListener(this);
	
			L3.setVisible(false);
			L4.setVisible(false);
			L5.setVisible(false);

			setSize(1000,800);
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
			int total=0;
			
			rs=stmt.executeQuery("select * from deposit where Accountno ="+acn);
			rs.last();
			String data[][] = new String[rs.getRow()][2];
			int i=0,j=0;
			rs.first();
			rs.previous();
			while(rs.next())
		//	System.out.println(rs.getString(2));
			{
			data[i][0]=rs.getString(2)+"-"+rs.getString(3)+"-"+rs.getString(4);
			data[i][1]=String.valueOf(rs.getString(5));
			i++;
			 total=total+rs.getInt(5);
			L3.setText("Total Deposit = Rs. "+total);
			L3.setVisible(true);
			}


				JTable jt=new JTable(data,column);
					JScrollPane sp=new JScrollPane(jt);
					
					add(sp);
					sp.setBounds(100,200,300,200);


		
			int amnt=0;
			rs=stmt.executeQuery("select * from withdrawal where Accountno ="+acn);
			rs.last();
			String data1[][] = new String[rs.getRow()][2];
			int m=0,n=0;
			rs.first();
			rs.previous();
			while(rs.next())
		//	System.out.println(rs.getString(2));
			{
			data1[m][0]=rs.getString(2)+"-"+rs.getString(3)+"-"+rs.getString(4);
			data1[m][1]=String.valueOf(rs.getString(5));
			m++;
			amnt=amnt+rs.getInt(5);
			L4.setText("Total Withdrawal = Rs. "+amnt);
			L4.setVisible(true);
			
			}


				JTable tb=new JTable(data1,column1);
					JScrollPane js=new JScrollPane(tb);
					
					add(js);
					js.setBounds(500,200,300,200);

				int net=0;
				net=total-amnt;	
				L5.setText("Net Balance = Rs. "+net);
				L5.setVisible(true);
				

		}
		catch(Exception e8)
		{
			e8.printStackTrace();
		}
	}
}
		
	}}	
