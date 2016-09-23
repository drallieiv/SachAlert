package com.herazade.sachalert.api;

public class PokemonEncounterInstance implements PokemonEncounter{
	private Double disappearTime;

	private Integer pokemonId;

	private String spawnpointId;

	private Double longitude;

	private Double latitude;

	private String encounterId;

	public Double getDisappearTime() {
		return disappearTime;
	}

	public void setDisappearTime(Double disappearTime) {
		this.disappearTime = disappearTime;
	}

	public Integer getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(Integer pokemonId) {
		this.pokemonId = pokemonId;
	}

	public String getSpawnpointId() {
		return spawnpointId;
	}

	public void setSpawnpointId(String spawnpointId) {
		this.spawnpointId = spawnpointId;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}

	@Override
	public String toString() {
		return "PokemonEncounterInstance [" + (disappearTime != null ? "disappearTime=" + disappearTime + ", " : "") + (pokemonId != null ? "pokemonId=" + pokemonId + ", " : "") + (spawnpointId != null ? "spawnpointId=" + spawnpointId + ", " : "")
				+ (longitude != null ? "longitude=" + longitude + ", " : "") + (latitude != null ? "latitude=" + latitude + ", " : "") + (encounterId != null ? "encounterId=" + encounterId : "") + "]";
	}
	
	

}
