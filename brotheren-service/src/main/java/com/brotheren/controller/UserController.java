package com.brotheren.controller;

import com.brotheren.model.UserData;
import com.brotheren.service.UserDataService;
import com.brotheren.service.UserDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@ComponentScan({"com.brotheren"})
public class UserController {

    private UserDataService userDataService;

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


    //    @RequestMapping("/userdata/{id}")
    @GetMapping("/userdata/{id}")
    public UserData retrieveUser(@PathVariable String id) {
        System.out.println("retrieveUser:" + id);
        return userDataService.getById(id);
    }

    @RequestMapping(value = "/userdata/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody UserData userData) {
        userDataService.saveOrUpdate(new UserData(userData.getId(), userData.getUserId(), userData.getPhone(), userData.getEmail(), userData.getFirstName(), userData.getLastName()));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(userData.getUserId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
