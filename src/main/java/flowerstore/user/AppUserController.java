package flowerstore.controller;

import flowerstore.repository.AppUserRepository;
import flowerstore.user.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @GetMapping
    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody AppUser user) {
        Optional<AppUser> existingUser = appUserRepository.findAppUserByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            return ResponseEntity
                    .status(409)
                    .body("Error: Email " + user.getEmail() + " is already taken.");
        }

        appUserRepository.save(user);
        return ResponseEntity.ok("User created successfully.");
    }
}