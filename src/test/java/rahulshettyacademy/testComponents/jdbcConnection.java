package rahulshettyacademy.testComponents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jdbcConnection{

	@Test
	public void mysqlConnection() throws SQLException
	{
//		 Class.forName("com.mysql.jdbc.Driver");
		String host="localhost";
		String port="3306";
		Connection connection=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/cinema_booking_system","root","root");
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from bookings where id=2;");
		resultSet.next();
	System.out.println(resultSet.getInt("screening_id"));
	}
}
