package com.freelance.atelier_workshops.service.workshop.mapper;

import com.freelance.atelier_workshops.domain.vo.WorkshopResponse;
import com.freelance.atelier_workshops.model.Workshop;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface WorkshopToWorkshopResponseMapper extends Converter<Workshop, WorkshopResponse> {

	WorkshopResponse convertToWorkshopResponse(Workshop workshop);

}
