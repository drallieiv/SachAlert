package com.herazade.sachalert.core.step.logic;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.herazade.sachalert.api.PokemonAlert;
import com.herazade.sachalert.core.Trainer;
import com.herazade.sachalert.core.geo.GeoService;
import com.herazade.sachalert.core.step.BaseStep;
import com.herazade.sachalert.core.step.data.SetTrainer;
import com.vividsolutions.jts.geom.Geometry;

public class InTrainerZone extends BaseStep {

	@Inject
	private GeoService geoService;

	public boolean process(PokemonAlert alert) {

		Logger logger = LoggerFactory.getLogger(getClass());

		Trainer trainer = alert.getContextData(Trainer.class, SetTrainer.TRAINER);

		if (trainer == null) {
			return false;
		}

		if (trainer.getZone() == null) {
			return true;
		}

		Geometry point = geoService.createPoint(alert.getEncounter().getLatitude(), alert.getEncounter().getLongitude());

		if (trainer.getZone().getArea().contains(point)) {
			logger.debug("{} inside of zone : {} in {}",alert.getName(),point,trainer.getZone());
			return getNext().process(alert);
		}
		logger.debug("{}  outside of zone : {} / {}",alert.getName(),point,trainer.getZone());

		return false;
	}

}
