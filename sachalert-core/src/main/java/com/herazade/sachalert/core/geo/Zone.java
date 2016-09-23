package com.herazade.sachalert.core.geo;

import java.util.List;

import com.vividsolutions.jts.geom.Polygon;

public class Zone {

	/**
	 * Outside border of the zone
	 */
	private Polygon area;

	/**
	 * Name of the zone
	 */
	private String name;
	
	/**
	 * List of point of interest
	 */
	private List<POI> poi;

	public Polygon getArea() {
		return area;
	}

	public void setArea(Polygon area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public List<POI> getPoi() {
		return poi;
	}

	public void setPoi(List<POI> poi) {
		this.poi = poi;
	}

	
}
