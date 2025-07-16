package com.freelance.atelier_workshops.service.workshop;

import com.freelance.atelier_workshops.domain.vo.WorkshopRequest;
import com.freelance.atelier_workshops.domain.vo.WorkshopResponse;

public interface WorkshopCreateService {

	WorkshopResponse createWorkshop(WorkshopRequest workshopRequest);

}
