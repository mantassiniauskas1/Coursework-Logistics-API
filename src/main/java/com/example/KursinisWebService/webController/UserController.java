package com.example.KursinisWebService.webController;

import com.example.KursinisWebService.exception.ResourceNotFoundException;
import com.example.KursinisWebService.model.User;
import com.example.KursinisWebService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }



    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable  int id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id:" + id));

        return ResponseEntity.ok(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User userDetails) {
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id: " + id));

        updateUser.setUsername(userDetails.getUsername());
        updateUser.setPassword(userDetails.getPassword());
        updateUser.setFullname(userDetails.getFullname());
        updateUser.setSurname(userDetails.getSurname());
        updateUser.setEmail(userDetails.getEmail());
        updateUser.setPhoneNo(userDetails.getPhoneNo());
        updateUser.setDateOfBirth(userDetails.getDateOfBirth());
        updateUser.setRole(userDetails.getRole());

        userRepository.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id: " + id));

        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}