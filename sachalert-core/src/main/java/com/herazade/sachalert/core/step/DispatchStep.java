package com.herazade.sachalert.core.step;

import java.util.List;

public abstract class DispatchStep implements Step {

	private List<Step> next;

	public List<Step> getNext() {
		return next;
	}

	public void setNext(List<Step> next) {
		this.next = next;
	}

}
