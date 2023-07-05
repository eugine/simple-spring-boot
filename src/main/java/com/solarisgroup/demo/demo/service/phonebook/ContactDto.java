package com.solarisgroup.demo.demo.service.phonebook;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ContactDto(
        String id,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        List<String> emails,
        @JsonProperty("phone_numbers")
        List<String> phoneNumbers) {
}
