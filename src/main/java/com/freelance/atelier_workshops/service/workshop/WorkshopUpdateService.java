package com.freelance.atelier_workshops.service.workshop;

import com.freelance.atelier_workshops.domain.vo.WorkshopRequest;
import com.freelance.atelier_workshops.domain.vo.WorkshopResponse;

public interface WorkshopUpdateService {

	WorkshopResponse updateWorkshop(WorkshopRequest workshopRequest, Long workshopId);

}
