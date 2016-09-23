package com.herazade.sachalert.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.herazade.sachalert.api.PokemonAlert;
import com.herazade.sachalert.core.step.Step;

@Service
public class AlertWorkFlow {

	@Autowired
	@Qualifier("start")
	private Step startStep;

	public boolean process(PokemonAlert alert){
		
		return startStep.process(alert);

	}
}
