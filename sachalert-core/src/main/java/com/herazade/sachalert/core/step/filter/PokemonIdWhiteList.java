package com.herazade.sachalert.core.step.filter;

import java.util.Collection;
import java.util.HashSet;

/**
 * Filter if ID is not in whitelist
 * 
 * @author drallieiv
 *
 */
public class PokemonIdWhiteList extends PokemonIdFiter {

	private Collection<Integer> whitelist;

	public PokemonIdWhiteList() {
		this.whitelist = new HashSet<Integer>();
	}

	@Override
	boolean filterByPokemonId(Integer pokemonId) {
		boolean isWhitelisted = whitelist.contains(pokemonId);
		logger.debug("Pokemon #{} in whitelist : {}", pokemonId, isWhitelisted);
		return isWhitelisted;
	}

	public Collection<Integer> getWhitelist() {
		return whitelist;
	}

	public void setWhitelist(Collection<Integer> whitelist) {
		this.whitelist = whitelist;
	}

}