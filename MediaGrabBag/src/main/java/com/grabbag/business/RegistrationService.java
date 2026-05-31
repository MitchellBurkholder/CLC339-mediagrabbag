package com.grabbag.business;

import org.springframework.stereotype.Service;

import com.grabbag.model.RegistrationModel;

@Service
public class RegistrationService implements RegistrationServiceInterface {

    @Override
    public void registerUser(RegistrationModel user) {
        System.out.println("Registered user: " + user.getUsername());
    }
}
