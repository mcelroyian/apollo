package local.mcelroyian.apolloscratch.controllers;

import local.mcelroyian.apolloscratch.models.User;
import local.mcelroyian.apolloscratch.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping(value = "/users/all", produces = {"application/json"})
    public ResponseEntity<?> getUsers() {
        List<User> users = new ArrayList<>();

        userRepo.findAll().iterator().forEachRemaining(users::add);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
