package com.solarisgroup.demo.demo.api;

import com.solarisgroup.demo.demo.service.phonebook.ContactDto;
import com.solarisgroup.demo.demo.service.phonebook.PhoneBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/contacts")
@RequiredArgsConstructor
public class ContactsController {
    private final PhoneBookService phoneBookService;

    @PostMapping
    public ContactDto create(@PathVariable("userId") String userId, @RequestBody ContactDto request) {
        return phoneBookService.createContact(userId, request);
    }

    @GetMapping
    public List<ContactDto> index(@PathVariable("userId") String userId) {
        return phoneBookService.getContacts(userId);
    }

}
