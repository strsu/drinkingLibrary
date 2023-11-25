package com.anhae.drinkingLibrary.domain.User.service;

import com.anhae.drinkingLibrary.domain.User.Authority;
import com.anhae.drinkingLibrary.domain.User.User;
import com.anhae.drinkingLibrary.domain.User.repository.UserRepository;
import com.anhae.drinkingLibrary.domain.User.repository.dto.UserDto;

import com.anhae.drinkingLibrary.global.util.SecurityUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public User getUserInfo(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail()).orElseThrow(() -> new EntityNotFoundException("err"));;
        return user;
//        User user2 = userRepository.findByEmailAndUsername(userDto.getEmail(), userDto.getUsername());
    }


    @Transactional
    public User signup(UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        // 가입되어 있지 않은 회원이면,
        // 권한 정보 만들고
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        // 유저 정보를 만들어서 save
        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .email(userDto.getEmail())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        return userRepository.save(user);
    }

    // 유저,권한 정보를 가져오는 메소드
    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(String email) {
        User user = userRepository.findOneWithAuthoritiesByEmail(email);
        Optional<User> opt = Optional.ofNullable(user);
        return opt;
    }

    // 현재 securityContext에 저장된 username의 정보만 가져오는 메소드
//    @Transactional(readOnly = true)
//    public Optional<User> getMyUserWithAuthorities() {
//        return SecurityUtil.getCurrentUsername()
//                .flatMap(userRepository::findOneWithAuthoritiesByEmail);
//    }
}
