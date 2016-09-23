package com.herazade.sachalert.core.step.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.herazade.sachalert.api.PokemonAlert;
import com.herazade.sachalert.core.step.BaseStep;

public class AddEncounterData extends BaseStep {

	Logger logger = LoggerFactory.getLogger(getClass());

	private String mapLinkFormat = "http://maps.google.com/maps?q=%s,%s";
	private String navLinkFormat = "http://maps.google.com/maps?daddr=%s,%s";
		
	public boolean process(PokemonAlert alert) {
			
		Double latitude = alert.getEncounter().getLatitude();
		Double longitude = alert.getEncounter().getLongitude();
		alert.getContext().put(PokemonAlert.GPS, String.format(mapLinkFormat, latitude,longitude));
		alert.getContext().put(PokemonAlert.NAV, String.format(navLinkFormat, latitude,longitude));
		
		logger.debug("GPS link added");
		return getNext().process(alert);
	}

}
