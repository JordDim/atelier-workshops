package com.freelance.atelier_workshops.service.workshop.impl;

import com.freelance.atelier_workshops.domain.vo.WorkshopResponse;
import com.freelance.atelier_workshops.repository.WorkshopRepository;
import com.freelance.atelier_workshops.service.workshop.WorkshopFindAllService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkshopFindAllServiceImpl implements WorkshopFindAllService {

	private final WorkshopRepository workshopRepository;

	private final ConversionService conversionService;

	@Override
	public List<WorkshopResponse> findAll() {

		return workshopRepository.findAll()
			.stream()
			.map(workshop -> conversionService.convert(workshop, WorkshopResponse.class))
			.toList();
	}

}
