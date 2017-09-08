package com.brotheren.user.controller;

import com.brotheren.user.datamodel.UserData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {
    private static final String welcomeTemplate = "Welcome %s !";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/welcome")
    public String userGreeting(@RequestParam(value = "name", defaultValue = "User") String name) {
        return String.format(welcomeTemplate, name);
    }

    @RequestMapping("/displayuser")
    public UserData displayUserData(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new UserData(counter.incrementAndGet(), "usrid", "123456", "abc@dkl.com", name, "lastname");
    }


}
