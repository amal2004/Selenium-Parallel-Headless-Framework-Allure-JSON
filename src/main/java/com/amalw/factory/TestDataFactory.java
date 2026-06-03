package com.amalw.factory;

import java.util.UUID;

public final class TestDataFactory {

    private TestDataFactory() {}

    public static String generateEmail() {

        return UUID.randomUUID() + "@example.com";
    }
}