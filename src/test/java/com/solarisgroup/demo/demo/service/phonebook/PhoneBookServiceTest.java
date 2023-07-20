package com.solarisgroup.demo.demo.service.phonebook;

import com.solarisgroup.demo.demo.repository.ContactRepository;
import com.solarisgroup.demo.demo.repository.EmailRepository;
import com.solarisgroup.demo.demo.repository.PhoneNumberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PhoneBookServiceTest {

    @Mock
    private ContactRepository contactRepository;
    @Mock
    private EmailRepository emailRepository;
    @Mock
    private PhoneNumberRepository phoneNumberRepository;

    private PhoneBookService target;

    @BeforeEach
    void setUp() {
        target = new PhoneBookService(contactRepository, emailRepository, phoneNumberRepository);
    }

    @Test
    void shouldCreateContact() {
        when(contactRepository.save(Mockito.any())).thenAnswer(invocation -> invocation.getArgument(0));
        when(emailRepository.saveAll(Mockito.any())).thenAnswer(invocation -> invocation.getArgument(0));
        when(phoneNumberRepository.saveAll(Mockito.any())).thenAnswer(invocation -> invocation.getArgument(0));

        var request = new ContactDto(null, "John", "Doe", List.of("email@example.com"), List.of("123456789", "987654321"));
        var contact = target.createContact("any", request);

        assertEquals("John", contact.firstName());
        assertEquals("Doe", contact.lastName());
        assertEquals(1, contact.emails().size());
        assertEquals(2, contact.phoneNumbers().size());
    }


}
