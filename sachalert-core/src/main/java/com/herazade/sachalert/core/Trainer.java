package com.herazade.sachalert.core;

import com.herazade.sachalert.core.geo.Zone;

/**
 * A trainer is an alerting configuration with a name
 * 
 * @author drallieiv
 *
 */
public class Trainer {

	private String name;

	private Zone zone;
	
	public boolean showPoiGroup = false;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public boolean isShowPoiGroup() {
		return showPoiGroup;
	}

	public void setShowPoiGroup(boolean showPoiGroup) {
		this.showPoiGroup = showPoiGroup;
	}
	
	

}
