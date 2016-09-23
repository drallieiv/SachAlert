package com.herazade.sachalert.core.step.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.herazade.sachalert.api.PokemonAlert;
import com.herazade.sachalert.core.Trainer;
import com.herazade.sachalert.core.geo.Direction;
import com.herazade.sachalert.core.geo.GeoService;
import com.herazade.sachalert.core.geo.POI;
import com.herazade.sachalert.core.step.BaseStep;
import com.vividsolutions.jts.geom.Point;

public class AddDirection extends BaseStep {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private GeoService geoService;

	private String directionFormat = "à %sm %s de '%s%s'";

	public boolean process(PokemonAlert alert) {
		Trainer trainer = alert.getContextData(Trainer.class, SetTrainer.TRAINER);

		if (trainer == null || trainer.getZone() == null) {
			return false;
		}
		
		Double latitude = alert.getEncounter().getLatitude();
		Double longitude = alert.getEncounter().getLongitude();
		Point pokemon = geoService.createPoint(latitude, longitude);

		if (trainer.getZone().getPoi().isEmpty()) {
			logger.debug("No POI in zone");
		} else {
			POI closest = geoService.closetPoi(pokemon, trainer.getZone().getPoi());
			Direction direction = geoService.getDirection(closest.getPoint(), pokemon);
			
			String group = trainer.isShowPoiGroup() ? " ("+closest.getGroup()+")" : "";

			String directionMsg = String.format(directionFormat, direction.getDistance(), direction.getDirection(), closest.getName(), group);
			alert.getContext().put(PokemonAlert.DIRECTIONS, directionMsg);

		}

		return getNext().process(alert);
	}

}
