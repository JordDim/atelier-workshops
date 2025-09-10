package com.freelance.atelier_workshops.service.workshop.impl;

import com.freelance.atelier_workshops.domain.vo.WorkshopResponse;
import com.freelance.atelier_workshops.model.Workshop;
import com.freelance.atelier_workshops.repository.WorkshopRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WorkshopFindAllServiceImplTest {

    @Mock
    private WorkshopRepository workshopRepository;

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private WorkshopFindAllServiceImpl workshopFindAllService;

    @Test
    void findAllSuccess() {
        Workshop workshop = new Workshop(1L, "pintura");
        Workshop workshop2 = new Workshop(2L, "pintura");

        List<Workshop> workshops = Arrays.asList(workshop, workshop2);

        WorkshopResponse workshopResponse = new WorkshopResponse(1L, "pintura");
        WorkshopResponse workshopResponse2 = new WorkshopResponse(2L, "pintura");

        List<WorkshopResponse> workshopResponses = Arrays.asList(workshopResponse, workshopResponse2);

        when(workshopRepository.findAll()).thenReturn(workshops);
        when(conversionService.convert(workshop, WorkshopResponse.class)).thenReturn(workshopResponse);
        when(conversionService.convert(workshop2, WorkshopResponse.class)).thenReturn(workshopResponse2);

        List<WorkshopResponse> results = workshopFindAllService.findAll();

        assertNotNull(results);
        assertNotNull(workshopResponses);
        assertEquals(workshopResponses, results);

        verify(workshopRepository, times(1)).findAll();
    }
}