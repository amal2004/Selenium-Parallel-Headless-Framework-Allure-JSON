package com.amalw.utils;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;

import com.amalw.exceptions.FrameworkException;
import com.amalw.logging.FrameworkLogger;
import com.amalw.testdata.RegistrationTestData;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtils {

	private static final Logger LOGGER = FrameworkLogger.getLogger(JsonUtils.class);

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	private JsonUtils() {
	}

	public static List<RegistrationTestData> getRegistrationData(String fileName) {

		String path = "testdata/" + fileName;

		try (InputStream inputStream = JsonUtils.class.getClassLoader().getResourceAsStream(path)) {

			if (inputStream == null) {

				throw new FrameworkException("JSON file not found: " + path);
			}

			LOGGER.info("Reading JSON test data file: {}", fileName);

			RegistrationTestData[] data = OBJECT_MAPPER.readValue(inputStream, RegistrationTestData[].class);

			List<RegistrationTestData> executableData = Arrays.stream(data)
					.collect(Collectors.toList());

			LOGGER.info("Executable datasets loaded | count={}", executableData.size());

			return executableData;

		} catch (Exception e) {

			LOGGER.error("Failed to read JSON data file: {}", fileName, e);

			throw new FrameworkException("Failed to read JSON test data", e);
		}
	}
}