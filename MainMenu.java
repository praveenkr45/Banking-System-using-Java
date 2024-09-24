import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class MainMenu extends JFrame implements ActionListener
{
	JMenuBar mb=new JMenuBar();
	JMenu master=new JMenu("Master");
	JMenu transaction=new JMenu("Transaction");
	JMenu report=new JMenu("Report");
	JMenuItem i1=new JMenuItem("Open Account");
	JMenuItem i2=new JMenuItem("Delete Account");
	JMenuItem i3=new JMenuItem("Modify Account");
	JMenuItem i4=new JMenuItem("Create User");
	JMenuItem i5=new JMenuItem("Deposit");
	JMenuItem i6=new JMenuItem("Withdrawl");
	JMenuItem i7=new JMenuItem("Print Passbook");
	JMenuItem i8=new JMenuItem("Show A/C Balance");

	MainMenu()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		master.add(i1);master.add(i2);master.add(i3);master.add(i4);transaction.add(i5);transaction.add(i6);
		report.add(i7);report.add(i8);
		mb.add(master);
		mb.add(transaction);
		mb.add(report);
		setJMenuBar(mb);

		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		i5.addActionListener(this);
		i6.addActionListener(this);
		i7.addActionListener(this);
		i8.addActionListener(this);
		//setSize(700,700);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);


		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
			if(e.getSource()==i1)
				{
					//OpenAccount.main(new String[]{});
					new OpenAccount();

				}

			if(e.getSource()==i2)
			{
				new DeleteAccount();
			}

			if(e.getSource()==i3)
			{
				new ModifyAccount();
			}	
			if(e.getSource()==i4)
			{
				new User();
			}
			if(e.getSource()==i5)
			{
				new Deposit();
			}

			if(e.getSource()==i6)
			{
				new Withdrawal();
			}

			if(e.getSource()==i7)
			{
				new Passbook();
			}

			if(e.getSource()==i8)
			{
				new CheckBalance();
			}
	}
			
			
	public static void main(String args[])
	{
		new MainMenu();
	}

}