package com.herazade.sachalert.core.data;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.herazade.sachalert.data.PokemonConst;

public class Pokedex {
	
	
	private Properties prop;

	public Pokedex() {
		YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
		ClassPathResource names = new ClassPathResource("lang.fr");
		factory.setResources(names);
		prop = factory.getObject();

	}
	
	public Set<Integer> getSuperCommons(){
		Set<Integer> superCommons = new HashSet<Integer>();
		
		superCommons.add(PokemonConst.CATERPIE);
		superCommons.add(PokemonConst.PIDGEY);
		superCommons.add(PokemonConst.RATTATA);
		superCommons.add(PokemonConst.ZUBAT);
				
		return superCommons;
	}
	
	public Set<Integer> getSuperRares(){
		Set<Integer> superCommons = new HashSet<Integer>();
		
		superCommons.add(PokemonConst.LAPRAS);
		superCommons.add(PokemonConst.DRAGONITE);
		superCommons.add(PokemonConst.SNORLAX);
		superCommons.add(PokemonConst.CHARIZARD);
		superCommons.add(PokemonConst.CHANSEY);
		superCommons.add(PokemonConst.RAICHU);
		superCommons.add(PokemonConst.ARCANINE);
				
		return superCommons;
	}

	public String getName(Integer pokemonId) {
		return prop.getProperty("pokemon.name."+pokemonId);
	}
}
