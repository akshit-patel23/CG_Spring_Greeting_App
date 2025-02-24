package com.example.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/request")
public class SpringGreetingAppLogic {

    @GetMapping("/get")
    public User get(){
        return new User("Hello from BridgeLabz!");
    }
    @PutMapping("/put")
    public User putting(@RequestBody User user){
        return new User("Updated message !"+user.getMessage());
    }

    @DeleteMapping("/delete")
    public User deleting(){
        return new User("Deleting message!");
    }

    @PostMapping("/post")
    public User posting(@RequestBody User user) {
        return new User("Received: " + user.getMessage());
    }



    private final GreetingService greetingService;
    @GetMapping("/")
    public String message(){
        return greetingService.getGreeting();
    }
    @Autowired
    public SpringGreetingAppLogic(GreetingService greetingService) {
        this.greetingService = greetingService;
    }



}