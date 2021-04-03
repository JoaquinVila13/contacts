package com.apis.colposapi.controller.example;

import com.apis.colposapi.exception.ResourceNotFoundException;
import com.apis.colposapi.model.example.Contact;
import com.apis.colposapi.repository.example.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin()
@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/contacts")
    public Page<Contact> getContacts(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }

    @GetMapping("/contacts/{contactId}")
    public Contact getContactById(@PathVariable Long contactId) {
        return contactRepository.findById(contactId)
                .map(contact -> {
                    return contact;
                }).orElseThrow(() -> new ResourceNotFoundException("Contact not found with id " + contactId));
    }

    @PostMapping("/contacts")
    public Contact createContact(@Valid @RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @PutMapping("/contacts/{contactId}")
    public Contact updateContact(@PathVariable Long contactId,
                                   @Valid @RequestBody Contact contactRequest) {
        return contactRepository.findById(contactId)
                .map(contact -> {
                    contact.setEmail(contactRequest.getEmail());
                    contact.setPassword(contactRequest.getPassword());
                    contact.setPhotourl(contactRequest.getPhotourl());

                    return contactRepository.save(contact);
                }).orElseThrow(() -> new ResourceNotFoundException("Contact not found with id " + contactId));
    }


    @DeleteMapping("/contacts/{contactId}")
    public ResponseEntity<?> deleteContact(@PathVariable Long contactId) {
        return contactRepository.findById(contactId)
                .map(contact -> {
                    contactRepository.delete(contact);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Contact not found with id " + contactId));
    }
}