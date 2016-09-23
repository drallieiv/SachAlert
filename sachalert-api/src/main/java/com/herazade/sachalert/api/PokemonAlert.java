package com.herazade.sachalert.api;

import java.util.HashMap;
import java.util.Map;

public class PokemonAlert {
	
	public static final String NAME = "name";
	public static final String GPS = "location";
	public static final String NAV = "nav";
	public static final String DIRECTIONS = "directions";
	public static final String TXT = "txt";

	private Map<String, Object> context;

	private PokemonEncounter encounter;

	public PokemonAlert(PokemonEncounter encounter) {
		this.encounter = encounter;
		context = new HashMap<String, Object>();
	}

	public Map<String, Object> getContext() {
		return context;
	}

	public void setContext(Map<String, Object> context) {
		this.context = context;
	}

	public PokemonEncounter getEncounter() {
		return encounter;
	}

	@Override
	public String toString() {
		return "PokemonAlert [" + (context != null ? "context=" + context + ", " : "") + (encounter != null ? "encounter=" + encounter : "") + "]";
	}

	public <T> T getContextData(Class<T> clazz, String key) {

		Object data = context.get(key);
		if(data !=null && clazz.isInstance(data)){
			return clazz.cast(data);
		}
		return null;
	}
	
	public String getName(){
		return (String) context.getOrDefault(NAME, "pokemon");
	}
	
	public String getLocation(){
		return (String) context.getOrDefault(GPS, "");
	}
	
	public String getDirections(){
		return (String) context.getOrDefault(DIRECTIONS, "");
	}
	
	public String getTXT(){
		return (String) context.getOrDefault(TXT, "");
	}
	

}
