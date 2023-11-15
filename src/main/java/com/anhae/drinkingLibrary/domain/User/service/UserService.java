package com.anhae.drinkingLibrary.domain.User.service;

import com.anhae.drinkingLibrary.domain.User.User;
import com.anhae.drinkingLibrary.domain.User.repository.UserRepository;
import com.anhae.drinkingLibrary.domain.User.repository.dto.UserRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void join(UserRequestDto userRequestDto) {
        User user = new User();
        user.setEmail(userRequestDto.getEmail());
        user.setUsername((userRequestDto.getUsername()));
        this.userRepository.save(user);
    }
}
