package com.spotify.oauth2.utils;

import com.github.javafaker.Faker;

public class FakeUtils {
    public static String generateName() {
        Faker faker = new Faker();
        return "PlayList " + faker.regexify("[A-Za-z0-9 ,-]{20}");
    }

    public static String generateDescription() {
        Faker faker = new Faker();
        return "Description " + faker.regexify("[ A-Za-z0-9_@./#&+-]{50}");
    }
}
