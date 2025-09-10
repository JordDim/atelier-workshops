package com.freelance.atelier_workshops.service.workshop.impl;

import com.freelance.atelier_workshops.domain.vo.WorkshopRequest;
import com.freelance.atelier_workshops.domain.vo.WorkshopResponse;
import com.freelance.atelier_workshops.model.Workshop;
import com.freelance.atelier_workshops.repository.WorkshopRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WorkshopCreateServiceImplTest {

    @Mock
    private WorkshopRepository workshopRepository;

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private WorkshopCreateServiceImpl workshopCreateServiceImpl;


    @Test
    void createWorkshop() {

        WorkshopRequest workshopRequest = new WorkshopRequest("test1");

        Workshop workshop = new Workshop(null, "test1");
        Workshop savedWorkshop = new Workshop(1L, "test1"); // Después de guardar


        WorkshopResponse workshopResponse = new WorkshopResponse(1L, "test1");


        when(workshopRepository.save(any(Workshop.class))).thenReturn(savedWorkshop);
        when(conversionService.convert(savedWorkshop, WorkshopResponse.class)).thenReturn(workshopResponse);


        WorkshopResponse result = workshopCreateServiceImpl.createWorkshop(workshopRequest);

        assertNotNull(workshopRequest);
        assertNotNull(workshop);
        assertNotNull(workshopResponse);

        assertEquals(result, workshopResponse);

        verify(workshopRepository).save(any(Workshop.class));
    }
}