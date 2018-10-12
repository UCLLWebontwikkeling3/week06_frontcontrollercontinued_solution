package domain.db;

import java.util.List;

import domain.model.Country;

public interface CountryDB {

	void add(Country country);

	List<Country> getAll();
	

}
