package com.serviceFusion.Capstone.ServiceTests;

import com.serviceFusion.Capstone.data.models.ServiceCategory;
import com.serviceFusion.Capstone.dtos.requests.ServiceCreationRequest;
import com.serviceFusion.Capstone.dtos.responses.ServiceCreationResponse;
import com.serviceFusion.Capstone.services.ServiceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ServiceProvidedTest {
    @Autowired
    private ServiceService serviceService;
    @Test
    public void testThatServiceCanBeCreated() {

        ServiceCreationRequest request = new ServiceCreationRequest();
        request.setName("Fashion");
        request.setDescription("Makes both Male and Female modern wears");
        request.setServiceCategory(ServiceCategory.CLEANERS);
        request.setPrice(BigDecimal.valueOf(5000));
        request.setServiceProviderId(1L);
        request.setDuration("2 hours");

        ServiceCreationResponse response = serviceService.createService(request);
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatMultipleServicesCanBeCreated() {

        ServiceCreationRequest request = new ServiceCreationRequest();
        request.setName("Hair Fashion");
        request.setDescription("Styles both male and female hair");
        request.setServiceCategory(ServiceCategory.HAIRSTYLISTS);
        request.setPrice(BigDecimal.valueOf(4500));
        request.setServiceProviderId(1L);
        request.setDuration("5 hours");

        ServiceCreationResponse response = serviceService.createService(request);
        assertThat(response).isNotNull();
    }

}
