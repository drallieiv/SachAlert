package com.herazade.sachalert.core.step;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.herazade.sachalert.api.PokemonAlert;
import com.herazade.sachalert.api.PokemonEncounter;
import com.herazade.sachalert.com.config.TestAlertConfiguration;
import com.herazade.sachalert.core.AlertWorkFlow;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAlertConfiguration.class)
public class ScenarioTest {

	@Autowired
	private AlertWorkFlow AlertWorkFlow;

	@Autowired
	@Qualifier("pikachu1")
	private PokemonEncounter pikachu;
	
	@Autowired
	@Qualifier("pikachu2")
	private PokemonEncounter pikachuVaise;
	
	@Autowired
	@Qualifier("roucool")
	private PokemonEncounter roucool;
	
	@Autowired
	@Qualifier("arcanin")
	private PokemonEncounter arcanin;


	@Test
	public void pikachuOk() {
		PokemonAlert alert = new PokemonAlert(pikachu);
		boolean result = AlertWorkFlow.process(alert);
		Assert.assertTrue(result);
	}
	
	@Test
	public void archaninOk() {
		PokemonAlert alert = new PokemonAlert(arcanin);
		boolean result = AlertWorkFlow.process(alert);
		Assert.assertTrue(result);
	}

	@Test
	public void pikachuOutside() {
		PokemonAlert alert = new PokemonAlert(pikachuVaise);
		boolean result = AlertWorkFlow.process(alert);
		Assert.assertFalse(result);
	}
	
	@Test
	public void roucoulInside() {
		PokemonAlert alert = new PokemonAlert(roucool);
		boolean result = AlertWorkFlow.process(alert);
		Assert.assertFalse(result);
	}
}
