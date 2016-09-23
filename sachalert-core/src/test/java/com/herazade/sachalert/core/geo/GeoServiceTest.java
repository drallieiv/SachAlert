package com.herazade.sachalert.core.geo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vividsolutions.jts.geom.Point;

public class GeoServiceTest {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	private GeoService geoService;
	
	private List<POI> allPOI;

	@Before
	public void init(){
		geoService = new GeoService();
		
		allPOI = new ArrayList<>();
		allPOI.add(geoService.createPOI(45.778968, 4.8470410).setName("Yokohama"));
		allPOI.add(geoService.createPOI(45.775041, 4.853837).setName("Parc au daims"));
				
		geoService.setAllPOI(allPOI);
	}

	@Test
	public void zooClosestPoiTest() {
		Point pokemon = geoService.createPOI(45.777630, 4.854965).getPoint();
		POI closest = geoService.closetPoi(pokemon, allPOI);
		Direction direction = geoService.getDirection(closest.getPoint(), pokemon);
		
		logger.info("Direction to the zoo is : {}m {} de '{}'", direction.getDistance(), direction.getDirection(), closest.getName());
		
	}
	
}
