package com.solarisgroup.demo.demo.service.phonebook.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryPhoneBookTest {

    @Test
    void shouldAddItem() {
        var target = new InMemoryPhoneBook();
        target.add(new PhoneBookRecord("John", "123456789"));
        target.add(new PhoneBookRecord("Jane", "123456789"));
        target.add(new PhoneBookRecord("Jane", "987654321"));

        assertEquals(3, target.getAll().size());
    }

}
