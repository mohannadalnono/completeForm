package awtFormApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;

/*
 * 
 * 
 * add Exceptions!!
 * 
 * 
 * */



public class connection{
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = null;
		public connection() {
			try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myinfo","mea","0000");
			statement = conn.createStatement();
			}catch(Exception e)
			{
				System.out.println("Not Connected! 1st");
				e.printStackTrace();
			}

		}
		
	public void addRecord(String nameim, String addresse, String hobbies, String gender, String lang, String choice) {	
		 String order = "insert into formI(name,addresse,hobbies,gender,lang,choice) values(?,?,?,?,?,?)";
		 
		try 
		{
			//add
			PreparedStatement stmt = conn.prepareStatement(order);
			stmt.setString(1, nameim);
			stmt.setString(2, addresse);
			stmt.setString(3, hobbies);
			stmt.setString(4, gender);
			stmt.setString(5, lang);
			stmt.setString(6, choice);
			stmt.executeUpdate();

		}
		catch(Exception e)
		{
			System.out.println("peut pas add!");
			e.printStackTrace();
		}
	}
	public void deleteRecordID(int id) {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myinfo","mea","0000");
			statement = conn.createStatement();
			//delete
			conn.prepareStatement("delete from formI where id = "+ id ).executeUpdate();
					}
		catch(Exception e)
		{
			System.out.println("Not Connected!");
			e.printStackTrace();
		}
	}
	public List<client> getRecordes() {
		List<client> clients = new ArrayList<client>();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myinfo","mea","0000");
			statement = conn.createStatement();
			//read
			resultSet = statement.executeQuery("select * from formI ");
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String addresse = resultSet.getString(3);
				String hobb = resultSet.getString(4);
				String gender = resultSet.getString(5);
				String lang = resultSet.getString(6);
				String choice = resultSet.getString(7);
				clients.add(new client(id, name, addresse, hobb, gender, lang, choice));
			}
			return clients;
		}
		catch(Exception e)
		{
			System.out.println("Not Connected!");
			e.printStackTrace();
			return clients;
		}
	}
	public void importdata(String path) {
		File f = new File(path);
		try {
			Scanner s = new Scanner(f);
			while(s.hasNextLine()) {
				String dating = s.nextLine();
				String[] dataInsert = dating.split(",");
				String order = "insert into formI(name,addresse,hobbies,gender,lang,choice) values(?,?,?,?,?,?)";
				 
				try 
				{
					//add
					PreparedStatement stmt = conn.prepareStatement(order);
					stmt.setString(1, dataInsert[0]);
					stmt.setString(2, dataInsert[1]);
					stmt.setString(3, dataInsert[2]);
					stmt.setString(4, dataInsert[3]);
					stmt.setString(5, dataInsert[4]);
					stmt.setString(6, dataInsert[5]);
					stmt.executeUpdate();

				}
				catch(Exception e)
				{
					System.out.println("peut pas add!");
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



/*
creating DB :
	CREATE TABLE formI (
	     id MEDIUMINT NOT NULL AUTO_INCREMENT,
	     name CHAR(50),
	     addresse CHAR(70),
	     hobbies CHAR(70),
	     gender CHAR(10),
	     lang CHAR(70),
	     choice CHAR(50),
	     PRIMARY KEY (id)
	);
*/