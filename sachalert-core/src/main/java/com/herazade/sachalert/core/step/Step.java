package com.herazade.sachalert.core.step;

import com.herazade.sachalert.api.PokemonAlert;

public interface Step {

	/**
	 * Try to process an alert
	 * @param alert
	 * @return true if success and should go to next
	 */
	boolean process(PokemonAlert alert);
}
