package com.freelance.atelier_workshops.service.workshop.impl;

import com.freelance.atelier_workshops.exception.WorkshopDeleteByIdException;
import com.freelance.atelier_workshops.repository.WorkshopRepository;
import com.freelance.atelier_workshops.service.workshop.WorkshopDeleteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkshopDeleteServiceImpl implements WorkshopDeleteService {

	private final WorkshopRepository workshopRepository;

	@Override
	public void deleteWorkshopById(Long workshopId) {
		try {
			workshopRepository.deleteById(workshopId);
		}
		catch (EmptyResultDataAccessException | IllegalArgumentException e) {
			log.error("Error, the workshop wasn't deleted correctly: {}", e.getMessage());
			throw new WorkshopDeleteByIdException(e.getMessage());
		}
	}

}
