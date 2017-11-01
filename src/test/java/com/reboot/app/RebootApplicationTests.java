package com.reboot.app;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.reboot.admin.ApplicationConfig;
import com.reboot.admin.dao.country.CountryDao;
import com.reboot.admin.model.Country;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, CountryDao.class})
public class RebootApplicationTests {

	@Autowired
	CountryDao countryDao;
	
	@Test
	public void getCountriesTest() {
		List<Country> countries = countryDao.getCountriesFromDB();
		assertEquals("Canada", countries.get(0).getName());
	}
	

	

}
