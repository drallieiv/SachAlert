package com.herazade.sachalert.core.step;

import com.herazade.sachalert.api.AlertSender;
import com.herazade.sachalert.api.PokemonAlert;

public class Send extends BaseStep {

	private AlertSender sender;

	public boolean process(PokemonAlert alert) {
		sender.send(alert);
		return true;
	}

	public AlertSender getSender() {
		return sender;
	}

	public void setSender(AlertSender sender) {
		this.sender = sender;
	}
	
	

}
