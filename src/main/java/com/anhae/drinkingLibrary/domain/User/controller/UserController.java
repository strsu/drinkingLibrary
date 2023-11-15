package com.anhae.drinkingLibrary.domain.User.controller;

import com.anhae.drinkingLibrary.domain.User.repository.dto.UserRequestDto;
import com.anhae.drinkingLibrary.domain.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> user(@RequestBody UserRequestDto userRequestDto) {
        this.userService.join(userRequestDto);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }
}
