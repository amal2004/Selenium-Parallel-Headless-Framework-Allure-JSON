package com.amalw.factory;

import java.util.UUID;

import com.amalw.model.User;

public class UserFactory {

    private UserFactory() {
    }

    public static User buildUser(
            String firstName,
            String lastName,
            String company,
            String password,
            String confirmPassword) {

        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);

        // Generate unique email
        user.setEmail(UUID.randomUUID() + "@example.com");

        user.setCompany(company);
        user.setPassword(password);
        user.setConfirmPassword(confirmPassword);

        return user;
    }
}