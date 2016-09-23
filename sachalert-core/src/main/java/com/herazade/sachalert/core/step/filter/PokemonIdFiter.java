package com.herazade.sachalert.core.step.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.herazade.sachalert.api.PokemonAlert;
import com.herazade.sachalert.core.step.BaseStep;

public abstract class PokemonIdFiter extends BaseStep {

	Logger logger = LoggerFactory.getLogger(getClass());

	public boolean process(PokemonAlert alert) {
		if (alert.getEncounter() == null) {
			return false;
		}

		boolean keep = filterByPokemonId(alert.getEncounter().getPokemonId());
		
		if(keep){
			return getNext().process(alert);
		}
		return false;
	}

	abstract boolean filterByPokemonId(Integer pokemonId);

}
