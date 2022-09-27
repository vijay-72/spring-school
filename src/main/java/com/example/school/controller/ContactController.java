package com.example.school.controller;

import com.example.school.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.school.model.Contact;

@Controller
public class ContactController {
    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String Displaycontact() {
        return "contact.html";
    }

    @PostMapping("/saveMsg")
    public ModelAndView saveMessage(Contact contact) {
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }

}
