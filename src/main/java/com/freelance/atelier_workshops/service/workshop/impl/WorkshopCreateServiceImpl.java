package com.freelance.atelier_workshops.service.workshop.impl;

import com.freelance.atelier_workshops.domain.vo.WorkshopRequest;
import com.freelance.atelier_workshops.domain.vo.WorkshopResponse;
import com.freelance.atelier_workshops.model.Workshop;
import com.freelance.atelier_workshops.repository.WorkshopRepository;
import com.freelance.atelier_workshops.service.workshop.WorkshopCreateService;
import com.freelance.atelier_workshops.service.workshop.factory.WorkshopFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkshopCreateServiceImpl implements WorkshopCreateService {

	private final WorkshopRepository workshopRepository;

	private final ConversionService conversionService;

	@Override
	public WorkshopResponse createWorkshop(WorkshopRequest workshopRequest) {
		log.info("INIT - WorkshopCreateServiceImpl -> createWorkshop() - Saving workshop {}", workshopRequest);
		Workshop workshop = workshopRepository.save(WorkshopFactory.buildProduct(workshopRequest));
		log.info("END - WorkshopCreateServiceImpl -> createWorkshop() - Saved workshop {}", workshop);
		return conversionService.convert(workshop, WorkshopResponse.class);
	}

}
