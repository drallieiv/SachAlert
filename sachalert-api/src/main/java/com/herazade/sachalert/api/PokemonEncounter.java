package com.herazade.sachalert.api;

/**
 * Pokemon encounter (read only)
 * 
 * @author drallieiv
 *
 */
public interface PokemonEncounter {

	public Double getDisappearTime();

	public Integer getPokemonId();

	public String getSpawnpointId();

	public Double getLongitude();

	public Double getLatitude();

	public String getEncounterId();

}
