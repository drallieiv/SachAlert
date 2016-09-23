package com.herazade.sachalert.core.step.logic;

import com.herazade.sachalert.api.PokemonAlert;
import com.herazade.sachalert.core.step.DispatchStep;
import com.herazade.sachalert.core.step.Step;

/**
 * All next steps can process the alert.
 * 
 * @author drallieiv
 *
 */
public class ToAll extends DispatchStep {

	public boolean process(PokemonAlert sourceAlert) {
		boolean oneOk = false;

		for (Step nextStep : this.getNext()) {
			PokemonAlert alert = new PokemonAlert(sourceAlert.getEncounter());
			alert.getContext().putAll(sourceAlert.getContext());
			boolean success = nextStep.process(alert);

			if (success) {
				oneOk = true;
			}
		}

		return oneOk;
	}

}
