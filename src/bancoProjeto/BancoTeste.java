package bancoProjeto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoTeste {
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url= "jdbc:sqlserver://35.225.192.75:1433";
		String user="SA";
		String passwd="<YourNewStrong!Passw0rd>";
		String dataBase="dbClass";
		String connectionUrl=url+";database="+ dataBase+";user="+user+";password="+passwd+";";
		
		Connection conn = DriverManager.getConnection(connectionUrl);
		
		String query="select name from sys.Databases";
		PreparedStatement ps =conn.prepareStatement(query);
		
		//String query2="create database falcao";
		//PreparedStatement ps1 = conn.prepareStatement(query2);
		
		ResultSet rs = ps.executeQuery();
		//ResultSet rs = ps1.executeQuery();
		
		
		while (rs.next()){
			String name = rs.getString("Name");
			System.out.println(name);
		}
		
	rs.close();
	ps.close();
	conn.close();
	
	}
	
}
