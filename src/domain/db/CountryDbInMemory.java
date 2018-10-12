package domain.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.model.Country;

public class CountryDbInMemory implements CountryDB {
	private Map<String, Country> countries = new HashMap<String, Country>();
	
	public CountryDbInMemory () {
		add(new Country("Belgie", 11000000, "Brussel", 4));
		add(new Country("Nederland", 20000000, "Amsterdam", 4));
	}
	
	public void add(Country country){
		countries.put(country.getName(), country);
	}
	
	public void create(String name){
		Country country = new Country(name);
		countries.put(name, country);
	}
	
	public List<Country> getAll(){
		return new ArrayList<Country>(countries.values());
	}

}
