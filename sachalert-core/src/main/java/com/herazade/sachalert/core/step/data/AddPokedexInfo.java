package com.herazade.sachalert.core.step.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.herazade.sachalert.api.PokemonAlert;
import com.herazade.sachalert.core.data.Pokedex;
import com.herazade.sachalert.core.step.BaseStep;

public class AddPokedexInfo extends BaseStep {

	Logger logger = LoggerFactory.getLogger(getClass());
	

	@Autowired
	private Pokedex pokedex;
		
	public boolean process(PokemonAlert alert) {
		Integer pokemonId = alert.getEncounter().getPokemonId();
		
		alert.getContext().put(PokemonAlert.NAME, pokedex.getName(pokemonId));
		
		logger.debug("Pokedex data added");
		return getNext().process(alert);
	}

}
