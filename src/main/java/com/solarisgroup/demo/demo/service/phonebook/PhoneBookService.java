package com.solarisgroup.demo.demo.service.phonebook;

import com.solarisgroup.demo.demo.entity.Contact;
import com.solarisgroup.demo.demo.entity.Email;
import com.solarisgroup.demo.demo.entity.PhoneNumber;
import com.solarisgroup.demo.demo.repository.ContactRepository;
import com.solarisgroup.demo.demo.repository.EmailRepository;
import com.solarisgroup.demo.demo.repository.PhoneNumberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhoneBookService {

    private final ContactRepository contactRepository;
    private final EmailRepository emailRepository;
    private final PhoneNumberRepository phoneNumberRepository;

    public PhoneBookService(ContactRepository contactRepository, EmailRepository emailRepository, PhoneNumberRepository phoneNumberRepository) {
        this.contactRepository = contactRepository;
        this.emailRepository = emailRepository;
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @Transactional
    public ContactDto createContact(String userId, ContactDto request) {
        Contact contact = contactRepository.save(Contact.builder()
                .uid(UUID.randomUUID().toString())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .userId(userId)
                .build());

        var emails = emailRepository.saveAll(request.emails().stream()
                .map(value -> Email.builder()
                        .email(value)
                        .contact(contact)
                        .build())
                .toList());
        contact.setEmails(emails);

        var phoneNumbers = phoneNumberRepository.saveAll(request.phoneNumbers().stream()
                .map(value -> PhoneNumber.builder()
                        .phoneNumber(value)
                        .contact(contact)
                        .build())
                .toList());
        contact.setPhoneNumbers(phoneNumbers);

        return map(contact);
    }

    @Transactional
    public ContactDto updateContact(String contactId, ContactDto request) {
        var contact = contactRepository.findByUid(contactId).orElseThrow();
        contact.setFirstName(request.firstName());
        contact.setLastName(request.lastName());
        contactRepository.save(contact);
        return map(contact);
    }

    @Transactional
    public List<ContactDto> getContacts(String userId) {
        return contactRepository.findByUserId(userId).stream()
                .map(this::map)
                .toList();
    }

    private ContactDto map(Contact contact) {
        return new ContactDto(
                contact.getUid(),
                contact.getFirstName(),
                contact.getLastName(),
                contact.getEmails().stream().map(Email::getEmail).toList(),
                contact.getPhoneNumbers().stream().map(PhoneNumber::getPhoneNumber).toList()
        );
    }
}
