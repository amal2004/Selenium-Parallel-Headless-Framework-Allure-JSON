package com.amalw.tests;

import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amalw.base.BaseTest;
import com.amalw.dataproviders.RegistrationDataProvider;
import com.amalw.enums.Gender;
import com.amalw.logging.FrameworkLogger;
import com.amalw.model.User;
import com.amalw.pages.RegisterPage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/*
 * RegistrationTest validates user registration
 * functionality using multiple datasets.
 */
@Epic("User Management")
@Feature("Registration")
@Epic("User Management")
@Feature("Registration")
public class RegistrationTest extends BaseTest {

	private static final Logger LOGGER = FrameworkLogger.getLogger(RegistrationTest.class);

	@Test(dataProvider = "registrationData", dataProviderClass = RegistrationDataProvider.class)
	@Story("Successful user registration")
	@Severity(SeverityLevel.CRITICAL)
	public void testRegistration(User user, Gender gender) {

		LOGGER.info("Executing registration test | email={}", user.getEmail());

		RegisterPage registerPage = new RegisterPage();

		registerPage.open().selectGender(gender).fillForm(user).submit();

		Assert.assertTrue(registerPage.isRegistrationSuccessful(), "Registration failed");

		Assert.assertTrue(registerPage.getConfirmationMessage().contains("registration completed"));
	}
}