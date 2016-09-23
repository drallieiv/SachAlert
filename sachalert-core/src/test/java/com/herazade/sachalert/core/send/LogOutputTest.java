package com.herazade.sachalert.core.send;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.herazade.sachalert.api.PokemonAlert;
import com.herazade.sachalert.api.PokemonEncounter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:alertSample.xml")
public class LogOutputTest {

	@Autowired
	@Qualifier("pikachu1")
	private PokemonEncounter encounter;

	@Test
	public void logOutputTest() {

		PokemonAlert alert = new PokemonAlert(encounter);

		LogOutput out = new LogOutput();
		out.send(alert);
	}

}
