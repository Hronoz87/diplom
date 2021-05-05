//package ru.netology.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import ru.netology.demo.service.CloudService;
//
//import java.util.Optional;
//
//@RestController
//public class CloudController {
//
//    private final CloudService cloudService;
//
//    @Autowired
//    public CloudController(CloudService cloudService) {
//        this.cloudService = cloudService;
//    }
//
//    @GetMapping("/login")
//    public Optional<ModelLoginPassworde> byNameAndPassword(@RequestParam String name, @RequestParam String password) {
//        return cloudService.get
//    }
//}
