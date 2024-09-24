import java.sql.*;
class abc
{
	public static void main(String args[])
	{
		Connection con;
		ResultSet rs;
		Statement stmt;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","prakash");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from login1");
			System.out.println("\t\t Login Record\n");
			System.out.println("---------------------------------------------");
			System.out.println("Id\t Password");
			System.out.println("----------------------------------------------");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t" + rs.getString(2));

			}
			System.out.println("---------------------------------------------------");
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}