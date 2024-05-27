package com.serviceFusion.Capstone.data.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Entity
@Getter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Username is a mandatory field")
    private String username;
    @NotBlank(message = "Email is a mandatory field")
    private String email;
    @NotBlank(message = "Password is a mandatory field")
    private String password;
    @NotBlank(message = "FullName is a mandatory field")
    private String fullName;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean isLogin;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Customer> customers;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<ServiceProvider> serviceProviders;


}
