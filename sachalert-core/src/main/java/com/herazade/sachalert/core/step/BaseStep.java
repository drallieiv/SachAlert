package com.herazade.sachalert.core.step;

import com.herazade.sachalert.core.step.data.SetTrainer;

public abstract class BaseStep implements Step {

	private Step next;

	public Step getNext() {
		return next;
	}

	public void setNext(Step next) {
		this.next = next;
	}
	
}
