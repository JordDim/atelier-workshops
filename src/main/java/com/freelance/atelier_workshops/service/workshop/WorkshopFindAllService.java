package com.freelance.atelier_workshops.service.workshop;

import com.freelance.atelier_workshops.domain.vo.WorkshopResponse;

import java.util.List;

public interface WorkshopFindAllService {

	List<WorkshopResponse> findAll();

}
