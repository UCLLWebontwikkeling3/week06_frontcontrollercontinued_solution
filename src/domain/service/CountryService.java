package domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.db.CountryDB;
import domain.db.CountryDbInMemory;
import domain.db.CountryDbSql;
import domain.model.Country;

public class CountryService {
	
	private CountryDB db;
	
	public CountryService (Properties properties) {
		//db = new CountryDbInMemory();
		db = new CountryDbSql(properties);
	}
	
	public void addCountry(Country country){
		db.add(country);
	}
	
	public List<Country> getCountries(){
		return db.getAll();
	}

	public Country getMostPopularCountry() {
		int highestVotes = -1;
		Country mostPopular = null;
		List<Country> countryList = getCountries();
		for(int i = 0; i < countryList.size(); i++){
			if(countryList.get(i).getVotes() > highestVotes){
				mostPopular = countryList.get(i);
				highestVotes = mostPopular.getVotes();
			}
		}
		return mostPopular;
	}

}
