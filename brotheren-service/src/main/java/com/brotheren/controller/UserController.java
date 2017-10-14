package com.brotheren.controller;

import com.brotheren.model.UserData;
import com.brotheren.service.EmailService;
import com.brotheren.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.mail.MessagingException;
import java.net.URI;
import java.util.List;

@RestController
@ComponentScan({"com.brotheren"})
public class UserController {

    private UserDataService userDataService;

    private EmailService emailService;

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    @Autowired
    public void setUserDataService(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @RequestMapping("/")
    public String redirToList() {
        return "redirect:/userdata/list";
    }

    @RequestMapping({"/userdata/list", "/userdata"})
    public List<UserData> listUserData() {
        return userDataService.listAll();
    }

//    @GetMapping("/userdata/{id}")
    @RequestMapping("/userdata/{id}")
    public UserData retrieveUser(@PathVariable String id) {
        System.out.println("retrieveUser:" + id);
        return userDataService.getById(id);
    }

    @RequestMapping(value = "/userdata/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody UserData userData) throws MessagingException {
        userDataService.saveOrUpdate(new UserData(userData.getId(), userData.getUserId(), userData.getPhone(), userData.getEmail(), userData.getFirstName(), userData.getLastName()));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(userData.getUserId()).toUri();
        emailService.sendEmail(userData.getEmail());
        return ResponseEntity.created(location).build();
    }

}
