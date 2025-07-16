package com.freelance.atelier_workshops.service.workshop.impl;

import com.freelance.atelier_workshops.domain.vo.WorkshopRequest;
import com.freelance.atelier_workshops.domain.vo.WorkshopResponse;
import com.freelance.atelier_workshops.model.Workshop;
import com.freelance.atelier_workshops.repository.WorkshopRepository;
import com.freelance.atelier_workshops.service.workshop.WorkshopUpdateService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkshopUpdateServiceImpl implements WorkshopUpdateService {

	private final WorkshopRepository workshopRepository;

	private final ConversionService conversionService;

	@Override
	public WorkshopResponse updateWorkshop(WorkshopRequest workshopRequest, Long workshopId) {
		Workshop workshop = workshopRepository.findById(workshopId)
			.orElseThrow(() -> new EntityNotFoundException("Workshop not found with id: " + workshopId));

		workshop.setName(workshopRequest.getName());

		Workshop savedWorkshop = workshopRepository.save(workshop);

		return conversionService.convert(savedWorkshop, WorkshopResponse.class);
	}

}
