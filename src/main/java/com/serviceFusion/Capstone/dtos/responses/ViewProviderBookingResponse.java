package com.serviceFusion.Capstone.dtos.responses;

import com.serviceFusion.Capstone.data.models.Booking;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ViewProviderBookingResponse {
    private List<Booking> providerListOfBooking;
}
