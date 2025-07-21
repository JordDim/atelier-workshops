package com.freelance.atelier_workshops.controller;

import com.freelance.atelier_workshops.apifirst.api.WorkshopsApiDelegate;
import com.freelance.atelier_workshops.domain.vo.WorkshopRequest;
import com.freelance.atelier_workshops.domain.vo.WorkshopResponse;
import com.freelance.atelier_workshops.service.workshop.WorkshopCreateService;
import com.freelance.atelier_workshops.service.workshop.WorkshopDeleteService;
import com.freelance.atelier_workshops.service.workshop.WorkshopFindAllService;
import com.freelance.atelier_workshops.service.workshop.WorkshopUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkshopController implements WorkshopsApiDelegate {

	private final WorkshopCreateService workshopCreateService;

	private final WorkshopDeleteService workshopDeleteService;

	private final WorkshopUpdateService workshopUpdateService;

	private final WorkshopFindAllService workshopFindAllService;

	@Override
	public ResponseEntity<List<WorkshopResponse>> getWorkshops() {
		return ResponseEntity.ok(workshopFindAllService.findAll());
	}

	@Override
	public ResponseEntity<WorkshopResponse> updateWorkshop(Long workshopId, WorkshopRequest workshopRequest) {
		return ResponseEntity.ok(workshopUpdateService.updateWorkshop(workshopRequest, workshopId));
	}

	@Override
	public ResponseEntity<Void> deleteWorkshop(Long workshopId) {
		workshopDeleteService.deleteWorkshopById(workshopId);
		return ResponseEntity.ok(null);
	}

	@Override
	public ResponseEntity<WorkshopResponse> createWorkshop(WorkshopRequest workshopRequest) {
		return ResponseEntity.ok(workshopCreateService.createWorkshop(workshopRequest));
	}

}
