package com.herazade.sachalert.core.geo;

public class Direction {

	public static final String N = "N";
	public static final String S = "S";
	public static final String E = "E";
	public static final String W = "W";
	public static final String NE = "NE";
	public static final String NW = "NW";
	public static final String SE = "SE";
	public static final String SW = "SW";

	private long distance;

	private String direction;

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public static String getCardinalByAzimuth(double azimuth) {
		String[] cardinals = { W, SW, SW, SW, SW, SW, SW, S, S, SE, SE, SE, SE, SE, SE, E, E, NE, NE, NE, NE, NE, NE, N, N, NW, NW, NW, NW, NW, NW, W };
		int quadrant = (int) Math.round((azimuth + 180) / (360 / cardinals.length));
		return cardinals[quadrant];
	}

}
