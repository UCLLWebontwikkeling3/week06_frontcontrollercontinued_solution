package domain.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.model.Country;

public class CountryDbSql implements CountryDB{
	private Properties properties = new Properties();
	private String url;
	private String currentSchema;
	
	public CountryDbSql(Properties properties) {
		try {
			Class.forName("org.postgresql.Driver");
			this.properties = properties;
			this.url = properties.getProperty("url");
			this.currentSchema = properties.getProperty("currentSchema");
		} catch (ClassNotFoundException e) {
			throw new DbException(e.getMessage(), e);
		}
	}
	
	public List<Country> getAll () {
		List<Country> countries = new ArrayList<Country>();
		try (
				Connection connection = DriverManager.getConnection(url, properties);	
				Statement statement = connection.createStatement();
		) {
			ResultSet result = statement.executeQuery("SELECT * from " + currentSchema + ".country");
		
			while (result.next()) {
				String name = result.getString("name");
				String capital = result.getString("capital");
				int votes = result.getInt("votes");
				int inhabitants = result.getInt("inhabitants");
				Country country = new Country(name, inhabitants, capital, votes);
				countries.add(country);
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage(), e);
		}
		return countries;
	}
	
	public void add (Country country) {
		
	}
		

}
