package com.herazade.sachalert.core.step.filter;

import java.util.Collection;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Filter if id is in blacklist
 * 
 * @author drallieiv
 *
 */
public class PokemonIdBlackList extends PokemonIdFiter {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	private Collection<Integer> blackList;

	public PokemonIdBlackList() {
		this.blackList = new HashSet<Integer>();
	}

	@Override
	boolean filterByPokemonId(Integer pokemonId) {
		boolean isBlacklisted = blackList.contains(pokemonId);
		if(isBlacklisted){
			logger.info("Pokemon #{} is blacklisted",pokemonId);
		}
		return ! isBlacklisted;
	}

	public Collection<Integer> getBlackList() {
		return blackList;
	}

	public void setBlackList(Collection<Integer> blackList) {
		this.blackList = blackList;
	}

}
