package com.freelance.atelier_workshops.service.workshop.factory;

import com.freelance.atelier_workshops.domain.vo.WorkshopRequest;
import com.freelance.atelier_workshops.model.Workshop;

public class WorkshopFactory {

	private WorkshopFactory() {
		// Empty constructor so there cant be instances of this class
	}

	public static Workshop buildProduct(WorkshopRequest workshopRequest) {
		return Workshop.builder().name(workshopRequest.getName()).build();
	}

}
