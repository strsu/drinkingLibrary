package com.anhae.drinkingLibrary.domain.User.controller;

import com.anhae.drinkingLibrary.domain.User.User;
import com.anhae.drinkingLibrary.domain.User.repository.dto.UserDto;
import com.anhae.drinkingLibrary.domain.User.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(
            @Valid @RequestBody UserDto userDto
    ) {
        return ResponseEntity.ok(userService.signup(userDto));
    }

//    @GetMapping("/user")
//    @PreAuthorize("hasAnyRole('USER','ADMIN')")
//    public ResponseEntity<User> getMyUserInfo() {
//        return ResponseEntity.ok(userService.getMyUserWithAuthorities().get());
//    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<User> getUserInfo(Principal principal) {
        // Principal principal <- django의 request.user 와 비슷한 역할
        return ResponseEntity.ok(userService.getUserWithAuthorities(principal.getName()).get());
    }

}