package com.amalw.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.amalw.enums.Gender;
import com.amalw.factory.UserFactory;
import com.amalw.model.User;
import com.amalw.testdata.RegistrationTestData;
import com.amalw.utils.JsonUtils;



public class RegistrationDataProvider {

    private RegistrationDataProvider() {
    }

	@DataProvider(name = "registrationData", parallel = true)
    public static Object[][] registrationData() {

		List<RegistrationTestData> jsonData = JsonUtils.getRegistrationData("registration-data.json");

        Object[][] data =
                new Object[jsonData.size()][2];

        for (int i = 0; i < jsonData.size(); i++) {

            RegistrationTestData row =
                    jsonData.get(i);

            User user =
                    UserFactory.buildUser(
                            row.getFirstName(),
                            row.getLastName(),
                            row.getCompany(),
                            row.getPassword(),
                            row.getConfirmPassword());

            Gender gender =
                    Gender.valueOf(
                            row.getGender().toUpperCase());

            data[i] = new Object[] {
                    user,
                    gender
            };
        }

        return data;
    }
}