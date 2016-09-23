package com.herazade.sachalert.core.step.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.herazade.sachalert.api.PokemonAlert;
import com.herazade.sachalert.core.Trainer;
import com.herazade.sachalert.core.geo.Zone;
import com.herazade.sachalert.core.step.BaseStep;

public class SetTrainer extends BaseStep {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	public static final String TRAINER = "trainer";

	private Trainer trainer;
		
	public boolean process(PokemonAlert alert) {
		alert.getContext().put(TRAINER, trainer);
		logger.debug("Send to Trainer {}", trainer.getName());
		return getNext().process(alert);
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

}
