package com.serviceFusion.Capstone.dtos.requests;

import com.serviceFusion.Capstone.data.models.Admin;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DeleteAdminRequest {
    private Long adminId;
    private List<Admin> admins;
}
