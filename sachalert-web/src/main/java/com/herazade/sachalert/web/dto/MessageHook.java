package com.herazade.sachalert.web.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageHook {

	@JsonProperty("disappear_time")
	private Double disappearTime;
	@JsonProperty("pokemon_id")
	private Integer pokemonId;
	@JsonProperty("spawnpoint_id")
	private String spawnpointId;
	@JsonProperty("longitude")
	private Double longitude;
	@JsonProperty("latitude")
	private Double latitude;
	@JsonProperty("encounter_id")
	private String encounterId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The disappearTime
	 */
	@JsonProperty("disappear_time")
	public Double getDisappearTime() {
		return disappearTime;
	}

	/**
	 * 
	 * @param disappearTime
	 *            The disappear_time
	 */
	@JsonProperty("disappear_time")
	public void setDisappearTime(Double disappearTime) {
		this.disappearTime = disappearTime;
	}

	/**
	 * 
	 * @return The pokemonId
	 */
	@JsonProperty("pokemon_id")
	public Integer getPokemonId() {
		return pokemonId;
	}

	/**
	 * 
	 * @param pokemonId
	 *            The pokemon_id
	 */
	@JsonProperty("pokemon_id")
	public void setPokemonId(Integer pokemonId) {
		this.pokemonId = pokemonId;
	}

	/**
	 * 
	 * @return The spawnpointId
	 */
	@JsonProperty("spawnpoint_id")
	public String getSpawnpointId() {
		return spawnpointId;
	}

	/**
	 * 
	 * @param spawnpointId
	 *            The spawnpoint_id
	 */
	@JsonProperty("spawnpoint_id")
	public void setSpawnpointId(String spawnpointId) {
		this.spawnpointId = spawnpointId;
	}

	/**
	 * 
	 * @return The longitude
	 */
	@JsonProperty("longitude")
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * 
	 * @param longitude
	 *            The longitude
	 */
	@JsonProperty("longitude")
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * 
	 * @return The latitude
	 */
	@JsonProperty("latitude")
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * 
	 * @param latitude
	 *            The latitude
	 */
	@JsonProperty("latitude")
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * 
	 * @return The encounterId
	 */
	@JsonProperty("encounter_id")
	public String getEncounterId() {
		return encounterId;
	}

	/**
	 * 
	 * @param encounterId
	 *            The encounter_id
	 */
	@JsonProperty("encounter_id")
	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
