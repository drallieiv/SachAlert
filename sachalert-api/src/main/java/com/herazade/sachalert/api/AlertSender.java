package com.herazade.sachalert.api;

/**
 * Message Endpoint EIP
 * @author drallieiv
 *
 */
public interface AlertSender {
	
	/**
	 * True if success
	 * @param alert
	 */
	boolean send(PokemonAlert alert);
}
