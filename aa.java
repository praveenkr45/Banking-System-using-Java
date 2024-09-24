import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public  class aa extends JFrame 
{


		JLabel L1=new JLabel("Student Maintainance");
		JLabel L2=new JLabel("Roll");

		JTextField T1=new JTextField(20);

		aa()
		{
		setLayout(null);

			L1.setFont(new Font("Arial",Font.BOLD,30));
			L2.setFont(new Font("Arial",Font.BOLD,25));
			add(L1);add(L2);add(T1);

			L1.setBounds(50,30,290,90);
			L2.setBounds(80,90,90,80);
			T1.setBounds(140,120,90,20);



			setSize(500,300);
			setVisible(true);
		}
		public static void main(String args[])
		{
			new aa();
		}
	}