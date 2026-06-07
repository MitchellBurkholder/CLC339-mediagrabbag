package com.grabbag.business;

import org.springframework.stereotype.Service;

import com.grabbag.data.RegistrationDataServiceInterface;
import com.grabbag.model.RegistrationModel;

@Service
public class RegistrationService implements RegistrationServiceInterface {

    private final RegistrationDataServiceInterface registrationDataService;

    public RegistrationService(RegistrationDataServiceInterface registrationDataService) {
        this.registrationDataService = registrationDataService;
    }

    @Override
    public void registerUser(RegistrationModel registrationModel) {
        registrationDataService.createUser(registrationModel);
    }
}
