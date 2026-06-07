package com.grabbag.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.grabbag.model.RegistrationModel;

@Repository
public class RegistrationDataService implements RegistrationDataServiceInterface {

    private final JdbcTemplate jdbcTemplate;

    public RegistrationDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createUser(RegistrationModel registrationModel) {
        String sql = """
            INSERT INTO users
            (first_name, last_name, email, phone_number, username, password)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        return jdbcTemplate.update(
            sql,
            registrationModel.getFirstName(),
            registrationModel.getLastName(),
            registrationModel.getEmail(),
            registrationModel.getPhoneNumber(),
            registrationModel.getUsername(),
            registrationModel.getPassword()
        );
    }
}
