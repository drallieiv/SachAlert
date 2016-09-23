package com.herazade.sachalert.api;

/**
 * Message Filter EIP
 * @author drallieiv
 *
 */
public interface AlertFilter{

	/**
	 * True if the alert should not pass
	 * @param alert
	 * @return
	 */
	boolean filter(PokemonAlert alert);
}
