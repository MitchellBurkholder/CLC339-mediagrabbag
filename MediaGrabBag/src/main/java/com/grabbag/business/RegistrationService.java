package com.grabbag.business;

import org.springframework.stereotype.Service;
import com.gcu.model.UserModel;

@Service
public class RegistrationService implements RegistrationServiceInterface {

    @Override
    public void registerUser(UserModel user) {
        System.out.println("Registered user: " + user.getUsername());
    }
}
