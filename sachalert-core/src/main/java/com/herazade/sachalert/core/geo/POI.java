package com.herazade.sachalert.core.geo;

import com.vividsolutions.jts.geom.Point;

/**
 * Point of interest
 */
public class POI {

	private String name;

	private String group;

	private Point point;

	/**
	 * Weight from 1 to 10
	 */
	private int weight;

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public POI setName(String name) {
		this.name = name;
		return this;
	}

	public int getWeight() {
		return weight;
	}

	public POI setWeight(int weight) {
		this.weight = weight;
		return this;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
